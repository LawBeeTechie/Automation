package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	private static int maximumAttempts = 3;
	private static int count = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
	if(count <= maximumAttempts) {
		count = count + 1;
		
		return true; //run the failed test
	}
		return false; // dont want to run the failed test
	}

}
