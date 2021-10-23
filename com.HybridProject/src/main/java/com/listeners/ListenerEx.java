package com.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener{
	
	
	public void onFinish(ITestContext result) {
		log.info("Test suite is finished with execution");
		report.flush();
	}

	public void onStart(ITestContext result) {
		log.info("Test suite is ready to start execution");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		log.info("TestCase failed with name: "+ result.getName());
		log.info(result.getThrowable());
		test.log(Status.FAIL, "Testcase failed");
		test.log(Status.FAIL, result.getThrowable());
		String path=takeScreenShot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		log.info("TestCase skipped with name: "+ result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		log.info("Testcase ready to sdtart with name: "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		log.info("TestCase passed successfuly with name: "+ result.getName());
		test.log(Status.PASS, "Testcase passed successfully");
		}
	
	

}
