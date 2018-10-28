package com.pages;

import org.testng.annotations.DataProvider;

public class RegistrationLoginDataProvider {

	/**
	 * This data provider will pass data for TC001.
	 * @return: test data.
	 */
	@DataProvider(name ="TC001")
	public static Object[][] getEmailID(){
		return new Object[][]{{"abc@xyz.com"}};
	}
}
