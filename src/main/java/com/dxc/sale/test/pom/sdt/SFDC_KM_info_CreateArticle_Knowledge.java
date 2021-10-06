package com.dxc.sale.test.pom.sdt;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.dxc.sale.test.Functions.KM_Function;
import com.dxc.sale.test.framework.generic.GenericLib;

import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;


public class SFDC_KM_info_CreateArticle_Knowledge {

	final static Logger log = LogManager.getLogger(SFDC_KM_info_CreateArticle_Knowledge.class);

	private GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;

	private static WebDriver driver;
	// ExtentTest logTest;

	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);
		// logger = test.createTest("Description");

	}

	public void test(String SdEmID, String SdPwrd, String SSrlNum,String Title,String ReslnTitle,String PublishedArticle) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();

//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		Robot re = new Robot();
		try {

			KM_Function func = new KM_Function();
			func.beforemethod();
			KM_Function.createArticle(SdEmID, SdPwrd, ReslnTitle);
			KM_Function.info(SdEmID, SdPwrd, ReslnTitle);
			func.test(SdEmID, SdPwrd, SSrlNum,Title,ReslnTitle);
			SFDC_KM_CreateArticle_Knowledge_SecondLevelApprove scapp= new SFDC_KM_CreateArticle_Knowledge_SecondLevelApprove();
			
			scapp.beforemethod();
			scapp.test(SdEmID, SdPwrd, SSrlNum, Title, ReslnTitle, PublishedArticle);
			KM_Function.createArticle(SdEmID, SdPwrd, ReslnTitle);
			KM_Function.info(SdEmID, SdPwrd, ReslnTitle);
			KM_Function.Resolution(SdEmID, SdPwrd,ReslnTitle);

			

		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}

		System.out.println("KM Info Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}