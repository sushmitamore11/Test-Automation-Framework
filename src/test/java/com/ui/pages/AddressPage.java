package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{

	private static final By COMPANY_FIELD_LOCATOR = By.id("company");
	private static final By ADDRESS1_FIELD_LOCATOR = By.id("address1");
	private static final By ADDRESS2_FIELD_LOCATOR = By.id("address2");
	private static final By CITY_FIELD_LOCATOR = By.id("city");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By POSTAL_CODE_FIELD_LOCATOR = By.id("postcode");
	private static final By COUNTRY_DROPDOWN_LOCATOR = By.id("id_country");
	private static final By HOME_PHONE_NUMBER_FIELD_LOCATOR = By.id("phone");
	private static final By MOBILE_NUMBER_FIELD_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]");
	
	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	public String saveAddress(AddressPOJO add) {
		enterText(COMPANY_FIELD_LOCATOR, add.getCompany());
		enterText(ADDRESS1_FIELD_LOCATOR, add.getAddress1());
		enterText(ADDRESS2_FIELD_LOCATOR, add.getAddress2());
		enterText(CITY_FIELD_LOCATOR, add.getCity());
		enterText(POSTAL_CODE_FIELD_LOCATOR, add.getPostalCode());
		enterText(HOME_PHONE_NUMBER_FIELD_LOCATOR, add.getHomePhoneNumber());
		enterText(MOBILE_NUMBER_FIELD_LOCATOR, add.getMobileNumber());
		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, add.getOtherInfo());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, add.getAddressAlias());
		selectDromDropdown(STATE_DROPDOWN_LOCATOR, add.getState());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		
		return newAddress;
	}
	

}
