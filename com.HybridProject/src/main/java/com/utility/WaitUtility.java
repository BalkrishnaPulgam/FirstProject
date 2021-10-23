package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	// 1. why we need utilty--read property file
	// 2. whats are inputs-- key
	// 3. what will be output-- value

	public void waitForElement(WebElement element, WebDriver driver, long timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
