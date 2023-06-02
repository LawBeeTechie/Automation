package com.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BrowserUtility {
	
	private static final By PENDING_FOR_DELIVERY_LOCATOR = 
			By.xpath("//div[contains(text(),\"Pending for delivery\")]/../div/button");
	private static final By SEARCH_TEXTBOOK_LOCATOR = 
			By.xpath("//input[@placeholder=\"Search for a Job or IMEI\"]");

	public DashBoardPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public String getTotalPendingForDeliveryJobsCount() {
		String data = getVisibleText(PENDING_FOR_DELIVERY_LOCATOR);
		return data;
	} 
	
	public void searchforJobUsing(String imeiOrJobNumber) {
		enterText(SEARCH_TEXTBOOK_LOCATOR, imeiOrJobNumber);
		enterText(SEARCH_TEXTBOOK_LOCATOR, Keys.ENTER);
		GlobalListPage globalListPage = new GlobalListPage(getWd());
		//globalistpage is returned because when you searchjob it takes u to globallist page
	}
}
