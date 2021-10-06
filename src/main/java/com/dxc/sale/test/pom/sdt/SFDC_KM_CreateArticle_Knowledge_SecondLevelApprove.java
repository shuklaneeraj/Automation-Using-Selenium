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

public class SFDC_KM_CreateArticle_Knowledge_SecondLevelApprove {

	final static Logger log = LogManager.getLogger(SFDC_KM_CreateArticle_Knowledge_SecondLevelApprove.class);

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

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Robot re = new Robot();
		try {

			KM_Function func = new KM_Function();
			func.beforemethod();
//			KM_Function.createArticle(SdEmID, SdPwrd, ReslnTitle);
//			func.test(SdEmID, SdPwrd, SSrlNum,Title,ReslnTitle);

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

				re.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(2000);
				re.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);

				By saveAssignee = By.xpath(
						"(//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton'])");
				gl.clickElement(saveAssignee, "Clicking on Save Button");
				Thread.sleep(25000);

			} else {
				System.out.println("Text displayed in Validation Status is not Correct");
				Thread.sleep(2000);
			}

			KM_Function.approveTab(SdEmID, SdPwrd,Title);

			By secondLevelEdit = By.xpath("//button[@title='Edit Second Level Approval Required']");
			gl.clickElement(secondLevelEdit, "Second Level Approval Edit");
			Thread.sleep(15000);

			By secondLevelApproval = By.xpath("(//span[text()='Second Level Approval Required'])[2]");
			gl.clickElement(secondLevelApproval, "Second Level Approval");
			Thread.sleep(10000);

			By save3 = By.xpath("(//button[@title='Save'])");
			gl.clickElement(save3, "Save Article");
			Thread.sleep(20000);

			By more = By.xpath("//li[@class='tabs__item uiTabOverflowMenuItem']/descendant::a[position()=1]");
			gl.clickElement(more, "clicked More");
			Thread.sleep(8000);

			By AQI = By.xpath("(//a[text()='AQI'])");
			gl.clickElement(AQI, "clicked AQI");
			Thread.sleep(8000);

//				By AQI = By.xpath("//div[@class='column region-sidebar-right']/descendant::span[position()=6]");
//				gl.clickElement(AQI, "clicked AQI");
//				Thread.sleep(8000);

			By radio1 = By.xpath("(//input[@type='radio'])[3]");
			gl.clickElement(radio1, "clicked Good Radio1 Button");
			Thread.sleep(6000);

			By radio2 = By.xpath("(//input[@type='radio'])[6]");
			gl.clickElement(radio2, "clicked Good Radio2 Button");
			Thread.sleep(6000);

			By radio3 = By.xpath("(//input[@type='radio'])[9]");
			gl.clickElement(radio3, "clicked Good Radio3 Button");
			Thread.sleep(6000);

			By radio4 = By.xpath("(//input[@type='radio'])[12]");
			gl.clickElement(radio4, "clicked Good Radio4 Button");
			Thread.sleep(10000);

			By saveAQI = By.xpath("(//button[text()='Save'])");
			gl.clickElement(saveAQI, "Clicking AQI Save");
			Thread.sleep(20000);

			By homeArrow = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(homeArrow, "DropDown");
			Thread.sleep(10000);

			By home = By.xpath("//span[text()='Home']");
			gl.clickElement(home, "Home");
			Thread.sleep(10000);
//Title name
			By item = By.xpath("//a[text()='" + Title + "']");
			gl.clickElement(item, "Clicking on Article");
			Thread.sleep(15000);
//
//				By approve = By.xpath("//a[@title='Approve']");
//				gl.clickElement(approve, "Approve");
//				Thread.sleep(20000);
			By approve = By.xpath("//a[@title='Approve']");
			gl.clickElement(approve, "Approve");
			Thread.sleep(15000);

			By textApprove = By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']");
			gl.inputText(textApprove, "Approve Text", "Approved");
			Thread.sleep(3000);

			By approveBtn = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(approveBtn, "Clicking on Approve Botton");
			Thread.sleep(35000);

