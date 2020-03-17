package com.qa.rest.test;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetCallBDD {
	public String baseURL = "https://jsonplaceholder.typicode.com/";
	
	
	@Test
	public void test_GetUser() {
				Response response = get(baseURL + "users");
		response.then().body("username", hasItems("Samantha"));
		//System.out.println(response.asString());
		
		 String jsonString = response.asString();
		 System.out.println(response.getStatusCode()); 
		 Assert.assertEquals(jsonString.contains("Samantha"), true);
		
		
		}
	
		 	
}
