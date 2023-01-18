package com.societymanagement.genrics;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"//reports//extent-report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);

		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("TestResult");
		reporter.config().setReportName("Web Automation Result");

		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("platformName", "Windows");
		extent.setSystemInfo("status", "Senior Test Engineer");
		extent.setSystemInfo("Test Engineer", "Nitish Babu");
		return extent;
	}
}
