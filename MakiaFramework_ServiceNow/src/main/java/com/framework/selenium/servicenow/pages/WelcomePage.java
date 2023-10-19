package com.framework.selenium.servicenow.pages;

import com.framework.testng.api.base.BaseMethods;

public class WelcomePage extends BaseMethods {

	public WelcomePage clickAll() throws InterruptedException {
        pause(15000);
		click(locateShadowElement("//div[text()='All']"));
		return this;
	}

	public IncidentsPage clickIncident() {

		waitForApperance(locateShadowElement("//input[@id='filter']"));

		click(locateShadowElement("//span[text()='Incidents']"));

		return new IncidentsPage();
	}

	
}
