package com.servicenow.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.servicenow.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;


public class TC_001Create_Incident extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateIncident";
		testcaseName="CreateIncident";
		testDescription ="Test data with mandatory Field";
		authors="Hari";
		category="Funtional";
		
	
	}
	
	
	
	@Test(dataProvider="fetchData")
	public void runCreateIncident(String uname,String pwd) throws IOException, InterruptedException {
		
		new Loginpage()
		.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.clickIncident()
		.clickNewOption()
		.getIncidentNum()
		.enterShortDescription()
		.clickSubmitButton()
		.getTheIncident()
		;
		
		}
	

}
