package com.societymanagement.genrics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpclass implements IRetryAnalyzer{
int counter=0;
int retryLimit=2;
	@Override
	public boolean retry(ITestResult result) {
	if(counter<retryLimit) {
		counter++;
		return true;
	}
		return false;
	}

}
