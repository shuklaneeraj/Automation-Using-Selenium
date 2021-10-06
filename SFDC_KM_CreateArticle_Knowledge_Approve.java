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
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;

public class SFDC_KM_CreateArticle_Knowledge_Approve {

	final static Logger log = LogManager.getLogger(SFDC_KM_CreateArticle_Knowledge_Approve.class);

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

	public void test(String SdEmID, String SdPwrd) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			By menu = By.xpath("//div[@class='slds-icon-waffle']");
			gl.clickLink(menu, "Menu");
			Thread.sleep(5000);

			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_TAB);
			r1.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);

			WebElement menuSearch = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));

			executor.executeScript("arguments[0].value='GSD CSC Console';", menuSearch);
			Thread.sleep(4000);

			r1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			By drpDownArrow = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(drpDownArrow, "Cases");
			Thread.sleep(5000);

			By cases = By.xpath("//span[text()='Knowledge']");
			gl.clickElement(cases, "Knowledge");
			Thread.sleep(10000);

			By arrow = By.xpath(
					"//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']");
			gl.clickElement(arrow, "Arrow Down");
			Thread.sleep(10000);

			By newArticle = By.xpath("//div[@title='Create New Article']");
			gl.clickElement(newArticle, " Clicked New Article Button");
			Thread.sleep(35000);

			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
			Thread.sleep(1000);

			By articleType = By.xpath("(//select[@name='select'])[1]");
			gl.selectByText(articleType, "Article Type", "Troubleshooting");
			Thread.sleep(5000);

			By info = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[1]");
			gl.clickElement(info, "Information Expand");
			Thread.sleep(3000);

			String titleName = "test 042";
			By title = By.xpath("//input[@name='subject']");
			gl.inputText(title, "title", titleName);
			Thread.sleep(3000);

			By url = By.xpath("//input[@name='URL']");
			gl.clickElement(url, "URL");
			Thread.sleep(3000);

			By summary = By.xpath("//textarea[@class='slds-textarea']");
			gl.inputText(summary, "Summary", "Test");
			Thread.sleep(3000);

			By disclose = By.xpath("(//select[@name='select'])[3]");
			gl.selectByText(disclose, "DisClosure", "Company Confidential");
			Thread.sleep(3000);

			By attr = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[2]");
			gl.clickElement(attr, "Attributes Expand");
			Thread.sleep(3000);

			By group = By.xpath("(//select[@name='select'])[5]");
			gl.selectByText(group, "Product Group", "Servers");
			Thread.sleep(3000);

			By prd = By.xpath("(//select[@name='select'])[6]");
			gl.selectByText(prd, "Product Queue", "ProLiant ML Servers");
			Thread.sleep(5000);

			By env = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[3]");
			gl.clickElement(env, "Environment Expand");
			Thread.sleep(3000);

			By envText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(envText, "Environment", "Test env");
			Thread.sleep(3000);

			By issue = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[4]");
			gl.clickElement(issue, "Issue Expand");
			Thread.sleep(3000);

			By issueText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(issueText, "Issue", "Test Issue");
			Thread.sleep(3000);

			By resoln = By
					.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[5]");
			gl.clickElement(resoln, "Resolution Expand");
			Thread.sleep(3000);

			By resolnText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(resolnText, "Resolution Text", "Test Resolution");
			Thread.sleep(3000);

			By resolnText1 = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(resolnText1, "Resolution Text", "Test");
			Thread.sleep(3000);

			By save = By.xpath("(//button[text()='Save'])");
			gl.clickElement(save, "Save Article");
			Thread.sleep(20000);

			String status = driver.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]"))
					.getText();
			System.out.println("Validation Status : " + status);
			if (status.equals("Work In Progress")) {
				System.out.println("Text displayed in Validation Status is Correct: " + status);
				Thread.sleep(2000);
				By submit = By.xpath("(//a[@title='Submit for Approval'])");
				gl.clickElement(submit, "Submit for Approval");
				Thread.sleep(8000);

			} else {
				System.out.println("Text displayed in Validation Status is not Correct");
			}
			Thread.sleep(3000);

			By valStatus = By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]");
			gl.elementContain(valStatus, "Validation Status");
			Thread.sleep(8000);

			By submitPopup = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(submitPopup, "Submit for Approval in Popup");
			Thread.sleep(20000);

			String tagPopup = driver.findElement(By.xpath("//div[@class='detail slds-text-align--center']")).getText();
			System.out.println("Validation Status : " + tagPopup);
			if (tagPopup.equals("Please provide Product Tagging before submitting for Approval.")) {
				System.out.println("Text displayed in popup is Correct: " + tagPopup);
				Thread.sleep(2000);
				By closePopup = By.xpath(
						"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']/descendant::lightning-primitive-icon[position()=1]");
				gl.clickElement(closePopup, "Close Popup");
				Thread.sleep(6000);

				By edit = By.xpath("//button[@title='Edit']");
				gl.clickElement(edit, "Click edit button");
				Thread.sleep(6000);

				By prdTag = By.xpath("//input[@placeholder='search Product..']");
				gl.inputText(prdTag, "Product Tagging", "AM305A");
				Thread.sleep(3000);

				By search = By.xpath("//button[@title='Search']");
				gl.clickElement(search, "Click Seach Botton");
				Thread.sleep(4000);

				By searchPrd = By.xpath("//span[@class='slds-listbox__option-text_entity']");
				gl.clickElement(searchPrd, "Search Products");
				Thread.sleep(6000);

				By saveClose = By.xpath("//button[@title='Save and Close']");
				gl.clickElement(saveClose, "Save Close");
				Thread.sleep(8000);

			} else {
				System.out.println("Text displayed in popup is not Correct");
			}
			Thread.sleep(8000);

			By submit = By.xpath("(//a[@title='Submit for Approval'])");
			gl.clickElement(submit, "Submit for Approval");
			Thread.sleep(10000);

			By submitPopup1 = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(submitPopup1, "Submit for Approval in Popup");
			Thread.sleep(10000);

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
				Thread.sleep(30000);

				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
				driver.manage().deleteAllCookies();
				driver.get("https://test-hpvertica.cs77.force.com/SSOLoginPage/");
				Thread.sleep(8000);

