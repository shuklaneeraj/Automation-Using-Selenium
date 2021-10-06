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

public class SFDC_DateValidation_Whispernet {

	final static Logger log = LogManager.getLogger(SFDC_DateValidation_Whispernet.class);

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
		// var javaScriptExecutor = (IJavaScriptExecutor)webDriver;

		By menu = By.xpath("//div[@class='slds-icon-waffle']");
		gl.clickLink(menu, "Menu");
		Thread.sleep(10000);

		WebElement menuSearch = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));

		executor.executeScript("arguments[0].value='Whispernet';", menuSearch);
		Thread.sleep(10000);
		// driver.findElement(By.xpath("//input[@placeholder='Search apps and
		// items...']")).sendKeys("Whispernet");

		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(7000);

		By newWhispernet = By.xpath("(//a[@title='New'])[2]");
		gl.howerMouse(newWhispernet, "newWhispernet");
		gl.clickLink(newWhispernet, "NewWhispernet");
		Thread.sleep(5000);

		By checkBox = By.xpath("(//span[@class='slds-radio--faux topdown-radio--faux'])[1]");
		gl.howerMouse(checkBox, "checkBox");
		gl.clickLink(checkBox, "checkBox");
		Thread.sleep(5000);

		By next = By.xpath(
				"//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']/descendant::span[position()=1]");
		gl.howerMouse(next, "next");
		gl.clickLink(next, "Next");
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//input[@name='Valid_From__c']"));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

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
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='Valid_To__c']")).sendKeys(todayAsString);
		Thread.sleep(10000);

		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		// By anchorType =
		// By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]");
		WebElement ele = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);

		WebElement asset = driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Asset'])"));
		
		String anchorTypeText=asset.getText();
		System.out.println("Anchor Type Text: "+anchorTypeText);
		By asset1 =By.xpath("(//lightning-base-combobox-item[@data-value='Asset'])");
		gl.elementShouldContain(asset1, "Anchor Type PickList Value","Asset");
		Thread.sleep(8000);
		executor.executeScript("arguments[0].click();", asset);
		Thread.sleep(8000);
	//	By assetText1 = By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]");
		
		WebElement anchor = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='USE542N19Q';", anchor);
		Thread.sleep(4000);
		
		// By save = By.xpath("//button[@name='SaveEdit']");

		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		executor.executeScript("arguments[0].click();", save);
		// gl.clickButton(save, "Save");
		Thread.sleep(50000);

		/**WebElement ele1 = driver.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
		executor.executeScript("arguments[0].click();", ele1);
		Thread.sleep(10000);

		// Robot re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_UP);

		Thread.sleep(6000);

		driver.switchTo().defaultContent();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//ul[@class='slds-tabs_default__nav']"));
		Thread.sleep(10000);

		WebElement rel = driver.findElement(By.xpath("//a[@id='relatedListsTab__item']"));
		executor.executeScript("arguments[0].click();", rel);

		Thread.sleep(10000);

		WebElement whis = driver.findElement(By.xpath("//a[@id='customTab__item']"));
		executor.executeScript("arguments[0].click();", whis);

		Thread.sleep(10000);
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(10000);**/
		
		

		// driver.findElement(By.xpath("(//div[@force-recordlayoutsection_recordlayoutsection=''])[8]"));
		// Thread.sleep(6000);

		// driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
		Thread.sleep(3000);

		WebElement ele3 = driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]"));
		executor.executeScript("arguments[0].click();", ele3);

		Select category = new Select(
				driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
		category.selectByVisibleText("[ENTITLEMENT]");
		Thread.sleep(20000);

		Select attribute = new Select(
				driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
		attribute.selectByVisibleText("Penalties for missed SLA");
		Thread.sleep(20000);

		Select language = new Select(
				driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
		language.selectByVisibleText("English");
		Thread.sleep(20000);

		driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
				.sendKeys("Test");
		Thread.sleep(10000);

		WebElement sdi = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
		executor.executeScript("arguments[0].click();", sdi);
		Thread.sleep(20000);

		WebElement saveCase = driver.findElement(By.xpath("//input[@value='Save']"));
		executor.executeScript("arguments[0].click();", saveCase);
		Thread.sleep(50000);
		
		WebElement whisCase = driver.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
		executor.executeScript("arguments[0].click();", whisCase);
		Thread.sleep(10000);
		
		Robot re1 = new Robot();
		re1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		re1.keyRelease(KeyEvent.VK_END);
		Thread.sleep(2000);
		
		WebElement assetDetail = driver.findElement(By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]"));
		
		String assetDtl=assetDetail.getText();
		System.out.println("Anchor Type: "+assetDtl);
		By anchr =By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
		gl.elementShouldContain(anchr, "Anchor Type","Asset");
		Thread.sleep(8000);
		
		
		WebElement assetDetailType = driver.findElement(By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]"));
		
		String assetDtlAnchr=assetDetailType.getText();
		System.out.println("Anchor: "+assetDtlAnchr);
		By anchrDtl =By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
		gl.elementShouldContain(anchrDtl, "Anchor","USE542N19Q");
		Thread.sleep(8000);
	

		WebElement submit = driver.findElement(By.xpath("//button[@name='GSD_Lead_Whispernet__c.Submit']"));
		executor.executeScript("arguments[0].click();", submit);
		//Thread.sleep(10000);
		
		

	
		
		/*
		 * WebElement alert =
		 * driver.findElement(By.xpath("//div[@class='forceVisualMessageQueue']"));
		 * String typeSubmit1 = alert.getText(); System.out.println("Record Type1: " +
		 * typeSubmit1); Thread.sleep(10000);
		 */
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-theme--error slds-notify--toast slds-notify slds-notify--toast forceToastMessage']")));
		WebElement toast1 = driver.findElement(By.xpath("//div[@class='slds-theme--error slds-notify--toast slds-notify slds-notify--toast forceToastMessage']"));  
		WebElement toastMssg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));  
		alertText = toastMssg.getText();
		System.out.println( "Alert Message: "+alertText);
		By alrt =By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
		gl.elementShouldContain(alrt, "Alert Message in Date Validation","Valid To and Valid From are set to same date. This will delete the Whispernets in this request. Do you want to continue? If YES: Please add the below comments in Requestor comments field: delete the Whispernets");
		Thread.sleep(10000);
		
		
		 
		 if(alertText.equals("Valid To and Valid From are set to same date. This will delete the Whispernets in this request. Do you want to continue? If YES: Please add the below comments in Requestor comments field: delete the Whispernets"))
		 {
				//WebElement show1 = driver.findElement(By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[16]"));
				
			 System.out.println("Failed: Valid To and Valid From are set to same date");
			 Thread.sleep(10000);
			}
			else {
				
			 System.out.println("Success : Valid To and Valid From are set to different date");
			 Thread.sleep(10000);
			
			}
		 System.out.println("Case 13 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}