package com.framework.selenium.servicenow.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class VerifyIncidentPage extends BaseMethods {

	public VerifyIncidentPage getTheIncident() {
		switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
		locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']");
		selectDropDownUsingText(locateElement(Locators.XPATH, "//select[@class='form-control default-focus-outline']"),
				"Number");
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@class='form-control'])[1]"), incidentNumber);
		defaultContent();
		return this;
	}

	public VerifyIncidentPage verifyIncidentNumber() {
		//switchToFrame(locateShadowElement("//iframe[@title='Main Content']"));
		getElementText(locateElement(Locators.XPATH, "//table[@id='incident_table']/tbody/tr/td[3]/a"));
		return this;
	}
	
	public VerifyIncidentPage verifyDeletedIncident() {
		defaultContent();
		switchToFrame(locateShadowElement("//iframe[@id='gsft_main']"));
		WebElement ele = locateElement(Locators.XPATH, "//input[@placeholder='Search']");
		typeAndEnter(ele, incidentNumber);
		String elementText = getElementText(locateElement(Locators.XPATH,"//div[text()='No records to display']"));
		System.out.println(elementText);
		return this;

	}

}
