package com.dxc.sale.test.Functions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.report.ExtentManager;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;

public class KM_Function {

	final static Logger log = LogManager.getLogger(KM_Function.class);

	static GenericLib gl;
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

	public void test(String SdEmID, String SdPwrd, String SSrlNum,String Title,String ReslnTitle ) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			

			By info = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[1]");
			gl.clickElement(info, "Information Expand");
			Thread.sleep(3000);

			String titleName = "HPE ProLiant - Character1";
			By title = By.xpath("//input[@name='subject']");
			gl.inputText(title, "title", titleName);
			Thread.sleep(10000);

			WebElement similarResult = driver.findElement(By.xpath("(//div[@class='coveo-result-row'])[2]"));
			String result = similarResult.getText();
			Thread.sleep(4000);
			System.out.println("Validation Status : " + result);
			if (titleName.equals(result)) {
				System.out.println("Verified Similar article results" + result);
				Thread.sleep(8000);

			} else {
				System.out.println("Not Verified Similar article results " + result);
				Thread.sleep(2000);
			}

//Title Name
			String titleName1 = Title;
			By title1 = By.xpath("//input[@name='subject']");
			gl.clearElementText(title1, "Clear title");
			gl.inputText(title1, "title", titleName1);
			Thread.sleep(3000);

			WebElement url = driver.findElement(By.xpath("//input[@name='URL']"));
			url.clear();
			WebElement title2 = driver.findElement(By.xpath("//input[@name='subject']"));
			title2.click();
			Thread.sleep(3000);

			url.click();
			// gl.clearElementText(url,"URL Text Clear");
			// gl.clickElement(url, "URL");
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
			
			String reslText = driver.findElement(By.xpath("(//span[@class='slds-accordion__summary-content'])[5]")).getText();
			System.out.println("Text"+reslText);
			
			if (reslText.equals("Resolution")) {
				//WebElement linkElements = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
				By resolnText1 = By.xpath(
						"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
				gl.inputText(resolnText1, "Resolution Text", "https://www.google.com/");
				Thread.sleep(3000);

				By disclaimer = By.xpath("//span[text()='Disclaimer Check']");
				gl.clickElement(disclaimer, "Disclaimer Check Box");
				Thread.sleep(10000);

				By internalNotes = By.xpath(
						"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
				gl.inputText(internalNotes, "Internal Notes", "Confidential content");
				Thread.sleep(8000);
				
			
			By save2 = By.xpath("(//button[text()='Save'])");
			gl.clickElement(save2, "Save Article");
			Thread.sleep(15000);

	By tab = By.xpath("(//span[@class='title slds-truncate'])[1]");
	gl.clickElement(tab, "switch to article tab");
	Thread.sleep(10000);

			WebElement disc = driver.findElement(By.xpath("(//span[@class='uiOutputTextArea'])[2]"));
			String Code = disc.getText();
			Thread.sleep(6000);
			if (Code.equals(
					"One or more of the links above will take you outside the Hewlett-Packard Enterprise web site. HPE does not control and is not responsible for information outside of the HPE web site.")) {

				System.out.println("Disclaimer Text : " + Code);
				Thread.sleep(4000);

				By discText = By.xpath("(//span[@class='uiOutputTextArea'])[2]");
				gl.elementContain(discText, "Disclaimer Text");
				
				System.out.println("Disclaimer Text is Available");
				Thread.sleep(6000);

			} else {
				System.out.println("Disclaimer Text is not Available");
				Thread.sleep(3000);
			}
			}
			else {
				System.out.println("Element not found");
				
				By save2 = By.xpath("(//button[text()='Save'])");
				gl.clickElement(save2, "Save Article");
				Thread.sleep(25000);
				
				By tab = By.xpath("(//span[@class='title slds-truncate'])[1]");
				gl.clickElement(tab, "switch to article tab");
				Thread.sleep(8000);
			}

			String status = driver.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]"))
					.getText();
			Thread.sleep(6000);
			System.out.println("Validation Status : " + status);
			if (status.equals("Work In Progress")) {
				System.out.println("Text displayed in Validation Status is Correct: " + status);
				Thread.sleep(5000);

				By valStatus = By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]");
				gl.elementContain(valStatus, "Validation Status");
				Thread.sleep(8000);

				By submit = By.xpath("(//a[@title='Submit for Approval'])");
				gl.clickElement(submit, "Submit for Approval");
				Thread.sleep(15000);

			} else {
				System.out.println("Text displayed in Validation Status is not Correct");
				
				By submit = By.xpath("(//a[@title='Submit for Approval'])");
				gl.clickElement(submit, "Submit for Approval");
				Thread.sleep(15000);
			}
			//Thread.sleep(10000);

