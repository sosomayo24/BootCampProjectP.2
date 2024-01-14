package com.tutorialsninja.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Execution Started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + ": Test Execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + ": Test Execution Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + ": Test Execution Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + ": Test Execution Skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project Execution Finished");
	}

   
	
}