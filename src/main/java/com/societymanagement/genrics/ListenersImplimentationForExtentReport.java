package com.societymanagement.genrics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplimentationForExtentReport extends BaseClass implements ITestListener{
	ExtentTest test;
	ExtentReports report=ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest>extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		extenttest.set(test);//unique thread id
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "This Test Script is Successfully Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL, result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass()
					.getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		String filepath = null;
		try {
			filepath = takeScreenShot(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(filepath, result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP, "Test is Skip ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}