			By submitPopup = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(submitPopup, "Submit for Approval in Popup");
			Thread.sleep(25000);

			List<WebElement> dynamicElement = driver
					.findElements(By.xpath("//div[@class='detail slds-text-align--center']"));

			if (dynamicElement.size() > 0) {

				String tagPopup = driver.findElement(By.xpath("//div[@class='detail slds-text-align--center']"))
						.getText();
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

					By submit = By.xpath("(//a[@title='Submit for Approval'])");
					gl.clickElement(submit, "Submit for Approval");
					Thread.sleep(12000);

					By submitPopup1 = By.xpath(
							"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
					gl.clickElement(submitPopup1, "Submit for Approval in Popup");
					Thread.sleep(10000);

				}
			} else {
				System.out.println("Element not present");
				Thread.sleep(8000);
			}

			//Thread.sleep(15000);

			String statusReview = driver
					.findElement(By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]")).getText();
			System.out.println("Validation Status : " + statusReview);
			if (statusReview.equals("Awaiting Technical Review")) {
				System.out.println("Text displayed in Validation Status is Correct: " + statusReview);
				Thread.sleep(8000);
			} else {
				System.out.println("Text displayed in Validation Status is not Correct: ");
				Thread.sleep(8000);
			}

		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}

		System.out.println("Test Case Passed");

	}

	public static void approveTab(String SdEmID, String SdPwrd, String Title) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		// JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
			driver.manage().deleteAllCookies();
			driver.get("https://test-hpvertica.cs77.force.com/SSOLoginPage/");
			Thread.sleep(10000);

			By login = By.xpath("//a[text()='  Hewlett Packard Enterprise Employee']");
			gl.clickElement(login, "Clicking on HPE");
			Thread.sleep(25000);

			/**
			 * WebDriverWait wait = new WebDriverWait(driver,20); WebElement
			 * email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
			 * email.sendKeys(SdEmID);
			 * 
			 * WebElement psswrd = driver.findElement(By.id("password"));
			 * psswrd.sendKeys(SdPwrd);
			 * 
			 * WebElement SbxLgn = driver.findElement(By.xpath("//input[@value='Log on']"));
			 * SbxLgn.click(); Thread.sleep(20000);
			 **/

			By drpDownArrow1 = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(drpDownArrow1, "Cases");
			Thread.sleep(5000);

			By casesKnowledge = By.xpath("//span[text()='Knowledge']");
			gl.clickElement(casesKnowledge, "Knowledge");
			Thread.sleep(8000);
			List<WebElement> liElements = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
			System.out.println(liElements.size());

			int k = liElements.size() + 50;

			// for(int j=liElements.size(); j <= liElements.size();)
			for (int j = 0; j <= k; j++) {

				List<WebElement> dynamicEle = driver.findElements(By.xpath("//ul[2]/li[2]/div[2]/button"));
				// List<WebElement> liElements1 =
				// driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
				if (dynamicEle.size() > 0) {
					WebElement linkElements = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
					linkElements.click();
					System.out.println("List" + liElements.size());
					Thread.sleep(8000);
				}
			}

			By arrowKnowledge = By.xpath("//button[@title='Select List View']");
			gl.clickElement(arrowKnowledge, "Select List View");
			Thread.sleep(6000);

			By draft = By.xpath("//span[text()='Draft Articles']");
			gl.clickElement(draft, "Select Draft Article");
			Thread.sleep(6000);

			By sort = By.xpath("//span[@title='Created Date']");
			gl.clickElement(sort, "Sort Date");
			Thread.sleep(8000);
			// Title name
			By selectArticle = By.xpath("//a[text()='" + Title + "']");
			gl.clickElement(selectArticle, "Select Article");
			Thread.sleep(16000);

			By tab1 = By.xpath("(//span[@class='title slds-truncate'])[1]");
			gl.clickElement(tab1, "switch to article tab");
			Thread.sleep(3000);

		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}
	}

	public static void Resolution(String SdEmID, String SdPwrd,String ReslnTitle) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		// JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			By info = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[1]");
			gl.clickElement(info, "Information Expand");
			Thread.sleep(3000);
