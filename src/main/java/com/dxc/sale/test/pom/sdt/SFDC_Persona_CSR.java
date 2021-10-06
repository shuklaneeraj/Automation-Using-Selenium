package com.dxc.sale.test.pom.sdt;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
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

public class SFDC_Persona_CSR {

	final static Logger log = LogManager.getLogger(SFDC_Persona_CSR.class);

	private GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;

	private static WebDriver driver;
	// ExtentTest logTest;

	public void beforemethod() throws IOException {
		WebDriver driver = WebDriverManager.getstance().getDriver();
		// Create Test
		report = ExtentManager.getInstance().getExtent();
		String testName = this.getClass().getSimpleName();
		ExtentTest test = report.createTest(testName);
		test.assignAuthor(PropertyLoader.getUser());

		gl = new GenericLib(driver, test);
		// logger = test.createTest("Description");

	}

	public boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (NoAlertPresentException e) {
			foundAlert = false;
		}
		System.out.println(foundAlert);
		return foundAlert;

	}

	public void test(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
		By menu = By.xpath("//div[@class='slds-icon-waffle']");
			gl.clickLink(menu, "Menu");
			Thread.sleep(5000);

			Robot r1 = new Robot();
			r1.keyPress(KeyEvent.VK_TAB);
			r1.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);

			WebElement menuSearch = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));

			executor.executeScript("arguments[0].value='GSD CSC L0.5 Persona Console';", menuSearch);
			Thread.sleep(4000);

			r1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			By homeArrow = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(homeArrow, "L0.5 Home");
			Thread.sleep(5000);

			By cases = By.xpath("//span[text()='Home']");
			gl.clickElement(cases, "L0.5 Case");
			Thread.sleep(10000);
			By openCase = By.xpath("(//span[@class='title'])[1]");
			gl.elementShouldContain(openCase, "Open Case text", "My Open Cases");
			Thread.sleep(4000);

			By quickAction = By.xpath("(//span[@class='title'])[2]");
			gl.elementShouldContain(quickAction, "Quick Action Text", "Case Quick Action");
			Thread.sleep(4000);

			By rctat = By.xpath("(//span[@class='title'])[3]");
			gl.elementShouldContain(rctat, "RCTAT text", "RCTAT Milestone");
			Thread.sleep(4000);

			By mileStone = By.xpath("(//span[@class='title'])[3]");
			gl.clickElement(mileStone, " RCTAT mileStone");
			Thread.sleep(12000);

			ArrayList<String> obtainedList = new ArrayList<>();

			for (int i = 0; i < 12; i++) {
				WebElement field = driver.findElement(By.xpath(
						"(//div[@class='slds-table_header-fixed_container slds-scrollable_x']//table//thead//tr//th["
								+ (i + 1) + "]//lightning-primitive-header-factory//span//a//span)[2]"));
				By hdrList = By.xpath(
						"(//div[@class='slds-table_header-fixed_container slds-scrollable_x']//table//thead//tr//th["
								+ (i + 1) + "]//lightning-primitive-header-factory//span//a//span)[2]");
				gl.elementContain(hdrList, "Header List");
				Thread.sleep(6000);
				obtainedList.add(field.getText());
				Thread.sleep(1000);
			}
			System.out.println("Header List: " + obtainedList);

			Thread.sleep(8000);

			if (obtainedList.contains("Milestone") || obtainedList.contains("Milestone Status")
					|| obtainedList.contains("CaseNumber") || obtainedList.contains("Date/Time Opened")
					|| obtainedList.contains("Target Response Date") || obtainedList.contains("Target Response (Min)")
					|| obtainedList.contains("Time Remaining (Min:Sec)") || obtainedList.contains("Subject")
					|| obtainedList.contains("Severity") || obtainedList.contains("Service Portfolio")
					|| obtainedList.contains("Account Name") || obtainedList.contains("Last Modified Date Time")) {
				System.out.println("Header Matches: " + obtainedList);
				
			} else {
				System.out.println("Header not matches: " + obtainedList);
			}
			Thread.sleep(5000);
			
			By action = By.xpath("(//span[@class='title'])[2]");
			gl.clickElement(action, " Clicked Case Quick Action");
			Thread.sleep(13000);

