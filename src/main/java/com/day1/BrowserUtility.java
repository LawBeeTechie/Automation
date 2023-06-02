package com.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtility {
	private WebDriver wd;
	
	
	
	public void launchBrowser() {
		wd = new ChromeDriver();
		
	}
	
	public void goToWebsite(String enterURL) {
		wd.get(enterURL);
	}

}
