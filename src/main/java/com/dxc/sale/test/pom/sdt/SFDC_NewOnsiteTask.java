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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

public class SFDC_NewOnsiteTask {

	final static Logger log = LogManager.getLogger(SFDC_NewOnsiteTask.class);

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
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		Thread.sleep(5000);
//		By NewOnsiteLink = By.xpath("//a[text()='New Onsite Task LWC']");
//		gl.clickLink(NewOnsiteLink, "NewOnsiteLink ");
//		Thread.sleep(50000);
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//a[text()='New Onsite Task LWC']"));

		if (dynamicElement.size() > 0) {

			executor.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//a[text()='New Onsite Task LWC']")));
			System.out.println("Element present");
			Thread.sleep(8000);
		} else {
			System.out.println("Element not present");
			Thread.sleep(4000);
		}
		List<WebElement> POPUP = driver.findElements(By.xpath("//select[@class='slds-select']"));

		System.out.println("No of tabs" + POPUP.size());
		if (POPUP.size() > 0) {

			By Selectcase = By.xpath("//select[@class='slds-select']");
			gl.selectByIndex(Selectcase, "Contry", "5");

			By ApplyBtn = By.xpath("//button[@title='Apply']");
			gl.clickElement(ApplyBtn, "Apply ");
			Thread.sleep(10000);

		}
		Thread.sleep(20000);
		gl.pageShouldContainsText("GSD CSC Task Creation");
		Thread.sleep(8000);

		/**
		 * By BusinessClose = By.xpath("(//button[@title='Clear Selection'])[2]");
		 * gl.clickButton(BusinessClose, "Business close"); Thread.sleep(4000);
		 * 
		 * By Business = By.xpath("//input[@placeholder='Search DLVR Business
		 * Center...']");
		 * 
		 * gl.inputText(Business, "Business", "US TEST");
		 * 
		 * Thread.sleep(10000); Robot r1 = new Robot(); r1.keyPress(KeyEvent.VK_UP);
		 * 
		 * Thread.sleep(2000); gl.keyBoardEvents("Enter"); Thread.sleep(10000); new
		 * WebDriverWait(driver, Duration.ofSeconds(10));
		 **/

		List<WebElement> BusinessClose1 = driver.findElements(By.xpath("(//button[@title='Clear Selection'])[2]"));

		if (BusinessClose1.size() > 0) {
			String text = (String) executor.executeScript("return arguments[0].value;", driver.findElement(
					By.xpath("(//input[@class='slds-input slds-combobox__input slds-combobox__input-value'])[2]")));
			// System.out.println("hii: "+text);
			Thread.sleep(4000);
			executor.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")));
			Thread.sleep(4000);

			WebElement conNameText = driver
					.findElement(By.xpath("//input[@placeholder='Search DLVR Business Center...']"));
			// String text = conNameText.getText();
			System.out.println("Element present: " + text);
			Thread.sleep(4000);

			// driver.findElement(By.xpath("//a[text()='New Onsite Task LWC']")).click();

			conNameText.sendKeys(text);
			Thread.sleep(8000);

			Robot re = new Robot();
			re.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(10000);

//			executor.executeScript("arguments[0].click();",
//					driver.findElement(By.xpath("//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=5]")));
		} else {
			System.out.println("Element not present");
		}

		List<WebElement> country = driver.findElements(By.xpath(
				"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=9]"));

		if (country.size() > 0) {

			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(
					"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=9]")));
			Thread.sleep(5000);
		} else {
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(
					"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=5]")));
			Thread.sleep(5000);
		}

		//WebElement Repair = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[12]"));
		 WebElement Repair =driver.findElement(By.xpath("(//label[text()='Repair Complexity'])"));

		executor.executeScript("arguments[0].click();", Repair);
		// Repair.click();
		Thread.sleep(8000);

		WebElement OutageNo = driver.findElement(By.xpath("//*[contains(text(),'Low')]"));
		executor.executeScript("arguments[0].click();", OutageNo);
		Thread.sleep(8000);

