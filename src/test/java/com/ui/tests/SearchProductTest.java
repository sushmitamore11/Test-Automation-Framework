package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed dress";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("wahecow406@gitated.com", "Password");   //("wahecow406@gitated.com", "Password");
	}

	@Test(description = "Verify if logged in user is able to search for product and correct search results are displayed", groups = {
			"E2E", "Smoke", "Sanity" })
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}
}
