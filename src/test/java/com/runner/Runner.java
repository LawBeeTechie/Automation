package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {
	public static String env, testType, component, name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (verifyEnvType(args[0]) && verifyTestType(args[1]) && verifyComponentType(args[2])) {
			env = args[0].toLowerCase();
			testType = args[1].toLowerCase();
			component = args[2].toLowerCase();
			name = env + "_" + testType + "_" + component;
			generateDynamicXML();
			
		} else {
			System.out.println("Invalid Config!! Please select the right config to begin the test");
			System.exit(0);
		}
	/*	1
	 * 	env = args[0];
		testType = args[1];
		component = args[2];
	*/	
		System.out.println(env);
		System.out.println(testType);
		System.out.println(component);
		
	}
// heart where the deciding would happen
	private static void generateDynamicXML() {
		// TODO Auto-generated method stub
		System.out.println("Create a Custom dynamic testing xml file");
		
		TestNG mytestNg = new TestNG();
		
		//Create an instance of xml Suite and assign a name for it;
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName(name+ " _Suite");
		
		//Create an instance of xmlTest and assign a name for it;
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName(name+ " _Test");
				//("com."+component+".test") must be the same with the name of the package ..com.api.test .. com.ui.test
		XmlPackage myxmlPackage = new XmlPackage("com."+"component"+".customrunner");
		
		List<XmlPackage> myPackageList = new ArrayList<XmlPackage>();
		myPackageList.add(myxmlPackage);
		myTest.setPackages(myPackageList);
		myTest.addIncludedGroup("sanity");
		
		List<XmlTest> myTestList = new ArrayList <XmlTest>();
		myTestList.add(myTest);
		
		List<XmlSuite> mySuiteList = new ArrayList<XmlSuite>();
		mySuiteList.add(mySuite);
		
		// Set the list of suites to the TestNG object u created earlier
		mytestNg.setXmlSuites(mySuiteList);
		
		//Invoke run() - this will run your class
		mytestNg.run();
		
		
	}

	private static boolean verifyEnvType(String env) {
		// TODO Auto-generated method stub
		if(env.equalsIgnoreCase("DEV") || env.equalsIgnoreCase("QA") || env.equalsIgnoreCase("UAT")) {
			return true;
		} else {
			System.err.println("Invalid Env Type valid value are DEV/QA or UAT");
			return false;
		}
	}
	
	private static boolean verifyTestType(String testType) {
		// TODO Auto-generated method stub
		if(testType.equalsIgnoreCase("sanity") || testType.equalsIgnoreCase("smoke") || 
				testType.equalsIgnoreCase("e2e") ) {
			return true;
		} else {
			System.err.println("Invalid Test Type valid value are Sanity/ Smoke or UAT");
			return false;
		}
	}
	private static boolean verifyComponentType(String component) {
		// TODO Auto-generated method stub
		if(component.equalsIgnoreCase("api") ) {
			return true;
		} else {
			System.err.println("Invalid component Type valid values for api ");
			return false;
		}
	}
	
}