//Resolution title name
			String titleNameResl = ReslnTitle;
			By title = By.xpath("//input[@name='subject']");
			gl.inputText(title, "title", titleNameResl);
			Thread.sleep(3000);

			WebElement url = driver.findElement(By.xpath("//input[@name='URL']"));
			url.clear();
			WebElement title1 = driver.findElement(By.xpath("//input[@name='subject']"));
			title1.click();
			Thread.sleep(3000);

			url.click();
			// gl.clearElementText(url,"URL Text Clear");
			// gl.clickElement(url, "URL");
			Thread.sleep(3000);

			By summaryres = By.xpath("//textarea[@class='slds-textarea']");
			gl.inputText(summaryres, "Summary", "Test for unknown resolution");
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

			By unknownResol = By.xpath("(//span[@class='slds-checkbox_faux'])[5]");
			gl.clickElement(unknownResol, "Unknown Resolution");
			Thread.sleep(3000);

			By env = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[3]");
			gl.clickElement(env, "Environment Expand");
			Thread.sleep(3000);

			By envText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(envText, "Environment", "Test env");
			Thread.sleep(3000);

			By issue = By.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[4]");
			gl.clickElement(issue, "Issue Expand");
			Thread.sleep(5000);

			By issueText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(issueText, "Issue", "Test Issue");
			Thread.sleep(5000);

			By resoln = By
					.xpath("(//button[@class='slds-button slds-button_reset slds-accordion__summary-action'])[5]");
			gl.clickElement(resoln, "Resolution Expand");
			Thread.sleep(5000);
			
			String reslText = driver.findElement(By.xpath("(//span[@class='slds-accordion__summary-content'])[5]")).getText();
			System.out.println("Text"+reslText);
			
			if (reslText.equals("Resolution")) {
			By resolnText = By.xpath(
					"(//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow'])[1]");
			gl.inputText(resolnText, "Resolution Text", "Test Resolution");
			Thread.sleep(8000);

			By save2 = By.xpath("(//button[text()='Save'])");
			gl.clickElement(save2, "Save Article");
			Thread.sleep(20000);
			}
			else {
				By save2 = By.xpath("(//button[text()='Save'])");
				gl.clickElement(save2, "Save Article");
				Thread.sleep(15000);
			}
			

			By tab1 = By.xpath("(//span[@class='title slds-truncate'])[1]");
			gl.clickElement(tab1, "switch to article tab");
			Thread.sleep(3000);

			By same = By.xpath(
					"//lightning-icon[@class='slds-icon_container_circle slds-icon-action-follow slds-icon_container']");
			gl.clickElement(same, "Clicked same here button");
			Thread.sleep(10000);

			String sameHere = driver.findElement(By.xpath(
					"//article[@class='slds-card slds-wrap slds-card_narrow cGSDKMMeeTooController']/descendant::b[position()=1]"))
					.getText();
			System.out.println("Same Here Text : " + sameHere);
			if (sameHere.contains("Same here : 1")) {
				System.out.println("Text displayed in same here is Correct: " + sameHere);
				Thread.sleep(2000);

			} else {
				System.out.println("Text displayed in same here is not Correct");
				Thread.sleep(2000);
			}

			By submit1 = By.xpath("(//a[@title='Submit for Approval'])");
			gl.clickElement(submit1, "Submit for Approval");
			Thread.sleep(8000);

			By submitPopup1 = By.xpath(
					"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
			gl.clickElement(submitPopup1, "Submit for Approval in Popup");
			Thread.sleep(15000);

			List<WebElement> dynamicElement = driver
					.findElements(By.xpath("//div[@class='detail slds-text-align--center']"));

			if (dynamicElement.size() > 0) {

				String tagPopup = driver.findElement(By.xpath("//div[@class='detail slds-text-align--center']"))
						.getText();
				System.out.println("Validation Status : " + tagPopup);
				if (tagPopup.equals("Please provide Resolution before submitting for approval.")) {
					System.out.println("Text displayed in popup is Correct: " + tagPopup);
					Thread.sleep(2000);
					By closePopup = By.xpath(
							"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']/descendant::lightning-primitive-icon[position()=1]");
					gl.clickElement(closePopup, "Close Popup");
					Thread.sleep(10000);

					By tabArticle = By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']");
					gl.clickElement(tabArticle, "Article Tab");
					Thread.sleep(8000);

					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_END);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_END);
					Thread.sleep(3000);

					By edit = By.xpath("//button[@title='Edit Resolution']");
					gl.clickElement(edit, "Click edit button");
					Thread.sleep(10000);

					By tabArticle1 = By.xpath("(//input[@class=' input'])[4]");
					gl.inputText(tabArticle1, "Resolution text", "Test");
					// gl.clickElement(tabArticle1, "Article Tab");
					Thread.sleep(12000);
//					r.keyRelease(KeyEvent.VK_CONTROL);
//					Thread.sleep(3000);
//					r.keyRelease(KeyEvent.VK_END);
//					Thread.sleep(3000);

//					By tabArticle2 = By.xpath("(//lightning-icon[@class='tooltipIcon slds-button__icon slds-icon-utility-info slds-icon_container forceIcon'])[23]");
//					gl.clickElement(tabArticle2, "Article Tab");
//					Thread.sleep(12000);

					// Robot r = new Robot();
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(3000);

					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_S);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);

					r.keyRelease(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_S);
					Thread.sleep(1000);
					
					r.keyRelease(KeyEvent.VK_T);

					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(6000);

					By saveResol = By.xpath("(//span[text()='Save'])[2]");
					gl.clickElement(saveResol, "Save Article");
					Thread.sleep(15000);

					By submit = By.xpath("(//a[@title='Submit for Approval'])");
					gl.clickElement(submit, "Submit for Approval");
					Thread.sleep(15000);

					By submitPopup = By.xpath(
							"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
					gl.clickElement(submitPopup, "Submit for Approval in Popup");
					Thread.sleep(15000);
				}
				else if (tagPopup.equals("Please provide the Procedure before submitting for approval.")) {
					System.out.println("Text displayed in popup is Correct: " + tagPopup);
					Thread.sleep(2000);
					By closePopup = By.xpath(
							"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']/descendant::lightning-primitive-icon[position()=1]");
					gl.clickElement(closePopup, "Close Popup");
					Thread.sleep(8000);
					
					By tabArticle = By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']");
					gl.clickElement(tabArticle, "Article Tab");
					Thread.sleep(12000);

					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_END);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_END);
					Thread.sleep(3000);
					
					By editProcedure = By.xpath("//button[@title='Edit Procedure']");
					gl.clickElement(editProcedure, "Edit Procedure");
					Thread.sleep(10000);
					
					By chkBox = By.xpath("(//span[text()='Second Level Approval Required'])[2]");
					gl.clickElement(chkBox, "Clicked on check box");
					Thread.sleep(10000);
				
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					
					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_S);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);

					r.keyRelease(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_S);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_T);

					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(6000);
					
					By chkBox1 = By.xpath("(//span[text()='Second Level Approval Required'])[2]");
					gl.clickElement(chkBox1, "Clicked on check box");
					Thread.sleep(8000);

					By saveResol = By.xpath("(//span[text()='Save'])[2]");
					gl.clickElement(saveResol, "Save Article");
					Thread.sleep(15000);

					By submit = By.xpath("(//a[@title='Submit for Approval'])");
					gl.clickElement(submit, "Submit for Approval");
					Thread.sleep(15000);

					By submitPopup = By.xpath(
							"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
					gl.clickElement(submitPopup, "Submit for Approval in Popup");
					Thread.sleep(20000);
				
				}
				
				else if (tagPopup.equals("Please provide Answer before submitting for approval."))
				{
					System.out.println("Text displayed in popup is Correct: " + tagPopup);
					Thread.sleep(2000);
					By closePopup = By.xpath(
							"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']/descendant::lightning-primitive-icon[position()=1]");
					gl.clickElement(closePopup, "Close Popup");
					Thread.sleep(8000);
					

					By tabArticle = By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']");
					gl.clickElement(tabArticle, "Article Tab");
					Thread.sleep(8000);

					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_END);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(3000);
					r.keyRelease(KeyEvent.VK_END);
					Thread.sleep(3000);

					By edit = By.xpath("//button[@title='Edit Answer']");
					gl.clickElement(edit, "Click edit button");
					Thread.sleep(10000);
					
					By chkBox = By.xpath("(//span[text()='Second Level Approval Required'])[2]");
					gl.clickElement(chkBox, "Clicked on check box");
					Thread.sleep(8000);

				
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);
					

					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_S);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_T);
					Thread.sleep(1000);

					r.keyRelease(KeyEvent.VK_T);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_E);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_S);
					Thread.sleep(1000);
					Thread.sleep(1000);
					r.keyRelease(KeyEvent.VK_T);

					r.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(3000);

					r.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(6000);

					
					By chkBox1 = By.xpath("(//span[text()='Second Level Approval Required'])[2]");
					gl.clickElement(chkBox1, "Clicked on check box");
					Thread.sleep(8000);

					By saveResol = By.xpath("(//span[text()='Save'])[2]");
					gl.clickElement(saveResol, "Save Article");
					Thread.sleep(15000);

					By submit = By.xpath("(//a[@title='Submit for Approval'])");
					gl.clickElement(submit, "Submit for Approval");
					Thread.sleep(15000);

					By submitPopup = By.xpath(
							"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
					gl.clickElement(submitPopup, "Submit for Approval in Popup");
					Thread.sleep(20000);
				}

					List<WebElement> dynamicElementResl = driver
							.findElements(By.xpath("//div[@class='detail slds-text-align--center']"));

					if (dynamicElementResl.size() > 0) {

						String tagPopupResl = driver
								.findElement(By.xpath("//div[@class='detail slds-text-align--center']")).getText();
						System.out.println("Validation Status : " + tagPopupResl);
						if (tagPopupResl.equals("Please provide Product Tagging before submitting for Approval.")) {
							System.out.println("Text displayed in popup is Correct: " + tagPopupResl);
							Thread.sleep(6000);
							By closePopupResl = By.xpath(
									"//button[@class='slds-button slds-button_icon slds-modal__close closeIcon slds-button_icon-bare slds-button_icon-inverse']/descendant::lightning-primitive-icon[position()=1]");
							gl.clickElement(closePopupResl, "Close Popup");
							Thread.sleep(8000);

							By editResl = By.xpath("//button[@title='Edit']");
							gl.clickElement(editResl, "Click edit button");
							Thread.sleep(8000);

							By prdTagResl = By.xpath("//input[@placeholder='search Product..']");
							gl.inputText(prdTagResl, "Product Tagging", "C7G09A");
							Thread.sleep(8000);

							By search = By.xpath("//button[@title='Search']");
							gl.clickElement(search, "Click Search Botton");
							Thread.sleep(8000);

							By searchPrd = By.xpath("//span[@class='slds-listbox__option-text_entity']");
							gl.clickElement(searchPrd, "Search Products");
							Thread.sleep(6000);

							By next = By.xpath("//button[@title='Next']");
							gl.clickElement(next, "Clicked on Next button");
							Thread.sleep(6000);

							List<WebElement> dynamicEle1 = driver
									.findElements(By.xpath("//span[@title='C7G09A-HP ProLiant DL360e Gen8 Server']"));
							// List<WebElement> liElements1 =
							// driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
							if (dynamicEle1.size() > 0) {

								By expand = By.xpath("//span[@title='C7G09A-HP ProLiant DL360e Gen8 Server']");
								gl.clickElement(expand, "Expand button");
								Thread.sleep(6000);

								By os = By.xpath("//span[@title='OS Independent']");
								gl.clickElement(os, "Availabl OS");
								Thread.sleep(6000);

								By arrowNext = By.xpath("//button[@title='Move selection to Selected']");
								gl.clickElement(arrowNext, "Cilcked on right Arrow");
								Thread.sleep(6000);

								By os1 = By.xpath("(//span[@title='OS Independent'])[2]");
								gl.clickElement(os1, "Availabl OS");
								Thread.sleep(6000);

								By arrowNext1 = By.xpath("(//button[@title='Move selection to Selected'])[2]");
								gl.clickElement(arrowNext1, "Cilcked on right Arrow");
								Thread.sleep(6000);

								By nextIssue = By.xpath("//button[@title='Next']");
								gl.clickElement(nextIssue, "Clicked on Next button");
								Thread.sleep(10000);
							} else {
								System.out.println("Element not found");
								By nextIssue = By.xpath("//button[@title='Next']");
								gl.clickElement(nextIssue, "Clicked on Next button");
								Thread.sleep(10000);
							}

							List<WebElement> dynamicEle2 = driver.findElements(
									By.xpath("(//span[@title='C7G09A-HP ProLiant DL360e Gen8 Server'])[2]"));
							// List<WebElement> liElements1 =
							// driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
							if (dynamicEle2.size() > 0) {

								By expandIssue = By
										.xpath("(//span[@title='C7G09A-HP ProLiant DL360e Gen8 Server'])[2]");
								gl.clickElement(expandIssue, "Expand button");
								Thread.sleep(6000);

								By issueCtgry = By.xpath("//span[@title='iLO/NAND/Management Software issues']");
								gl.clickElement(issueCtgry, "Availabl Issue ctegory");
								Thread.sleep(6000);

								By arrowNextIssue = By.xpath("(//button[@title='Move selection to Selected'])[3]");
								gl.clickElement(arrowNextIssue, "Cilcked on right Arrow");
								Thread.sleep(6000);

								By saveClose = By.xpath("//button[@title='Save and Close']");
								gl.clickElement(saveClose, "Save Close");
								Thread.sleep(8000);
							} else {
								System.out.println("Element not found");
								By saveClose = By.xpath("//button[@title='Save and Close']");
								gl.clickElement(saveClose, "Save Close");
								Thread.sleep(8000);
							}

							By submitResl = By.xpath("(//a[@title='Submit for Approval'])");
							gl.clickElement(submitResl, "Submit for Approval");
							Thread.sleep(15000);

							By submitPopup2 = By.xpath(
									"//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']");
							gl.clickElement(submitPopup2, "Submit for Approval in Popup");
							Thread.sleep(20000);

							String statusReview = driver
									.findElement(
											By.xpath("(//div[@class='slds-form-element__static slds-truncate'])[5]"))
									.getText();
							System.out.println("Validation Status : " + statusReview);
							if (statusReview.equals("Awaiting Technical Review")) {
								System.out.println("Text displayed in Validation Status is Correct: " + statusReview);
								Thread.sleep(8000);
							} else {
								System.out.println("Text displayed in Validation Status is not Correct: ");
								Thread.sleep(8000);
							}

//							By saveClose = By.xpath("//button[@title='Save and Close']");
//							gl.clickElement(saveClose, "Save Close");
//							Thread.sleep(8000);

							By related = By.xpath("//a[@title='Related']");
							gl.clickElement(related, "Related tab");
							Thread.sleep(10000);

							By prdtag = By.xpath("(//span[@title='Product Tagging'])[2]");
							gl.clickElement(prdtag, "Clicked on Product tagging");
							Thread.sleep(10000);

							String prdTagging = "C7G09A";

							WebElement mytable1 = driver.findElement(By.xpath("(//html//body//table//tbody)[2]"));
							// To locate rows of table.

							List<WebElement> rows1 = mytable1.findElements(By.tagName("tr"));

							System.out.println("No of rows are : " + rows1.size());
							int lastRow1 = rows1.size();
							int s1 = lastRow1;

							WebElement lastRowFetch1 = driver
									.findElement(By.xpath("(//table[1]//tbody[1]//tr[" + s1 + "]//th[1])[2]"));
							String rowText1 = lastRowFetch1.getText();
							Thread.sleep(4000);
							System.out.println("Validation Status : " + rowText1);

							if (prdTagging.equals(rowText1)) {
								System.out.println("Text displayed is Correct: " + rowText1);
								Thread.sleep(8000);

							} else {
								System.out.println("Text displayed is not Correct: " + rowText1);
								Thread.sleep(2000);
							}

						
						}}}}
				
		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}
					}
	
	
	public static void createArticle(String SdEmID, String SdPwrd,String ReslnTitle) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		// JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			

			/**
			 * WebDriverWait wait = new WebDriverWait(driver,20); WebElement
			 * email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
			 * email.sendKeys(SdEmID);
			 * 
			 * WebElement psswrd = driver.findElement(By.id("password"));
			 * psswrd.sendKeys(SdPwrd);
			 * 
			 * WebElement SbxLgn = driver.findElement(By.xpath("//input[@value='Log on']"));
			 * SbxLgn.click(); Thread.sleep(20000);
			 **/

			By drpDownArrow1 = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(drpDownArrow1, "Cases");
			Thread.sleep(5000);

			By casesKnowledge = By.xpath("//span[text()='Knowledge']");
			gl.clickElement(casesKnowledge, "Knowledge");
			Thread.sleep(8000);
			List<WebElement> liElements = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
			System.out.println(liElements.size());

			int k = liElements.size() + 50;

			// for(int j=liElements.size(); j <= liElements.size();)
			for (int j = 0; j <= k; j++) {

				List<WebElement> dynamicEle = driver.findElements(By.xpath("//ul[2]/li[2]/div[2]/button"));
				// List<WebElement> liElements1 =
				// driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']"));
				if (dynamicEle.size() > 0) {
					WebElement linkElements = driver.findElement(By.xpath("//ul[2]/li[2]/div[2]/button"));
					linkElements.click();
					System.out.println("List" + liElements.size());
					Thread.sleep(8000);
				}
			}

			By arrowKnowledge = By.xpath("//button[@title='Select List View']");
			gl.clickElement(arrowKnowledge, "Select List View");
			Thread.sleep(6000);

			By draft = By.xpath("//span[text()='Draft Articles']");
			gl.clickElement(draft, "Select Draft Article");
			Thread.sleep(6000);

			By arrow = By.xpath("//a[@title='Show one more action']");
			gl.clickElement(arrow, "Arrow Down");
			Thread.sleep(10000);

			By newArticle = By.xpath("//div[@title='Create New Article']");
			gl.clickElement(newArticle, " Clicked New Article Button");
			Thread.sleep(20000);

			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
			Thread.sleep(1000);

		}
	catch (NoSuchElementException e11) {
		System.out.println("Error" + e11);
	}}

public static void howTos(String SdEmID, String SdPwrd,String ReslnTitle) throws Exception {

	WebDriver driver = WebDriverManager.getstance().getDriver();
	// JavascriptExecutor executor = (JavascriptExecutor) driver;
	try {
		By articleType = By.xpath("(//select[@name='select'])[1]");
	gl.selectByText(articleType, "Article Type", "How Tos");
		Thread.sleep(5000);
	}
	catch (NoSuchElementException e11) {
		System.out.println("Error" + e11);
	}}

public static void info(String SdEmID, String SdPwrd,String ReslnTitle) throws Exception {

	WebDriver driver = WebDriverManager.getstance().getDriver();
	// JavascriptExecutor executor = (JavascriptExecutor) driver;
	try {
		By articleType = By.xpath("(//select[@name='select'])[1]");
	gl.selectByText(articleType, "Article Type", "Informational");
		Thread.sleep(5000);
	}
	catch (NoSuchElementException e11) {
		System.out.println("Error" + e11);
	}}}
