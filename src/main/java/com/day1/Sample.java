package com.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	WebDriver wd = new ChromeDriver();//FirefoxDriver();
		//wd.get("https://phoneix.testautomationacademy.in");//1st exception-InvalidArgumentException
		wd.get("https://www.goggle.com");

	}

}
