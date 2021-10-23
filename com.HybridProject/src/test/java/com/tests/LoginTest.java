package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.ExcelUtility;

public class LoginTest extends BaseClass {
	static WebDriver driver=null;
	 LoginPage lp=null;
	public static DashboardPage dp;
	
	@BeforeSuite
	public void Inialization() {
		driver=setUp();
		reportInit();
		lp=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		String uname=ExcelUtility.getCellData(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx", "login", 2, 0);
		String pass=ExcelUtility.getCellData(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx", "login", 2, 1);
		lp.inValidLogin(uname, pass);
	}
	
	@Test(priority=3)
	public void loginTest() {
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
