package com.day0;

import com.utils.Role;
import com.utils.TestUtility;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JobAssignmentAPIRequest {
	public static void main (String[] args) {
		RestAssured.baseURI = "http://139.59.91.96:9000/v1";
		
		RequestSpecification request = RestAssured.given();
		
		Header headers1 = new Header("Authorization", TestUtility.getAuthToken(Role.ENG));
		Header headers2 = new Header("Content-Type", "application/json");
		Headers headers = new Headers(headers1, headers2);
		
		request.headers(headers);
		request.body(TestUtility.jobAssignmentRequest());
		Response response = request.post("engineer/assign");
		
		System.out.println(response.asPrettyString());
		 
		JsonPath jsonPath = new JsonPath(response.asPrettyString());
		String token = jsonPath.getString("data");
		System.out.println(token);
	}

}
