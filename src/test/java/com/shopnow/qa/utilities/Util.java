package com.shopnow.qa.utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopnow.qa.testcases.BaseTest;

public class Util extends BaseTest {
	
	WebDriverWait wait;
	ReadConfigurationFile readConfig;
	
	public void switchDriverControlOnTitle(String expTitle) {
		Set<String> wIds = driver.getWindowHandles();
		for (String i : wIds) {
			String actTitle = driver.getTitle();
			if (!actTitle.contains(expTitle)) {
				driver.switchTo().window(i);
			} else {
				break;
			}
		}
	}
	
	public void applyExplicitWait(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICITLY_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
}
