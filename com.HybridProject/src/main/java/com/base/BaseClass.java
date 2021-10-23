package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;
import com.utility.WaitUtility;

public class BaseClass {
	
	public PropertiesUtility pu=null;
	public WaitUtility wu=null;
	public static Logger log=Logger.getLogger(BaseClass.class);
		
	public static WebDriver driver=null;
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	
	@BeforeSuite
	public WebDriver setUp() {
		pu= new PropertiesUtility();
		wu=new WaitUtility();
		
		
		log.info("initializing browser");
		String br=pu.readProperty("browser");
		log.info(br+" browser is initialized ");
		// see if user enters browser name as IE,Edge--- code is not satisfied
		if(pu.readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pu.readProperty("chromeDriverfilePath"));
			driver=new ChromeDriver();
		}
		if(pu.readProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pu.readProperty("geckoDriverfilePath"));
			driver=new FirefoxDriver();
		}
		
		log.info("maximising browser window");
		driver.manage().window().maximize();
		driver.get(pu.readProperty("url"));
		log.info("applying common waits over a browser");
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pu.readProperty("pageload")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(pu.readProperty("pageload")), TimeUnit.SECONDS);
		return driver;
	}
	
	public void reportInit() {
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Reports/ExtentReport.html");
		report=new ExtentReports();
		report.setSystemInfo("Host Name"," Mangesh-JBK");
		report.setSystemInfo("Platform","Windows");
		report.setSystemInfo("Enviornment","Test Automation");
		report.attachReporter(spark);
	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
	
	

}
