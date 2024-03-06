package com.shopnow.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopSearchPage {
	
	WebDriver ldriver;
	
	public LaptopSearchPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@class='_1AtVbE col-12-12']/descendant::div[contains(text(), 'Acer Extensa (2023)')]")
	private WebElement acerLaptop;
	
	public String getCurrentUrl() {
		return ldriver.getCurrentUrl();
	}
	
	public void clickOnLaptop() {
		acerLaptop.click();
	}
	
}
