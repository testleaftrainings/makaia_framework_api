package com.framework.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

public class BaseMethods extends SeleniumBase {


	
	@DataProvider(name = "fetchData",indices=0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.getSheet(excelFileName);
	}
	
	@BeforeMethod
	public void  preCondition() {
		startApp("chrome", false, "https://dev63112.service-now.com/");
		setNode();
		setDom();
	}
	
	@AfterMethod
	public void postCondition() {
		//quit();
	}

	

	
	  

	
	
}
