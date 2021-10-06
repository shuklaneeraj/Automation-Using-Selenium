package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.report.ExtentManager;

public class SFDC_ClickMobilePart {

	final static Logger log = LogManager.getLogger(SFDC_ClickMobilePart.class);

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

		// String basedir = System.getProperty("user.dir");

		WebDriver driver = WebDriverManager.getstance().getDriver();
		// driver.manage().deleteAllCookies();
		// Thread.sleep(40000);
		// WebDriver chDriver = WebDriverManager.getstance().getDriver();
		driver.get("https://hpe-he-itg2-cwf.ext.hpe.com/ClickMobileWeb/Default.aspx?state=1");
		Thread.sleep(10000);

		// Maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(6000);
		// driver.manage().deleteAllCookies();
		// Thread.sleep(10000);

		// Click Webelemnt

		WebElement SdEmailId = driver.findElement(By.name("username"));
		SdEmailId.sendKeys(EmID);
		Thread.sleep(3000);
		// Enter Value in SdPsswrd Field
		WebElement SdPsswrd = driver.findElement(By.id("password"));
		SdPsswrd.sendKeys(Pwrd);
		Thread.sleep(3000);

		WebElement SbxLgn = driver.findElement(By.id("Login"));
		SbxLgn.click();
		Thread.sleep(50000);
		Robot r1 = new Robot();

		/**
		 * By popup = By.xpath("//div[text()='OK']"); gl.clickElement(popup, "popup");
		 * Thread.sleep(5000);
		 **/

		/*
		 * By settings = By.xpath("//div[@title='Settings']"); gl.clickElement(settings,
		 * "settings"); Thread.sleep(10000);
		 */

		By start = By.xpath("//div[@id='StartStopButton']");
		gl.clickElement(start, "start");
		Thread.sleep(15000);

		By finish = By.xpath("//div[@id='closeButton']");
		gl.clickElement(finish, "finish");
		Thread.sleep(10000);

		By tab = By.xpath("//div[@id='surface_middle_inner']");
		gl.clickElement(tab, "tab");
		Thread.sleep(10000);

		By sche = By.xpath("//div[@title='Schedule']");
		gl.clickElement(sche, "sche");
		Thread.sleep(6000);

		By task = By.xpath("(//div[@id='info'])[1]");
		gl.clickElement(task, "task");
		Thread.sleep(6000);

		By statusPart = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(statusPart, "statusPart", "Accepted");
		Thread.sleep(6000);

		By save1 = By.xpath("//a[text()='Save']");
		gl.clickElement(save1, "save1");
		Thread.sleep(6000);

