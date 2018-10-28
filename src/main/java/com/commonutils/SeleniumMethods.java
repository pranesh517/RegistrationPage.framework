package com.commonutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {
	
	/**
	 * This method will wait for element until it is visible.
	 * @param element: Webelement to be wait for.
	 * @param driver: driver object.
	 */
	public void waitForElementToBeVisible(WebElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until page loads.
	 * @param driver: driver object.
	 */
	public void waitForLoadingRing(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait until button is clickable.
	 * @param element: Element to be clicked.
	 * @param driver: driver object.
	 */
	public void waitForButtonToBeClickable(WebElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
