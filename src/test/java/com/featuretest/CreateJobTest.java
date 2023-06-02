package com.featuretest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import com.api.pojo.CreateJobPojo;
import com.utils.Role;
import com.utils.TestUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateJobTest {
	String endpoint;
	Headers headers;
	String createJobRequestBody;
	Response response;
	
@Given("Backend URL and Login endpoint")
public void backend_url_and_login_endpoint() {
    // Write code here that turns the phrase above into concrete actions
	  baseURI = "http://139.59.91.96:9000/v1";
	  endpoint = "/job/create";
	  
}
@When("a valid user creates job")
public void a_valid_user_creates_job() {
	Header header1 = new Header ("Content-Type", "application/json");
	Header header2 = new Header("Authorization", TestUtility.getAuthToken(Role.FD));
	   headers = new Headers(header1 , header2);
	  String createJobRequestBody = TestUtility.toJson(TestUtility.getCreateJobRequestBody());
	
    // Write code here that turns the phrase above into concrete actions
	 response = given().headers(headers)
	 .body(createJobRequestBody).when()	
.log().all().post("/job/create");

}



}
