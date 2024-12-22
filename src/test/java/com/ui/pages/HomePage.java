package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.ENV;
import com.constants.ENV.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);  //to call parent class constructor from child class constructor
		//goToWebsite(readProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(ENV.QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);  //to call parent class constructor from child class constructor
		//goToWebsite(readProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(ENV.QA).getUrl());
	}

	public LoginPage goToLoginPage() {   // Page functions
		logger.info("Trying to perform click to go to Sign In page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	
}
