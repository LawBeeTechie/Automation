package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.day2.Browser.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhoenixLoginScript2modified {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub....  you can write this as Browser.CHROME or do a static
												//import and write as just CHROME.Check line 9
		BrowserUtility bu = new BrowserUtility(Browser.CHROME); // the screaming is due to the fact i have name the browserUtility class as abstract
		bu.goToWebsite("https://www.phoenix.testautomationacademy.in/sign-in");//enter the webpage
		bu.maximizeTheWindow();			//maximize the webpage
		bu.enterText(By.id("username"), "iamsup"); //use By to find the element and .sendkeys //string//
		bu.enterText(By.id("password"), "password");
		bu.clickOnButton(By.xpath( "//span[contains(text(),\"Sign in\")]/../.."));// The \ is to ignore the double quote
		bu.enterText(By.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"), "JOB_23204");
		bu.enterText(By.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"), Keys.ENTER);//enterText key function

	}
 
}
