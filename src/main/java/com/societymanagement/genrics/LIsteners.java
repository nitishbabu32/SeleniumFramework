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
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LIsteners extends BaseClass implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass SuccessFully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+result.getName()+new JavaUtility().getSystemDateAndTimeFormat()+".png");
		String path=dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String path=System.getProperty("user.dir")+"//Extent_reports//extent"+new JavaUtility().getSystemDateAndTimeFormat()+".html";
		//String path=System.getProperty("user.dir"+"//ExtentReport//report"+new JavaUtility().formatedSystemDate()+".html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("SDET-45 Testing");
		reporter.config().setReportName("SocietyManagement Extent Report");
		reporter.config().setTheme(Theme.DARK);
//		try {
//			reporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Os", "Windows");
		extent.setSystemInfo("post", "STE");
		extent.setSystemInfo("Engineer Name", "Nitish Babu");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
