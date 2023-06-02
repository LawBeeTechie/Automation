package com.day0;


import com.api.pojo.LoginPojo;
import com.utils.TestUtility;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class LoginAPIRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //baseURI = "http://139.59.91.96:9000/v1"; 

		 LoginPojo loginpojo = new LoginPojo("iamfd", "password");
		 String loginRequestBody = TestUtility.toJson(loginpojo); //3
/*
		 Header headerOne = new Header("Content-Type", "application/json");
		 requestSpecification.header(headerOne);
		 requestSpecification.body(loginRequestBody);   		//4
		 Response response = requestSpecification.post("/login");
		 System.out.println(response.asPrettyString());
		 System.out.println(response.statusCode());
		 System.out.println(response.time());			// Code block 1
*/		 
		
		 
//	LINQ style of writing code block 1 . linq is more acceptable
	  baseURI = "http://139.59.91.96:9000/v1"; 
		 
		 Response response = given()
		 				.header(new Header("Content-Type", "application/json"))
		 				.body("{\r\n"
						 		+ "    \"username\": \"iamfd\",\r\n"
						 		+ "    \"password\": \"password\"\r\n"
						 		+ "}")
						.post("/login");
		 System.out.println(response.asPrettyString());
	  
		 //How to retrieve data from Response using Rest Assured		Code block 2
		 JsonPath jsonPath = new JsonPath(response.asPrettyString());
		 String token = jsonPath.getString("data.token");
		 System.out.println(token);
		 String message = jsonPath.getString("message");
		 System.out.println(message);
		 
		 
		 
	}

}
