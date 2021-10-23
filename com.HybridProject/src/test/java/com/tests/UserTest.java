package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {
	
	@Test(priority=6)
	public void verifyTableRows() {
		Assert.assertEquals(DashboardTest.up.verifyRows(), 5);
	}

}
