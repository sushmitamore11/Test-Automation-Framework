package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT = By.name("processCarrier");
	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.id("cgv");
	
	public ShippmentPage(WebDriver driver) {
		super(driver);
	}
	
	public PaymentPage goToPaymentPage() {
		clickOnCheckbox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT);
		return new PaymentPage(getDriver());
	}

}
