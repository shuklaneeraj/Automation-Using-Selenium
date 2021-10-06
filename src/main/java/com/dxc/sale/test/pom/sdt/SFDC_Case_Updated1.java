package com.dxc.sale.test.pom.sdt;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class SFDC_Case_Updated1 {

	final static Logger log = LogManager.getLogger(SFDC_Case_Updated1.class);

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
		

		By ELin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
		gl.clickLink(ELin, "EntlLink");
		Thread.sleep(5000);

		
		
		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		//gl.clickElement(Ebt, "Link");
		
		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");
		

		driver.switchTo().frame(1);
		Thread.sleep(5000);
//		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[3]")));
//	
//		Thread.sleep(6000);
		
		
			By SerlNum = By.xpath("//input[@id='pg:FormId:main:serialNo']");
			gl.inputText(SerlNum, "SlrNO", "SGH233ATKK");
		//gl.inputText(SerlNum, "SlrNO", "SUMITN789613");

		By CntryCode = By.xpath("//Select[@id='pg:FormId:main:countries']");
		gl.selectByText(CntryCode, "Country", "United States");

		By EntChk = By.id("pg:FormId:main:search");
		gl.clickButton(EntChk, "EntlMntChk");
		Thread.sleep(20000);
		

		// Verify Product Description text on the page
		By ProdDes = By.xpath("//input[@value='Additional Contract or Asset Required']");
		gl.verifyElementVisible(ProdDes, "ProductDescription");
		Thread.sleep(8000);

		// Click on Done Button
		By Dne = By.xpath("(//input[@value='Done'])[1]");
		gl.clickElement(Dne, "Done");
		System.out.println("Clicked On Done Button ");
		Thread.sleep(50000);

		
//		// Click on Ok Button
		//By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");
		
		/** By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");
		 gl.clickButton(Oky, "Okay"); System.out.println("Clicked On Okay Button ");
		  Thread.sleep(20000);
		 
		 driver.switchTo().defaultContent(); Thread.sleep(8000);
		 
		 driver.switchTo().frame(1);
		 
		 By Dne2 = By.xpath("//*[@id=\"pg:FormId:main:j_id256:doneBotButton\"]");
		 gl.clickButton(Dne2, "Done");
		 
		  System.out.println("Clicked On Done2 Button ");
		  Thread.sleep(80000);**/
		 
				
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Ucbtn));
		
		
		
		By Location = By.xpath("(//span[contains(text(),'Location ')])[1]");
        gl.clickLink(Location, "Location");
        System.out.println("Clicked On Location Button ");
					
		driver.switchTo().frame(1);
		/**By acc= By.xpath("//a[text()='Search By Account Name']");
		 gl.clickElement(acc, "acc");
		 Thread.sleep(10000);
		 
		 driver.findElement (By.xpath("(//input[@lightning-input_input=''])[3]")).clear();
		 Thread.sleep(10000);
		 
		 By text= By.xpath("(//input[@lightning-input_input=''])[3]");
		 gl.inputText(text, "text", "Coca-Cola Bottling Company High Country");
			
		
		 Thread.sleep(10000);
		 
		 By ctry = By.xpath("(//select[@class='slds-select'])[1]");
			gl.selectByText(ctry, "ctry", "United States");
			Thread.sleep(10000);
			
			By search= By.xpath("(//button[@title='Search'])[1]");
			 gl.clickElement(search, "search");
			 Thread.sleep(10000);
			 
			 By checkbox= By.xpath("(//span[@class='slds-radio_faux'])[4]");
			 gl.clickElement(checkbox, "checkbox");
			 Thread.sleep(10000);
		 **/
		 
		// By R1= By.xpath("(//span[@lightning-input_input=''])[7]");
		By R1= By.xpath("(//span[@lightning-input_input=''])[3]");
		
		 gl.clickRadioButton(R1, "FromPreviousCase1");
		 Thread.sleep(10000);
		 
			/**By loc= By.xpath("//a[text()='Search By Location Name']");
			 gl.clickElement(loc, "loc");
			 Thread.sleep(10000);
			 
			 By val= By.xpath("//div[@id='serByLocName']/descendant::button[position()=2]");
			 gl.clickElement(val, "val");
			 Thread.sleep(15000);
			 
			// By chk = (By.xpath("(//span[@class='slds-radio_faux'])[27]"));
			 By chk = (By.xpath("(//span[@class='slds-radio_faux'])[8]"));
				gl.clickElement(chk, "chk");
				Thread.sleep(10000);**/

		// By R2= By.xpath("(//span[@lightning-input_input=''])[24]");
		// By R2= By.xpath("(//span[@lightning-input_input=''])[28]");
		By R2= By.xpath("(//span[@lightning-input_input=''])[11]");
		 gl.clickButton(R2, "FromPreviousCase2");
		 Thread.sleep(10000);
		 
		 By Ucbtn=By.xpath("//div[@id='assLocId']/descendant::button[position()=1]");
		 gl.clickButton(Ucbtn, "UpdateCase");
	     Thread.sleep(60000);
	 
	     By Smry= By.xpath("//a[text()='Summary']");
	     gl.verifyElementVisible(Smry, "Summary Tab");
			
	     System.out.println("Case 2 Passed");
	}

	public void afterMethod() {
		report.flush();
	}

}