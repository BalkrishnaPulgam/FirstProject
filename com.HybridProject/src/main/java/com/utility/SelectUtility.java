package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	
	public void selectbyText(String text, WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectbyValue(String value, WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectbyIndex(int index, WebElement element) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void deselectbyIndex(int index, WebElement element) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deselectbyValue(String value, WebElement element) {
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deselectbyText(String text, WebElement element) {
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
	}

}
