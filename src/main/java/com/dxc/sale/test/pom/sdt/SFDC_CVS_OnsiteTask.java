package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;

public class SFDC_CVS_OnsiteTask {

	final static Logger log = LogManager.getLogger(SFDC_CVS_OnsiteTask.class);

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

		Login_GSD_CSC Login = new Login_GSD_CSC();
		Login.beforemethod();
		Login.test(SdEmID, SdPwrd, SSrlNum);

		SFDC_Case_Created LightingCase = new SFDC_Case_Created();
		LightingCase.beforemethod();
		LightingCase.test(SdEmID, SdPwrd, SSrlNum);

		SFDC_Case_Updated1 UpdateCase1 = new SFDC_Case_Updated1();
		UpdateCase1.beforemethod();
		UpdateCase1.test(SdEmID, SdPwrd, SSrlNum);

		By cvsLink = By.xpath("//a[text()='View Compliance Results']");
		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(40000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]"));
		Thread.sleep(4000);

		List<WebElement> rows = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count = rows.size();
		System.out.println("ROW COUNT : " + count);
		Thread.sleep(4000);
		if (count == 1) {
			System.out.println("CVS call Occurs when Update Case");
		} else {
			System.out.println("Error in CVS call When Update Case");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tab1 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab1, "tab1");
		Thread.sleep(12000);

		SFDC_Case_Updated2 update = new SFDC_Case_Updated2();
		update.beforemethod();
		update.test(SdEmID, SdPwrd, SSrlNum);
		Thread.sleep(6000);

		// By tab2 = By.xpath("(//a[@class='tabHeader slds-tabs--default__link
		// slds-p-right--small slds-grow '])[2]");
		// gl.clickElement(tab2, "tab2");
		// Thread.sleep(20000);

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		Thread.sleep(4000);

		By pos = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos));

		List<WebElement> row2 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count2 = row2.size();
		System.out.println("ROW COUNT : " + count2);
		Thread.sleep(4000);
		if (count2 == 2) {
			System.out.println("CVS call Occurs when Enter Contact Name");
		} else {
			System.out.println("Error in CVS call When enter Contact Name");
		}
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab3 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab3, "tab3");
		Thread.sleep(8000);

		SFDC_NewOnsiteTask OnsiteLink = new SFDC_NewOnsiteTask();
		OnsiteLink.beforemethod();
		OnsiteLink.test(SdEmID, SdPwrd, SSrlNum);

		By tab5 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab5, "tab5");
		Thread.sleep(8000);

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos1 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos1));

		List<WebElement> rows3 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count3 = rows3.size();
		System.out.println("ROW COUNT : " + count3);
		Thread.sleep(4000);
		if (count3 == 4) {
			System.out.println("CVS call Occurs when Onsite task submitted");
		} else {
			System.out.println("Error in CVS call When Onsite task submitted");
		}
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tabCsr = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tabCsr, "tabCsr");
		Thread.sleep(8000);

		By tabPart = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[4]/a");
		gl.clickElement(tabPart, "tabPart");
		Thread.sleep(8000);

		SFDC_NewOnsite_PartOrder OnsiteLinkPartOrder = new SFDC_NewOnsite_PartOrder();
		OnsiteLinkPartOrder.beforemethod();
		OnsiteLinkPartOrder.test(SdEmID, SdPwrd, SSrlNum);

		By tab6 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab6, "tab6");
		Thread.sleep(8000);

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos5 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos5));

		List<WebElement> rows5 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count5 = rows5.size();
		System.out.println("ROW COUNT : " + count5);
		Thread.sleep(4000);
		if (count5 == 6) {
			System.out.println("CVS call Occurs when Onsite task Order Placed");
		} else {
			System.out.println("Error in CVS call When Onsite task Order Placed");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By win = By.xpath("//div[@class='pbBody']");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(win));

		By reScreen = By.xpath("//input[@class='btn slds-button slds-button_neutral wk_btn']");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(reScreen));
		gl.clickElement(reScreen, "reScreen");
		Thread.sleep(8000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos6 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos6));

		List<WebElement> rows6 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count6 = rows6.size();
		System.out.println("ROW COUNT : " + count6);
		Thread.sleep(4000);
		if (count6 == 7) {
			System.out.println("CVS call Occurs when Rescreen");
		} else {
			System.out.println("Error in CVS call When Rescreen");
		}
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tabOnsite = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tabOnsite, "tabOnsite");
		Thread.sleep(10000);

		SFDC_CVS_Status status = new SFDC_CVS_Status();
		status.beforemethod();
		status.test(SdEmID, SdPwrd, SSrlNum);
		Thread.sleep(10000);
		System.out.println("Case 11 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}