//		 By starttime = By.xpath("//input[@name='Customer_Requested_Start_Time__c']");
//		 gl.inputText(starttime, "starttime", "18:00:00"); 
//		 Thread.sleep(10000);
//		
//		 By endTime = By.xpath("//input[@name='Customer_Requested_End_Time__c']");
//		 gl.inputText(endTime, "endTime", "18:40:00"); 
//		 Thread.sleep(10000);

		// WebElement delaycode = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[21]"));
		WebElement delaycode =driver.findElement(By.xpath("(//label[text()='Delay Code'])"));
		executor.executeScript("arguments[0].click();", delaycode);
		Thread.sleep(8000);

		WebElement delay = driver.findElement(By.xpath("//span[@title='9-Other']"));
		executor.executeScript("arguments[0].click();", delay);
		Thread.sleep(6000);
//		Robot r = new Robot();
//
//		r.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		gl.keyBoardEvents("Enter");
//		Thread.sleep(10000);

		//WebElement SiteAccess = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[22]"));
		 WebElement SiteAccess =driver.findElement(By.xpath("(//label[text()='Site Access Required'])"));

		executor.executeScript("arguments[0].click();", SiteAccess);
		// gl.selectByText(SiteAccess, "SiteAccess", "NO");
		Thread.sleep(6000);

		WebElement SiteAccessNo = driver.findElement(By.xpath("//span[@title='NO']"));
		// WebElement SiteAccess =
		// driver.findElement(By.xpath("(//input[@type='text'])[24]"));
		executor.executeScript("arguments[0].click();", SiteAccessNo);
		Thread.sleep(4000);

		//WebElement Reason = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[25]"));
		 WebElement Reason =driver.findElement(By.xpath("(//label[text()='Ignore Partner Reason'])"));
		executor.executeScript("arguments[0].click();", Reason);
		Thread.sleep(5000);

		WebElement ReasonInfo = driver.findElement(By.xpath("//*[contains(text(),'R2-After Hours Service')]"));
		executor.executeScript("arguments[0].click();", ReasonInfo);
		Thread.sleep(4000);

		By Ignore = (By.xpath("//span[text()='Ignore Partner Selection']"));
		gl.clickElement(Ignore, "Ignore");
		Thread.sleep(4000);

		// driver.findElement(By.xpath("//span[text()='Ignore Partner
		// Selection']")).click();

		By Save2 = By.xpath("//button[@name='SaveEdit']");
		gl.clickElement(Save2, "Save 2");
		Thread.sleep(30000);

		String RecordText1 = driver.findElement(By.xpath("//slot[@name='header']/descendant::span[position()=5]"))
				.getText();
		System.out.println("Record Type : " + RecordText1);
		if (RecordText1.equals("GSD CSC Task")) {
			System.out.println("Text displayed in Record Type is Correct" + RecordText1);

		} else {
			System.out.println("Text displayed in Record Type is not Correct");
		}
		Thread.sleep(6000);

		By record = By.xpath("//slot[@name='header']/descendant::span[position()=5]");
		gl.elementContain(record, "Task Status");
		Thread.sleep(6000);

		By submit = By.xpath("//a[text()='Submit LWC']");
		// driver.findElement(By.xpath("//a[text()='Submit LWC']")).click();
		gl.clickElement(submit, "submit");
		Thread.sleep(60000);

		String RecordText2 = driver.findElement(By.xpath("//slot[@name='header']/descendant::span[position()=5]"))
				.getText();
		System.out.println("Record Type : " + RecordText2);
		if (RecordText2.equals("GSD CSC Task - Click Submitted")) {
			System.out.println("Text displayed in Record Type is Correct: " + RecordText2);
		} else {
			System.out.println("Text displayed in Record Type is not Correct");
		}

		Thread.sleep(20000);

		By record1 = By.xpath("//slot[@name='header']/descendant::span[position()=5]");
		gl.elementContain(record1, "Task Status");
		Thread.sleep(6000);

		Robot re = new Robot();

		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);

		WebElement WesCode = driver.findElement(By.xpath(
				"(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])"));
		String Code = WesCode.getText();
		Thread.sleep(6000);
		System.out.println("Task ID WES Code : " + Code);
		Thread.sleep(4000);

		By wesID = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(wesID, "WES Code");
		Thread.sleep(6000);

		System.out.println("Case 4 Passed");

	}

	public void newOnsite_Persona(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		By NewOnsiteLink = By.xpath("//a[text()='New Onsite Task LWC']");
//		gl.clickLink(NewOnsiteLink, "NewOnsiteLink ");
//		Thread.sleep(50000);

		List<WebElement> dynamicElement = driver.findElements(By.xpath("//a[text()='New Onsite Task LWC']"));

		if (dynamicElement.size() > 0) {

			// driver.findElement(By.xpath("//a[text()='New Onsite Task LWC']")).click();
			executor.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//a[text()='New Onsite Task LWC']")));
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
		Thread.sleep(10000);

		List<WebElement> POPUP = driver.findElements(By.xpath("//select[@class='slds-select']"));

		System.out.println("No of tabs" + POPUP.size());
		if (POPUP.size() > 0) {

			By Selectcase = By.xpath("//select[@class='slds-select']");
			gl.selectByIndex(Selectcase, "Contry", "5");

			By ApplyBtn = By.xpath("//button[@title='Apply']");
			gl.clickElement(ApplyBtn, "Apply ");
			Thread.sleep(10000);

		}

		gl.pageShouldContainsText("GSD CSC Task Creation");
		Thread.sleep(8000);

		List<WebElement> BusinessClose = driver.findElements(By.xpath("(//button[@title='Clear Selection'])[2]"));

		if (BusinessClose.size() > 0) {
			String text1 = (String) executor.executeScript("return arguments[0].value;", driver.findElement(
					By.xpath("(//input[@class='slds-input slds-combobox__input slds-combobox__input-value'])[2]")));

			Thread.sleep(4000);
			executor.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")));
			Thread.sleep(4000);

			WebElement conNameText = driver
					.findElement(By.xpath("//input[@placeholder='Search DLVR Business Center...']"));

			System.out.println("Element present: " + text1);
			Thread.sleep(4000);

			// driver.findElement(By.xpath("//a[text()='New Onsite Task LWC']")).click();

			conNameText.sendKeys(text1);
			Thread.sleep(5000);

			Robot re = new Robot();
			re.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(8000);

		} else {
			System.out.println("Element not present");
		}

		List<WebElement> country = driver.findElements(By.xpath(
				"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=9]"));

		if (country.size() > 0) {

			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(
					"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=9]")));
			Thread.sleep(5000);
		} else {
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(
					"//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']/descendant::a[position()=5]")));
			Thread.sleep(5000);
		}

		// WebElement Repair =
		// driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[12]"));
		WebElement Repair = driver.findElement(By.xpath("(//input[@type='text'])[8]"));

		executor.executeScript("arguments[0].click();", Repair);
		// Repair.click();
		Thread.sleep(8000);

		WebElement OutageNo = driver.findElement(By.xpath("//*[contains(text(),'Low')]"));
		executor.executeScript("arguments[0].click();", OutageNo);
		Thread.sleep(8000);

		// WebElement SiteAccess =
		// driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[23]"));
		WebElement SiteAccess = driver.findElement(By.xpath("(//input[@type='text'])[23]"));

		executor.executeScript("arguments[0].click();", SiteAccess);

		Thread.sleep(6000);

		WebElement SiteAccessNo = driver.findElement(By.xpath("//span[@title='NO']"));
		// WebElement SiteAccess =
		// driver.findElement(By.xpath("(//input[@type='text'])[24]"));

		executor.executeScript("arguments[0].click();", SiteAccessNo);
		Thread.sleep(2000);
		// WebElement delaycode =
		// driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[21]"));
		WebElement delaycode = driver.findElement(By.xpath("(//input[@type='text'])[21]"));
		executor.executeScript("arguments[0].click();", delaycode);
		Thread.sleep(6000);

		WebElement delay = driver.findElement(By.xpath("//span[@title='9-Other']"));
		executor.executeScript("arguments[0].click();", delay);
		Thread.sleep(6000);

		/**
		 * Robot r = new Robot();
		 * 
		 * r.keyPress(KeyEvent.VK_DOWN); Thread.sleep(2000);
		 * r.keyPress(KeyEvent.VK_DOWN); Thread.sleep(2000);
		 * r.keyPress(KeyEvent.VK_DOWN); Thread.sleep(2000);
		 * r.keyPress(KeyEvent.VK_DOWN); Thread.sleep(2000); gl.keyBoardEvents("Enter");
		 * Thread.sleep(2000);
		 **/

		// WebElement Reason =
		// driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[26]"));
		WebElement Reason = driver.findElement(By.xpath("(//input[@type='text'])[26]"));
		executor.executeScript("arguments[0].click();", Reason);
		Thread.sleep(5000);

		WebElement ReasonInfo = driver.findElement(By.xpath("//*[contains(text(),'R2-After Hours Service')]"));
		executor.executeScript("arguments[0].click();", ReasonInfo);
		Thread.sleep(8000);

		By Ignore = (By.xpath("//span[text()='Ignore Partner Selection']"));
		gl.clickElement(Ignore, "Ignore");
		Thread.sleep(4000);

		// driver.findElement(By.xpath("//span[text()='Ignore Partner
		// Selection']")).click();

		By Save2 = By.xpath("//button[@name='SaveEdit']");
		gl.clickElement(Save2, "Save 2");
		Thread.sleep(40000);

		String RecordText1 = driver.findElement(By.xpath("//slot[@name='header']/descendant::span[position()=5]"))
				.getText();
		System.out.println("Record Type : " + RecordText1);
		if (RecordText1.equals("GSD CSC Task")) {
			System.out.println("Text displayed in Record Type is Correct" + RecordText1);

		} else {
			System.out.println("Text displayed in Record Type is not Correct");
		}
		Thread.sleep(10000);

		By record = By.xpath("//slot[@name='header']/descendant::span[position()=5]");
		gl.elementContain(record, "Task Status");
		Thread.sleep(6000);
		
		Robot re = new Robot();

		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);

		WebElement WesCode = driver.findElement(By.xpath(
				"(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])"));
		String Code = WesCode.getText();
		Thread.sleep(6000);
		System.out.println("Task ID WES Code : " + Code);
		Thread.sleep(4000);

		By wesID = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(wesID, "WES Code");
		Thread.sleep(6000);

	}

	public void autoClose_Onsite() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();

		By closeOnsiteTab1 = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[2]");

		gl.clickElement(closeOnsiteTab1, "Close Tab");
		Thread.sleep(5000);

		By Smry = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry, "SummaryLink");
		Thread.sleep(10000);
		List<WebElement> imgCheck = driver.findElements(By.xpath("(//img[@class=' unchecked'])[1]"));

		if (imgCheck.size() > 0) {
			WebElement autoClose = driver.findElement(By.xpath("(//img[@class=' unchecked'])[1]"));

			String value1 = autoClose.getAttribute("alt");
			 By unchk = By.xpath("(//img[@class=' unchecked'])[1]");
			 gl.verifyCheckboxUnSelected(unchk, "New Onsite Task Autoclose in cases");
			 Thread.sleep(1000);

			if (value1.equals("False"))
				System.out.println("Checkbox is false Condition Pass");
			else
				System.out.println("Checkbox is true condition Failed");
		}

		else {
			System.out.println("Element not present");
		}

		By closeCase = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[1]");
		gl.clickElement(closeCase, "Case Close");
		Thread.sleep(5000);
	}

	public void autoClose_Onsite_L5_Task() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		driver.navigate().refresh();
		Thread.sleep(10000);

		By Dtls = By.xpath("//a[@data-tab-value='detailTab']");
		gl.clickLink(Dtls, "Details");
		Thread.sleep(6000);

		By Smry = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry, "SummaryLink");
		Thread.sleep(8000);
		List<WebElement> imgCheck = driver.findElements(By.xpath("(//img[@class=' unchecked'])[1]"));

		if (imgCheck.size() > 0) {
			WebElement autoClose = driver.findElement(By.xpath("(//img[@class=' unchecked'])[1]"));
			String value1 = autoClose.getAttribute("alt");

			System.out.println("checked: " + value1);
			 
			 By unchk = By.xpath("(//img[@class=' unchecked'])[1]");
			 gl.verifyCheckboxUnSelected(unchk, "New Onsite Task Autoclose in L0.5");
			 Thread.sleep(1000);
			 
			if (value1.equals("False"))
				System.out.println("Checkbox is false Condition Pass");
			else
				System.out.println("Checkbox is true condition Failed");
		}

		else {
			System.out.println("Element not present");
		}
		By closeCSRTab1 = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[2]");

		gl.clickElement(closeCSRTab1, "Close Tab");
		Thread.sleep(5000);

		By closeCase = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[1]");
		gl.clickElement(closeCase, "Case Close");
		Thread.sleep(5000);
	}

	public void afterMethod() {
		report.flush();
	}

}
