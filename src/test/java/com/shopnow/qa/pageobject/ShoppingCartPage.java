package com.shopnow.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	WebDriver ldriver;
	
	public ShoppingCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Acer Extensa (2023)')]")
	private WebElement productLink;
	@FindBy(xpath = "//span[text()='Place Order']/parent::button")
	private WebElement buttonPlaceOrder;
	
	public String getTitle() {
		return ldriver.getTitle();
	}
	
	public String verifyProductName() {
		String productName = productLink.getText();
		return productName;
	}
	
	public void clickOnPlaceOrderButton() {
		buttonPlaceOrder.click();
	}
	
}
