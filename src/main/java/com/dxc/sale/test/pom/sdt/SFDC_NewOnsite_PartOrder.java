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
import org.openqa.selenium.Keys;
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

public class SFDC_NewOnsite_PartOrder {

	final static Logger log = LogManager.getLogger(SFDC_NewOnsite_PartOrder.class);

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
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	
		By NewOnsiteLinPartk = By.xpath("//a[text()='Onsite Part Order LWC']");
		gl.clickLink(NewOnsiteLinPartk, "NewOnsiteLink ");
		Thread.sleep(20000);
		
		gl.pageShouldContainsText("Order Status");
     
		Thread.sleep(2000);
		
		/**	By popup = By.xpath("//button[@class= 'slds-button slds-button_icon toastClose slds-notify__close slds-button--icon-inverse slds-button_icon-bare' and @title='Close']");
	
		 gl.clickElement(popup, "popup");
			
		 System.out.println("popup closed"); 
		
		
		Thread.sleep(6000);**/
		
		/**By popup1 = By.xpath("//button[@class= 'slds-button slds-button_icon toastClose slds-notify__close slds-button--icon-inverse slds-button_icon-bare' and @title='Close']");
		
		 gl.clickElement(popup1, "popup1");
			//Thread.sleep(8000);
		 System.out.println("popup1 closed"); **/
		
		//Thread.sleep(10000);
//}
		Thread.sleep(6000);
	
		WebElement CSR = driver.findElement(By.xpath("//input[@class='slds-input slds-combobox__input' and @name='CSR Refusal Reason']"));
 		executor.executeScript("arguments[0].click();", CSR);
 		Thread.sleep(2000);

         
 		WebElement ReasonInfo= driver.findElement(By.xpath("//*[contains(text(),'CSR Not Allowed')]"));
 		executor.executeScript("arguments[0].click();", ReasonInfo);
 		Thread.sleep(5000);
 		
 		By shipping = (By.xpath("//span[text()='Shipping Conditions']"));
		gl.clickElement(shipping, "shipping");
		Thread.sleep(6000);
         
 		
 		WebElement address = driver.findElement(By.xpath("//input[@class='slds-input slds-combobox__input' and @name='Address Type']"));
 		executor.executeScript("arguments[0].click();", address);
 		Thread.sleep(2000);
 		
 		
 		WebElement type= driver.findElement(By.xpath("//*[contains(text(),'User Entry')]"));
 		executor.executeScript("arguments[0].click();", type);
 		Thread.sleep(10000);
 		By addr = (By.xpath("//span[text()='Address']"));
		gl.clickElement(addr, "addr");
		Thread.sleep(8000);

 		  
		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		//re.keyPress(KeyEvent.VK_DOWN);
		//Thread.sleep(2000);

		
		//By PlaceOrderbtn1 = By.xpath("(//button[@title='Place Order'])[2]");
		//gl.arrowUP(PlaceOrderbtn1);
		//Thread.sleep(50000);
		/*
		 * By GSTID = By.xpath(
		 * "//div[@id='lgt-accordion-section-368']/descendant::input[position()=2]");
		 * gl.inputText(GSTID, "GSTID Description", "INDIANCURRENCY1");
		 * Thread.sleep(5000);
		 */
		
 		
 		By PartNumber = By.xpath("//div[@class='slds-grid slds-list_horizontal']/descendant::input[position()=1]");
	//	gl.inputText(PartNumber, "PartNumber Description", "101951-001");
 		gl.inputText(PartNumber, "PartNumber Description", "101920-001");
		Thread.sleep(10000);
		
		


		By AddPartBtn = By.xpath("//button[@title='Add Part']");
		gl.clickElement(AddPartBtn, "AddPartBtn");
		Thread.sleep(20000);
		
		

		
		By CheckAvailabilitbtn = By.xpath("//button[@title='Check Availability']");
		gl.clickElement(CheckAvailabilitbtn, "CheckAvailabilitbtn");
		Thread.sleep(100000);
		//Robot re1 = new Robot();
		
		/*
		 * By Intervene = (By.xpath("//span[text()='Intervene']"));
		 * gl.clickElement(Intervene, "Intervene"); Thread.sleep(6000);
		 */
		
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(6000);
		
		/*
		 * By save = By.xpath("(//button[@title='Save'])[2]"); gl.clickElement(save,
		 * "save"); Thread.sleep(60000);
		 */
		
		By PlaceOrderbtn = By.xpath("(//button[@title='Place Order'])[2]");
		gl.clickElement(PlaceOrderbtn, "PlaceOrderbtn");
		Thread.sleep(100000);
		
		gl.pageShouldContainsText("DLVR Part Order");
		Thread.sleep(20000);
		
		WebElement orderInfo= driver.findElement(By.xpath("//lightning-accordion[@class='example-accordion accordianHeader slds-accordion']/descendant::input[position()=1]"));
		String info = orderInfo.getAttribute("value");
		System.out.println("Order information Status: "+ info);
		
		  
		   Thread.sleep(8000);
		   if(info.equals("Ordered"))
			{
				System.out.println("Order information Status is Ordered");
			}
			else
			{
				System.out.println("Order information Status is not Ordered");
			}
			Thread.sleep(6000);
		
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(20000);
		
		WebElement e = driver.findElement(By.xpath("(//button[@title='Place Order'])[2]"));
		boolean actualValue = e.isEnabled();
		//Thread.sleep(50000);
		if (actualValue) {
		       System.out.println("Button is enabled");
		}
		else {
		       System.out.println("Button is disabled and Order is Placed");
		}
		//Thread.sleep(2000);
		Thread.sleep(50000);
		
			
		/*
		 * re.keyPress(KeyEvent.VK_CONTROL); re.keyPress(KeyEvent.VK_END);
		 * Thread.sleep(3000);
		 */
			re.keyPress(KeyEvent.VK_UP);
			Thread.sleep(6000);
			By status = By.xpath("(//select[@c-gsdlwcpartorder_gsdlwcpartorder=''])[2]");
			gl.selectByText(status, "status", "Shipped");
			Thread.sleep(10000);
			
			re.keyPress(KeyEvent.VK_CONTROL);
			re.keyPress(KeyEvent.VK_END);
			Thread.sleep(6000);
			By save = By.xpath("(//button[@title='Save'])[2]");
			gl.clickElement(save, "save");
			Thread.sleep(50000);


		/**gl.pageShouldContainsText("DLVR Part Order");
		WebElement prtNo= driver.findElement(By.xpath("(//slot[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp'])[3]"));
		String number = prtNo.getText();
		System.out.println("DLVR Part Order"  +number);
		driver.findElement(By.xpath("//header[@id='oneHeader']/descendant::div[position()=18]")).sendKeys(number);
		re.keyPress(KeyEvent.VK_ENTER);
		
		WebElement prtNo1= driver.findElement(By.xpath("//th[@class='slds-cell-edit cellContainer']/descendant::a[position()=1]"));
		String number1 = prtNo1.getText();
		System.out.println("DLVR Part Order"  +number1);
		
		WebElement status= driver.findElement(By.xpath("(//span[@class='slds-truncate'])[14]"));
		String order = status.getText();
		System.out.println("DLVR Part Order placed:"  +order);
		String status1 ="Ordered";
		if(number.equals(number1) && order.equals(status1))
		{
		
			
			System.out.println("Order Placed");
		}
		else
		{
			System.out.println("Order not Placed");
		
		}**/
		
		System.out.println("Case 5 Passed");
 		
	
		
		
	}

	public void afterMethod() {
		report.flush();
	}

}