package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class SFDC_NewCSRTask {

	final static Logger log = LogManager.getLogger(SFDC_NewCSRTask.class);

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
//		By NewCSRLink = By.xpath("//a[text()='New CSR Task LWC']");
//		gl.clickLink(NewCSRLink, "NewCSRLink ");
		Thread.sleep(10000);

		List<WebElement> dynamicElement = driver.findElements(By.xpath("//a[text()='New CSR Task LWC']"));

		if (dynamicElement.size() > 0) {
			System.out.println("Element present");
			// JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//a[text()='New CSR Task LWC']")));
			// driver.findElement(By.xpath("//a[text()='New CSR Task LWC']")).click();
		} else {
			System.out.println("Element not present");
		}

		List<WebElement> POPUP = driver.findElements(By.xpath("//select[@class='slds-select']"));

		System.out.println("No of tabs" + POPUP.size());
		if (POPUP.size() > 0) {

			By Selectcase = By.xpath("//select[@class='slds-select']");
			gl.selectByIndex(Selectcase, "Contry", "5");

			By ApplyBtn = By.xpath("//button[@title='Apply']");
			gl.clickElement(ApplyBtn, "Apply ");
			Thread.sleep(5000);

		}

		//gl.pageShouldContainsText("Order Status");

		By order = (By.xpath("//span[text()='Order Information']"));
		gl.clickElement(order, "order");
		Thread.sleep(4000);

		By entitle = (By.xpath("//span[text()='Entitlement Information']"));
		gl.clickElement(entitle, "entitle");
		Thread.sleep(4000);

		By shipping = (By.xpath("//span[text()='Shipping Conditions']"));
		gl.clickElement(shipping, "shipping");
		Thread.sleep(4000);

		By addr = (By.xpath("//span[text()='Address']"));
		gl.clickElement(addr, "addr");
		Thread.sleep(4000);

		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

	
		By PartNumber = By.xpath("//div[@class='slds-grid slds-list_horizontal']/descendant::input[position()=1]");
		gl.inputText(PartNumber, "PartNumber Description", "101920-001");
		// gl.inputText(PartNumber, "PartNumber Description", "101951-001");
		Thread.sleep(4000);
		System.out.println("Part Number to add");
		
		By AddPartBtn = By.xpath("//button[@title='Add Part']");
		gl.clickElement(AddPartBtn, "AddPartBtn");
		Thread.sleep(30000);
		System.out.println("Part Number added");

		By CheckAvailabilitbtn = By.xpath("//button[@title='Check Availability']");

		gl.clickElement(CheckAvailabilitbtn, "CheckAvailabilitbtn");
		Thread.sleep(20000);
		System.out.println("CheckAvailability");

		By csr = By.xpath("(//span[contains(text(),'CSR Part Order')])[2]");
		gl.clickLink(csr, "csr");
		System.out.println("Clicked On CSR Button ");
		Thread.sleep(3000);

		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(6000);

		By PlaceOrderbtn = By.xpath("(//button[@title='Place Order'])[2]");
		gl.clickElement(PlaceOrderbtn, "PlaceOrderbtn");
		Thread.sleep(50000);

		gl.pageShouldContainsText("Part Order");

		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(10000);

		WebElement e = driver.findElement(By.xpath("(//button[@title='Place Order'])[2]"));
		boolean actualValue = e.isEnabled();
		// Thread.sleep(50000);
		if (actualValue) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled and Order is Placed");
		}
		Thread.sleep(2000);

		System.out.println("Case 6 Passed");

	}

	public void csrPersona(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		By NewCSRLink = By.xpath("//a[text()='New CSR Task LWC']");
//		gl.clickLink(NewCSRLink, "NewCSRLink ");
//		Thread.sleep(15000);

		List<WebElement> POPUP = driver.findElements(By.xpath("//select[@class='slds-select']"));

		System.out.println("No of tabs" + POPUP.size());
		if (POPUP.size() > 0) {

			By Selectcase = By.xpath("//select[@class='slds-select']");
			gl.selectByIndex(Selectcase, "Contry", "5");

			By ApplyBtn = By.xpath("//button[@title='Apply']");
			gl.clickElement(ApplyBtn, "Apply ");
			Thread.sleep(5000);

		}

		//gl.pageShouldContainsText("Order Status");

		By order = (By.xpath("//span[text()='Order Information']"));
		gl.clickElement(order, "order");
		Thread.sleep(4000);

		By entitle = (By.xpath("//span[text()='Entitlement Information']"));
		gl.clickElement(entitle, "entitle");
		Thread.sleep(4000);

		By shipping = (By.xpath("//span[text()='Shipping Conditions']"));
		gl.clickElement(shipping, "shipping");
		Thread.sleep(4000);

//		By gsd = By.xpath("(//input[@maxlength='15'])[2]");
//		
//		gl.inputText(gsd, "GSD ID", "123456123451234");
//		Thread.sleep(15000);

		By addr = (By.xpath("//span[text()='Address']"));
		gl.clickElement(addr, "addr");
		Thread.sleep(4000);

		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		By PartNumber = By.xpath("//div[@class='slds-grid slds-list_horizontal']/descendant::input[position()=1]");
		gl.inputText(PartNumber, "PartNumber Description", "101920-001");
		// gl.inputText(PartNumber, "PartNumber Description", "101951-001");
		Thread.sleep(8000);
		System.out.println("Part Number to add");

		By AddPartBtn = By.xpath("//button[@title='Add Part']");
		gl.clickElement(AddPartBtn, "AddPartBtn");
		Thread.sleep(30000);
		System.out.println("Part Number added");

		By CheckAvailabilitbtn = By.xpath("//button[@title='Check Availability']");

		gl.clickElement(CheckAvailabilitbtn, "CheckAvailabilitbtn");
		Thread.sleep(30000);
		System.out.println("Check Availability");

		By csr = By.xpath("(//span[contains(text(),'CSR Part Order')])[2]");
		gl.clickLink(csr, "csr");
		System.out.println("Clicked On CSR Button ");
		Thread.sleep(3000);

		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(6000);

		By PlaceOrderbtn = By.xpath("(//button[@title='Place Order'])[2]");
		gl.clickElement(PlaceOrderbtn, "PlaceOrderbtn");
		Thread.sleep(50000);

		gl.pageShouldContainsText("Part Order");

		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(10000);

		WebElement e = driver.findElement(By.xpath("(//button[@title='Place Order'])[2]"));
		boolean actualValue = e.isEnabled();
		// Thread.sleep(50000);
		if (actualValue) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled and Order is Placed");
		}
		Thread.sleep(2000);

		System.out.println("Case 6 Passed");

	}

	public void autoClose_csr() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		By closeCSRTab1 = By.xpath(
				"//div[@class='close slds-col--bump-left slds-p-left--none slds-p-right--none ']/descendant::lightning-primitive-icon[position()=1]");
		// By closeCSRTab1 = By.xpath("(//button[@class='slds-button slds-button_icon
		// slds-button_icon-x-small
		// slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[2]");
		gl.clickElement(closeCSRTab1, "Close Tab");
		Thread.sleep(5000);

		By Smry = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry, "SummaryLink");
		Thread.sleep(8000);
		List<WebElement> imgCheck = driver.findElements(By.xpath("//img[@class=' checked']"));

		if (imgCheck.size() > 0) {
			WebElement autoClose = driver.findElement(By.xpath("//img[@class=' checked']"));
			String value1 = autoClose.getAttribute("alt");

			System.out.println("checked: " + value1);
			
			By chk1 = By.xpath("//img[@class=' checked']");
			 gl.verifyCheckboxSelected(chk1, "CSR Task Auto close in cases");
			 Thread.sleep(1000);
			 
			if (value1.equals("True"))
				System.out.println("Checkbox is true Condition Pass");
			else
				System.out.println("Checkbox is false condition Failed");
		}

		else {
			System.out.println("Element is not present");
		}

		By closeCase = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])[1]");
		gl.clickElement(closeCase, "Case Close");
		Thread.sleep(10000);
	}

	public void autoClose_csr_L5() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		By closeCSRTab1 = By.xpath(
				"//div[@class='close slds-col--bump-left slds-p-left--none slds-p-right--none ']/descendant::lightning-primitive-icon[position()=1]");
		gl.clickElement(closeCSRTab1, "Close Tab");
		Thread.sleep(10000);
		
		By Dtls = By.xpath("//a[@data-tab-value='detailTab']");
		gl.clickLink(Dtls, "Details");
		Thread.sleep(6000);

		By Smry = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry, "SummaryLink");
		Thread.sleep(10000);

		List<WebElement> imgCheck1 = driver.findElements(By.xpath("(//img[@class=' unchecked'])[1]"));

		if (imgCheck1.size() > 0) {
			WebElement autoClose1 = driver.findElement(By.xpath("(//img[@class=' unchecked'])[1]"));
			String value2 = autoClose1.getAttribute("alt");

			System.out.println("checked: " + value2);
			
			By chk1 = By.xpath("(//img[@class=' unchecked'])[1]");
			 gl.verifyCheckboxSelected(chk1, "CSR Task Auto close in L0.5");
			 Thread.sleep(1000);
			if (value2.equals("False"))
				System.out.println("Checkbox is False Condition Pass");
			else
				System.out.println("Checkbox is True condition Failed");
		}

		else {
			System.out.println("Element not present in Autoclose L0.5");
		}

		By closeCase = By.xpath(
				"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])");
		gl.clickElement(closeCase, "Case Close");
		Thread.sleep(10000);
	}

	public void afterMethod() {
		report.flush();
	}

}