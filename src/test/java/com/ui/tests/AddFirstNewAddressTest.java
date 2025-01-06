package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddFirstNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid user logs in for the first time")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("wahecow406@gitated.com", "Password");
		address = FakeAddressUtility.getFakeAddress();
		//("Google", "102 main street", "Elixar park", "Manhattan", "New York", "10023", "0299028998", "9982922828", "Other", "Office address");
	}

	@Test
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}

}
