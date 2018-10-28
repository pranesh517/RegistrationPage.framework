package com.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.commonutils.LaunchBrowser;
import com.contants.RegistrationPageConstants;
import com.pages.LoginPage;
import com.pages.RegistrationLoginDataProvider;
import com.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationTest extends LaunchBrowser {
	WebDriver driver;
	ExtentReports extents;
	ExtentTest logger;
	
	@BeforeTest
	public void startReports(){
		extents = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+System.currentTimeMillis()+".html", true);
		extents.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
	}
	
	@Test(dataProvider = "TC001", dataProviderClass = RegistrationLoginDataProvider.class)
	public void TC001(String emailID) throws IOException {
		logger = extents.startTest("Enter value in Text fields");
		driver = launchBrowser();
		logger.log(LogStatus.PASS, "URL is launched successfully.");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueInEmailIDTextField(emailID);
		logger.log(LogStatus.PASS, "Value entered in Email ID Field.");
		RegistrationPage registrationPage = loginPage.clickOnLoginButton();
		logger.log(LogStatus.PASS, "Clicked on Sign IN button.");
		registrationPage.enterValueInFirstNameTextField();
		logger.log(LogStatus.PASS, "Value entered in First Name Field.");
		registrationPage.enterValueInLastNameTextField();
		logger.log(LogStatus.PASS, "Value entered in Last Name Field.");
	}
	
	@Test(dataProvider = "TC001", dataProviderClass = RegistrationLoginDataProvider.class)
	public void TC002(String emailID) throws IOException{
		logger = extents.startTest("Enter value in Text fields");
		driver = launchBrowser();
		logger.log(LogStatus.PASS, "URL is launched successfully.");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueInEmailIDTextField(emailID);
		logger.log(LogStatus.PASS, "Value entered in Email ID Field.");
		RegistrationPage registrationPage = loginPage.clickOnLoginButton();
		logger.log(LogStatus.PASS, "Clicked on Sign IN button.");
		String pageTitle = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(pageTitle, RegistrationPageConstants.REGISTRATION_PAGE_TITLE);
		logger.log(LogStatus.PASS, "Registration page title is as expected.");
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result){
		if(ITestResult.FAILURE == result.getStatus()){
			logger.log(LogStatus.FAIL, "Test is failed.");
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		} else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		extents.endTest(logger);
		//driver.quit();
	}
	
	@AfterTest
	public void endReport(){
		extents.flush();
		extents.close();		
	}

}
