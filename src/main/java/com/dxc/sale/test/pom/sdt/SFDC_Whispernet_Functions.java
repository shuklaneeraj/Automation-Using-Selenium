package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SFDC_Whispernet_Functions {

	final static Logger log = LogManager.getLogger(SFDC_Whispernet_Functions.class);

	static GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;

	
	
	//ExtentTest logTest;
	
	
	
	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);
		//logger = test.createTest("Description");

	}

	
	public void test(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		By menu = By.xpath("//div[@class='slds-icon-waffle']");
		gl.clickLink(menu, "Menu");
		Thread.sleep(5000);
		
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		

		WebElement menuSearch = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));

		executor.executeScript("arguments[0].value='Whispernet';", menuSearch);
		Thread.sleep(5000);
		
		r1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);

		By newWhispernet = By.xpath("(//a[@title='New'])[2]");
		gl.howerMouse(newWhispernet, "newWhispernet");
		gl.clickLink(newWhispernet, "NewWhispernet");
		Thread.sleep(2000);

		By checkBox = By.xpath("(//span[@class='slds-radio--faux topdown-radio--faux'])[1]");
		gl.howerMouse(checkBox, "checkBox");
		gl.clickLink(checkBox, "checkBox");
		Thread.sleep(1000);

		By next = By.xpath(
				"//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']/descendant::span[position()=1]");
		gl.howerMouse(next, "next");
		gl.clickLink(next, "Next");
		Thread.sleep(8000);

		WebElement element = driver.findElement(By.xpath("//input[@name='Valid_From__c']"));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);

		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		String todayAsString = dateFormat.format(today);
		String tomorrowAsString = dateFormat.format(tomorrow);

		System.out.println(todayAsString);
		System.out.println(tomorrowAsString);
		driver.findElement(By.xpath("//input[@name='Valid_From__c']")).sendKeys(todayAsString);

		WebElement toDate = driver.findElement(By.xpath("//input[@name='Valid_To__c']"));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", toDate);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='Valid_To__c']")).sendKeys(tomorrowAsString);
		Thread.sleep(2000);

		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		re.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);


	}

		
	public static void whispernetCreation() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement submit = driver.findElement(By.xpath("//button[@name='GSD_Lead_Whispernet__c.Submit']"));
		executor.executeScript("arguments[0].click();", submit);
		Thread.sleep(20000);

		WebElement recordTypeSubmit = driver.findElement(
				By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]"));
		String typeSubmit = recordTypeSubmit.getText();
		System.out.println("Record Type: " + typeSubmit);
		Thread.sleep(1000);
		
		By sbtText =By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]");
		gl.elementShouldContain(sbtText, "Afted Clicked Submit Button","GSD SDI Request Submitted");
		Thread.sleep(1000);
		
		if (typeSubmit.equals("GSD SDI Request Submitted")) {
			System.out.println("Record Type is GSD SDI Request Submitted");
		} else {
			System.out.println("Record Type is not correct");
		}
		Thread.sleep(1000);

		WebElement edit = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_neutral'])[1]"));
		executor.executeScript("arguments[0].click();", edit);
		Thread.sleep(10000);

		WebElement edittatus = driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]"));
		executor.executeScript("arguments[0].click();", edittatus);
		Thread.sleep(1000);


		WebElement app = driver.findElement(By.xpath("//span[@title='Approved']"));
		executor.executeScript("arguments[0].click();", app);
		Thread.sleep(1000);

		WebElement saveEdit = driver.findElement(By.xpath("(//button[@name='SaveEdit'])"));
		executor.executeScript("arguments[0].click();", saveEdit);
		Thread.sleep(10000);

		WebElement recordTypeApprove = driver.findElement(
				By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]"));
		String typeApprove = recordTypeApprove.getText();
		System.out.println("Record Type: " + typeApprove);
		Thread.sleep(3000);
		
		By apprvText =By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]");
		gl.elementShouldContain(apprvText, "Afted Clicked Approved in Dropdown","GSD SDI Request Approved");
		Thread.sleep(2000);
		
		if (typeApprove.equals("GSD SDI Request Approved")) {
			System.out.println("Record Type is GSD SDI Request Approved");
		} else {
			System.out.println("Record Type is not correct");
		}
		Thread.sleep(1000);

		WebElement Status = driver
				.findElement(By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[3]"));
		String whisStatus = Status.getText();
		System.out.println("Record Type: " + whisStatus);
		Thread.sleep(1000);
		
		By stsWhis =By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[3]");
		gl.elementShouldContain(stsWhis, "Checking Status","Approved");
		Thread.sleep(1000);
		
		if (whisStatus.equals("Approved")) {
			System.out.println("Whispernet Status is Approved");
		} else {
			System.out.println("Whispernet Status is not Approved");
		}
		Thread.sleep(1000);

		WebElement process = driver.findElement(By.xpath("//button[@name='GSD_Lead_Whispernet__c.Process']"));
		executor.executeScript("arguments[0].click();", process);
		Thread.sleep(15000);

		WebElement recordType = driver.findElement(
				By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]"));
		String type = recordType.getText();
		System.out.println("Record Type: " + type);
		Thread.sleep(3000);
		
		By prcss =By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']/descendant::span[position()=1]");
		gl.elementShouldContain(prcss, "Checking Uploaded Status","GSD SDI Request Uploaded");
		Thread.sleep(1000);
		
		if (type.equals("GSD SDI Request Uploaded")) {
			System.out.println("Record Type is GSD SDI Request Uploaded");
		} else {
			System.out.println("Record Type is not correct");
		}
		Thread.sleep(1000);
		
		WebElement closeTab1 = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[2]"));
		executor.executeScript("arguments[0].click();", closeTab1);
		Thread.sleep(1000);
		
		WebElement closeTab2 = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[1]"));
		executor.executeScript("arguments[0].click();", closeTab2);
		Thread.sleep(3000);
		
	}

	public static void whispernetLightning() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement cases = driver.findElement(By.xpath("//a[@title='Cases']"));
		executor.executeScript("arguments[0].click();", cases);
		Thread.sleep(1000);

		WebElement lightning = driver.findElement(By.xpath("//div[contains(text(),'New Lightning Case')]"));
		executor.executeScript("arguments[0].click();", lightning);
		Thread.sleep(17000);

		WebElement entitle = driver.findElement(By.xpath("//a[@title='Entitlement']"));
		executor.executeScript("arguments[0].click();", entitle);
		Thread.sleep(8000);

		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		// gl.clickElement(Ebt, "Link");

		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		Thread.sleep(1000);

		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='pbBody']"));
		Thread.sleep(1000);

		WebElement SerlNum = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=1]"));
		executor.executeScript("arguments[0].value='TC00000070';", SerlNum);
		Thread.sleep(2000);
		

		WebElement contract = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=2]"));
		executor.executeScript("arguments[0].value='4000054077';", contract);
		Thread.sleep(2000);
		
		WebElement prdno = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=3]"));
		executor.executeScript("arguments[0].value='QW968A';", prdno);
		Thread.sleep(2000);
		

		// gl.inputText(SerlNum, "SlrNO", "SUMITN789613");
		Select CntryCode = new Select(driver.findElement(By.xpath("//Select[@class='slds-select ']")));
		CntryCode.selectByVisibleText("United States");
		Thread.sleep(2000);

		WebElement entitleCheck = driver.findElement(By.id("pg:FormId:main:search"));
		executor.executeScript("arguments[0].click();", entitleCheck);
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//div[@class='pbSubsection']"));
		Thread.sleep(1000);
		
		WebElement prdNo = driver.findElement(By.xpath("//table[@class='list slds-table slds-table_striped']//tr[1]//td[1]//a[1]"));

		executor.executeScript("arguments[0].click();", prdNo);
		Thread.sleep(10000);

		// Click on Done Button
		WebElement dne = driver.findElement(By.xpath("(//input[@value='Done'])[1]"));
		executor.executeScript("arguments[0].click();", dne);
		System.out.println("Clicked On Done Button ");
		Thread.sleep(25000);
		
		WebElement popupMssg = driver.findElement(By.xpath("//div[@class='squeeze']"));  
		String alertText = popupMssg.getText();
		System.out.println( "Popup Message1 : "+alertText);
		Thread.sleep(3000);
		
		By alrtText =By.xpath("//div[@class='squeeze']");
		gl.elementContain(alrtText, "Popup Text in Entitlement Page");
		Thread.sleep(1000);
		
	
		

		// Click on Ok Button
		// By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");

		WebElement oky = driver.findElement(By.xpath("//input[@class='btn searchBtn']"));
		executor.executeScript("arguments[0].click();", oky);
		System.out.println("Clicked On Okay Button ");
		Thread.sleep(8000);

		driver.switchTo().defaultContent();
		//Thread.sleep(1000);

		driver.switchTo().frame(1);

		WebElement dne2 = driver.findElement(By.xpath("(//input[@class='btn slds-button slds-button_brand'])[1]"));
		executor.executeScript("arguments[0].click();", dne2);

		System.out.println("Clicked On Done2 Button ");
		Thread.sleep(20000);

		WebElement location = driver.findElement(By.xpath("(//span[contains(text(),'Location ')])[1]"));
		executor.executeScript("arguments[0].click();", location);
		System.out.println("Clicked On Location Button ");

		driver.switchTo().frame(1);

		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		WebElement R1 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[1]"));

		executor.executeScript("arguments[0].click();", R1);
		Thread.sleep(2000);
		
		WebElement R2 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[4]"));
		executor.executeScript("arguments[0].click();", R2);
		Thread.sleep(2000);

		WebElement updBtn = driver.findElement(By.xpath("//div[@id='assLocId']/descendant::button[position()=1]"));
		executor.executeScript("arguments[0].click();", updBtn);
		//newby
		By newsdiok= By.xpath("//div[@id='assLocId']/div[2]//c-g-s-d-c-s-c-s-d-i-popup/section[@role='dialog']//button[@title='OK']");
        Thread.sleep(1000);
        gl.clickButton(newsdiok, "OK");
		Thread.sleep(20000);
		
		/**driver.findElement(By.xpath("//ul[@class='slds-tabs_default__nav']"));
		Thread.sleep(2000);
		
		WebElement gtal = driver.findElement(By.xpath("(//a[@class='slds-tabs_default__link'])[3]"));
		executor.executeScript("arguments[0].click();", gtal);
		Thread.sleep(1000);
		
		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);**/
		
		WebElement sdiMssg1 = driver.findElement(By.xpath("(//div[@class='slds-card__body'])[4]"));  
		String sdiMss1 = sdiMssg1.getText();
		System.out.println( "SDI Message : "+sdiMss1);
		Thread.sleep(1000);

		By sdiMessage1 =By.xpath("(//div[@class='slds-card__body'])[4]");
		gl.elementContain(sdiMessage1, "SDI Message");
		Thread.sleep(1000);
		
	/**	WebElement sdiMssg2 = driver.findElement(By.xpath("//slot[@name='leftsidebar']/descendant::p[position()=5]"));  
		String sdiMss2 = sdiMssg2.getText();
		System.out.println( "SDI Message : "+sdiMss2);
		
		By sdiMessage2 =By.xpath("//slot[@name='leftsidebar']/descendant::p[position()=5]");
		gl.elementContain(sdiMessage2, "SDI Message");
		Thread.sleep(10000);
		
		WebElement sdiMssg = driver.findElement(By.xpath("(//div[@class='more'])[2]"));  
		String sdiMss = sdiMssg.getText();
		System.out.println( "SDI Message1 : "+sdiMss);
		
		By sdiMessage =By.xpath("(//div[@class='more'])[2]");
		gl.elementContain(sdiMessage, "SDI Message");
		Thread.sleep(10000);**/
		
		
		WebElement result = driver.findElement(By.xpath("//a[text()='View All Messages ']"));
		executor.executeScript("arguments[0].click();", result);
		Thread.sleep(8000);
		
		WebElement checkbox = driver.findElement(By.xpath("(//img[@class='slds-truncate checked'])[2]"));
		checkbox.isSelected();
		checkbox.isDisplayed();
		String value = checkbox.getAttribute("alt");
		
		System.out.println("Checkbox is selected: " + checkbox.isDisplayed());
		 System.out.println("checked: "+value);
	
		Thread.sleep(1000);
		
		 By chk = By.xpath("(//img[@class='slds-truncate checked'])[2]");
		 gl.verifyCheckboxSelected(chk, "DLVR info case Checked");
		 Thread.sleep(1000);

		WebElement closeDLVR = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[2]"));
		executor.executeScript("arguments[0].click();", closeDLVR);
		Thread.sleep(1000);
	
		WebElement reentitle = driver.findElement(By.xpath("//a[@title='Entitlement']"));
		executor.executeScript("arguments[0].click();", reentitle);
		Thread.sleep(6000);
		
		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		Thread.sleep(1000);

		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='pbBody']"));
		Thread.sleep(1000);
		
		WebElement clr = driver.findElement(By.id("pg:FormId:main:ClearSTD"));

		executor.executeScript("arguments[0].click();", clr);
		Thread.sleep(3000);

		WebElement reSerlNum = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=1]"));

		executor.executeScript("arguments[0].value='SGH233ATKK';", reSerlNum);
		Thread.sleep(3000);

		// gl.inputText(SerlNum, "SlrNO", "SUMITN789613");
		Select reCntryCode = new Select(driver.findElement(By.xpath("//select[@id='pg:FormId:main:countries']")));
		reCntryCode.selectByVisibleText("United States");
		Thread.sleep(3000);

		WebElement reentitleCheck = driver.findElement(By.id("pg:FormId:main:search"));
		executor.executeScript("arguments[0].click();", reentitleCheck);
		Thread.sleep(25000);
		
		driver.findElement(By.xpath("//div[@class='pbSubsection']"));
		Thread.sleep(3000);
		
		WebElement reprdNo = driver.findElement(By.xpath("//table[@class='list slds-table slds-table_striped']//tr[1]//td[1]//a[1]"));

		executor.executeScript("arguments[0].click();", reprdNo);
		Thread.sleep(10000);

		// Click on Done Button
		WebElement redne = driver.findElement(By.xpath("(//input[@value='Done'])[1]"));
		executor.executeScript("arguments[0].click();", redne);
		System.out.println("Clicked On Done Button ");
		Thread.sleep(20000);
		
		WebElement nonSDI = driver.findElement(By.xpath("(//div/center)[2]"));  
		String nonSDIMssg = nonSDI.getText();
		System.out.println( "Non SDI Message : "+nonSDIMssg);
		Thread.sleep(3000);
		
		WebElement related = driver.findElement(By.xpath("//a[text()='Related']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", related);
		executor.executeScript("arguments[0].click();", related);
		Thread.sleep(6000);
		
		WebElement share = driver.findElement(By.xpath("//button[@title='Share an update...']"));
		executor.executeScript("arguments[0].click();", share);
		Thread.sleep(6000);
		
		WebElement shareContent = driver.findElement(By.xpath("//div[@data-placeholder='Share an update...']"));
		executor.executeScript("arguments[0].click();", shareContent);
		Thread.sleep(1000);
		
		Robot re = new Robot();
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
		boolean eleSelected= driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]")).isDisplayed();
		 System.out.println("Element Displayed: " +eleSelected);
		 Thread.sleep(2000);
		if(eleSelected == true) {
			//WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
			WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]"));
		 executor.executeScript("arguments[0].click();", show1); 
		 System.out.println("DLVR Info Cases clicked");
		 Thread.sleep(8000);
		}
		else {
			
		 System.out.println("DLVR Info Cases not clicked");
		
		
		
		}}
		catch (NoSuchElementException e) {
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
		Thread.sleep(3000);
		WebElement dlvrCase = driver.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[9]"));
	//	String text =show1.getText();
	 executor.executeScript("arguments[0].click();", dlvrCase); 
	 System.out.println("DLVR Info Cases clicked");
	 Thread.sleep(8000);
		}
	
		WebElement reentlchk = driver.findElement(By.xpath("(//img[@class='slds-truncate unchecked'])[2]"));
		reentlchk.isSelected();
		System.out.println("Checkbox is selected: "+reentlchk.isSelected());
		Thread.sleep(3000);
		String value1 = reentlchk.getAttribute("alt");
		
		//System.out.println("Checkbox is selected: "+ reentlchk.isDisplayed());
		 System.out.println("checked: "+value1);
		 
		 
		 By unchk = By.xpath("(//img[@class='slds-truncate unchecked'])[2]");
		 gl.verifyCheckboxUnSelected(unchk, "DLVR info case");
		 Thread.sleep(3000);
		
	}
	
	public static void lightningForAccount() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement cases = driver.findElement(By.xpath("//a[@title='Cases']"));
		executor.executeScript("arguments[0].click();", cases);
		Thread.sleep(2000);

		WebElement lightning = driver.findElement(By.xpath("//div[contains(text(),'New Lightning Case')]"));
		executor.executeScript("arguments[0].click();", lightning);
		Thread.sleep(17000);

		WebElement entitle = driver.findElement(By.xpath("//a[@title='Entitlement']"));
		executor.executeScript("arguments[0].click();", entitle);
		Thread.sleep(8000);

		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		// gl.clickElement(Ebt, "Link");

		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		Thread.sleep(1000);

		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='pbBody']"));
		Thread.sleep(1000);

		WebElement SerlNum = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=1]"));
		executor.executeScript("arguments[0].value='TC00000070';", SerlNum);
		Thread.sleep(2000);
		

		WebElement contract = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=2]"));
		executor.executeScript("arguments[0].value='4000054077';", contract);
		Thread.sleep(2000);
		
		WebElement prdno = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=3]"));
		executor.executeScript("arguments[0].value='QW968A';", prdno);
		Thread.sleep(2000);
		

		// gl.inputText(SerlNum, "SlrNO", "SUMITN789613");
		Select CntryCode = new Select(driver.findElement(By.xpath("//Select[@class='slds-select ']")));
		CntryCode.selectByVisibleText("United States");
		Thread.sleep(2000);

		WebElement entitleCheck = driver.findElement(By.id("pg:FormId:main:search"));
		executor.executeScript("arguments[0].click();", entitleCheck);
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//div[@class='pbSubsection']"));
		Thread.sleep(1000);
		
		WebElement prdNo = driver.findElement(By.xpath("//table[@class='list slds-table slds-table_striped']//tr[1]//td[1]//a[1]"));

		executor.executeScript("arguments[0].click();", prdNo);
		Thread.sleep(10000);

		// Click on Done Button
		WebElement dne = driver.findElement(By.xpath("(//input[@value='Done'])[1]"));
		executor.executeScript("arguments[0].click();", dne);
		System.out.println("Clicked On Done Button ");
		Thread.sleep(30000);
		
		/**WebElement popupMssg = driver.findElement(By.xpath("//div[@class='squeeze']"));  
		String alertText = popupMssg.getText();
		System.out.println( "Popup Message1 : "+alertText);
		Thread.sleep(2000);
		
		By alrtText =By.xpath("//div[@class='squeeze']");
		gl.elementContain(alrtText, "Popup Text in Entitlement Page");
		Thread.sleep(1000);
		
		

		// Click on Ok Button
		// By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");

		WebElement oky = driver.findElement(By.xpath("//input[@class='btn searchBtn']"));
		executor.executeScript("arguments[0].click();", oky);
		System.out.println("Clicked On Okay Button ");
		Thread.sleep(8000);

		driver.switchTo().defaultContent();
		//Thread.sleep(1000);

		driver.switchTo().frame(1);

		WebElement dne2 = driver.findElement(By.xpath("(//input[@class='btn slds-button slds-button_brand'])[1]"));
		executor.executeScript("arguments[0].click();", dne2);

		System.out.println("Clicked On Done2 Button ");
		Thread.sleep(20000);**/

		WebElement location = driver.findElement(By.xpath("(//span[contains(text(),'Location ')])[1]"));
		executor.executeScript("arguments[0].click();", location);
		System.out.println("Clicked On Location Button ");
		Thread.sleep(8000);
		driver.switchTo().frame(1);
		WebElement acc=  driver.findElement(By.xpath("//a[text()='Search By Account Name']"));
		executor.executeScript("arguments[0].click();", acc);
		 Thread.sleep(8000);
		 
		 driver.findElement (By.xpath("(//input[@lightning-input_input=''])[4]")).clear();
		 Thread.sleep(10000);
		 
		 WebElement text= driver.findElement(By.xpath("(//input[@lightning-input_input=''])[4]"));
		
		 text.sendKeys("The Coca-Cola Bottling Company of New York Inc");
	
		 Thread.sleep(10000);
		 
		 Select CntryCode1 = new Select(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")));
			CntryCode1.selectByVisibleText("United States");
			Thread.sleep(2000);
		
			
			 WebElement search= driver.findElement(By.xpath("(//button[@title='Search'])[1]"));
			 executor.executeScript("arguments[0].click();", search);
			 Thread.sleep(10000);
			 
			 WebElement checkbox= driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[5]"));
			 executor.executeScript("arguments[0].click();", checkbox);
			 Thread.sleep(10000);
		 

		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		WebElement R1 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[3]"));

		executor.executeScript("arguments[0].click();", R1);
		Thread.sleep(2000);
		
		WebElement loc= driver.findElement(By.xpath("//a[text()='Search By Location Name']"));
		executor.executeScript("arguments[0].click();", loc);
		 Thread.sleep(10000);
		 
		 By val = By.xpath("(//button[text()='Search Locations'])");
			gl.clickElement(val, "val");
			Thread.sleep(15000);

		 
		// By chk = (By.xpath("(//span[@class='slds-radio_faux'])[27]"));
		 WebElement chk = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[10]"));
		 executor.executeScript("arguments[0].click();", chk);
			Thread.sleep(10000);

		
		WebElement R2 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[8]"));
		executor.executeScript("arguments[0].click();", R2);
		Thread.sleep(2000);

		WebElement updBtn = driver.findElement(By.xpath("//div[@id='assLocId']/descendant::button[position()=1]"));
		executor.executeScript("arguments[0].click();", updBtn);
		//new by
		By newsdiok2= By.xpath("//div[@id='assLocId']/div[2]//c-g-s-d-c-s-c-s-d-i-popup/section[@role='dialog']//button[@title='OK']");
        Thread.sleep(1000);
        gl.clickButton(newsdiok2, "OK");
		Thread.sleep(30000);
		
		/**driver.findElement(By.xpath("//ul[@class='slds-tabs_default__nav']"));
		Thread.sleep(2000);
		
		WebElement gtal = driver.findElement(By.xpath("(//a[@class='slds-tabs_default__link'])[3]"));
		executor.executeScript("arguments[0].click();", gtal);
		Thread.sleep(1000);
		
		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);**/
		
		WebElement sdiMssg1 = driver.findElement(By.xpath("(//div[@class='slds-card__body'])[4]"));  
		String sdiMss1 = sdiMssg1.getText();
		System.out.println( "SDI Message : "+sdiMss1);
		Thread.sleep(1000);

		By sdiMessage1 =By.xpath("(//div[@class='slds-card__body'])[4]");
		gl.elementContain(sdiMessage1, "SDI Message");
		Thread.sleep(1000);
		
	/**	WebElement sdiMssg2 = driver.findElement(By.xpath("//slot[@name='leftsidebar']/descendant::p[position()=5]"));  
		String sdiMss2 = sdiMssg2.getText();
		System.out.println( "SDI Message : "+sdiMss2);
		
		By sdiMessage2 =By.xpath("//slot[@name='leftsidebar']/descendant::p[position()=5]");
		gl.elementContain(sdiMessage2, "SDI Message");
		Thread.sleep(10000);
		
		WebElement sdiMssg = driver.findElement(By.xpath("(//div[@class='more'])[2]"));  
		String sdiMss = sdiMssg.getText();
		System.out.println( "SDI Message1 : "+sdiMss);
		
		By sdiMessage =By.xpath("(//div[@class='more'])[2]");
		gl.elementContain(sdiMessage, "SDI Message");
		Thread.sleep(10000);**/
		
		
		WebElement result = driver.findElement(By.xpath("//a[text()='View All Messages ']"));
		executor.executeScript("arguments[0].click();", result);
		Thread.sleep(8000);
		
		WebElement checkbox1 = driver.findElement(By.xpath("(//img[@class='slds-truncate checked'])[2]"));
		checkbox1.isSelected();
		checkbox1.isDisplayed();
		String value = checkbox1.getAttribute("alt");
		
		System.out.println("Checkbox is selected: " + checkbox1.isDisplayed());
		 System.out.println("checked: "+value);
	
		Thread.sleep(1000);
		
		 By chk1 = By.xpath("(//img[@class='slds-truncate checked'])[2]");
		 gl.verifyCheckboxSelected(chk1, "DLVR info case Checked");
		 Thread.sleep(1000);

		WebElement closeDLVR = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[2]"));
		executor.executeScript("arguments[0].click();", closeDLVR);
		Thread.sleep(1000);
	
		WebElement reLocation = driver.findElement(By.xpath("//a[@title='Search Location']"));
		executor.executeScript("arguments[0].click();", reLocation);
		Thread.sleep(6000);
		
		WebElement locationSearch = driver.findElement(By.xpath("(//span[contains(text(),'Location ')])[1]"));
		executor.executeScript("arguments[0].click();", locationSearch);
		System.out.println("Clicked On Location Button ");
		Thread.sleep(8000);
		driver.switchTo().frame(1);
		WebElement reAcc=  driver.findElement(By.xpath("//a[text()='Search By Account Name']"));
		executor.executeScript("arguments[0].click();", reAcc);
		 Thread.sleep(8000);
		 
		 driver.findElement (By.xpath("(//input[@lightning-input_input=''])[4]")).clear();
		 Thread.sleep(10000);
		 
		 WebElement reText= driver.findElement(By.xpath("(//input[@lightning-input_input=''])[4]"));
		
		 reText.sendKeys("HPE SGP LIMITED ");
	
		 Thread.sleep(10000);
		 
		 Select reCntryCode = new Select(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")));
		 reCntryCode.selectByVisibleText("United Kingdom");
			Thread.sleep(2000);
		
			
			 WebElement reSearch= driver.findElement(By.xpath("(//button[@title='Search'])[1]"));
			 executor.executeScript("arguments[0].click();", reSearch);
			 Thread.sleep(10000);
			 
			 WebElement radio1= driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[5]"));
			 executor.executeScript("arguments[0].click();", radio1);
			 Thread.sleep(10000);
		 

		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		WebElement chk_R1 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[3]"));

		executor.executeScript("arguments[0].click();", chk_R1);
		Thread.sleep(2000);
		
		WebElement reLcn= driver.findElement(By.xpath("//a[text()='Search By Location Name']"));
		executor.executeScript("arguments[0].click();", reLcn);
		 Thread.sleep(10000);
		 
		 WebElement reval= driver.findElement(By.xpath("//div[@id='serByLocName']/descendant::button[position()=2]"));
		 executor.executeScript("arguments[0].click();", reval);
		 Thread.sleep(15000);
		 
		// By chk = (By.xpath("(//span[@class='slds-radio_faux'])[27]"));
		 WebElement chkBox = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[10]"));
		 executor.executeScript("arguments[0].click();", chkBox);
			Thread.sleep(10000);

		
		WebElement chk_R2 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[8]"));
		executor.executeScript("arguments[0].click();", chk_R2);
		Thread.sleep(2000);

		WebElement reUpdBtn = driver.findElement(By.xpath("//div[@id='assLocId']/descendant::button[position()=1]"));
		executor.executeScript("arguments[0].click();", reUpdBtn);
//		By newsdiok3= By.xpath("//div[@id='assLocId']/div[2]//c-g-s-d-c-s-c-s-d-i-popup/section[@role='dialog']//button[@title='OK']");
//        Thread.sleep(1000);
//        gl.clickButton(newsdiok3, "OK");
		Thread.sleep(30000);
		
		WebElement nonSDI = driver.findElement(By.xpath("(//div/center)[2]"));  
		String nonSDIMssg = nonSDI.getText();
		System.out.println( "Non SDI Message : "+nonSDIMssg);
		Thread.sleep(1000);
		
		WebElement related = driver.findElement(By.xpath("//a[text()='Related']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", related);
		executor.executeScript("arguments[0].click();", related);
		Thread.sleep(6000);
		
		WebElement share = driver.findElement(By.xpath("//button[@title='Share an update...']"));
		executor.executeScript("arguments[0].click();", share);
		Thread.sleep(6000);
		
		WebElement shareContent = driver.findElement(By.xpath("//div[@data-placeholder='Share an update...']"));
		executor.executeScript("arguments[0].click();", shareContent);
		Thread.sleep(6000);
		
		Robot re = new Robot();
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
		boolean eleSelected= driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]")).isDisplayed();
		 System.out.println("Element Displayed: " +eleSelected);
		 Thread.sleep(2000);
		if(eleSelected == true) {
			//WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
			WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]"));
		 executor.executeScript("arguments[0].click();", show1); 
		 System.out.println("DLVR Info Cases clicked");
		 Thread.sleep(8000);
		}
		else {
			
		 System.out.println("DLVR Info Cases not clicked");
		
		
		
		}}
		catch (NoSuchElementException e) {
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
		Thread.sleep(3000);
		WebElement dlvrCase = driver.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[9]"));
	//	String text =show1.getText();
	 executor.executeScript("arguments[0].click();", dlvrCase); 
	 System.out.println("DLVR Info Cases clicked");
	 Thread.sleep(8000);
		}
	
		WebElement reentlchk = driver.findElement(By.xpath("(//img[@class='slds-truncate unchecked'])[2]"));
		reentlchk.isSelected();
		System.out.println("Checkbox is selected: "+reentlchk.isSelected());
		Thread.sleep(3000);
		String value1 = reentlchk.getAttribute("alt");
		
		//System.out.println("Checkbox is selected: "+ reentlchk.isDisplayed());
		 System.out.println("checked: "+value1);
		 
		 
		 By unchk = By.xpath("(//img[@class='slds-truncate unchecked'])[2]");
		 gl.verifyCheckboxUnSelected(unchk, "DLVR info case");
		 Thread.sleep(3000);
		
	}
	
	

	public static void whispernet_Entitlement_AccountSearch() throws Exception {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement cases = driver.findElement(By.xpath("//a[@title='Cases']"));
		executor.executeScript("arguments[0].click();", cases);
		Thread.sleep(1000);

		WebElement lightning = driver.findElement(By.xpath("//div[contains(text(),'New Lightning Case')]"));
		executor.executeScript("arguments[0].click();", lightning);
		Thread.sleep(35000);

		WebElement entitle = driver.findElement(By.xpath("//a[@title='Entitlement']"));
		executor.executeScript("arguments[0].click();", entitle);
		Thread.sleep(10000);

		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		// gl.clickElement(Ebt, "Link");

		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		Thread.sleep(1000);

		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='pbBody']"));
		Thread.sleep(1000);

		WebElement SerlNum = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=1]"));
		executor.executeScript("arguments[0].value='TC00000070';", SerlNum);
		Thread.sleep(2000);
		

		WebElement contract = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=2]"));
		executor.executeScript("arguments[0].value='4000054077';", contract);
		Thread.sleep(2000);
		
		WebElement prdno = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=3]"));
		executor.executeScript("arguments[0].value='QW968A';", prdno);
		Thread.sleep(2000);
		

		// gl.inputText(SerlNum, "SlrNO", "SUMITN789613");
		Select CntryCode = new Select(driver.findElement(By.xpath("//Select[@class='slds-select ']")));
		CntryCode.selectByVisibleText("United States");
		Thread.sleep(2000);

		WebElement entitleCheck = driver.findElement(By.id("pg:FormId:main:search"));
		executor.executeScript("arguments[0].click();", entitleCheck);
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//div[@class='pbSubsection']"));
		Thread.sleep(1000);
		
		WebElement prdNo = driver.findElement(By.xpath("//table[@class='list slds-table slds-table_striped']//tr[1]//td[1]//a[1]"));

		executor.executeScript("arguments[0].click();", prdNo);
		Thread.sleep(8000);

		// Click on Done Button
		WebElement dne = driver.findElement(By.xpath("(//input[@value='Done'])[1]"));
		executor.executeScript("arguments[0].click();", dne);
		System.out.println("Clicked On Done Button ");
		Thread.sleep(25000);
		
		WebElement popupMssg = driver.findElement(By.xpath("//div[@class='squeeze']"));  
		String alertText = popupMssg.getText();
		System.out.println( "Popup Message1 : "+alertText);
		Thread.sleep(2000);
		
		By alrtText =By.xpath("//div[@class='squeeze']");
		gl.elementContain(alrtText, "Popup Text in Entitlement Page");
		Thread.sleep(1000);
		

		// Click on Ok Button
		// By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");

		WebElement oky = driver.findElement(By.xpath("//input[@class='btn searchBtn']"));
		executor.executeScript("arguments[0].click();", oky);
		System.out.println("Clicked On Okay Button ");
		Thread.sleep(10000);

		driver.switchTo().defaultContent();
		//Thread.sleep(1000);

		driver.switchTo().frame(1);

		WebElement dne2 = driver.findElement(By.xpath("(//input[@class='btn slds-button slds-button_brand'])[1]"));
		executor.executeScript("arguments[0].click();", dne2);

		System.out.println("Clicked On Done2 Button ");
		Thread.sleep(25000);

		WebElement location = driver.findElement(By.xpath("(//span[contains(text(),'Location ')])[1]"));
		executor.executeScript("arguments[0].click();", location);
		System.out.println("Clicked On Location Button ");

		Thread.sleep(4000);
		driver.switchTo().frame(1);
		WebElement acc=  driver.findElement(By.xpath("//a[text()='Search By Account Name']"));
		executor.executeScript("arguments[0].click();", acc);
		 Thread.sleep(8000);
		 
		 driver.findElement (By.xpath("(//input[@lightning-input_input=''])[4]")).clear();
		 Thread.sleep(2000);
		 
		 WebElement text= driver.findElement(By.xpath("(//input[@lightning-input_input=''])[4]"));
		
		 text.sendKeys("The Coca-Cola Bottling Company of New York Inc");
	
		 Thread.sleep(2000);
		 
		 Select CntryCode1 = new Select(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")));
			CntryCode1.selectByVisibleText("United States");
			Thread.sleep(2000);
		
			
			 WebElement search= driver.findElement(By.xpath("(//button[@title='Search'])[1]"));
			 executor.executeScript("arguments[0].click();", search);
			 Thread.sleep(5000);
			 
			 WebElement checkbox= driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[5]"));
			 executor.executeScript("arguments[0].click();", checkbox);
			 Thread.sleep(4000);
		 

		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		WebElement R1 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[3]"));

		executor.executeScript("arguments[0].click();", R1);
		Thread.sleep(2000);
		
		WebElement loc= driver.findElement(By.xpath("//a[text()='Search By Location Name']"));
		executor.executeScript("arguments[0].click();", loc);
		 Thread.sleep(4000);
		 
		 By val = By.xpath("(//button[text()='Search Locations'])");
			gl.clickElement(val, "val");
			Thread.sleep(15000);
		 
		// By chk = (By.xpath("(//span[@class='slds-radio_faux'])[27]"));
		 WebElement chk = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[10]"));
		 executor.executeScript("arguments[0].click();", chk);
			Thread.sleep(4000);

		
		WebElement R2 = driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[8]"));
		executor.executeScript("arguments[0].click();", R2);
		Thread.sleep(2000);

		WebElement updBtn = driver.findElement(By.xpath("//div[@id='assLocId']/descendant::button[position()=1]"));
		executor.executeScript("arguments[0].click();", updBtn);
		By newsdiok4= By.xpath("//div[@id='assLocId']/div[2]//c-g-s-d-c-s-c-s-d-i-popup/section[@role='dialog']//button[@title='OK']");
        Thread.sleep(1000);
        gl.clickButton(newsdiok4, "OK");
		Thread.sleep(30000);
		
		/**driver.findElement(By.xpath("//ul[@class='slds-tabs_default__nav']"));
		Thread.sleep(2000);
		
		WebElement gtal = driver.findElement(By.xpath("(//a[@class='slds-tabs_default__link'])[3]"));
		executor.executeScript("arguments[0].click();", gtal);
		Thread.sleep(1000);
		
		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);**/
		
		WebElement sdiMssg1 = driver.findElement(By.xpath("(//div[@class='slds-card__body'])[3]"));  
		String sdiMss1 = sdiMssg1.getText();
		System.out.println( "SDI Message : "+sdiMss1);
		Thread.sleep(1000);

		By sdiMessage1 =By.xpath("(//div[@class='slds-card__body'])[3]");
		gl.elementContain(sdiMessage1, "SDI Message");
		Thread.sleep(1000);
		
		
		WebElement result = driver.findElement(By.xpath("//a[text()='View All Messages ']"));
		executor.executeScript("arguments[0].click();", result);
		Thread.sleep(12000);
		
		WebElement checkbox1 = driver.findElement(By.xpath("(//img[@class='slds-truncate checked'])[2]"));
		checkbox1.isSelected();
		checkbox1.isDisplayed();
		String value = checkbox1.getAttribute("alt");
		
		System.out.println("Checkbox is selected: " + checkbox1.isDisplayed());
		 System.out.println("checked: "+value);
	
		Thread.sleep(1000);
		
		 By chk1 = By.xpath("(//img[@class='slds-truncate checked'])[2]");
		 gl.verifyCheckboxSelected(chk1, "DLVR info case Checked");
		 Thread.sleep(1000);

		WebElement closeDLVR = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[2]"));
		executor.executeScript("arguments[0].click();", closeDLVR);
		Thread.sleep(1000);
	
		WebElement reentitle = driver.findElement(By.xpath("//a[@title='Entitlement']"));
		executor.executeScript("arguments[0].click();", reentitle);
		Thread.sleep(6000);
		
		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		Thread.sleep(1000);

		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='pbBody']"));
		Thread.sleep(1000);
		
		WebElement clr = driver.findElement(By.id("pg:FormId:main:ClearSTD"));

		executor.executeScript("arguments[0].click();", clr);
		Thread.sleep(3000);

		WebElement reSerlNum = driver.findElement(By.xpath("//div[@id='Search']/descendant::input[position()=1]"));

		executor.executeScript("arguments[0].value='SGH233ATKK';", reSerlNum);
		Thread.sleep(3000);

		// gl.inputText(SerlNum, "SlrNO", "SUMITN789613");
		Select reCntryCode = new Select(driver.findElement(By.xpath("//select[@id='pg:FormId:main:countries']")));
		reCntryCode.selectByVisibleText("United States");
		Thread.sleep(3000);

		WebElement reentitleCheck = driver.findElement(By.id("pg:FormId:main:search"));
		executor.executeScript("arguments[0].click();", reentitleCheck);
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//div[@class='pbSubsection']"));
		Thread.sleep(3000);
		
		WebElement reprdNo = driver.findElement(By.xpath("//table[@class='list slds-table slds-table_striped']//tr[1]//td[1]//a[1]"));

		executor.executeScript("arguments[0].click();", reprdNo);
		Thread.sleep(10000);

		// Click on Done Button
		WebElement redne = driver.findElement(By.xpath("(//input[@value='Done'])[1]"));
		executor.executeScript("arguments[0].click();", redne);
		System.out.println("Clicked On Done Button ");
		Thread.sleep(35000);
		
		/*
		 * WebElement closeDLVR = driver.findElement(By.
		 * xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[2]"
		 * )); executor.executeScript("arguments[0].click();", closeDLVR);
		 * Thread.sleep(1000);
		 */
	
		WebElement reLocation = driver.findElement(By.xpath("//a[@title='Search Location']"));
		executor.executeScript("arguments[0].click();", reLocation);
		Thread.sleep(6000);
		
		WebElement locationSearch = driver.findElement(By.xpath("(//span[contains(text(),'Location ')])[1]"));
		executor.executeScript("arguments[0].click();", locationSearch);
		System.out.println("Clicked On ReLocation Button ");
		Thread.sleep(6000);
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		WebElement reLcn=  driver.findElement(By.xpath("//a[text()='Search By Account Name']"));
		executor.executeScript("arguments[0].click();", reLcn);
		 Thread.sleep(10000);
		 
		 driver.findElement (By.xpath("(//input[@name='compName'])")).clear();
		 Thread.sleep(8000);
		 WebElement reText= driver.findElement(By.xpath("(//input[@name='compName'])"));
		
		 reText.sendKeys("HPE SGP LIMITED ");
	
		 Thread.sleep(2000);
		 
		 Select reCntryCode1 = new Select(driver.findElement(By.xpath("(//select[@class='slds-select'])[1]")));
		 reCntryCode1.selectByVisibleText("United Kingdom");
			Thread.sleep(2000);
		
			
			 WebElement reSearch1= driver.findElement(By.xpath("(//button[@title='Search'])[1]"));
			 executor.executeScript("arguments[0].click();", reSearch1);
			 Thread.sleep(4000);
			 
			 WebElement radio1= driver.findElement(By.xpath("//tr[@class='slds-hint-parent']/descendant::span[position()=2]"));
			 executor.executeScript("arguments[0].click();", radio1);
			 Thread.sleep(2000);
		 

		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		WebElement chk_R1 = driver.findElement(By.xpath("//span[text()='From Search Results']"));

		executor.executeScript("arguments[0].click();", chk_R1);
		Thread.sleep(2000);
		
		WebElement reLcn1= driver.findElement(By.xpath("//a[text()='Search By Location Name']"));
		executor.executeScript("arguments[0].click();", reLcn1);
		 Thread.sleep(4000);
		 
		 WebElement reval= driver.findElement(By.xpath("//div[@id='serByLocName']/descendant::button[position()=2]"));
		 executor.executeScript("arguments[0].click();", reval);
		 Thread.sleep(4000);
		 
		 //chng
		 By val2 = By.xpath("(//button[text()='Search Locations'])");
			gl.clickElement(val2, "val");
			Thread.sleep(5000);

		// By chk = (By.xpath("(//span[@class='slds-radio_faux'])[27]"));
		 WebElement chkBox = driver.findElement(By.xpath("//tr[@class='slds-hint-parent']/descendant::span[position()=2]"));
		 executor.executeScript("arguments[0].click();", chkBox);
			Thread.sleep(4000);

		
		WebElement chk_R2 = driver.findElement(By.xpath("(//span[text()='From Search Results'])[2]"));
		//	driver.findElement(By.xpath("//span[text()='From Search Results']")).click();
		executor.executeScript("arguments[0].click();", chk_R2);
		Thread.sleep(2000);

		WebElement reUpdBtn = driver.findElement(By.xpath("//div[@id='assLocId']/descendant::button[position()=1]"));
		executor.executeScript("arguments[0].click();", reUpdBtn);
		//newby
