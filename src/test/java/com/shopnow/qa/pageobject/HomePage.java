package com.shopnow.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	private WebElement logoFlipkart;
	@FindBy(xpath = "//input[@class='Pke_EE']")
	private WebElement txtFieldSearch;
	@FindBy(xpath = "//input[@class='Pke_EE']/..//preceding-sibling::button")
	private WebElement btnSearch;
	
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public boolean verifyHomePageLogo() {
		return logoFlipkart.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return ldriver.getTitle();
	}
	
	public String verifyHomePageLink() {
		return ldriver.getCurrentUrl();
	}
	
	public void enterInSearchTextField(String item) {
		txtFieldSearch.sendKeys(item);
	}
	
	public void clickOnSearchButton() {
		btnSearch.click();
	}
	
}
