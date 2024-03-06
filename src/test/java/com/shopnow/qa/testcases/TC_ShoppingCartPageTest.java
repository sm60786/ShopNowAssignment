package com.shopnow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopnow.qa.pageobject.ShoppingCartPage;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class TC_ShoppingCartPageTest extends BaseTest {
	
	ShoppingCartPage shopCartPage;
	ReadConfigurationFile readConfig;
	
	@Test(priority = 1)
	void verifyShoppingCartPageTitle() {
		readConfig = new ReadConfigurationFile();
		shopCartPage = new ShoppingCartPage(driver);
		String actTitle = shopCartPage.getTitle();
		boolean titleResult = actTitle.contains(readConfig.getValue("productName"));
		Assert.assertTrue(titleResult);
	}
	
	@Test(priority = 2)
	void verifyProductInShoppingCart() {
		shopCartPage = new ShoppingCartPage(driver);
		readConfig = new ReadConfigurationFile();
		String productName = shopCartPage.verifyProductName();
		boolean productNameResult = productName.contains(readConfig.getValue("productName"));
		Assert.assertTrue(productNameResult);
	}
	
	@Test(priority = 3)
	void clickOnPlaceOrder() {
		shopCartPage = new ShoppingCartPage(driver);
		shopCartPage.clickOnPlaceOrderButton();
	}
	
}
