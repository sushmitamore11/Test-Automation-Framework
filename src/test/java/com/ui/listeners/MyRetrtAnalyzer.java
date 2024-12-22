package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.ENV;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetrtAnalyzer implements IRetryAnalyzer{

	//private static final int MAX_NO_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(ENV.DEV, "MAX_NO_OF_ATTEMPTS"));
	private static final int MAX_NO_OF_ATTEMPTS = JSONUtility.readJSON(ENV.QA).getMAX_NO_OF_ATTEMPTS();
	private static int currentAttempt = 1;	
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NO_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		
		return false;
	}

}
