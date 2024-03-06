package com.shopnow.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.shopnow.qa.utilities.Constants;
import com.shopnow.qa.utilities.ReadConfigurationFile;

public class BaseTest {
	
	public static WebDriver driver;
	ChromeOptions opt;
	
	ReadConfigurationFile readConfig;
	
	@BeforeSuite
	public void setUp() {
		readConfig = new ReadConfigurationFile();
		String appUrl = readConfig.getUrl();
		String browser = readConfig.getBrowser();
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
			break;
		default:
			driver = null;
			break;
		}
		
		// Implicit Wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_WAIT));
		
		// Maximize browser
		driver.manage().window().maximize();
		
		driver.get(appUrl);
	}
	
	@AfterSuite
	public void tearDown() {
//		driver.quit();
	}
	
}
