package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {
		
		//Create a browser session
		WebDriver wd = new ChromeDriver();
		
		//launch the url
		//BrowserUtility browserUtility = new BrowserUtility(wd);
		//browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
	
		//maximise the window
		//browserUtility.maximizeWindow();
		
		
		//browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		//browserUtility.enterText(emailTextBoxLocator, "wahecow406@gitated.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		//browserUtility.enterText(passwordTextBoxLocator, "Password");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		//browserUtility.clickOn(submitLoginButtonLocator);
	}

}
