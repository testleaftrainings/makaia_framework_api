package com.servicenow.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.servicenow.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;


public class TC_003DeleteIncident extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateIncident";
		testcaseName="DeleteIncident";
		testDescription ="Test data with mandatory Field";
		authors="Hari";
		category="Sanity";
	
	}
	
	@Test(dataProvider="fetchData",dependsOnMethods = {"com.servicenow.testcases.TC_001Create_Incident.runCreateIncident","com.servicenow.testcases.TC_002UpdateIncident.runUpdateIncident"})
	public void runDeleteIncident(String uname,String pwd) throws IOException, InterruptedException {
		
		new Loginpage()
		.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.clickIncident()
		.searchIncident()
		.deleteIncident()
		.verifyDeletedIncident();
		
		}
	

}