//			By next = By.xpath(" (//button[text()='Next'])[2]");
//			gl.clickElement(next, " Clicked next Button");
//			Thread.sleep(10000);
					
//			By sort = By.xpath("(//span[@title='Date/Time Opened'])[2]");
//			gl.clickElement(sort, "sorting");
//			Thread.sleep(6000);

			By radioBtn = By.xpath("(//span[@class='slds-radio_faux'])[2]");
			gl.clickElement(radioBtn, " Clicked radio Button");
			Thread.sleep(6000);

			By csrBotton = By.xpath("//button[text()='New CSR Task LWC']");
			gl.clickElement(csrBotton, " Clicked CSR Button");
			Thread.sleep(15000);

			boolean foundAlert = false;
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			try {
				foundAlert = true;
				String alertMessage= driver.switchTo().alert().getText(); 

				System.out.println("Alert Message: "+alertMessage); 
				Thread.sleep(5000);
				gl.elementAlertContain();
				Thread.sleep(6000);
				driver.switchTo().alert().accept();
				foundAlert = true;
				
				
				if ((foundAlert == true) && (alertMessage.contains("Global Trade Active Listening is mandatory")))
				{
			
					SFDC_Case_Updated2 update = new SFDC_Case_Updated2();
					update.beforemethod();
					update.test(SdEmID, SdPwrd, SSrlNum);
					Thread.sleep(3000);

					By more = By.xpath("(//a[contains(text(),'More')])[2]");
					gl.clickElement(more, "More");
					Thread.sleep(5000);

					By delay = By.xpath("(//a[@title='Delay'])[2]");
					gl.clickElement(delay, "Delay");
					Thread.sleep(8000);

					driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])")));
					Thread.sleep(1000);

					By datePicker = By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=2]");
					gl.clickElement(datePicker, "Date Picker");
					Thread.sleep(5000);

					By date = By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[position()=17]");
					gl.clickElement(date, "Date");
					Thread.sleep(5000);

					By time = By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=12]");
					gl.clickElement(time, "Time");
					Thread.sleep(5000);

					WebElement timeArrow = driver
							.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=12]"));
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);

					By oblg = By.xpath("//input[@value='Service Obligation']");
					gl.clickElement(oblg, "Service Obligation");
					Thread.sleep(5000);

					By delayReason = By.xpath("//div[@class='slds-scope']/descendant::select[position()=1]");
					gl.selectByText(delayReason, "Delay Reason", "RCTAT already expired");
					Thread.sleep(5000);

					By upd = By.xpath("//input[@value='Update']");
					gl.clickElement(upd, "update");
					Thread.sleep(5000);

					By closeCase = By.xpath(
							"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])");
					gl.clickElement(closeCase, "Case Close");
					Thread.sleep(5000);

