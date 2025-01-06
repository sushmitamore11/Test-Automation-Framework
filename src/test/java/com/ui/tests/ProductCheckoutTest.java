package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM = "Printed summer dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "User logins into the application & searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("wahecow406@gitated.com", "Password").searchProduct(SEARCH_TERM);
	}
	
	
	@Test(description = "Verify if logged in user is able to place an order", groups = {"E2E", "Smoke", "Sanity"})
	public void checkOut() {
		String result = searchResultPage.clickOnTheProductAt(0).changeSize(M).addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
		Assert.assertTrue(result.contains("complete"));
	}

}
