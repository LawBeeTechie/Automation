package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utils.TestUtility;

public class LoginExcelDataProvider {
	/*
		1D Array
		2D Array
		Iterator
	*/
	//When asked in interview .What if the DP doesn't have a name? The name of the method becomes the DP name 
		@DataProvider(name = "loginDP2")
		public  String[][] loginExcelDP() {
			return TestUtility.readExcelFile("TestData.xls.xlsx", "Login");
			
	}
}
