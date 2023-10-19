package com.framework.selenium.servicenow.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class IncidentsPage extends BaseMethods {
	
	

	public CreateIncidentPage clickNewOption() {

		switchToFrame(locateShadowElement("//iframe[@title='Main Content']"));

		click(locateElement(Locators.XPATH, "//button[text()='New']"));

		return new CreateIncidentPage();
	}
	
	public UpdatePage searchIncident(){

		System.out.println(incidentNumber);
		//iframe[@title='Main Content']
		defaultContent();
		WebElement frame = locateShadowElement("//iframe[@title='Main Content']");
		switchToFrame(frame);
//		pause(10000);
//		WebElement ele = locateElement(Locators.XPATH, "(//input[@placeholder='Search'])[1]");
//		typeAndEnter(ele, incidentNumber);
//		click(locateElement(Locators.XPATH, "//table[@id='incident_table']/tbody/tr/td[3]/a"));
		
		//switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
//		locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']");
//		selectDropDownUsingText(locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']"),
//				"Number");
//		pause(15000);
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@class='form-control'])[1]"), incidentNumber);
		click(locateShadowElement("//a[text()='"+incidentNumber+"']"));
		defaultContent();
		return new UpdatePage();
	}

}
