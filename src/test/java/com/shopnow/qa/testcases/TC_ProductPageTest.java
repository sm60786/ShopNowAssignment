package com.shopnow.qa.testcases;

import org.testng.annotations.Test;

import com.shopnow.qa.pageobject.ProductPage;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class TC_ProductPageTest extends BaseTest {
	
	ProductPage prodPage;
	ReadConfigurationFile readConfig;
	
	@Test
	void clickOnAddToCart() throws InterruptedException {
		prodPage = new ProductPage(driver);
		prodPage.clickOnAddToCart("Intel Ryzen", "560076");
	}
	
}
