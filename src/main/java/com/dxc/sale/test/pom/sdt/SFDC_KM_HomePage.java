package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.dxc.sale.test.framework.generic.GenericLib;

import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;


public class SFDC_KM_HomePage {

	final static Logger log = LogManager.getLogger(SFDC_KM_HomePage.class);

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

	public void test(String SdEmID, String SdPwrd, String SSrlNum,String CaseNo) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Robot re = new Robot();
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
			Thread.sleep(6000);

			r1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(12000);
			By drpDownArrow = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(drpDownArrow, "Cases");
			Thread.sleep(10000);

			By cases = By.xpath("//span[text()='Cases']");
			gl.clickElement(cases, "cases");
			Thread.sleep(8000);

			List<WebElement> liElements1 = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
			System.out.println(liElements1.size());
			int m = liElements1.size() + 10;
			for (int i = 0; i <= m; i++) {

				List<WebElement> dynamicEle1 = driver.findElements(By.xpath("//ul[2]/li[2]/div[2]/button"));
				if (dynamicEle1.size() > 0) {
					WebElement linkElements1 = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
					linkElements1.click();
					System.out.println("List" + liElements1.size());
					Thread.sleep(3000);

				}

			}

			By case1 = By.xpath("//table//tbody//tr[6]//th//span//a");
			gl.clickLink(case1, "Clicked on case");
			Thread.sleep(15000);

			By knowledgeTab = By.xpath("//li[@title='Knowledge']");
			gl.clickLink(knowledgeTab, "knowledgeTab");
			Thread.sleep(15000);

			By selectArticle = By.xpath("(//div[@class='coveo-result-row'])[1]");
			gl.clickLink(selectArticle, "selectArticle");
			Thread.sleep(8000);

			By attach = By.xpath("(//div[@class='CoveoAttachToCase coveo-result-actions-menu-menu-item'])[1]");
			gl.clickLink(attach, "click on attach");
			Thread.sleep(8000);

			String odsArticle = driver
					.findElement(By.xpath("(//a[@class='CoveoConsoleResultLink CoveoResultLink'])[1]")).getText();
			System.out.println("Validation Status : " + odsArticle);

			WebElement related = driver.findElement(By.xpath("//a[text()='Related']"));
			executor.executeScript("arguments[0].scrollIntoView(true);", related);
			executor.executeScript("arguments[0].click();", related);
			Thread.sleep(8000);

			WebElement share = driver.findElement(By.xpath("//button[@title='Share an update...']"));
			executor.executeScript("arguments[0].click();", share);
			Thread.sleep(8000);

			WebElement shareContent = driver.findElement(By.xpath("//div[@data-placeholder='Share an update...']"));
			executor.executeScript("arguments[0].click();", shareContent);
			Thread.sleep(8000);

