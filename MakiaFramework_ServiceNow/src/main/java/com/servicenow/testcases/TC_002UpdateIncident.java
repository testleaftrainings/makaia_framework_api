package com.servicenow.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.servicenow.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;


public class TC_002UpdateIncident extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateIncident";
		testcaseName="UpdateIncident";
		testDescription ="Test data with mandatory Field";
		authors="Hari";
		category="Regression";
	
	}
	
	@Test(dataProvider="fetchData",dependsOnMethods = "com.servicenow.testcases.TC_001Create_Incident.runCreateIncident")
	public void runUpdateIncident(String uname,String pwd) throws IOException, InterruptedException {
	
		
		new Loginpage()
		.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.clickIncident()
		.searchIncident()
		.updateUrgency()
		.updateState()
		.clickUpdateButton()
		.verifyIncidentNumber();
		
		}
	

}
