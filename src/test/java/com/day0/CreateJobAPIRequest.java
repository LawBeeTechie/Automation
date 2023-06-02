package com.day0;

import com.api.pojo.CreateJobPojo;

import com.utils.Role;
import com.utils.TestUtility;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateJobAPIRequest  {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		baseURI = "http://139.59.91.96:9000/v1";
	
		//CreateJobPojo createJob = new CreateJobPojo(0, 0, 0, 0, null, null, null, null);
		CreateJobPojo createJob = TestUtility.getCreateJobRequestBody();
		Header header1 = new Header ("Content-Type", "application/json");
		Header header2 = new Header("Authorization", TestUtility.getAuthToken(Role.FD)); 
		Headers headers = new Headers (header1, header2);
		
		Response response = given()
							.headers(headers)
							.body(createJob) //(TestUtility.toJson(TestUtility.getCreateJobRequestBody())) u can use this directly and leave out line 21 which is the creation of createjob object
							.post("/job/create");		
		System.out.println(response.asPrettyString());
		 
	
	}

}