			//Robot re = new Robot();
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);

			try {
				boolean eleSelected = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[8]"))
						.isDisplayed();
				System.out.println("Element Displayed: " + eleSelected);
				Thread.sleep(2000);
				if (eleSelected == true) {
					// WebElement show1 =
					// driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
					WebElement show1 = driver
							.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[8]"));
					// executor.executeScript("arguments[0].click();", show1);
					System.out.println("DLVR offer is displayed");

					re.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(1000);
					re.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(1000);

					re.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					re.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					WebElement dlvrCase = driver
							.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[16]"));
					// String text =show1.getText();
					executor.executeScript("arguments[0].click();", dlvrCase);
					System.out.println("Case Attached Results clicked");
					Thread.sleep(20000);
				} else {

					System.out.println("DLVR offer is not displayed");

				}
			} catch (NoSuchElementException e) {
				System.out.println("Show less is shown");

				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);

				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);

				re.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				re.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(4000);

				WebElement dlvrCase = driver.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[17]"));
				// String text =show1.getText();
				executor.executeScript("arguments[0].click();", dlvrCase);
				System.out.println("Case Attached Results clicked");
				Thread.sleep(15000);
			}
			
			
			WebElement mytable = driver.findElement(By.xpath("(//html//body//table//tbody)[3]"));
	    	//To locate rows of table. 
			
			List<WebElement> rows = mytable.findElements(By.tagName("tr"));
					

			System.out.println("No of rows are : " + rows.size());
			int lastRow = rows.size();
			int s = lastRow;
			Thread.sleep(8000);
			WebElement lastRowFetch = driver.findElement(By.xpath("(//table[1]//tbody[1]//tr[" + s + "]/th[1])[2]"));
			String rowText = lastRowFetch.getText();
			Thread.sleep(8000);
			System.out.println("Validation Status : " + rowText);
			if (odsArticle.equals(rowText)) {
				System.out.println("Text displayed is Correct: " + odsArticle);
				Thread.sleep(8000);

			} else {
				System.out.println("Text displayed is not Correct: " + odsArticle);
				Thread.sleep(2000);
			}

			WebElement linkElements1 = driver.findElement(
					By.xpath("(//a[@class='tabHeader slds-tabs--default__link slds-p-right--small slds-grow '])[1]"));
			linkElements1.click();
			Thread.sleep(5000);

			By article = By.xpath("(//a[@class='CoveoConsoleResultLink CoveoResultLink'])[1]");
			gl.clickLink(article, "Clicked on ODS Article");
			Thread.sleep(8000);

			WebElement e = driver.findElement(By.xpath("(//button[@title='Like'])"));

			boolean actualValue = e.isEnabled();
			
			
			if (actualValue) {
				System.out.println("Button is enabled");

				String likeCount = driver.findElement(By.xpath(
						"//article[@class='slds-card slds-wrap font slds-card_narrow cKnowledgeArticleVote']/descendant::div[position()=3]"))
						.getText();

				System.out.println("Validation Status : " + likeCount);
				Thread.sleep(8000);
				String[] parts = likeCount.split(" ");

				String text5 = parts[9];
				Integer z = Integer.valueOf(text5);
				String text2 = parts[12];

				System.out.println("Like: " + text5);

				System.out.println("DisLike: " + text2);
				Thread.sleep(8000);

				By like = By.xpath("(//button[@title='Like'])");
				gl.clickLink(like, "Clicked on like button");
				Thread.sleep(15000);

				By likeComments = By.xpath("//textarea[@placeholder='Additional Comments']");
				gl.inputText(likeComments, "likeComments", "test");
				Thread.sleep(15000);

				By likeSbt = By.xpath("//button[@title='Submit']");
				gl.clickLink(likeSbt, "Clicked on submit button");
				Thread.sleep(30000);

				String ticketNo = driver
						.findElement(
								By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[1]"))
						.getText();
				System.out.println("Validation Status : " + ticketNo);
				Thread.sleep(5000);

				WebElement linkElements2 = driver
						.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
				linkElements2.click();
				Thread.sleep(5000);

				By activity = By.xpath("(//a[@data-label='Activity'])[2]");
				gl.clickLink(activity, "Clicked on activity button");
				Thread.sleep(60000);

				By viewAll = By.xpath("//button[text()='View All']");
				gl.clickLink(viewAll, "Clicked on viewAll button");
				Thread.sleep(50000);

				String feedback = driver.findElement(By.xpath("(//table//tbody//tr[1]//th)[4]")).getText();
				System.out.println("Validation Status : " + feedback);
				Thread.sleep(10000);
				if (ticketNo.equals(feedback)) {
					System.out.println("Record is created succefully");
					Thread.sleep(2000);
				} else {
					System.out.println("Record is not created succefully");
				}

				Thread.sleep(8000);

				By linkElements = By.xpath("(//span[@class='title slds-truncate'])[2]");
				gl.clickLink(linkElements, "Clicked on linkElements");
				Thread.sleep(8000);

				By articleTools = By.xpath("(//a[text()='Article Tools'])[1]");
				gl.clickLink(articleTools, "Clicked on article button");
				Thread.sleep(20000);

				String likeCount1 = driver.findElement(By.xpath(
						"//article[@class='slds-card slds-wrap font slds-card_narrow cKnowledgeArticleVote']/descendant::div[position()=3]"))
						.getText();

				System.out.println("Validation Status : " + likeCount1);
				Thread.sleep(8000);
				String[] parts1 = likeCount1.split(" ");

				String text51 = parts1[9];
				String text21 = parts1[12];

				Integer x = Integer.valueOf(text51);
				x.toString();
				Integer y = z + 1;
				y.toString();
				// String new1=text5+1;
				System.out.println("Like: " + x);

				System.out.println("DisLike: " + text21);

				System.out.println("new1: " + y);
				if (y.equals(x)) {
					System.out.println("Clicked on Thumps up button ");
				} else {
					System.out.println("Not Clicked on Thumps up button ");
				}
			} else {
				System.out.println("Button is disabled");
			}
			Thread.sleep(15000);

			List<WebElement> dynamicElementResl = driver
					.findElements(By.xpath("(//button[@title='Close Feedback Tickets'])"));

			if (dynamicElementResl.size() > 0) {
				By closerecord = By.xpath("(//button[@title='Close Feedback Tickets'])");
				gl.clickLink(closerecord, "Clicked on closerecord");
				Thread.sleep(5000);

				By closerecord1 = By.xpath(
						"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[3]");
				gl.clickLink(closerecord1, "Clicked on closerecord1");
				Thread.sleep(5000);
			} else {
				System.out.println("Element not present");
			}

			WebElement e1 = driver.findElement(By.xpath("(//button[@title='Dislike'])"));

			boolean actualValue1 = e1.isEnabled();

			if (actualValue1) {
				System.out.println("Button is enabled");
				String dislikeCount = driver.findElement(By.xpath(
						"//article[@class='slds-card slds-wrap font slds-card_narrow cKnowledgeArticleVote']/descendant::div[position()=3]"))
						.getText();

				System.out.println("Validation Status : " + dislikeCount);
				Thread.sleep(8000);
				String[] parts = dislikeCount.split(" ");

				String text5 = parts[9];
				// Integer z = Integer.valueOf(text5);
				String text2 = parts[12];
				Integer z = Integer.valueOf(text2);

				System.out.println("Like: " + text5);

				System.out.println("DisLike: " + z);
				Thread.sleep(8000);

				By disLike = By.xpath("(//button[@title='Dislike'])");
				gl.clickLink(disLike, "Clicked on dislike button");
				Thread.sleep(8000);

				By issueType = By.xpath("(//select[@class='slds-select'])[2]");
				gl.selectByText(issueType, "Issue Type", "Missing content");
				Thread.sleep(5000);

				By dislikeComments = By.xpath("//textarea[@placeholder='Additional Comments']");
				gl.inputText(dislikeComments, "likeComments", "test");
				Thread.sleep(3000);

				By dislikeSbt = By.xpath("//button[@title='Submit']");
				gl.clickLink(dislikeSbt, "Clicked on submit button");
				Thread.sleep(50000);

				String ticketNoDisLike = driver
						.findElement(
								By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[1]"))
						.getText();
				System.out.println("Validation Status : " + ticketNoDisLike);
				Thread.sleep(15000);
				WebElement tab = driver
						.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
				tab.click();
				Thread.sleep(8000);
				By activityDisLike = By.xpath("(//a[@data-label='Activity'])[2]");
				gl.clickLink(activityDisLike, "Clicked on activity button");
				Thread.sleep(8000);

				By viewAllDislike = By.xpath("//button[text()='View All']");
				gl.clickLink(viewAllDislike, "Clicked on viewAll button");
				Thread.sleep(30000);

				String feedbackDisLike = driver.findElement(By.xpath("(//table//tbody//tr[1]//th)[4]")).getText();
				System.out.println("Validation Status : " + feedbackDisLike);
				if (ticketNoDisLike.equals(feedbackDisLike)) {
					System.out.println("Record is created succefully");
					Thread.sleep(5000);
				} else {
					System.out.println("Record is not created succefully");
				}
				Thread.sleep(5000);

				By linkElements = By.xpath("(//span[@class='title slds-truncate'])[2]");
				gl.clickLink(linkElements, "Clicked on linkElements");
				Thread.sleep(10000);

				By articleTools = By.xpath("(//a[text()='Article Tools'])[1]");
				gl.clickLink(articleTools, "Clicked on article button");
				Thread.sleep(30000);

				String likeCount1 = driver.findElement(By.xpath(
						"//article[@class='slds-card slds-wrap font slds-card_narrow cKnowledgeArticleVote']/descendant::div[position()=3]"))
						.getText();

				System.out.println("Validation Status : " + likeCount1);
				Thread.sleep(8000);
				String[] parts1 = likeCount1.split(" ");

				String text51 = parts1[9];
				String text21 = parts1[12];

				Integer x = Integer.valueOf(text21);
				x.toString();
				Integer y = z + 1;
				y.toString();
				// String new1=text5+1;
				System.out.println("Like: " + text51);

				System.out.println("DisLike: " + x);

				System.out.println("new1: " + y);
				if (y.equals(x)) {
					System.out.println("Clicked on Thumps down button ");
				} else {
					System.out.println("Not Clicked on Thumps down button ");
				}

			} else {
				System.out.println("Button is disabled");
			}
			Thread.sleep(30000);

			List<WebElement> dynamicElementRes2 = driver
					.findElements(By.xpath("(//button[@title='Close Feedback Tickets'])"));

			if (dynamicElementRes2.size() > 0) {
				By closerecord = By.xpath("(//button[@title='Close Feedback Tickets'])");
				gl.clickLink(closerecord, "Clicked on closerecord");
				Thread.sleep(5000);

				By closerecord1 = By.xpath(
						"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[3]");
				gl.clickLink(closerecord1, "Clicked on closerecord1");
				Thread.sleep(5000);
			} else {
				System.out.println("Element not present");
			}
			Thread.sleep(15000);

			By fdbckbtn = By.xpath("(//button[@class='slds-button slds-button_neutral'])[1]");
			gl.clickLink(fdbckbtn, "Clicked on feedback button");
			Thread.sleep(8000);

			// String ticketNoFeedback1 =driver.switchTo().alert().getText();
//			String ticketNoFeedback1 = driver.findElement(By.xpath("//div[@class='toastContainer slds-notify_container slds-is-relative']/descendant::div[position()=1]")).getText();
//			System.out.println("Validation Status : " + ticketNoFeedback1);
//			Thread.sleep(2000);

			
			By greatExp = By.xpath("(//select[@class='slds-select'])[1]");
			gl.selectByText(greatExp, "Great Experience", "Very Relevant");
			Thread.sleep(5000);

			By notGreatExp = By.xpath("(//select[@class='slds-select'])[2]");
			gl.selectByText(notGreatExp, "Not a Great Experience", "Broken link");
			Thread.sleep(5000);

			By fdbckComments1 = By.xpath("//textarea[@placeholder='Additional Comments']");
			gl.inputText(fdbckComments1, "Feedback Comments", "test");
			Thread.sleep(8000);

			By fdbckSbt = By.xpath("//button[@title='Submit']");
			gl.clickLink(fdbckSbt, "Clicked on submit button");
			Thread.sleep(30000);

			String ticketNoFeedback = driver
					.findElement(By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[1]"))
					.getText();
			System.out.println("Validation Status : " + ticketNoFeedback);
			Thread.sleep(8000);
			WebElement tab1 = driver
					.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
			tab1.click();
			Thread.sleep(8000);
			By activityFeedback = By.xpath("(//a[@data-label='Activity'])[2]");
			gl.clickLink(activityFeedback, "Clicked on activity button");
			Thread.sleep(15000);

			By viewAllDislike = By.xpath("//button[text()='View All']");
			gl.clickLink(viewAllDislike, "Clicked on viewAll button");
			Thread.sleep(20000);

			// String feedbackDisLike =
			// driver.findElement(By.xpath("(//table//tbody//tr[1]//th)[4]")).getText();

			String feedback1 = driver.findElement(By.xpath("(//table//tbody//tr[1]//th)[4]")).getText();
			System.out.println("Validation Status : " + feedback1);
			Thread.sleep(8000);
			if (ticketNoFeedback.equals(feedback1)) {
				System.out.println("Record is created succefully");

			} else {
				System.out.println("Record is not created succefully");
			}

			List<WebElement> dynamicElementFeedback = driver
					.findElements(By.xpath("(//button[@title='Close Feedback Tickets'])"));

			if (dynamicElementFeedback.size() > 0) {
				By closerecord = By.xpath("(//button[@title='Close Feedback Tickets'])");
				gl.clickLink(closerecord, "Clicked on closerecord");
				Thread.sleep(5000);

				By closerecord1 = By.xpath(
						"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[3]");
				gl.clickLink(closerecord1, "Clicked on closerecord1");
				Thread.sleep(5000);
			} else {
				System.out.println("Element not present");
			}

			By translation = By.xpath("//a[text()='Translations']");
			gl.clickLink(translation, "Clicked on translation");
			Thread.sleep(10000);
			
			By viewTrnsln = By.xpath("(//select[@class='slds-select'])");
			gl.clickLink(viewTrnsln, "View Translation");
			Thread.sleep(5000);
			List<WebElement> dynamicElementRes3 = driver
					.findElements(By.xpath("//option[text()='English']"));

			if (dynamicElementRes3.size() > 0) {

				By viewTrnsln1 = By.xpath("(//select[@class='slds-select'])");
				gl.selectByText(viewTrnsln1, "View Translation", "English");
				Thread.sleep(5000);

				String language = driver.findElement(By.xpath("(//div[@class='slds-truncate'])[4]")).getText();
				System.out.println("Language : " + language);
				Thread.sleep(8000);
				if (language.equals("English")) {
					System.out.println("Translated version is Available");

				} else {
					System.out.println("Translated version is not Available");
				}
			}

			By attachToCase = By.xpath("(//button[@class='slds-button slds-button_neutral'])[2]");
			gl.clickLink(attachToCase, "Clicked on attachToCase button");
			Thread.sleep(6000);

		/**	By caseSubmit = By.xpath("//button[@title='Submit']");
			gl.clickLink(caseSubmit, "Clicked on closerecord1");
			
			By captureerror1 = By.xpath("//div[@class='slds-theme--error slds-notify--toast slds-notify slds-notify--toast forceToastMessage']");
			WebElement Captureerr1 = driver.findElement(captureerror1);
			String error11 = Captureerr1.getText();
			Thread.sleep(8000);

			System.out.println("Alert message: " + error1);
			if (error1.equals("Please Enter A Valid Open Case Number")) {
				System.out.println("Alert Message thrown");
				Thread.sleep(8000);
			} else {
				System.out.println("Alert Message is not thrown");
				Thread.sleep(8000);
				
				By attachToCase1 = By.xpath("(//button[@class='slds-button slds-button_neutral'])[2]");
				gl.clickLink(attachToCase1, "Clicked on attachToCase button");
				Thread.sleep(10000);
			}**/


			By caseSearch = By.xpath("//input[@placeholder='Please Enter Case Number...']");
			gl.clickLink(caseSearch, "Clicked on case Number search");
			gl.inputText(caseSearch, "Clicked on case Number search",CaseNo);
			Thread.sleep(9000);
			
			By caseSubmit1 = By.xpath("//button[@title='Submit']");
			gl.clickLink(caseSubmit1, "Clicked on caseSubmit");
			Thread.sleep(40000);


			By caseSearch1 = By.xpath("//input[@placeholder='Search...']");
			// gl.clickLink(caseNo, "Clicked on case Number search");
			gl.inputText(caseSearch1, "Clicked on case Number search", CaseNo);
			Thread.sleep(10000);

			re.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(8000);
	
			By caseno = By.xpath("(//a[@title='" + CaseNo + "'])[2]");
			gl.clickLink(caseno, "Clicked on case Number search");

			Thread.sleep(10000);
			
			By closeCase = By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[1]");
			gl.clickLink(closeCase, "Clicked on closeCase");

			Thread.sleep(4000);
			
		WebElement related1 = driver.findElement(By.xpath("//a[text()='Related']"));
			executor.executeScript("arguments[0].scrollIntoView(true);", related1);
			executor.executeScript("arguments[0].click();", related1);
			Thread.sleep(8000);

			WebElement share1 = driver.findElement(By.xpath("//button[@title='Share an update...']"));
			executor.executeScript("arguments[0].click();", share1);
			Thread.sleep(8000);

			WebElement shareContent1 = driver.findElement(By.xpath("//div[@data-placeholder='Share an update...']"));
			executor.executeScript("arguments[0].click();", shareContent1);
			Thread.sleep(8000);

			//Robot re = new Robot();
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			re.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);


			try {
				boolean eleSelected = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[8]"))
						.isDisplayed();
				System.out.println("Element Displayed: " + eleSelected);
				Thread.sleep(2000);
				if (eleSelected == true) {
					// WebElement show1 =
					// driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
					WebElement show1 = driver
							.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[8]"));
					// executor.executeScript("arguments[0].click();", show1);
					System.out.println("DLVR offer is displayed");

					re.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(1000);
					re.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(1000);

					re.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					re.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					WebElement dlvrCase = driver
							.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[8]"));
					// String text =show1.getText();
					executor.executeScript("arguments[0].click();", dlvrCase);
					System.out.println("Case Attached Results clicked");
					Thread.sleep(20000);
				} else {

					System.out.println("DLVR offer is not displayed");

				}
			} catch (NoSuchElementException exe) {
				System.out.println("Show less is shown");

				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);

				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				re.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);

				re.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				re.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(4000);

				WebElement dlvrCase = driver.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[8]"));
				// String text =show1.getText();
				executor.executeScript("arguments[0].click();", dlvrCase);
				System.out.println("Case Attached Results clicked");
				Thread.sleep(20000);
			}
			
			WebElement mytable1 = driver.findElement(By.xpath("(//html//body//table//tbody)[5]"));
	    	//To locate rows of table. 
			
			List<WebElement> rows1= mytable1.findElements(By.tagName("tr"));
					
			System.out.println("No of rows are : " + rows1.size());
			int lastRow1 = rows1.size();
			int s1 = lastRow1;

			WebElement lastRowFetch1 = driver.findElement(By.xpath("(//table[1]//tbody[1]//tr[" + s1 + "]//th[1])[2]"));
			String rowText1 = lastRowFetch1.getText();
			Thread.sleep(4000);
			System.out.println("Validation Status : " + rowText1);
			
			
			if (odsArticle.equals(rowText1)) {
				System.out.println("Text displayed is Correct: " + odsArticle);
				Thread.sleep(8000);

			} else {
				System.out.println("Text displayed is not Correct: " + odsArticle);
				Thread.sleep(2000);
			}
			
			List<WebElement> knowldege = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
			System.out.println(knowldege.size());
			// System.out.println("hi");
			int n = knowldege.size() + 10;

			// for(int j=liElements.size(); j <= liElements.size();)
			for (int i = 0; i <= n; i++) {

				List<WebElement> dynamicEle1 = driver.findElements(By.xpath("//ul[2]/li[2]/div[2]/button"));
				// List<WebElement> liElements1 =
				// driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
				if (dynamicEle1.size() > 0) {
					WebElement linkElementsKnw = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
					linkElementsKnw.click();
					System.out.println("List" + knowldege.size());
					Thread.sleep(3000);

				}
			}
				
				By knowledge = By.xpath("(//button[@class='bare slds-button slds-utility-bar__action slds-truncate uiButton'])[3]");
				gl.clickLink(knowledge, "Clicked on Home Page knowledge Tab");
				Thread.sleep(8000);
				
				String titleName = "Purple screen of death";
				By knwldgeSearch = By.xpath("(//input[@placeholder='Please enter your query here'])");
				gl.inputText(knwldgeSearch, "Clicked on knowledge search", titleName);
				Thread.sleep(8000);
				
				By search = By.xpath("(//a[@class='CoveoSearchButton coveo-accessible-button'])");
				gl.clickLink(search, "Clicked on Search");
				Thread.sleep(10000);
				
				WebElement similarResult = driver.findElement(By.xpath("(//div[@class='coveo-result-cell'])[2]"));
				String result = similarResult.getText();
				Thread.sleep(4000);
				System.out.println("Validation Status : " + result);
				if (titleName.equals(result)) {
					System.out.println("Verified Similar article results" + result);
					Thread.sleep(10000);

				} else {
					System.out.println("Not Verified Similar article results " + result);
					Thread.sleep(2000);
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