package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{

	private static final By PAYMENT_BY_WIRE = By.xpath("//a[@title=\"Pay by bank wire\"]");
	private static final By CONFIRM_ORDER = By.xpath("//p[contains(@class,\"cart_navigation\")]/button");
	private static final By ALERT_SUCCESS_MESSAGE = By.xpath("//p[contains(@class,\"success\")]");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public String makePaymentByWire() {
		clickOn(PAYMENT_BY_WIRE);
		clickOn(CONFIRM_ORDER);
		return getVisibleText(ALERT_SUCCESS_MESSAGE);
		 
	}
}
