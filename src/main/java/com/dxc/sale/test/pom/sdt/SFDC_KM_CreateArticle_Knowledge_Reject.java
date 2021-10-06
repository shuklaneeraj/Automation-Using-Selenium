package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dxc.sale.test.Functions.KM_Function;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;

public class SFDC_KM_CreateArticle_Knowledge_Reject {

	final static Logger log = LogManager.getLogger(SFDC_KM_CreateArticle_Knowledge_Reject.class);

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

	public boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (NoAlertPresentException e) {
			foundAlert = false;
		}
		System.out.println(foundAlert);
		return foundAlert;

	}

	public void test(String SdEmID, String SdPwrd,String SSrlNum,String Title,String ReslnTitle) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
		

			KM_Function func = new KM_Function();
			func.beforemethod();
			KM_Function.createArticle(SdEmID, SdPwrd, ReslnTitle);
			func.test(SdEmID, SdPwrd, SSrlNum,Title,ReslnTitle);
			//func.test(SdEmID, SdPwrd, SSrlNum,Title,ReslnTitle);

			String statusReview = driver
					.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]")).getText();
			System.out.println("Validation Status : " + statusReview);
			if (statusReview.equals("Awaiting Technical Review")) {
				System.out.println("Text displayed in Validation Status is Correct: " + statusReview);
				Thread.sleep(2000);

				By assign = By.xpath("(//div[@title='Assign'])");
				gl.clickElement(assign, "Clicking on Assign Button");
				Thread.sleep(6000);

				By close = By.xpath("(//span[@class='deleteIcon'])");
				gl.clickElement(close, "Close");
				Thread.sleep(6000);

				By asigneeName = By.xpath("(//input[@title='Search People'])");
				gl.inputText(asigneeName, "Asignee Name", "ram chalasani");
				Thread.sleep(3000);

				Robot re = new Robot();
				re.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(2000);
				re.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				

				By saveAssignee = By.xpath(
						"(//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton'])");
				gl.clickElement(saveAssignee, "Clicking on Save Button");
				Thread.sleep(20000);
				
				KM_Function.approveTab(SdEmID, SdPwrd,Title);
		
				By homeArrow = By.xpath(
						"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
				gl.clickElement(homeArrow, "DropDown");
				Thread.sleep(10000);

				By home = By.xpath("//span[text()='Home']");
				gl.clickElement(home, "Home");
				Thread.sleep(10000);

				By item = By.xpath("//a[text()='" + Title + "']");
				gl.clickElement(item, "Clicking on Article");
				Thread.sleep(20000);

				By reject = By.xpath("//a[@title='Reject']");
				gl.clickElement(reject, "reject");
				Thread.sleep(15000);

				By textreject = By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']");
				gl.inputText(textreject, "Reject Text", "Rejected");
				Thread.sleep(3000);

				By rejectBtn = By.xpath(
						"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
				gl.clickElement(rejectBtn, "Clicking on Reject Botton");
				Thread.sleep(20000);

//				By tab = By.xpath("(//span[text()='test 042'])[1]']");
//				gl.clickElement(tab, "Clicking on Article tab");
//				Thread.sleep(25000);

				String statusreject = driver
						.findElement(By.xpath("//span[@class='processStatus status-rejected runtime_approval_processOutputStatus']"))
						.getText();
				System.out.println("Validation Status : " + statusreject);
				if (statusreject.equals("Rejected")) {
					System.out.println("Text displayed in Validation Status is Correct: " + statusreject);
					Thread.sleep(2000);

				} else {
					System.out.println("Text displayed in Validation Status is not Correct: " + statusreject);
					Thread.sleep(2000);
				}
			}

		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}

		System.out.println("Case 15 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}