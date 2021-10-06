package com.dxc.sale.test.pom.Login;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;

public class Login_GSD_CSC {

	final static Logger log = LogManager.getLogger(Login_GSD_CSC.class);

	private GenericLib gl;
	private ExtentReports report;

	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);

	}

	public void test(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		String URL = PropertyLoader.getProperty("URL");

		WebDriver driver = WebDriverManager.getstance().getDriver();
		driver.manage().deleteAllCookies();

		gl.launchApplication(URL);
		// Enter Value in SdEmailId Field
		//By SdEmailId = SeliniumUtil.getElement("SdEmailId");
		////gl.inputText(SdEmailId, "SdEmailId", SdEmID);
		//Thread.sleep(2000);
		// Enter Value in SdPsswrd Field
		//By SdPsswrd = SeliniumUtil.getElement("SdPsswrd");
		//gl.inputText(SdPsswrd, "SdPsswrd", SdPwrd);
		//Thread.sleep(2000);
		// Click Webelemnt
		//By SbxLgn = SeliniumUtil.getElement("SbxLgn");
		//gl.clickElement(SbxLgn, "SbxLgn");
		 System.out.println("launch Application is Successfull");
		
		Robot robot = new Robot();
		//Press key Ctrl+Shift+i
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		//Release key Ctrl+Shift+i
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(20000);
		
		
		   
		
		// test.log(Status.INFO, "launch Application is Successfull");

	}

	public void afterMethod() {
		report.flush();
	}

}