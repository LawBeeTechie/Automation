package com.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		BrowserUtility bu = new BrowserUtility();
		bu.launchBrowser();
		bu.goToWebsite("https://www.goggle.com");

	}

}
