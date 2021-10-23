package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.PropertiesUtility;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "email")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(xpath = "//button")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public DashboardPage validLogin() {
		uname.clear();
		pass.clear();
		uname.sendKeys(PropertiesUtility.readProperty("username"));
		pass.sendKeys(PropertiesUtility.readProperty("password"));
		loginBtn.click();
		return new DashboardPage(driver);

	}

	public void inValidLogin(String Uname, String Pass) {

		uname.sendKeys(Uname);
		pass.sendKeys(Pass);
		loginBtn.click();
	}

}
