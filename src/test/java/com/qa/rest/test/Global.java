package com.qa.rest.test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Global {
	public static String BaseURL = "https://jsonplaceholder.typicode.com/";
	public static String UserName ="Samantha";
	public static int UserId;
	//
	public static Response GetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
            given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get(endpoint).
                then().contentType(ContentType.JSON).extract().response();
    }
	
}
