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

public class SFDC_CVS_Status {

	final static Logger log = LogManager.getLogger(SFDC_CVS_Status.class);

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

		// OK
		By SmryOK = By.xpath("//a[text()='Summary']");
		gl.clickElement(SmryOK, "SummaryLink");
		//gl.arrowDown(SmryOK);
		Thread.sleep(3000);

		By EdtOk = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=13]");
		gl.clickElement(EdtOk, "EditButton");
		Thread.sleep(10000);

		By acctNameOk = By.xpath("(//a[@class='deleteAction'])");
		gl.clickButton(acctNameOk, "acctName");
		Thread.sleep(4000);

		By ConNamOk = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNamOk, "ContactName", "Kavitha ");

		Thread.sleep(6000);

		WebElement ConNam1Ok = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter tex
		ConNam1Ok.sendKeys("Venkatesh ");
		ConNam1Ok.sendKeys(" ");
		Thread.sleep(4000);

		WebElement elementOk = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
		JavascriptExecutor executorOk = (JavascriptExecutor) driver;
		executorOk.executeScript("arguments[0].click();", elementOk);
		Thread.sleep(5000);

		By Save2OK = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(Save2OK, "Save 2 ");
		Thread.sleep(10000);
		
		
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

		By cvsLink = By.xpath("//a[text()='View Compliance Results']");
		gl.clickLink(cvsLink, "cvsLink");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By pos2 = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pos2));

		List<WebElement> rows8 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count8 = rows8.size();
		System.out.println("ROW COUNT : " + count8);
		Thread.sleep(4000);

		WebElement okText = driver.findElement(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[3]//span[1]"));
		String textok = okText.getText();
		System.out.println("OK Text :" + textok);
		Thread.sleep(4000);

		if (count8 == 8 && textok.equals("OK")) {
			System.out.println("CVS call Occurs when Change OK Account Name");
			System.out.println("Status is OK in CVS call");
		} else {
			System.out.println("Error in CVS call When Change OK Account Name");
			System.out.println("Status is not OK in CVS call");
		}
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tab8 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab8, "tab8");
		Thread.sleep(8000);

		// STOP
		By tabOnsite = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tabOnsite, "tabOnsite");
		Thread.sleep(8000);

		By SmryStop = By.xpath("//a[text()='Summary']");
		gl.clickElement(SmryStop, "SummaryLink");
		gl.arrowDown(SmryStop);
		Thread.sleep(3000);

		By EdtStop = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=13]");
		gl.clickElement(EdtStop, "EditButton");
		Thread.sleep(80000);

		By acctNameStop = By.xpath("(//a[@class='deleteAction'])");
		gl.clickButton(acctNameStop, "acctName");
		Thread.sleep(4000);

		By ConNamStop = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNamStop, "ContactName", "None ");

		Thread.sleep(4000);

		WebElement ConNam1Stop = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter tex
		ConNam1Stop.sendKeys("None");
		ConNam1Stop.sendKeys(" ");
		Thread.sleep(4000);

		WebElement elementStop = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
		JavascriptExecutor executorStop = (JavascriptExecutor) driver;
		executorStop.executeScript("arguments[0].click();", elementStop);
		Thread.sleep(5000);

		By Save2Stop = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(Save2Stop, "Save 2 ");
		Thread.sleep(10000);
		
		
		WebElement caseNo1 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
		String case2 = caseNo1.getText();
		System.out.println("Case Number  : "+case2);
		Thread.sleep(30000);
		
		//WebElement caseNumber1 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[9]"));
		By caseNumber1 = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(caseNumber1, "Case Number1");
		Thread.sleep(30000);
		
		//WebElement accname = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grid itemBody'])[19]"));
		WebElement accname2 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]"));
		String name2 = accname2.getText();
		System.out.println("Account Name  : "+name2);	
		Thread.sleep(20000);
		
		By acc1 = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]");
		gl.elementContain(acc1, "Account Name");
		Thread.sleep(20000);

		By tab2 = By.xpath("(//a[@class='tabHeader slds-tabs--default__link slds-p-right--small slds-grow '])[2]");
		gl.clickElement(tab2, "tab2");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By posStop = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(posStop));

		// tr[@class='dataRow even first']/td[3]

		List<WebElement> rows7 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count7 = rows7.size();
		System.out.println("ROW COUNT : " + count7);
		Thread.sleep(4000);

		WebElement stopTextbdy = driver.findElement(By.xpath("//table[@id='j_id0:FRM:PB:PBT']"));
		Thread.sleep(3000);

		WebElement stopText = driver.findElement(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[3]//span[1]"));
		Thread.sleep(3000);
		String textStop = stopText.getText();
		Thread.sleep(3000);

		System.out.println("Stop Text: " + textStop);
		if (count7 == 9 && textStop.equals("STOP")) {
			System.out.println("CVS call Occurs when Change STOP Account Name");
			System.out.println("Status is STOP in CVS call");
		} else {
			System.out.println("Error in CVS call When Change STOP Account Name");
			System.out.println("Status is not STOP in CVS call");
		}
		Thread.sleep(8000);

		driver.switchTo().defaultContent();
		Thread.sleep(6000);

		By tab7 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab7, "tab7");
		Thread.sleep(18000);

	
		// Watch Name change

		By SmryWatch = By.xpath("//a[text()='Summary']");
		gl.clickElement(SmryWatch, "SummaryLink");
		gl.arrowDown(SmryWatch);
		Thread.sleep(3000);

		By EdtWatch = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=13]");
		gl.clickElement(EdtWatch, "EditButton");
		Thread.sleep(8000);

		By acctNameWatch = By.xpath("(//a[@class='deleteAction'])");
		gl.clickButton(acctNameWatch, "acctName");
		Thread.sleep(4000);

		By ConNamWatch = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNamWatch, "ContactName", "Watch ");

		Thread.sleep(4000);

		WebElement ConNam1Watch = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter tex
		ConNam1Watch.sendKeys("Contact");
		ConNam1Watch.sendKeys(" ");
		Thread.sleep(4000);

		WebElement elementWatch = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
		JavascriptExecutor executorWatch = (JavascriptExecutor) driver;
		executorWatch.executeScript("arguments[0].click();", elementWatch);
		Thread.sleep(5000);

		By Save2Watch = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(Save2Watch, "Save 2 ");
		Thread.sleep(8000);
		
		WebElement caseNo2 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
		String case3 = caseNo2.getText();
		System.out.println("Case Number  : "+case3);
		Thread.sleep(30000);
		
		//WebElement caseNumber1 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[9]"));
		By caseNumber2 = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(caseNumber2, "Case Number");
		Thread.sleep(30000);
		
		//WebElement accname = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grid itemBody'])[19]"));
		WebElement accname3 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]"));
		String name3 = accname3.getText();
		System.out.println("Account Name  : "+name3);	
		Thread.sleep(20000);
		
		By acc2 = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]");
		gl.elementContain(acc2, "Account Name");
		Thread.sleep(20000);


		By tabWatch = By.xpath("(//a[@class='tabHeader slds-tabs--default__link slds-p-right--small slds-grow '])[2]");
		gl.clickElement(tabWatch, "tabWatch");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By posWatch = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(3000);

	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(posWatch));

		List<WebElement> rows9 = driver.findElements(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count9 = rows9.size();
		System.out.println("ROW COUNT : " + count9);
		Thread.sleep(4000);

		WebElement watchText = driver.findElement(By.xpath(
				"//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[3]//span[1]"));
		String textwatch = watchText.getText();
		System.out.println("Watch Text : " + textwatch);
		Thread.sleep(4000);

		if (count9 == 10 && textwatch.equals("WATCH")) {
			System.out.println("CVS call Occurs when Change Watch Account Name");
			System.out.println("Status is Watch in CVS call");
		} else {
			System.out.println("Error in CVS call When Change Watch Account Name");
			System.out.println("Status is not Watch in CVS call");
		}
		Thread.sleep(4000);

		By checkboxWatch = By.xpath("//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[1]//input[1]");
		gl.clickElement(checkboxWatch, "checkboxWatch");
		Thread.sleep(6000);

		By win = By.xpath("//div[@class='pbBody']");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(win));

		By overrideWatch = By.xpath("//input[@id='j_id0:FRM:PB:j_id16']");
		gl.clickElement(overrideWatch, "overrideWatch");
		Thread.sleep(8000);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(4000);
				By overrideReason = By.xpath("//select[@name='j_id0:j_id2:j_id3:j_id29:overrideReason']");
				gl.selectByText(overrideReason, "overrideReason", "HP Security Team Approved Override");
				Thread.sleep(4000);

				By overrideDetail = By.xpath("//textarea[@name='j_id0:j_id2:j_id3:j_id29:j_id32:j_id36']");
				gl.inputText(overrideDetail, "overrideDetail", "test");
				Thread.sleep(4000);

				By submit = By.xpath("//input[@value='Submit']");
				gl.clickElement(submit, "submit");
				Thread.sleep(8000);

				// driver.close(); //closing child window
				driver.switchTo().window(parentWindow); // cntrl to parent window
			}
		}

		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		By tab9 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab9, "tab9");
		Thread.sleep(8000);
		// Hold
		By SmryHold = By.xpath("//a[text()='Summary']");
		gl.clickElement(SmryHold, "SummaryLink");
		gl.arrowDown(SmryHold);
		Thread.sleep(3000);

		By EdtHold = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=13]");
		gl.clickElement(EdtHold, "EditButton");
		Thread.sleep(8000);

		By acctNameHold = By.xpath("(//a[@class='deleteAction'])");
		gl.clickButton(acctNameHold, "acctName");
		Thread.sleep(4000);

		By ConNamHold = By.xpath("//input[@placeholder='Search Contacts...']");
		// gl.inputText(ConNam, "ContactName", "Abhijit Test ");
		gl.inputText(ConNamHold, "ContactName", "R14CVS ");

		Thread.sleep(6000);

		WebElement ConNam1Hold = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		// enter tex
		ConNam1Hold.sendKeys("HOLD");
		ConNam1Hold.sendKeys(" ");
		Thread.sleep(4000);

		WebElement elementhold = driver.findElement(By.xpath(
				"//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']"));
		JavascriptExecutor executorHold = (JavascriptExecutor) driver;
		executorHold.executeScript("arguments[0].click();", elementhold);
		Thread.sleep(5000);

		By Save2Hold = By.xpath("(//button[@title='Save'])[1]");
		gl.clickElement(Save2Hold, "Save 2 ");
		Thread.sleep(10000);
		

		WebElement caseNoHold = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
		String caseHold = caseNoHold.getText();
		System.out.println("Case Number  : "+caseHold);
		Thread.sleep(30000);
		
		//WebElement caseNumber1 = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[9]"));
		By caseNumberHold = By.xpath("(//span[@class='uiOutputText'])[6]");
		gl.elementContain(caseNumberHold, "Case Number");
		Thread.sleep(30000);
		
		//WebElement accname = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grid itemBody'])[19]"));
		WebElement accnameHold = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]"));
		String nameHold = accnameHold.getText();
		System.out.println("Account Name  : "+nameHold);	
		Thread.sleep(20000);
		
		By acc2Hold = By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/a)[2]");
		gl.elementContain(acc2Hold, "Account Name");
		Thread.sleep(20000);

		By tabHold = By.xpath("(//a[@class='tabHeader slds-tabs--default__link slds-p-right--small slds-grow '])[2]");
		gl.clickElement(tabHold, "tabHold");
		Thread.sleep(20000);

		driver.navigate().refresh();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		Thread.sleep(3000);

		By posHold = By.xpath("//div[@id='j_id0:FRM:PB']/descendant::div[position()=3]");
		Thread.sleep(4000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(posHold));

		List<WebElement> rows10 = driver.findElements(By.xpath("//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']/tbody/tr"));
		int count10 = rows10.size();
		System.out.println("ROW COUNT : " + count10);
		Thread.sleep(4000);

		WebElement holdText = driver.findElement(By.xpath("//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[3]//span[1]"));
		String textHold = holdText.getText();
		System.out.println("Hold Text: " + textHold);
		Thread.sleep(4000);

		if (count10 == 11 && textHold.equals("HOLD")) {
			System.out.println("CVS call Occurs when Change HOLD Account Name");
			System.out.println("Status is HOLD in CVS call");
		} else {
			System.out.println("Error in CVS call When Change HOLD Account Name");
			System.out.println("Status is not HOLD in CVS call");
		}
		Thread.sleep(3000);

		By checkboxHold = By.xpath("//table[@class='list slds-table slds-table--bordered slds-table--striped; slds-vf-data-table']//tr[1]//td[1]//input[1]");
		gl.clickElement(checkboxHold, "checkboxHold");
		Thread.sleep(6000);

		By win1 = By.xpath("//div[@class='pbBody']");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(win1));

		By overrideHold = By.xpath("//input[@id='j_id0:FRM:PB:j_id16']");
		gl.clickElement(overrideHold, "overrideHold");
		Thread.sleep(8000);

		String parentWindow1 = driver.getWindowHandle();
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle1 : handles1) {
			if (!windowHandle1.equals(parentWindow1)) {
				driver.switchTo().window(windowHandle1);
				Thread.sleep(4000);
				By overrideReason = By.xpath("//select[@name='j_id0:j_id2:j_id3:j_id29:overrideReason']");
				gl.selectByText(overrideReason, "overrideReason", "HP Security Team Approved Override");
				Thread.sleep(4000);

				By overrideDetail = By.xpath("//textarea[@name='j_id0:j_id2:j_id3:j_id29:j_id32:j_id36']");
				gl.inputText(overrideDetail, "overrideDetail", "test");
				Thread.sleep(4000);

				By submit = By.xpath("//input[@value='Submit']");
				gl.clickElement(submit, "submit");
				Thread.sleep(8000);

				// driver.close(); //closing child window
				driver.switchTo().window(parentWindow); // cntrl to parent window
			}
		}

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		By tab10 = By.xpath("//ul[@class='tabBarItems slds-tabs--default__nav']/li[2]/a");
		gl.clickElement(tab10, "tab10 ");
		Thread.sleep(8000);
		

	}

	public void afterMethod() {
		report.flush();
	}

}