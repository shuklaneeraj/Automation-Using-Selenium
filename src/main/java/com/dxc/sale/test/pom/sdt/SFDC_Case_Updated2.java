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
import org.openqa.selenium.NoAlertPresentException;
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

public class SFDC_Case_Updated2 {

	final static Logger log = LogManager.getLogger(SFDC_Case_Updated2.class);

	private GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;
	private WebDriver driver;

	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);

	}

	/**
	 * public SFDC_Case_Updated2(WebDriver driver,ExtentTest test){ this.driver =
	 * driver; this.test = test; }
	 **/

	public void test(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();

		/*
		 * Robot robot = new Robot(); // Press key Ctrl+Shift+i
		 * robot.keyPress(KeyEvent.VK_TAB);
		 * 
		 * Thread.sleep(3000); // Release key Ctrl+Shift+i
		 * robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(20000);
		 */

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		By Dtls = By.xpath("//a[@data-tab-value='detailTab']");
		gl.clickLink(Dtls, "Details");
		Thread.sleep(8000);

		gl.pageShouldContainsText("GSD CSC Case Open");

		By Smry = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry, "SummaryLink");

		Thread.sleep(8000);

		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		ro.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);

		By Edt = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=7]");
		gl.clickElement(Edt, "EditButton");
		Thread.sleep(8000);

		By Sbjt = By.xpath("//input[@required='']");

		gl.inputText(Sbjt, "Subject", "Test");
		Thread.sleep(8000);

		/**
		 * By Smry1 = By.xpath("//a[text()='Summary']"); gl.clickElement(Smry1,
		 * "SummaryLink"); //gl.arrowDown(Smry1); Thread.sleep(3000);
		 **/

//		WebElement conNameText = driver.findElement(By.xpath("//span[@class='pillText']"));
//		String text = conNameText.getText();
//		Thread.sleep(10000);
//
//	  if(text == null) {

		By ConNam = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNam, "ContactName", "Mahendar ");
		// gl.inputText(ConNam, "ContactName", "Kavitha ");

		Thread.sleep(4000);

		WebElement ConNam1 = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter text
		ConNam1.sendKeys("Dumpla");
		// ConNam1.sendKeys("Venkatesh");
		ConNam1.sendKeys(" ");
		Thread.sleep(4000);

		WebElement element = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));

		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
//		}
//		
//		else if(text!= null) {
//			By close = By.xpath("//span[@class='deleteIcon']");
//			gl.clickElement(close, "Close");
//			//gl.arrowDown(Smry1);
//			Thread.sleep(3000);
//			
//			By ConNam = By.xpath("//input[@placeholder='Search Contacts...']");
//			// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
//			gl.inputText(ConNam, "ContactName", "Mahendar ");
//			// gl.inputText(ConNam, "ContactName", "Kavitha ");
//
//			Thread.sleep(10000);
//
//			WebElement ConNam1 = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
//			// enter text
//			ConNam1.sendKeys("Dumpla");
//			// ConNam1.sendKeys("Venkatesh");
//			ConNam1.sendKeys(" ");
//			Thread.sleep(10000);
//
//			WebElement element = driver.findElement(By.xpath(
//					"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
//			
//			executor.executeScript("arguments[0].click();", element);
//			Thread.sleep(8000);
//			
//		}
//		

		By Envi = By.xpath("//slot[@name='main']/descendant::p[position()=9]");
		gl.inputText(Envi, "Envi", "Test");
		Thread.sleep(2000);

		By Issue = By.xpath("//slot[@name='main']/descendant::p[position()=10]");
		gl.inputText(Issue, "Issue", "Test Issue");
		Thread.sleep(3000);

		WebElement elementGtal = driver.findElement(By.xpath("(//a[@class='select'])[7]"));
		// WebElement elementGtal =
		// driver.findElement(By.xpath("(//a[contains(text(),'Not Required')])"));
		executor.executeScript("arguments[0].click();", elementGtal);
		Thread.sleep(4000);

		WebElement elementGtalPassed = driver.findElement(By.xpath("//a[text()='Passed']"));
		executor.executeScript("arguments[0].click();", elementGtalPassed);
		Thread.sleep(4000);

		// WebElement Otge =
		// driver.findElement(By.xpath("(//a[contains(text(),'--None--')])[3]"));
		WebElement Otge = driver.findElement(By.xpath("(//a[@class='select'])[8]"));
		executor.executeScript("arguments[0].click();", Otge);
		Thread.sleep(4000);

		WebElement OutageNo = driver.findElement(By.xpath("//a[text()='No']"));
		executor.executeScript("arguments[0].click();", OutageNo);
		Thread.sleep(6000);

