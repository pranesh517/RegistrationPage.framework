package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.commonutils.SeleniumMethods;

public class LoginPage extends SeleniumMethods {
	WebDriver driver;
	
	/**
	 * Login button
	 */
	@FindBy(how = How.ID, using ="enterimg")
	private WebElement loginButton;
	
	/**
	 * Email ID text field.
	 */
	@FindBy (how = How.ID, using="email")
	private WebElement emailIDTextField;
	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will enter value in Email ID text field.
	 * @param emailID
	 */
	public void enterValueInEmailIDTextField(String emailID){
		waitForElementToBeVisible(emailIDTextField, driver);
		emailIDTextField.clear();
		emailIDTextField.sendKeys(emailID);
	}
	
	/**
	 * This method will click on Login button.
	 * @return: Registration Page object.
	 */
	public RegistrationPage clickOnLoginButton() {
		waitForButtonToBeClickable(loginButton, driver);
		loginButton.click();
		return new RegistrationPage(driver);
	}

}