		By status2 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status2, "status2", "Activity Start");
		Thread.sleep(100000);

		By savePart2 = By.xpath("//a[text()='Save']");
		gl.clickElement(savePart2, "save2");
		Thread.sleep(6000);

		By status3 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status3, "status3", "Activity Complete");
		Thread.sleep(6000);

		By savePart3 = By.xpath("//a[text()='Save']");
		gl.clickElement(savePart3, "save3");
		Thread.sleep(6000);
		By statusPart4 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(statusPart4, "status4", "Closed");
		Thread.sleep(10000);

		By savePart8 = By.xpath("//a[text()='Save']");
		gl.clickElement(savePart8, "savePart8");
		Thread.sleep(20000);

		By tabPart = By.xpath("//div[@id='surface_middle_inner']");
		gl.clickElement(tabPart, "tabPart");
		Thread.sleep(10000);

		gl.clickElement(sche, "sche");
		Thread.sleep(6000);

		By task2 = By.xpath("(//div[@id='info'])[1]");
		gl.clickElement(task2, "task");
		Thread.sleep(6000);

		By stat2 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(stat2, "status2", "Activity Start");
		Thread.sleep(100000);

		By save2 = By.xpath("//a[text()='Save']");
		gl.clickElement(save2, "save2");
		Thread.sleep(6000);

		By stat3 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(stat3, "status3", "Activity Complete");
		Thread.sleep(6000);

		By save3 = By.xpath("//a[text()='Save']");
		gl.clickElement(save3, "save3");
		Thread.sleep(6000);

		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		Thread.sleep(10000);

		// By sche = By.xpath("//div[@title='Schedule']");
		gl.clickElement(sche, "sche");
		Thread.sleep(6000);

		By taskPart2 = By.xpath("(//div[@id='info'])[1]");
		gl.clickElement(taskPart2, "taskPart2");
		Thread.sleep(6000);

		By statPart3 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(statPart3, "statPart3", "Activity Complete");
		Thread.sleep(6000);

		By saveReload = By.xpath("//a[text()='Save']");
		gl.clickElement(saveReload, "saveReload");
		Thread.sleep(6000);

		By repair = By.xpath("(//select[@objname='ComboBoxControl.Value'])[4]");
		gl.selectByText(repair, "repair", "IR-Incomplete Repair");
		Thread.sleep(6000);

		By delay = By.xpath("(//select[@objname='ComboBoxControl.Value'])[5]");
		gl.selectByText(delay, "delay", "9-Other");
		Thread.sleep(6000);

		// Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		By summary = By.xpath("(//textarea[@id='textBoxText'])[39]");

		gl.inputText(summary, "summary",
				"Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test"
						+ " Test Test Test Test Test Test Test Test Test Test Test Test Test Test Testin");
		Thread.sleep(6000);

		By save4 = By.xpath("//a[text()='Save']");
		gl.clickElement(save4, "save4");
		Thread.sleep(6000);

		By rightArrow = By.xpath("//img[@alt='Right']");
		gl.clickElement(rightArrow, "rightArrow");
		Thread.sleep(6000);

		By add1 = By.xpath("(//img[@id='imgNew'])[4]");
		gl.clickElement(add1, "add1");
		Thread.sleep(6000);

		By labor = By.xpath("//select[@objname='ComboBoxControl.Value']");
		gl.selectByText(labor, "labor", "Other");
		Thread.sleep(6000);

		By startTime = By.xpath("//img[@id='imgDown']");
		gl.clickElement(startTime, "startTime");
		Thread.sleep(6000);

		By plus1 = By.xpath("//img[@id='plus']");
		gl.clickElement(plus1, "plus1");
		Thread.sleep(6000);

		By checkbox = By.xpath("(//div[@id='checkBoxImg'])[3]");
		gl.clickElement(checkbox, "checkbox");
		Thread.sleep(6000);

		By save5 = By.xpath("//a[text()='Save']");
		gl.clickElement(save5, "save5");
		Thread.sleep(6000);

		By chkVerify = By.xpath("(//div[@id='checkBoxImg'])[18]");
		gl.clickElement(chkVerify, "chkVerify");
		Thread.sleep(6000);

		By savechk = By.xpath("//a[text()='Save']");
		gl.clickElement(savechk, "savechk");
		Thread.sleep(6000);

		By rightArrow1 = By.xpath("//img[@alt='Right']");
		gl.clickElement(rightArrow1, "rightArrow1");
		Thread.sleep(6000);

		By add2 = By.xpath("(//img[@id='imgNew'])[5]");
		gl.clickElement(add2, "add2");
		Thread.sleep(6000);

		By processGrp = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(processGrp, "processGrp", "CTR");
		Thread.sleep(6000);

		By process = By.xpath("(//select[@objname='ComboBoxControl.Value'])[2]");
		gl.selectByText(process, "process", "SB-Battery Replacement");
		Thread.sleep(6000);

		By save6 = By.xpath("//a[text()='Save']");
		gl.clickElement(save6, "save6");
		Thread.sleep(6000);

		By rightArrow2 = By.xpath("//img[@alt='Right']");
		gl.clickElement(rightArrow2, "rightArrow2");
		Thread.sleep(6000);

		By add3 = By.xpath("(//img[@id='imgNew'])[7]");
		gl.clickElement(add3, "add3");
		Thread.sleep(6000);

		By charge = By.xpath("//select[@objname='ComboBoxControl.Value']");
		gl.selectByText(charge, "charge", "22-Freight");
		Thread.sleep(6000);

		By amount = By.xpath("//textarea[@id='textBoxText']");
		gl.clickElement(amount, "amount");
		gl.clearElementText(amount, "amount");
		gl.inputText(amount, "amount", "20");
		Thread.sleep(6000);

		By save7 = By.xpath("//a[text()='Save']");
		gl.clickElement(save7, "save7");
		Thread.sleep(6000);

		By rightArrow3 = By.xpath("//img[@alt='Right']");
		gl.clickElement(rightArrow3, "rightArrow3");
		Thread.sleep(5000);

		/*
		 * driver.navigate().refresh(); Thread.sleep(6000);
		 * driver.switchTo().alert().accept(); Thread.sleep(10000);
		 */
		By add4 = By.xpath("(//div[@id='itemText'])[5]");
		gl.clickElement(add4, "add3");
		Thread.sleep(6000);

		/*
		 * By partNo = By.xpath("(//textarea[@id='textBoxText'])[1]");
		 * gl.inputText(partNo, "PartNumber", "101920-001"); Thread.sleep(6000);
		 */

		By serialNo = By.xpath("(//textarea[@id='textBoxText'])[20]");
		gl.inputText(serialNo, "Serial number", "USE542N19Q");
		Thread.sleep(6000);

		By failure = By.xpath("(//select[@objname='ComboBoxControl.Value'])[3]");
		gl.selectByText(failure, "Failure code", "74 Verified failure");
		Thread.sleep(6000);

		By chkpart = By.xpath("(//div[@id='checkBoxImg'])[2]");
		gl.clickElement(chkpart, "chkpart");
		Thread.sleep(6000);

		By partDesc = By.xpath("(//textarea[@id='textBoxText'])[28]");
		gl.inputText(partDesc, "Part description", "Test Part description");
		Thread.sleep(6000);

		By savePart = By.xpath("//a[text()='Save']");
		gl.clickElement(savePart, "savePart");
		Thread.sleep(6000);

		gl.clickElement(rightArrow3, "rightArrow3");
		Thread.sleep(6000);

		By generate = By.xpath("//button[@id='btnGenerate']");
		gl.clickElement(generate, "generate");
		Thread.sleep(6000);

		By attach = By.xpath("//button[@id='btnAttachToTask']");
		gl.clickElement(attach, "attach");
		Thread.sleep(6000);

		By popup1 = By.xpath("//div[text()='OK']");
		gl.clickElement(popup1, "popup1");
		Thread.sleep(4000);

		By status4 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status4, "status4", "Closed");
		Thread.sleep(10000);

		By save8 = By.xpath("//a[text()='Save']");
		gl.clickElement(save8, "save8");
		Thread.sleep(20000);

		// Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		WebElement panel = driver.findElement(By.xpath("(//div[@id='alertsPanel'])[1]"));
		// panel.isDisplayed()
		boolean actualValue = panel.isDisplayed();
		Thread.sleep(50000);
		if (actualValue) {
			System.out.println("Assignment Deleted");

			Thread.sleep(8000);
		} else {
			System.out.println("Assignment is not Deleted");
		}
		Thread.sleep(6000);

		WebElement prtNo = driver.findElement(By.xpath("(//textarea[@id='textBoxText'])[2]"));
		String number = prtNo.getAttribute("value");
		System.out.println("SubCase Id: " + number);
		Thread.sleep(6000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get("https://hp--test.my.salesforce.com/");
		Thread.sleep(80000);
		WebElement searchcase = driver
				.findElement(By.xpath("//a[@class='slds-context-bar__label-action slds-p-left--xx-small']"));
		searchcase.click();
		Thread.sleep(10000);
		// driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(number);
		WebElement search = driver.findElement(By.xpath(
				"//input[@class='slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']"));

		search.sendKeys(number);
		Thread.sleep(10000);
		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(50000);

		//WebElement prtNo1 = driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread'])[4]"));
		WebElement prtNo1 = driver.findElement(By.xpath("//span[text()='Closed']"));
		String number1 = prtNo1.getText();
		Thread.sleep(6000);
		System.out.println("Scheduling Status: " + number1);

		if (number1.equals("Closed")) {
			System.out.println("Scheduling status is closed");
		} else {
			System.out.println("Scheduling status is not closed");
		}
		Thread.sleep(6000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		//WebElement partOrder = driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread'])[14]"));
		WebElement partOrder = driver.findElement(By.xpath("//span[text()='Ordered']"));
		String order = partOrder.getText();
		Thread.sleep(6000);
		System.out.println("Part Order Status: " + order);

		if (order.equals("Ordered")) {
			System.out.println("Onsite Part is Ordered");
		} else {
			System.out.println("Onsite Part is not Ordered");
		}
		Thread.sleep(10000);
		WebElement prtNo2 = driver.findElement(By.xpath("//div[@class='slds-grid slds-grid_vertical']/descendant::a[position()=11]"));
		prtNo2.click();
		Thread.sleep(20000);
		String RecordText1 = driver.findElement(By.xpath("(//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1])"))
				.getText();
		Thread.sleep(6000);
		System.out.println("Record Type : " + RecordText1);

		if (RecordText1.equals("GSD CSC Task - Closed")) {
			System.out.println("Task is closed");
		} else {
			System.out.println("Task is not closed");
		}
		Thread.sleep(20000);

		// WebElement searchcase=
		// driver.findElement(By.xpath("//a[@class='slds-context-bar__label-action
		// slds-p-left--xx-small']"));
		searchcase.click();
		Thread.sleep(6000);

		// WebElement search= driver.findElement(By.xpath("//input[@placeholder='Search
		// Cases and more...']"));
		// WebElement search = driver.findElement(By.xpath("//input[@class='slds-input
		// slds-text-color_default slds-p-left--none slds-size--1-of-1 input default
		// input uiInput uiInputTextForAutocomplete uiInput--{remove}']"));

		search.sendKeys(number);
		Thread.sleep(10000);

		/*
		 * WebElement search= driver.findElement(By.
		 * xpath("//input[@placeholder='Search Cases and more...']")); search.clear();
		 * search.sendKeys(number); Thread.sleep(10000);
		 */

		re.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(50000);
		/**re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);**/
		WebElement placeOrder = driver.findElement(By.xpath("	"));
		placeOrder.click();
		Thread.sleep(50000);
		WebElement orderInfo = driver.findElement(By.xpath("//lightning-accordion[@class='example-accordion accordianHeader slds-accordion']/descendant::input[position()=1]"));
		String info = orderInfo.getAttribute("value");
		System.out.println("Order information Status: " + info);
		Thread.sleep(2000);
		if (info.equals("Ordered")) {
			System.out.println("Order information Status is Ordered");
		} else {
			System.out.println("Order information Status is Ordered");
		}
		Thread.sleep(20000);

		System.out.println("Case 9 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}