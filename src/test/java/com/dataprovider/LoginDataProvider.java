package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utils.TestUtility;

public class LoginDataProvider {
	/*
		1D Array
		2D Array
		Iterator
	*/
		@DataProvider(name = "loginDP")
		public Iterator<String[]> loginDP() {
			return TestUtility.readCSVFile("loginData.csv");
			
	}
}