//		// WebElement IssueNew =
//		// driver.findElement(By.xpath("(//a[contains(text(),'--None--')])[3]"));
//		WebElement IssueNew = driver.findElement(By.xpath("(//a[@class='select'])[9]"));
//		executor.executeScript("arguments[0].click();", IssueNew);
//		Thread.sleep(5000);
//
//		WebElement IssueNewNo = driver.findElement(By.xpath("(//a[@title='New System'])"));
//		executor.executeScript("arguments[0].click();", IssueNewNo);
//		Thread.sleep(5000);
//
//		// WebElement IssueClick =
//		// driver.findElement(By.xpath("(//a[contains(text(),'--None--')])[3]"));
//		WebElement IssueClick = driver.findElement(By.xpath("(//a[@class='select'])[9]"));
//		executor.executeScript("arguments[0].click();", IssueClick);
//		Thread.sleep(5000);
//
//		/**ro.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		ro.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		ro.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		ro.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);**/
//		
//
//		WebElement IssueNewNo1 = driver.findElement(By.xpath("(//a[@title='No'])"));
//		executor.executeScript("arguments[0].click();", IssueNewNo1);
//		Thread.sleep(5000);
        // WebElement IssueNew =
        // driver.findElement(By.xpath("(//a[contains(text(),'--None--')])[3]"));
        WebElement IssueNew = driver.findElement(By.xpath("(//a[@class='select'])[9]"));
        executor.executeScript("arguments[0].click();", IssueNew);
        Thread.sleep(2000);
        

        WebElement IssueNewNo = driver.findElement(By.xpath("//body/div[10]/div[1]/ul[1]/li[2]/a[1]"));
      //  WebElement IssueNewNo = driver.findElement(By.xpath("//a[@title='No']"));
      //a[@title='No']
        executor.executeScript("arguments[0].click();", IssueNewNo);
        Thread.sleep(1000);

        // WebElement IssueClick =
        // driver.findElement(By.xpath("(//a[contains(text(),'--None--')])[3]"));
//        WebElement IssueClick = driver.findElement(By.xpath("(//a[@class='select'])[9]"));
//        executor.executeScript("arguments[0].click();", IssueClick);
//        Thread.sleep(3000);

        ro.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        ro.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        ro.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);


		By Se = By.xpath("//button[@title='Save']");
		gl.clickElement(Se, "Save");
		Thread.sleep(40000);

		WebElement caseNo = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
		String case1 = caseNo.getText();
		System.out.println("Case Number  : " + case1);
		Thread.sleep(10000);

		By caseNumber = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(caseNumber, "Case Number");
		Thread.sleep(10000);

		WebElement accname1 = driver.findElement(
				By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]"));
		String name1 = accname1.getText();
		System.out.println("Account Name  : " + name1);
		Thread.sleep(6000);

		By acc = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]");
		gl.elementContain(acc, "Account Number");
		Thread.sleep(6000);

		// Clicking On Issue Mapping

		By IsueMpng = By.xpath("//span[contains(text(),'Issue Mapping')]");
		gl.clickElement(IsueMpng, "IssueMapping");
		Thread.sleep(5000);

		By IsueTyp = By.xpath("//select[@name='Issue Type']");
		gl.selectByText(IsueTyp, "IssueType", "Product Non-functional/Not working as Expected");
		Thread.sleep(3000);
		//
		By IsueCtgry = By.xpath("//select[@name='Issue Category']");
		gl.selectByText(IsueCtgry, "Issue Category", "Other");
		Thread.sleep(2000);

		By Oicd = By.xpath("//input[@name='Other Issue Category Description']");
		gl.inputText(Oicd, "Other Issue Category Description", "Test");
		Thread.sleep(6000);

		gl.keyBoardEvents("Tab");
		Thread.sleep(3000);

		By saveIssue = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(saveIssue, "saveIssue");
		Thread.sleep(30000);

		System.out.println("Case 3 Passed");
	}

	public void afterMethod() {
		report.flush();
	}

}