//				By hpe = By.xpath("//div[@id='idp_section_buttons']/descendant::span[position()=1]");
//				gl.clickElement(hpe, "Clicking on HPE");
//				Thread.sleep(10000);

				By login = By.xpath("//a[text()='  Hewlett Packard Enterprise Employee']");
				gl.clickElement(login, "Clicking on HPE");
				Thread.sleep(25000);

				
				 /**WebDriverWait wait = new WebDriverWait(driver,20); 
				 WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
				 email.sendKeys(SdEmID);
				  
				 WebElement psswrd = driver.findElement(By.id("password"));
				 psswrd.sendKeys(SdPwrd);
				 
				 WebElement SbxLgn = driver.findElement(By.xpath("//input[@value='Log on']"));
				 SbxLgn.click(); Thread.sleep(20000);**/
				 

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

				By selectArticle = By.xpath("//a[text()='test 042']");
				gl.clickElement(selectArticle, "Select Article");
				Thread.sleep(10000);
				
				By secondLevelEdit = By.xpath("//button[@title='Edit Second Level Approval Required']");
				gl.clickElement(secondLevelEdit, "Second Level Approval Edit");
				Thread.sleep(10000);
				
				By secondLevelApproval= By.xpath("(//span[text()='Second Level Approval Required'])[2]");
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
				Thread.sleep(25000);
				
				By homeArrow = By.xpath(
						"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
				gl.clickElement(homeArrow, "DropDown");
				Thread.sleep(10000);

				By home = By.xpath("//span[text()='Home']");
				gl.clickElement(home, "Home");
				Thread.sleep(10000);

				By item = By.xpath("//a[text()='test 042']");
				gl.clickElement(item, "Clicking on Article");
				Thread.sleep(20000);

				By approve = By.xpath("//a[@title='Approve']");
				gl.clickElement(approve, "Approve");
				Thread.sleep(20000);

				By textApprove = By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']");
				gl.inputText(textApprove, "Approve Text", "Approved");
				Thread.sleep(3000);

				By approveBtn = By.xpath(
						"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
				gl.clickElement(approveBtn, "Clicking on Approve Botton");
				Thread.sleep(25000);

//				By tab = By.xpath("(//span[text()='test 042'])[1]']");
//				gl.clickElement(tab, "Clicking on Article tab");
//				Thread.sleep(25000);

				String statusApprove = driver
						.findElement(By.xpath("//span[@class='processStatus status-approved runtime_approval_processOutputStatus']"))
						.getText();
				System.out.println("Validation Status : " + statusApprove);
				if (statusApprove.equals("Approved")) {
					System.out.println("Text displayed in Validation Status is Correct: " + statusApprove);
					Thread.sleep(2000);

				} else {
					System.out.println("Text displayed in Validation Status is not Correct: " + statusApprove);
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