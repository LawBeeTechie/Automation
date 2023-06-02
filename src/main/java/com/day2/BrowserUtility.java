package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	private WebDriver wd;

	//toString
	public BrowserUtility(WebDriver wd) {
		super();
		this.wd = wd;
	}
	
	//getters&setters 
	public WebDriver getWd() {
		return wd;
	}

	public void setWd(WebDriver wd) {
		this.wd = wd;
	}

	//Browser to use
	public BrowserUtility(Browser browser) {
	if (browser == Browser.CHROME) {
		WebDriverManager.chromedriver().setup();
		 wd = new ChromeDriver();
	}	
	else if (browser == Browser.FIREFOX) {
		WebDriverManager.firefoxdriver().setup();
		wd = new FirefoxDriver();
	}
}
	//Website to visit
	public void goToWebsite(String url) {
		wd.get(url);
		sleepFor(4);
	}
	

	//Maximize my Window
	public void maximizeTheWindow() {
	wd.manage().window().maximize();
	}
	

	//Entering an element and the string character to be entered 
	public void enterText(By elementLocator, String textToEnter) {
		WebElement element = wd.findElement(elementLocator);
		element.clear();
		element.sendKeys(textToEnter);
	}

	//public BrowserUtility() {
		// TODO Auto-generated constructor stub
	//}


	//Entering an element and using keyboardSpecialEnum Keys
	public void enterText(By elementLocator, Keys keyToEnter) {
		sleepFor(4);
		WebElement element = wd.findElement(elementLocator);
		element.clear();
		element.sendKeys(keyToEnter);
	}

	// Clicking on the button
	public void clickOnButton(By elementLocator) {// The \ is to ignore the double quote
		sleepFor(4);
		WebElement element = wd.findElement(elementLocator);
		element.click();
	}
	
	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getVisibleText(By locatorForTheElement) {
		WebElement element = wd.findElement(locatorForTheElement);
		String data = element.getText();
		return data;
	}

}
