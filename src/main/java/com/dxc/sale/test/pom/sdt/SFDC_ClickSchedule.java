package com.dxc.sale.test.pom.sdt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.report.ExtentManager;

public class SFDC_ClickSchedule {

	final static Logger log = LogManager.getLogger(SFDC_ClickSchedule.class);

	private GenericLib gl;
	private ExtentReports report;
	// private ExtentTest test;

	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);

	}

	public void test(String EmID, String Pwrd) throws Exception {

	
		String basedir = System.getProperty("user.dir");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability("nativeEvents", false);
		caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		System.setProperty("webdriver.ie.driver", basedir + File.separator + "drivers/IEDriverServer.exe");

		WebDriver driver1 = new InternetExplorerDriver(caps);

		Thread.sleep(10000);
		driver1.get("https://hp--test.cs77.my.salesforce.com/home/home.jsp?tsid=02uG0000000McC1");
		Thread.sleep(20000);

		// Maximize the browser
		driver1.manage().window().maximize();
		Thread.sleep(6000);

		// Click Webelemnt
		WebDriverWait wait = new WebDriverWait(driver1,20);
		WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		//email.sendKeys(EmID);
		//WebElement email = driver1.findElement(By.xpath("//input[@id='username']"));
		email.sendKeys(EmID);
		//(By.xpath("//*[@id='text-input-what']"))
		
		
		/*
		 * WebElement VARName=
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		 * VARName.sendKeys("Krishna-05")
		 */
		
		/*
		 * WebElement SdEmailId = driver1.findElement(By.id("username"));
		 * SdEmailId.sendKeys(EmID);
		 */

		// Enter Value in SdPsswrd Field
		WebElement psswrd = driver1.findElement(By.id("password"));
		psswrd.sendKeys(Pwrd);

		WebElement SbxLgn = driver1.findElement(By.id("Login"));
		SbxLgn.click();
		Thread.sleep(60000);

		WebElement sche = driver1.findElement(By.xpath("//a[@title='ClickSchedule Tab']"));
		sche.click();
		Thread.sleep(2000000);
	
		System.out.println("Case 1 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}