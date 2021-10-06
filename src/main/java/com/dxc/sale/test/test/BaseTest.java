package com.dxc.sale.test.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.report.ExtentManager;

public class BaseTest {
	
	@BeforeTest
	public void init(final ITestContext testContext) throws IOException {
		String testName = testContext.getName();
		ExtentManager.init(testName);
		WebDriverManager.getstance().getDriver();
		
		
	}
	
	@AfterTest
	public void cleanUp() {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		System.out.println("Closed");
		//driver.close();
	}
}
