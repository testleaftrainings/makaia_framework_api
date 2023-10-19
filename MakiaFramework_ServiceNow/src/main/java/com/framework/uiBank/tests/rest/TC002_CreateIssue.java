package com.framework.uiBank.tests.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TC002_CreateIssue extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create New Account";
		testDescription = "Create New Account using REST API";
		authors = "Hari";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) {	
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Authorization", token);
		Response response = postWithHeaderAndFileBody(headers, file, "accounts");
		verifyResponseCode(response, 200);
		
		 
		
	}


}




















