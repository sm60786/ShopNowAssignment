package com.shopnow.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopnow.qa.utilities.Util;

public class SecurePaymentPage {
	
	WebDriver ldriver;
	Util util;
	
	public SecurePaymentPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtFieldEmail;
	@FindBy(xpath = "//span[text()='CONTINUE']/ancestor::button")
	private WebElement buttonContinue;
	@FindBy(xpath = "//span[text()='Login']/ancestor::button")
	private WebElement buttonLogin;
	
	@FindBy(xpath = "//button[text()='Deliver Here']")
	private WebElement buttonDeliverHere;
	
	@FindBy(xpath = "//button[text()='CONTINUE']")
	private WebElement buttonContinueOrderSummary;
	
	@FindBy(xpath = "//button[text()='Accept & Continue']")
	private WebElement buttonAcceptAndContinue;
	
	@FindBy(xpath = "//input[@id='CREDIT']/following-sibling::div[1]")
	private WebElement radioCreditCard;
	
	@FindBy(xpath = "//div[text()='Order Summary']/parent::div/following-sibling::button")
	private WebElement buttonChangeOrderSummary;
	@FindBy(xpath = "//div[contains(text(), 'Acer Extensa (2023)')]")
	private WebElement textProductName;
	
	public void providePhoneNumber(String phoneNumber) {
		txtFieldEmail.sendKeys(phoneNumber);
	}
	
	public void clickOnContinueButton() {
		buttonContinue.click();
	}
	
	public void clickOnLoginButton() {
		buttonLogin.click();
	}
	
	public void clickOnDeliverHereButton() {
		buttonDeliverHere.click();
	}
	
	public void clickOnAcceptAndContinue() {
		buttonAcceptAndContinue.click();
	}
	
	public void clickOnCreditCardRadioButton() {
		radioCreditCard.click();
	}
	
	public void clickOnContinueOnOrderSummary() {
		buttonContinueOrderSummary.click();
	}
	
	public void clickOnOrderSummaryButton() {
		util = new Util();
		util.applyExplicitWait(buttonChangeOrderSummary);
	}
	
	public String getProductNameInOrderSummary() {
		return textProductName.getText();
	}
	
}