//				By tab = By.xpath("(//span[text()='test 042'])[1]']");
//				gl.clickElement(tab, "Clicking on Article tab");
//				Thread.sleep(25000);

			String statusApprove = driver
					.findElement(By.xpath(
							"//span[@class='processStatus status-approved runtime_approval_processOutputStatus']"))
					.getText();
			System.out.println("Validation Status : " + statusApprove);
			if (statusApprove.equals("Approved")) {
				System.out.println("Text displayed in Validation Status is Correct: " + statusApprove);
				Thread.sleep(4000);

			} else {
				System.out.println("Text displayed in Validation Status is not Correct: " + statusApprove);
				Thread.sleep(2000);
			}

			WebElement linkElements = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
			linkElements.click();
			Thread.sleep(4000);

			By drpDownArrow1 = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(drpDownArrow1, "Cases");
			Thread.sleep(5000);

			By casesKnowledge = By.xpath("//span[text()='Knowledge']");
			gl.clickElement(casesKnowledge, "Knowledge");
			Thread.sleep(8000);
			By arrowKnowledge = By.xpath("//button[@title='Select List View']");
			gl.clickElement(arrowKnowledge, "Select List View");
			Thread.sleep(6000);

			By draft = By.xpath("//span[text()='Draft Articles']");
			gl.clickElement(draft, "Select Draft Article");
			Thread.sleep(6000);

			By sort = By.xpath("//span[@title='Created Date']");
			gl.clickElement(sort, "Sort Date");
			Thread.sleep(8000);
//Title Name
			By selectArticle = By.xpath("//a[text()='" + Title + "']");
			gl.clickElement(selectArticle, "Select Article");
			Thread.sleep(8000);

			By submit = By.xpath("(//a[@title='Submit for Approval'])");
			gl.clickElement(submit, "Submit for Approval");
			Thread.sleep(8000);

			By submitPopup = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(submitPopup, "Submit for Approval in Popup");
			Thread.sleep(20000);

			By related = By.xpath("//a[@title='Related']");
			gl.clickElement(related, "Related tab");
			Thread.sleep(10000);
			
			By appHistory = By.xpath("(//span[text()='Approval History'])[1]");
			gl.clickElement(appHistory, "Approval history");
			Thread.sleep(15000);

			String approveHis = driver.findElement(By.xpath("(//table/tbody/tr[1]/td[5])[2]")).getText();
			System.out.println("Validation Status : " + approveHis);
			if (approveHis.equals("GSD KM Servers")) {
				System.out.println("Text displayed in Approval History is Correct: " + approveHis);
				Thread.sleep(8000);

			} else {
				System.out.println("Text displayed in Approval History is not Correct: " + approveHis);
				Thread.sleep(8000);
			}

//			WebElement linkElements1 = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
//			linkElements1.click();
//			Thread.sleep(4000);
//			
//			WebElement linkElements2 = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
//			linkElements2.click();
//			Thread.sleep(4000);
//
//			By selectArticle1 = By.xpath("//a[text()='test 0572']");
//			gl.clickElement(selectArticle1, "Select Article");
//			Thread.sleep(8000);
//
//			By relatedrecall = By.xpath("//a[@title='Related']");
//			gl.clickElement(relatedrecall, "Recall-Related Tab");
//			Thread.sleep(10000);

//			By option = By.xpath(
//					"(//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix'])[3]");
//			gl.clickElement(option, "Recall Arrow");
//			Thread.sleep(10000);

			By recall = By.xpath("//a[@title='Recall']");
			gl.clickElement(recall, "Click Recall");
			Thread.sleep(10000);

			By recallText = By.xpath("(//textarea[@class='inputTextArea cuf-messageTextArea textarea'])");
			gl.inputText(recallText, "recall Text", "Recall");
			Thread.sleep(3000);

			By relatedbtn = By.xpath(
					"(//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton'])");
			gl.clickElement(relatedbtn, "Recall-Related Button");
			Thread.sleep(8000);
			
			By tab = By.xpath(
					"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[3]");
			gl.clickElement(tab, "Closed Approval history Tab");
			Thread.sleep(8000);
			
			driver.navigate().refresh();
			Thread.sleep(20000);

			String valStatusRecall = driver
					.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]")).getText();
			System.out.println("Validation Status : " + valStatusRecall);
			if (valStatusRecall.equals("Work In Progress")) {
				System.out.println("Text displayed in Approval History is Correct: " + valStatusRecall);
				Thread.sleep(2000);

			} else {
				System.out.println("Text displayed in Approval History is not Correct: " + valStatusRecall);
				Thread.sleep(2000);
			}

			WebElement linkElements3 = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
			linkElements3.click();
			Thread.sleep(4000);

			WebElement linkElements4 = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
			linkElements4.click();
			Thread.sleep(4000);

			// Search Published Article
			By search = By.xpath("//input[@placeholder='Search Knowledge and more...']");
			gl.inputText(search, "Search", PublishedArticle);
			Thread.sleep(3000);

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(8000);

			By knowledge = By.xpath("(//a[@title='Knowledge'])[2]");
			gl.clickElement(knowledge, "knowledge");
			Thread.sleep(10000);

			driver.navigate().refresh();
			Thread.sleep(15000);

