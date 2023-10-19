package com.framework.restassured.api.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.framework.utils.DataLibrary;
import com.framework.utils.Reporter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PreAndTest extends Reporter{	
	public static String token;   
	
	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
			
		setNode();
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		
	//	RestAssured.authentication = RestAssured.basic(prop.getProperty("username"),prop.getProperty("password"));
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
	
		Response response = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\"username\":\"FebApiuser\",\"password\":\"Eagle@123\"}")
				.post("users/login");
				
				JsonPath jsonPath = response.jsonPath();
				token = jsonPath.get("id");
	
	}
	
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		if(dataFileType.equalsIgnoreCase("Excel"))
			return DataLibrary.getSheet(dataFileName);	
		else if(dataFileType.equalsIgnoreCase("JSON")){
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/"+dataFileName+"."+dataFileType);
			System.out.println(data[0][0]);
			return data;
		}else {
			return null;
		}
			
	}
	
	
}
