package com.example.cookingrecipe.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static com.jayway.restassured.RestAssured.given;

public class GetRequest {
	private String url;
    com.jayway.restassured.response.Response response;
	
  @Given("^the apis are up and running for \"([^\"]*)\"$")
  public void apiRunning(String url) throws Throwable {
	  this.url = url;
  }

  @When("^a user performs a get request to \\\"([^\\\"]*)\\\"$")
  public void userGetRequest(String addurl) throws Throwable {
	  
	 this.url = this.url + addurl; 
  }

  
  @Then("^the response code is 200$")
  public void userGetResponse() throws Throwable {
	  
	  response = given().when().get(this.url);
	 org.junit.Assert.assertEquals(200, response.statusCode());
  }



}
