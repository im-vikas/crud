package com.example.cookingrecipe.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.minidev.json.JSONObject;
import cucumber.api.java.en.Then;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class PostRequest {
	private String url;
	
  @Given("^the apis are up and running for url \"([^\"]*)\"$")
  public void apiRunning(String url){
	  this.url = url;
  }

  @When("^a user performs a post request to this \\\"([^\\\"]*)\\\"$")
  public void userGetRequest(String addurl){
	  
	 this.url = this.url + addurl; 
  }

  
  @Then("^the response code is 200 in return$")
  public void userGetResponse(){
	  
	 
	  RequestSpecification request = RestAssured.given();
	  
	  JSONObject payload = new JSONObject();
	  
	  payload.put("title", "Chicken biryani");
	  payload.put("servingsize", "2");
	  payload.put("indicator", "nonveg");
	  payload.put("cookingins", "abcd");
	  payload.put("ingredients", "Chicken,rice");
	  payload.put("url", "palak");
          
	  request.header("Content-Type", "application/json");
	  
	  request.body(payload.toString());
	 
	  Response response = request.post(this.url+"/recipe");
      
      org.junit.Assert.assertEquals(200, response.statusCode());
      

  }


}