//					By next1 = By.xpath(" (//button[text()='Next'])[2]");
//					gl.clickElement(next1, " Clicked next Button");
//					Thread.sleep(10000);

					By radioBtnCase = By.xpath("(//span[@class='slds-radio_faux'])[2]");
					gl.clickElement(radioBtnCase, " Clicked on Case");
					Thread.sleep(6000);

					By csrBottonClick = By.xpath("//button[text()='New CSR Task LWC']");
					gl.clickElement(csrBottonClick, " Clicked CSR Button");
					Thread.sleep(15000);

					SFDC_NewCSRTask CSRLink = new SFDC_NewCSRTask();
					CSRLink.beforemethod();
					CSRLink.csrPersona(SdEmID, SdPwrd, SSrlNum);
					CSRLink.autoClose_csr_L5();
					}
					
					else if ((foundAlert == true) && (alertMessage.equals("Service Obligation Milestone is set to the past. Add a delay to the case to adjust the Service Obligation Milestone before creating a new CSR task")))
					{
				

					By more = By.xpath("(//a[contains(text(),'More')])[2]");
					gl.clickElement(more, "More");
					Thread.sleep(5000);

					By delay = By.xpath("(//a[@title='Delay'])[2]");
					gl.clickElement(delay, "Delay");
					Thread.sleep(8000);

					driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])")));
					Thread.sleep(1000);

					By datePicker = By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=2]");
					gl.clickElement(datePicker, "Date Picker");
					Thread.sleep(5000);

					By date = By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[position()=17]");
					gl.clickElement(date, "Date");
					Thread.sleep(5000);

					By time = By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=12]");
					gl.clickElement(time, "Time");
					Thread.sleep(5000);

					WebElement timeArrow = driver
							.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::span[position()=12]"));
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);
					timeArrow.sendKeys(Keys.ARROW_RIGHT);

					By oblg = By.xpath("//input[@value='Service Obligation']");
					gl.clickElement(oblg, "Service Obligation");
					Thread.sleep(5000);

					By delayReason = By.xpath("//div[@class='slds-scope']/descendant::select[position()=1]");
					gl.selectByText(delayReason, "Delay Reason", "RCTAT already expired");
					Thread.sleep(5000);

					By upd = By.xpath("//input[@value='Update']");
					gl.clickElement(upd, "update");
					Thread.sleep(5000);

					By closeCase = By.xpath(
							"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1])");
					gl.clickElement(closeCase, "Case Close");
					Thread.sleep(5000);

//					By next1 = By.xpath(" (//button[text()='Next'])[2]");
//					gl.clickElement(next1, " Clicked next Button");
//					Thread.sleep(10000);

					By radioBtnCase = By.xpath("(//span[@class='slds-radio_faux'])[2]");
					gl.clickElement(radioBtnCase, " Clicked on Case");
					Thread.sleep(6000);

					By csrBottonClick = By.xpath("//button[text()='New CSR Task LWC']");
					gl.clickElement(csrBottonClick, " Clicked CSR Button");
					Thread.sleep(15000);

					SFDC_NewCSRTask CSRLink = new SFDC_NewCSRTask();
					CSRLink.beforemethod();
					CSRLink.csrPersona(SdEmID, SdPwrd, SSrlNum);
					CSRLink.autoClose_csr_L5();

				} 
			} catch (NoAlertPresentException e) {
				foundAlert = false;
				 if (foundAlert == false) {

					SFDC_NewCSRTask CSRLink = new SFDC_NewCSRTask();
					CSRLink.beforemethod();
					CSRLink.csrPersona(SdEmID, SdPwrd, SSrlNum);

					CSRLink.autoClose_csr_L5();

				}
				
			}
			System.out.println(foundAlert);
			
			
			By homeArrow1 = By.xpath(
					"//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']/descendant::lightning-primitive-icon[position()=1]");
			gl.clickElement(homeArrow1, "L0.5 Home");
			Thread.sleep(5000);

			By cases1 = By.xpath("//span[text()='Cases']");
			gl.clickElement(cases1, "L0.5 Case");
			Thread.sleep(10000);

			SFDC_Case_Updated_Persona update = new SFDC_Case_Updated_Persona();
			update.beforemethod();
			update.test(SdEmID, SdPwrd, SSrlNum);

			SFDC_Case_Updated2 UpdateCase2 = new SFDC_Case_Updated2();
			UpdateCase2.beforemethod();
			UpdateCase2.test(SdEmID, SdPwrd, SSrlNum);
			Thread.sleep(3000);

			SFDC_NewCSRTask CSRLink = new SFDC_NewCSRTask();
			CSRLink.beforemethod();
			CSRLink.test(SdEmID, SdPwrd, SSrlNum);

			CSRLink.autoClose_csr();
			
			driver.navigate().refresh();
			Thread.sleep(10000);
			
			SFDC_Persona_NewOnsiteTask onsite = new SFDC_Persona_NewOnsiteTask();
			onsite.beforemethod();
			onsite.test(SdEmID, SdPwrd, SSrlNum);
			onsite.afterMethod();
			
		}

		catch (NoSuchElementException e) {
			System.out.println("Error" + e);
		}

		System.out.println("Case 14 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}