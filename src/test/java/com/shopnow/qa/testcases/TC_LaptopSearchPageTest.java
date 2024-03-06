package com.shopnow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopnow.qa.pageobject.LaptopSearchPage;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class TC_LaptopSearchPageTest extends BaseTest {
	
	LaptopSearchPage lapSearchPage;
	ReadConfigurationFile readConfig;
	
	@Test(priority = 1)
	void verifySearchPageTitle() {
		readConfig = new ReadConfigurationFile();
		Assert.assertEquals(driver.getTitle(), readConfig.getValue("titleSearchPage"), "Searchpage Title Mismatch");
	}
	
	@Test(priority = 2)
	void addToCart() {
		lapSearchPage = new LaptopSearchPage(driver);
		lapSearchPage.clickOnLaptop();
	}
	
}
