package com.shopnow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopnow.qa.pageobject.HomePage;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class TC_HomePageTest extends BaseTest {
	
	HomePage homePage;
	ReadConfigurationFile readConfig;
	
	@Test(priority = 1)
	void verifyHomePageTitle() {
		readConfig = new ReadConfigurationFile();
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.verifyHomePageTitle(), readConfig.getValue("titleHomePage"), "HomePage Title is not as expected");
	}
	
	@Test(priority = 1)
	void verifyHomePageUrl() {
		readConfig = new ReadConfigurationFile();
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.verifyHomePageLink(), readConfig.getUrl(), "HomePage URL is not as expected");
	}
	
	@Test(priority = 1)
	void verifyHomePageLogoDisplayed() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyHomePageLogo());
	}
	
	@Test(priority = 2)
	void enterItemOnSearchTextField() {
		readConfig = new ReadConfigurationFile();
		homePage = new HomePage(driver);
		homePage.enterInSearchTextField(readConfig.getSearchTextFieldItem());
		homePage.clickOnSearchButton();
	}
	
}
