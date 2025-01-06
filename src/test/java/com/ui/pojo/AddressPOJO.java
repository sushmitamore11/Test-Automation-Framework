package com.ui.pojo;

import org.openqa.selenium.By;

public class AddressPOJO {

	private String company;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInfo;
	private String addressAlias;
	

	public AddressPOJO(String company, String address1, String address2, String city, String state, String postalCode,
			String homePhoneNumber, String mobileNumber, String otherInfo, String addressAlias) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInfo = otherInfo;
		this.addressAlias = addressAlias;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", postalCode=" + postalCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", otherInfo=" + otherInfo + ", addressAlias=" + addressAlias
				+ "]";
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public String getAddressAlias() {
		return addressAlias;
	}
	
}
