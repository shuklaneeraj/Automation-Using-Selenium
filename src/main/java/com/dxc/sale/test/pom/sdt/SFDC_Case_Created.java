package com.dxc.sale.test.pom.sdt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;

public class SFDC_Case_Created {

	final static Logger log = LogManager.getLogger(SFDC_Case_Created.class);

	private GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;
	
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
		
		
       WebDriver driver = WebDriverManager.getstance().getDriver();
    
       	By homePageICon = By.xpath("//span[text()='Cases']");

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(homePageICon));
	   
	   Thread.sleep(10000);

       List<WebElement> tabnos = driver.findElements(By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']"));

       System.out.println("No of tabs" + tabnos.size());
	   if (tabnos.size() > 0) {

			By crossbtn = By.xpath(	
					"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and contains(@title,'Close')])[1]");
			gl.clickButton(crossbtn, "Close ");
			Thread.sleep(5000);

		}
	   
       By NewLightingButton = By.xpath("//div[contains(text(),'New Lightning Case')]");	
       gl.clickButton(NewLightingButton, "NewLightingButton");
       Thread.sleep(10000);
       
       By EntitleLin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
       gl.verifyElementVisible(EntitleLin, "Entitlement");
       
       
   
       System.out.println("Case 1 Passed");
       
     	}

	public void afterMethod() {
		report.flush();
	}

}