package com.framework.selenium.servicenow.pages;

import java.io.IOException;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class Loginpage extends BaseMethods {

	public Loginpage enterUsername(String uname) throws IOException {
		
		typeAndTab(locateElement(Locators.ID, "user_name"), uname);
		reportStep(uname, uname);
		return this;

	}

	public Loginpage enterPassword(String pwd) throws IOException {

		typeAndTab(locateElement(Locators.ID, "user_password"), pwd);
		return this;
	}

	public WelcomePage clickLogin() throws IOException {
		click(locateElement(Locators.ID, "sysverb_login"));
		return new WelcomePage();

	}

}
