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

public class SFDC_ClickMobile {
	final static Logger log = LogManager.getLogger(SFDC_ClickMobile.class);

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
		Thread.sleep(20000);

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
		Thread.sleep(60000);

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
		Thread.sleep(10000);

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
		
		By status1 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status1, "status1", "Accepted");
		Thread.sleep(6000);

		By save1 = By.xpath("//a[text()='Save']");
		gl.clickElement(save1, "save1");
		Thread.sleep(6000);

		By status2 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status2, "status2", "Activity Start");
		Thread.sleep(60000);

		By save2 = By.xpath("//a[text()='Save']");
		gl.clickElement(save2, "save2");
		Thread.sleep(6000);

		By status3 = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(status3, "status3", "Activity Complete");
		Thread.sleep(6000);

		By save3 = By.xpath("//a[text()='Save']");
		gl.clickElement(save3, "save3");
		Thread.sleep(6000);
		
		/**driver.navigate().refresh();
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		Thread.sleep(10000);

		// By sche = By.xpath("//div[@title='Schedule']");
		gl.clickElement(sche, "sche");
		Thread.sleep(6000);

		// By task = By.xpath("(//div[@id='info'])[2]");
		gl.clickElement(task, "task");
		Thread.sleep(6000);

		By sta = By.xpath("(//select[@objname='ComboBoxControl.Value'])[1]");
		gl.selectByText(sta, "sta", "Activity Complete");
		Thread.sleep(6000);

		By sa = By.xpath("//a[text()='Save']");
		gl.clickElement(sa, "sa");
		Thread.sleep(6000);**/

		By repair = By.xpath("(//select[@objname='ComboBoxControl.Value'])[4]");
		gl.selectByText(repair, "repair", "IR-Incomplete Repair");
		Thread.sleep(6000);

		By delay = By.xpath("(//select[@objname='ComboBoxControl.Value'])[5]");
		gl.selectByText(delay, "delay", "9-Other");
		Thread.sleep(6000);

		Robot r1 = new Robot();
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
		Thread.sleep(10000);

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
		Thread.sleep(3000);
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

		/**
		 * WebElement
		 * panel=driver.findElement(By.xpath("(//div[@id='alertsPanel'])[1]"));
		 * //panel.isDisplayed() boolean actualValue = panel.isDisplayed();
		 * Thread.sleep(50000); if (actualValue) { WebDriverWait wait = new
		 * WebDriverWait(driver,20); WebElement icon=
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='icon_schedule']/descendant::div[position()=4]")));
		 * //By icon = By.xpath("(//div[@class='iconTapSurface'])[1]"); icon.click();
		 * Thread.sleep(10000);
		 * 
		 * By close =
		 * By.xpath("//span[@id='emptyInbox']/descendant::img[position()=1]");
		 * gl.clickElement(close, "close"); Thread.sleep(10000); } else {
		 * System.out.println("Panel is not displayed"); } Thread.sleep(2000);
		 **/

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
		
		WebElement prtNo= driver.findElement(By.xpath("(//textarea[@id='textBoxText'])[2]"));
		String number = prtNo.getAttribute("value");
		System.out.println("SubCase Id: "+ number);
		   Thread.sleep(6000);
		   
		   JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    
		    driver.get("https://hp--test.my.salesforce.com/");
		    Thread.sleep(50000);
		    
	    driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(number);
	    Thread.sleep(10000);
	    Robot re = new Robot();
		re.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(20000);
		
		WebElement prtNo1= driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread'])[4]"));
		String number1 = prtNo1.getText();
		System.out.println("Scheduling Status: "+ number1);
		
		if(number1.equals("Closed"))
		{
			System.out.println("Scheduling status is closed");
		}
		else
		{
			System.out.println("Scheduling status is not closed");
		}
		Thread.sleep(6000);
		WebElement prtNo2= driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread'])[2]"));
		prtNo2.click();
		Thread.sleep(10000);
		String RecordText1 = driver.findElement(By.xpath("(//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1])"))
				.getText();
		System.out.println("Record Type : " + RecordText1);
		

		if(RecordText1.equals("GSD CSC Task - Closed"))
		{
			System.out.println("Task is closed");
		}
		else
		{
			System.out.println("Task is not closed");
		}

		System.out.println("Case 8 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}