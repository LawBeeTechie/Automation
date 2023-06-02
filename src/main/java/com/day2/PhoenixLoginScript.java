package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhoenixLoginScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver wd = new ChromeDriver();
		Thread.sleep(5000);
		
		wd.get("https://www.phoenix.testautomationacademy.in/sign-in");//enter the webpage
		wd.manage().window().maximize();			//maximize the webpage
		By userNameTextBoxLocator = By.id("username");//finding the elements using id selector
		By passwordNameTextBoxLocator = By.id("password");
		Thread.sleep(1000);
		
		//Inputing character into the elements
		WebElement userNameTextBoxElement = wd.findElement(userNameTextBoxLocator);//NoSuchElementException - if no matching elements are found
		userNameTextBoxElement.clear();
		userNameTextBoxElement.sendKeys("iamsup");
		Thread.sleep(1000);
		
		WebElement passwordTextBoxElement = wd.findElement(passwordNameTextBoxLocator);
		passwordTextBoxElement.clear();
		passwordTextBoxElement.sendKeys("password");
		Thread.sleep(1000);
		
		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in\")]/../..");// The \ is to ignore the double quote
		WebElement signInButtonElement = wd.findElement(signInButtonLocator);
		signInButtonElement.click();
		//The Thread makes the execution slow is it would be removed in future
		

	}

}
