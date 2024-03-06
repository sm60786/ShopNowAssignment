package com.shopnow.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopnow.qa.utilities.Util;

public class ProductPage {
	
	WebDriver ldriver;
	Util util;
	
	public ProductPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement buttonAddToCart;
	@FindBy(id = "pincodeInputId")
	private WebElement txtDeliveryPincode;
	@FindBy(xpath = "//span[text()='Check']")
	private WebElement buttonCheck;
	
	public void clickOnAddToCart(String expTitle, String pincode) throws InterruptedException {
		util = new Util();
		util.switchDriverControlOnTitle(expTitle);
		txtDeliveryPincode.sendKeys(pincode);
		buttonCheck.click();
		Thread.sleep(1000);
		buttonAddToCart.click();
	}
	
}
