package com.shopnow.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigurationFile {
	
	Properties prop;
	FileInputStream fis;
	String propertiesFilePath = "";
	
	public ReadConfigurationFile() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop = new Properties();
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		String appUrl = prop.getProperty("url");
		if (appUrl != null) {
			return appUrl;
		} else {
			throw new RuntimeException("Application URL is not mentioned in Config.properties file");
		}
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser is not mentioned in Config.properties file");
		}
	}
	
	public String getSearchTextFieldItem() {
		String searchText = prop.getProperty("searchText");
		if (searchText != null) {
			return searchText;
		} else {
			throw new RuntimeException("searchText is empty in Config.properties file");
		}
	}
	
	public String getValue(String key) {
		String val = prop.getProperty(key);
		if (val != null) {
			return val;
		} else {
			throw new RuntimeException(key + " is not provided.");
		}
	}
	
}
