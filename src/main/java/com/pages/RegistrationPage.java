package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.commonutils.SeleniumMethods;

public class RegistrationPage extends SeleniumMethods {
	WebDriver driver;
	
	/**
	 * First Name text box.
	 */
	@FindBy(how = How.CSS, using = "input[placeholder='First Name']")
	private WebElement firstNameTextBox;
	
	/**
	 * Last Name text box.
	 */
	@FindBy(how = How.CSS, using = "input[placeholder='Last Name']")
	private WebElement lastNameTextBox;
	
	/**
	 * Page Title.
	 */
	@FindBy(how= How.XPATH, using = "//h2[contains(text(),'Register')]")
	private WebElement registrationPageTitle;
	
	/**
	 * Default constructor.
	 * @param driver
	 */
	public RegistrationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will enter value in First Name text field.
	 */
	public void enterValueInFirstNameTextField() {
		waitForElementToBeVisible(firstNameTextBox, driver);
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys("ABC");
	}
	
	/**
	 * This method will enter value in Last Name text field.
	 */
	public void enterValueInLastNameTextField() {
		waitForElementToBeVisible(lastNameTextBox, driver);
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys("XYZ");
	}
	
	/**
	 * This method will get Title of Registration page.
	 * @return: Page title.
	 */
	public String getRegistrationPageTitle() {
		waitForElementToBeVisible(registrationPageTitle, driver);
		return registrationPageTitle.getText().trim();
	}

}
