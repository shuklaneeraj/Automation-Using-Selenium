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
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;

public class SFDC_CVS_CSR {

	final static Logger log = LogManager.getLogger(SFDC_CVS_CSR.class);

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

		Login_GSD_CSC Login = new Login_GSD_CSC();
		Login.beforemethod();
		Login.test(SdEmID, SdPwrd, SSrlNum);
		
		SFDC_Case_Created LightingCase = new SFDC_Case_Created();
		LightingCase.beforemethod();
		LightingCase.test(SdEmID, SdPwrd, SSrlNum);

		SFDC_Case_Updated1 UpdateCase1 = new SFDC_Case_Updated1();
		UpdateCase1.beforemethod();
		UpdateCase1.test(SdEmID, SdPwrd, SSrlNum);

		By cvsLink = By.xpath("//a[text()='View Compliance Results']");
		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		Thread.sleep(8000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]"));
		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count = rows.size();
		System.out.println("ROW COUNT : " + count);
		Thread.sleep(4000);
		if (count == 1) {
			System.out.println("CVS call Occurs when Update Case");
		} else {
			System.out.println("Error in CVS call When Update Case");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab1 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab1, "tab1");
		Thread.sleep(6000);

		SFDC_Case_Updated2 update = new SFDC_Case_Updated2();
		//SFDC_Case_Updated update = new SFDC_Case_Updated();
		update.beforemethod();
		update.test(SdEmID, SdPwrd, SSrlNum);
		Thread.sleep(3000);

		// By tab2 = By.xpath("(//a[@class='tabHeader slds-tabs--default__link
		// slds-p-right--small slds-grow '])[2]");
		// gl.clickElement(tab2, "tab2");
		// Thread.sleep(20000);

	gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(8000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos));

		List<WebElement> row2 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count2 = row2.size();
		System.out.println("ROW COUNT : " + count2);
		Thread.sleep(4000);
		if (count2 == 2) {
			System.out.println("CVS call Occurs when Enter Contact Name");
		} else {
			System.out.println("Error in CVS call When enter Contact Name");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab3 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab3, "tab3");
		Thread.sleep(8000);

		SFDC_NewCSRTask CSRLink = new SFDC_NewCSRTask();
		CSRLink.beforemethod();
		CSRLink.test(SdEmID, SdPwrd, SSrlNum);

		By tab4 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab4, "tab4");
		Thread.sleep(8000);

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(4000);

		By pos1 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos1));

		List<WebElement> rows3 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count3 = rows3.size();
		System.out.println("ROW COUNT : " + count3);
		Thread.sleep(4000);
		if (count3 == 3) {
			System.out.println("CVS call Occurs when CSR Place Order");
		} else {
			System.out.println("Error in CVS call When CSR Place Order");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tabCsr = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tabCsr, "tabCsr");
		Thread.sleep(8000);

		By Smry1 = By.xpath("//a[text()='Summary']");
		gl.clickElement(Smry1, "SummaryLink");
		//gl.arrowDown(Smry1);
		Thread.sleep(3000);

		//By Edt = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=13]");
		By Edt = By.xpath("//button[@title='Edit Contact Name']");
		gl.clickElement(Edt, "EditButton");
		Thread.sleep(10000);

		By acctName = By.xpath("(//a[@class='deleteAction'])");
		gl.clickButton(acctName, "acctName");
		Thread.sleep(4000);

		By ConNam = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNam, "ContactName", "Test ");

		Thread.sleep(4000);

		WebElement ConNam1 = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter tex
		ConNam1.sendKeys("201");
		ConNam1.sendKeys(" ");
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		By Save2 = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(Save2, "Save 2 ");
		Thread.sleep(20000);
		
		
		WebElement caseNo = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
		String case1 = caseNo.getText();
		System.out.println("Case Number  : "+case1);
		Thread.sleep(30000);
		
		//WebElement caseNumber1 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[9]"));
		By caseNumber = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(caseNumber, "Case Number");
		Thread.sleep(30000);
		
		//WebElement accname = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grid itemBody'])[19]"));
		WebElement accname1 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]"));
		String name1 = accname1.getText();
		System.out.println("Account Name  : "+name1);	
		Thread.sleep(20000);
		
		By acc = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]");
		gl.elementContain(acc, "Account Number");
		Thread.sleep(20000);
		
		By closeCSR = By.xpath("(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[3]");
		gl.clickElement(closeCSR, "closeCSR");
		Thread.sleep(5000);

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(10000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos2 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos2));

		List<WebElement> rows4 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count4 = rows4.size();
		System.out.println("ROW COUNT : " + count4);
		Thread.sleep(4000);
		if (count4 == 4) {
			System.out.println("CVS call Occurs when Change Account Name");
		} else {
			System.out.println("Error in CVS call When Change Account Name");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab6 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab6, "tab6");
		Thread.sleep(8000);

		// ReEntitlement

		By ELin = By.xpath("(//a[@title='Entitlement'])");
		gl.clickLink(ELin, "EntlLink");
		Thread.sleep(5000);

		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		// gl.clickElement(Ebt, "Link");

		gl.verifyElementVisible(Ebt, "Entitlement Check page is open");

		driver.findElement(By.xpath("(//div[@class='iframe-parent slds-template_iframe slds-card'])"));

		Thread.sleep(6000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().frame(1);
		Thread.sleep(20000);

		driver.findElement(By.xpath("(//div[@id='pg:FormId:main'])"));

		Thread.sleep(3000);

		By SerlNum = By.xpath("//input[@id='pg:FormId:main:serialNo']");
		// gl.inputText(SerlNum, "SlrNO", "SUMITN789621");
		gl.inputText(SerlNum, "SlrNO", "USE542N19Q");
		Thread.sleep(3000);

		By CntryCode = By.xpath("//Select[@id='pg:FormId:main:countries']");
		gl.selectByText(CntryCode, "Country", "India");
		Thread.sleep(3000);

		By contractId = By.xpath("//input[@id='pg:FormId:main:contractId']");
		gl.clearElementText(contractId, "Contract Id");
		Thread.sleep(3000);

		By prdCode = By.xpath("//input[@id='pg:FormId:main:productNo']");
		gl.clearElementText(prdCode, "Product Code");

		Thread.sleep(3000);

		By EntChk = By.id("pg:FormId:main:search");
		gl.clickButton(EntChk, "EntlMntChk");
		Thread.sleep(12000);

		Robot re = new Robot();
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);

		By exce = By.id("pg:FormId:main:j_id200");
		gl.clickButton(exce, "Exception");
		Thread.sleep(12000);
		re.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_END);
		Thread.sleep(2000);

		By exceProcess = By.xpath("//select[@id='pg:FormId:main:exepDetail:TestHidden:sel256']");
		gl.selectByText(exceProcess, "exceProcess", "Trust");
		Thread.sleep(3000);

		By prodNo = By.xpath("//input[@id='pg:FormId:main:exepDetail:myPBS1:j_id208:PN']");
		gl.inputText(prodNo, "prodNo", "654081-B21");
		Thread.sleep(3000);

		re.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		re.keyPress(KeyEvent.VK_HOME);
		Thread.sleep(2000);

		By Dne = By.xpath("(//input[@value='Done'])[1]");
		gl.clickElement(Dne, "Done");
		System.out.println("Clicked On Done Button ");
		Thread.sleep(50000);

		// By cvsLink = By.xpath("//a[text()='View Compliance Results']");

		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(10000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos3 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos3));

		List<WebElement> rows5 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count5 = rows5.size();
		System.out.println("ROW COUNT : " + count5);
		Thread.sleep(4000);
		if (count5 == 5) {
			System.out.println("CVS call Occurs when ReEntitlement");
		} else {
			System.out.println("Error in CVS call When ReEntitlement");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tab5 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab5, "tab5");
		Thread.sleep(10000);

		// Search Location

		By searchLoc = By.xpath("(//a[@title='Search Location'])");
		gl.clickLink(searchLoc, "searchLoc");
		Thread.sleep(5000);

		By Location = By.xpath("(//span[contains(text(),'Location ')])[1]");
		gl.clickLink(Location, "Location");
		System.out.println("Clicked On Location Button ");
		Thread.sleep(10000);

		driver.navigate().refresh();
		Thread.sleep(20000);

		driver.switchTo().frame(1);
		Thread.sleep(2000);
		By accSearch = By.xpath("//a[text()='Search By Account Name']");
		gl.clickElement(accSearch, "accSearch");
		Thread.sleep(8000);

		driver.findElement(By.xpath("(//input[@lightning-input_input=''])[3]")).clear();
		Thread.sleep(6000);

		By text = By.xpath("(//input[@lightning-input_input=''])[3]");
		gl.inputText(text, "text", "pennsylvania university");

		Thread.sleep(6000);

		By ctry = By.xpath("(//select[@class='slds-select'])[1]");
		gl.selectByText(ctry, "ctry", "United States");
		Thread.sleep(6000);

		By search = By.xpath("(//button[@title='Search'])[1]");
		gl.clickElement(search, "search");
		Thread.sleep(8000);

		By checkbox = By.xpath("(//span[@class='slds-radio_faux'])[4]");
		gl.clickElement(checkbox, "checkbox");
		Thread.sleep(8000);

		By R1 = By.xpath("(//span[@lightning-input_input=''])[7]");
		// By R1= By.xpath("(//span[@lightning-input_input=''])[3]");

		gl.clickRadioButton(R1, "FromPreviousCase1");
		Thread.sleep(8000);

		By loc = By.xpath("//a[text()='Search By Location Name']");
		gl.clickElement(loc, "loc");
		Thread.sleep(10000);

		By val = By.xpath("//div[@id='serByLocName']/descendant::button[position()=2]");
		gl.clickElement(val, "val");
		Thread.sleep(10000);

		By chk = (By.xpath("(//span[@class='slds-radio_faux'])[15]"));
		gl.clickElement(chk, "chk");
		Thread.sleep(6000);

		By R2 = By.xpath("(//span[@lightning-input_input=''])[20]");
		// By R2= By.xpath("(//span[@lightning-input_input=''])[11]");
		gl.clickButton(R2, "FromPreviousCase2");
		Thread.sleep(10000);

		By Ucbtn = By.xpath("//div[@id='assLocId']/descendant::button[position()=1]");
		gl.clickButton(Ucbtn, "UpdateCase");
		Thread.sleep(60000);
		
		
		By tabUpd = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[3]/a");
		gl.clickElement(tabUpd, "tabUpd");
		Thread.sleep(10000);
		// By cvsLink = By.xpath("//a[text()='View Compliance Results']");
		//gl.clickLink(cvsLink, "cvsLink");
		//Thread.sleep(30000);

		driver.navigate().refresh();
		Thread.sleep(20000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos4 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(6000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos4));

		List<WebElement> rows6 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count6 = rows6.size();
		System.out.println("ROW COUNT : " + count6);
		Thread.sleep(4000);
		if (count6 == 6) {
			System.out.println("CVS call Occurs when Research Location");
		} else {
			System.out.println("Error in CVS call When Research Location");
		}
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab8 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab8, "tab8");
		Thread.sleep(10000);

//		SFDC_CVS_Status status = new SFDC_CVS_Status();
		//status.beforemethod();
		//status.test(SdEmID, SdPwrd, SSrlNum);
		

		System.out.println("Case 10 Passed");
	}

	public void afterMethod() {
		report.flush();
	}

}