//		By newsdiok= By.xpath("//div[@id='assLocId']/div[2]//c-g-s-d-c-s-c-s-d-i-popup/section[@role='dialog']//button[@title='OK']");
//        Thread.sleep(1000);
//        gl.clickButton(newsdiok, "OK");
		Thread.sleep(30000);
		
		WebElement nonSDI = driver.findElement(By.xpath("(//div/center)[2]"));  
		String nonSDIMssg = nonSDI.getText();
		System.out.println( "Non SDI Message : "+nonSDIMssg);
		Thread.sleep(1000);
		
		
		
		WebElement related = driver.findElement(By.xpath("//a[text()='Related']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", related);
		executor.executeScript("arguments[0].click();", related);
		Thread.sleep(6000);
		
		WebElement share = driver.findElement(By.xpath("//button[@title='Share an update...']"));
		executor.executeScript("arguments[0].click();", share);
		Thread.sleep(6000);
		
		WebElement shareContent = driver.findElement(By.xpath("//div[@data-placeholder='Share an update...']"));
		executor.executeScript("arguments[0].click();", shareContent);
		Thread.sleep(6000);
		
		Robot re = new Robot();
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
		boolean eleSelected= driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]")).isDisplayed();
		 System.out.println("Element Displayed: " +eleSelected);
		 Thread.sleep(2000);
		if(eleSelected == true) {
			//WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
			WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[9]"));
		 executor.executeScript("arguments[0].click();", show1); 
		 System.out.println("DLVR Info Cases clicked");
		 Thread.sleep(8000);
		}
		else {
			
		 System.out.println("DLVR Info Cases not clicked");
		
		
		
		}}
		catch (NoSuchElementException e) {
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
		Thread.sleep(3000);
		WebElement dlvrCase = driver.findElement(By.xpath("(//a[@force-hoverablelink_hoverablelink=''])[9]"));
	//	String text =show1.getText();
	 executor.executeScript("arguments[0].click();", dlvrCase); 
	 System.out.println("DLVR Info Cases clicked");
	 Thread.sleep(8000);
		}
	
		WebElement reentlchk = driver.findElement(By.xpath("(//img[@class='slds-truncate unchecked'])[2]"));
		reentlchk.isSelected();
		System.out.println("Checkbox is selected: "+reentlchk.isSelected());
		Thread.sleep(3000);
		String value1 = reentlchk.getAttribute("alt");
		
		//System.out.println("Checkbox is selected: "+ reentlchk.isDisplayed());
		 System.out.println("checked: "+value1);
		 
		 
		 By unchk = By.xpath("(//img[@class='slds-truncate unchecked'])[2]");
		 gl.verifyCheckboxUnSelected(unchk, "DLVR info case");
		 Thread.sleep(3000);
		
	}


	public void afterMethod() {
		report.flush();
	}

}