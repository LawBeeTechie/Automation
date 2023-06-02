package com.day0;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleAPIRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 RestAssured.baseURI = "http://www.google.com"; 
		 
		 RequestSpecification requestSpecification = RestAssured.given();//add RestAssured.given() 1st
		 // then the return type is RequestSpecification
		 
		 Response response = requestSpecification.get();// add requestSpecification then .get() 
		 // it can be a get request or post or whatever the http verb is. Using the return type of 
		 //Response
		 
		  // if you say only print response it gives you a memory address but
		 // response in line 15 is a reference variable. SO, add .asPrettyString() to make it readable
		 
		 System.out.println(response.statusCode());//for statusCode
		 System.out.println(response.time());		//response time .timeIn to select time range sec or mm
		 System.out.println(response.timeIn(TimeUnit.SECONDS ));
	
	}

}
