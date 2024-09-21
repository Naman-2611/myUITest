/**
 * 
 */
package com.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.TestBase;
import com.utilities.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 */
public class MyListeners extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Verified", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
		extentTest.fail(result.getName(), MediaEntityBuilder
				.createScreenCaptureFromBase64String(Utilities.captureSSUsing64Base(), result.getName() + " Failed").build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.GREY));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		//D:\mytest\Test\reports
		//Utilities.generateReport(System.getProperty("user.dir")+"/reports", "Test Results", "Test Results");
		Utilities.generateReport(".\\reports\\", "Results", "Test Results");
		extentTest = extentReports.createTest(context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		Utilities.saveReport();

	}

}
