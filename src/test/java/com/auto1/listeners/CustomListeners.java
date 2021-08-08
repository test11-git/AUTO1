package com.auto1.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.auto.base.TestBase;
import com.auto1.utilities.TestUtil;



public class CustomListeners extends TestUtil implements ITestListener {
	WebDriver driver=TestBase.getWebDriverinstance();

	
	public void onTestStart(ITestResult result) {     

	}

	
	public void onTestSuccess(ITestResult result) {		
	}

	public void onTestFailure(ITestResult result) {
    System.out.println("Test failed - screenshot captured");
    failed();
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

}