//			List<WebElement> dynamicElementText = driver.findElements(By.xpath("(//a[text()='test05073'])[2]"));
//
//			if (dynamicElementText.size() > 0) {
//				
//					By textPublishedArticle = By.xpath("(//a[text()='test05073'])[2]");
//					gl.clickElement(textPublishedArticle, "Text PublishedArticle");
//					Thread.sleep(6000);
//			
//			}
//			else {
//				By textPublishedArticle1 = By.xpath("(//a[text()='test05073'])[1]");
//				gl.clickElement(textPublishedArticle1, "Text PublishedArticle");
//				Thread.sleep(6000);
//			}
//	<--------------------------->	

			By knowledge1 = By.xpath("(//a[@title='Knowledge'])[2]");
			gl.clickElement(knowledge1, "knowledge");
			Thread.sleep(10000);
			//a[text()='" + Title + "']
			By selectPublishArticle = By.xpath("(//a[text()='" + PublishedArticle + "'])[1]");
			gl.clickElement(selectPublishArticle, "Select Published Article");
			Thread.sleep(10000);

			By version = By.xpath("(//a[@title='Versions'])");
			gl.clickElement(version, "Version");
			Thread.sleep(10000);

			String verStatus = driver.findElement(By.xpath("(//th[@class='slds-tree__item'])[1]")).getText();
			System.out.println("Validation Status : " + verStatus);
			if (verStatus.contains("Draft")) {
				System.out.println("Article is in Draft version not able to edit this article " + verStatus);
				Thread.sleep(2000);

			} else {

				By details = By.xpath("(//a[@title='Details'])");
				gl.clickElement(details, "Details");
				Thread.sleep(10000);

				By dropDown = By.xpath(
						"(//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix'])[1]");
				gl.clickElement(dropDown, "Drop Down Article");
				Thread.sleep(8000);

				By editArticle = By.xpath("//a[@title='Edit Article']");
				gl.clickElement(editArticle, "Edit Article");
				Thread.sleep(8000);

				By editDraft = By.xpath("//button[text()='Edit as Draft']");
				gl.clickElement(editDraft, "Edit Draft");
				Thread.sleep(10000);

				By editSummary = By.xpath("(//button[@title='Edit Summary'])[2]");
				gl.clickElement(editSummary, "Edit Summary");
				Thread.sleep(8000);

				By summary = By.xpath("(//textarea[@class=' textarea'])");
				gl.inputText(summary, "Summary Text", "test");
				Thread.sleep(3000);

				// Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(3000);

				By save = By.xpath("(//button[@title='Save'])");
				gl.clickElement(save, "Save");
				Thread.sleep(8000);

				By submitApprv = By.xpath("//a[@title='Submit for Approval']");
				gl.clickElement(submitApprv, "submit for Approval");
				Thread.sleep(8000);

				By submitApprvText = By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']");
				gl.inputText(submitApprvText, "Submit for Approval Text", "test");
				Thread.sleep(8000);

				By save1 = By.xpath(
						"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
				gl.clickElement(save1, "Save");
				Thread.sleep(8000);

				String valStatus1 = driver
						.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[10]"))
						.getText();
				System.out.println("Validation Status : " + valStatus1);
				if (valStatus1.equals("Awaiting Technical Review")) {
					System.out.println("Text displayed in Validation Status is Correct: " + valStatus1);
					Thread.sleep(2000);

				} else {
					System.out.println("Text displayed in Validation Status is not Correct");
					Thread.sleep(2000);
				}

				
		
							}

		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}

		System.out.println("Test Case Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}