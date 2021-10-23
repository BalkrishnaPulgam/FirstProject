package com.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.UserPage;

public class DashboardTest extends BaseClass{
	
	public static  UserPage up;
	
	@Test(priority=4)
	public void verifyCourses() {
		ArrayList<String> expCourses = new ArrayList<String>();
		expCourses.add("Selenium");
		expCourses.add("Java / J2EE");
		expCourses.add("Python");
		expCourses.add("Php");
		Assert.assertEquals(LoginTest.dp.verifyCourses(), expCourses);;
		
	}
	@Test(priority=5)
	public void userClick() {
		up =LoginTest.dp.clickUsersLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		
	}

}
