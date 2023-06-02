package com.featuretest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import com.api.pojo.LoginPojo;
import com.utils.TestUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginTest {
	String endpoint;
	Response response;
	LoginPojo d;
@Given("Backend URL and login endpoint")
public void backend_url_and_login_endpoint() {
    // Write code here that turns the phrase above into concrete actions
    baseURI = "http://139.59.91.96:9000/v1";
    endpoint = "/login";
}

@When("a valid user enters their credentials")
public void a_valid_user_enters_their_credentials() {
	 d = TestUtility.loginpojo();
    // Write code here that turns the phrase above into concrete actions
	 response =  given().header(new Header("Content-Type", "application/json"))
	 .body(d).when().log().all().post(endpoint);
}

@Then("the response status code is {int}")
public void the_response_status_code_is(Integer statusCode) {
    // Write code here that turns the phrase above into concrete actions
    response.then().statusCode(statusCode);
}



}
