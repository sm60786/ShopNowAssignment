package com.shopnow.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopnow.qa.pageobject.SecurePaymentPage;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class TC_SecurePaymentPageTest extends BaseTest {
	
	SecurePaymentPage sPP;
	ReadConfigurationFile readConfig;
	
	@Test
	void fillCheckoutSection() throws InterruptedException {
		readConfig = new ReadConfigurationFile();
		sPP = new SecurePaymentPage(driver);
		sPP.providePhoneNumber(readConfig.getValue("phoneNumber"));
		sPP.clickOnContinueButton();
		Thread.sleep(15000);
		sPP.clickOnLoginButton();
		sPP.clickOnDeliverHereButton();
		sPP.clickOnContinueOnOrderSummary();
		sPP.clickOnAcceptAndContinue();
		sPP.clickOnCreditCardRadioButton();
		sPP.clickOnOrderSummaryButton();
		String productName = sPP.getProductNameInOrderSummary();
		Assert.assertEquals(productName, readConfig.getValue("productName"), "Product Name Mismatch in Order Summary");
	}
	
}
