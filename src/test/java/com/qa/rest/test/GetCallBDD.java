package com.qa.rest.test;

import static org.testng.Assert.assertEquals;
import org.json.*;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	
	
	

	public static RequestSpecification request;
	@Test (priority =0)
	public void GetUser() throws JSONException {
		String userName ="";
		Response response = Global.GetRequest(Global.BaseURL + "users");
		Assert.assertEquals(response.getStatusCode(), 200);
		String jsonString =  response.asString().toString(); //assign your JSON String here
		JSONArray arr = new JSONArray(jsonString);
		Assert.assertNotEquals(arr.length(), 0);
		for (int i = 0; i < arr.length(); i++)
		{
		if (arr.getJSONObject(i).getString("username").equals(Global.UserName))
		{
			Global.UserId = arr.getJSONObject(i).getInt("id");
			userName = arr.getJSONObject(i).getString("username");
			break;
		}

		}
		 Assert.assertEquals(userName.equals(Global.UserName), true);
		}
	
	@Test (priority =1)
	public void GetUserPost() throws JSONException {
		String userName ="";
		Response response = Global.GetRequest(Global.BaseURL + "posts?userId="+Global.UserId);
		Assert.assertEquals(response.getStatusCode(), 200);
		String jsonString =  response.asString().toString(); //assign your JSON String here
		JSONArray arr = new JSONArray(jsonString);
		Assert.assertNotEquals(arr.length(), 0);
//		for (int i = 0; i < arr.length(); i++)
//		{
//		if (arr.getJSONObject(i).getString("username").equals(Global.UserName))
//		{
//			Global.UserId = arr.getJSONObject(i).getInt("id");
//			userName = arr.getJSONObject(i).getString("username");
//			break;
//		}
//
//		}
//		 Assert.assertEquals(userName.equals(Global.UserName), true);
		}

	@Test (priority =2)
	public void GetUserPostComment() throws JSONException {
		String userName ="";
		Response response = Global.GetRequest(Global.BaseURL + "posts?userId="+Global.UserId);
		Assert.assertEquals(response.getStatusCode(), 200);
		String jsonString =  response.asString().toString(); //assign your JSON String here
		JSONArray arr = new JSONArray(jsonString);
		Assert.assertNotEquals(arr.length(), 0);
		for (int i = 0; i < arr.length(); i++)
		{
			Response commentResponse = Global.GetRequest(Global.BaseURL + "posts/"+arr.getJSONObject(i).getInt("id")+"comments");
			Assert.assertEquals(commentResponse.getStatusCode(), 200);
			String commentsJsonString =  commentResponse.asString().toString(); //assign your JSON String here
			JSONArray commentList = new JSONArray(commentsJsonString);
			//Assert.assertNotEquals(commentList.length(), 0);
			for (int j = 0; j < commentList.length(); j++)
			{
			System.out.print(commentList.getJSONObject(j).getString("email"));
			}
			
		}
		}
	
	
	
	
	
}
