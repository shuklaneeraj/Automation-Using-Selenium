package com.dxc.sale.test.pom.sdt;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.dxc.sale.test.framework.generic.GenericLib;

import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;


public class SFDC_CaseCreation_Loop {

	final static Logger log = LogManager.getLogger(SFDC_CaseCreation_Loop.class);

	private GenericLib gl;
	private ExtentReports report;
	

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
		
		

			By homePageICon = By.xpath("(//span[contains(text(),'Cases')])[1]");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(homePageICon));

			Thread.sleep(3000);

			List<WebElement> tabnos = driver
					.findElements(By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']"));

			System.out.println("No of tabs" + tabnos.size());
			if (tabnos.size() > 0) {

				By crossbtn = By.xpath(
						"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and contains(@title,'Close')])[1]");
				gl.clickElement(crossbtn, "Close ");
				Thread.sleep(3000);

			}

			By NewLightingButton = By.xpath("//div[contains(text(),'New Lightning Case')]");
			gl.clickElement(NewLightingButton, "NewLightingButton");
			Thread.sleep(8000);

			By EntitleLin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
			gl.verifyElementVisible(EntitleLin, "Entitlement");

			By ELin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
			gl.clickLink(ELin, "EntlLink");
			Thread.sleep(5000);

			By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
			// gl.clickElement(Ebt, "Link");

			gl.verifyElementVisible(Ebt, "Entitlement Check page is open");

			driver.switchTo().frame(1);
			Thread.sleep(3000);

			By SerlNum = By.xpath("//input[@id='pg:FormId:main:serialNo']");
			// gl.inputText(SerlNum, "SlrNO", "SUMITN789621");
			gl.inputText(SerlNum, "SlrNO", "USE914N2F4");

			By CntryCode = By.xpath("//Select[@id='pg:FormId:main:countries']");
			gl.selectByText(CntryCode, "Country", "United States");

			By EntChk = By.id("pg:FormId:main:search");
			gl.clickButton(EntChk, "EntlMntChk");
			Thread.sleep(20000);

			// Verify Product Description text on the page
			By ProdDes = By.xpath("//input[@value='Additional Contract or Asset Required']");
			gl.verifyElementVisible(ProdDes, "ProductDescription");
			Thread.sleep(4000);

			// Click on Done Button
			By Dne = By.xpath("(//input[@value='Done'])[1]");
			gl.clickElement(Dne, "Done");
			System.out.println("Clicked On Done Button ");
			Thread.sleep(40000);

			By Location = By.xpath("(//span[contains(text(),'Location ')])[1]");
			gl.clickLink(Location, "Location");
			System.out.println("Clicked On Location Button ");

			driver.switchTo().frame(1);
			/**By acc = By.xpath("//a[text()='Search By Account Name']");
			gl.clickElement(acc, "acc");
			Thread.sleep(6000);

			driver.findElement(By.xpath("(//input[@lightning-input_input=''])[3]")).clear();
			Thread.sleep(6000);

			By text = By.xpath("(//input[@lightning-input_input=''])[3]");
			gl.inputText(text, "text", "HPE SGP LIMITED");

			Thread.sleep(3000);

			By ctry = By.xpath("(//select[@class='slds-select'])[1]");
			gl.selectByText(ctry, "ctry", "United Kingdom");
			Thread.sleep(5000);

			By search = By.xpath("(//button[@title='Search'])[1]");
			gl.clickElement(search, "search");
			Thread.sleep(5000);

			By checkbox = By.xpath("(//span[@class='slds-radio_faux'])[4]");
			gl.clickElement(checkbox, "checkbox");
			Thread.sleep(8000);**/

			//By R1 = By.xpath("(//span[@lightning-input_input=''])[7]");
			 By R1= By.xpath("(//span[@lightning-input_input=''])[3]");

			gl.clickRadioButton(R1, "FromPreviousCase1");
			Thread.sleep(4000);

		/**	By loc = By.xpath("//a[text()='Search By Location Name']");
			gl.clickElement(loc, "loc");
			Thread.sleep(10000);

			By val = By.xpath("//div[@id='serByLocName']/descendant::button[position()=2]");
			gl.clickElement(val, "val");
			Thread.sleep(10000);

			By chk = (By.xpath("(//span[@class='slds-radio_faux'])[8]"));
			gl.clickElement(chk, "chk");
			Thread.sleep(6000);**/

			//By R2 = By.xpath("(//span[@lightning-input_input=''])[23]");
			By R2= By.xpath("(//span[@lightning-input_input=''])[11]");
			gl.clickButton(R2, "FromPreviousCase2");
			Thread.sleep(4000);

			By Ucbtn = By.xpath("//div[@id='assLocId']/descendant::button[position()=1]");
			gl.clickButton(Ucbtn, "UpdateCase");
			Thread.sleep(40000);
			
			
			for (int i = 1; i < 21; i++) {

			By Smry = By.xpath("//a[text()='Summary']");
			gl.verifyElementVisible(Smry, "Summary Tab");
			
			//By Smry = By.xpath("//a[text()='Summary']");
			gl.clickElement(Smry, "SummaryLink");
			Thread.sleep(6000);
			
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			

			System.out.println("Case : " + i);
			WebElement caseNo = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[6]"));
			String case1 = caseNo.getText();
			System.out.println("Case Number  : " + case1);
			Thread.sleep(3000);
		
			By caseNumber = By.xpath("(//span[@class='uiOutputText'])[6]");
			gl.elementContain(caseNumber, "caseNumber");
			Thread.sleep(3000);
			
			By Edt = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=7]");
			gl.clickElement(Edt, "EditButton");
			Thread.sleep(5000);

			By Sbjt = By.xpath("//input[@required='']");
			gl.inputText(Sbjt, "Subject", "Test"+i);
			Thread.sleep(5000);
			
			By Se = By.xpath("//button[@title='Save']");
			gl.clickElement(Se, "Save");
			Thread.sleep(15000);
			String basedir = System.getProperty("user.dir");

			File file = new File(basedir + File.separator + "src/main/resources/CaseDetails.xlsx");
			// File file = new
			// File("C:\\Users\\sr23\\eclipse-workspace\\Sales3-2\\com.dxc.sale.test\\src\\main\\resources\\Data.xlsx");
			FileInputStream filein = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(filein);
			XSSFSheet sheet = wb.getSheetAt(0);
			int num = sheet.getLastRowNum();
			Row row = sheet.createRow(++num);
			//row.createCell(0).setCellValue("Case Number");
			
			// Column col=sheet.create
			row.createCell(5).setCellValue(case1);
			FileOutputStream fileOut = new FileOutputStream(file);
			// Write the data
			wb.write(fileOut);
			// close the connection
			wb.close();
			Thread.sleep(2000);
			// test.log(Status.INFO, "Case Number: "+case1);
			// test.log(Status.INFO, "Verify " + elementname);
			
			
			/**By caseNumberDismiss = By.xpath("(//span[@class='uiOutputText'])[6]");
			gl.elementContain(caseNumberDismiss, "caseNumberDismiss");
			Thread.sleep(4000);

			By dismiss = By.xpath("//button[@title='Dismiss notification']");
			gl.clickElement(dismiss, "Dismiss");
			Thread.sleep(6000);**/
			
			
			By clone = By.xpath("//a[@title='Clone Case']");
			gl.clickElement(clone, "clone");
			Thread.sleep(30000);
			
			WebDriverWait w = new WebDriverWait(driver, 5);
		      //alertIsPresent() condition applied
		      if(w.until(ExpectedConditions.alertIsPresent())!=null) {
		      System.out.println("Alert exists");

				 Alert alert = driver.switchTo().alert();
				
				    alert.accept();
				    Thread.sleep(4000);
		      }
		      else {
		    	  By clone1 = By.xpath("//a[@title='Clone Case']");
					gl.clickElement(clone1, "clone1");
					
					 Alert alert = driver.switchTo().alert();
						
					    alert.accept();
		      System.out.println("Alert not exists");
		      Thread.sleep(4000);
			
		      }
			
			/*
			 * Robot re = new Robot(); re.keyPress(	KeyEvent.VK_ENTER);
			 * re.keyRelease(KeyEvent.VK_ENTER);
			 */
			
			Thread.sleep(30000);
			
			 By closeCase = By.xpath( "(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])[1]"); 
			 gl.clickLink(closeCase, "closeCase"); 
			 Thread.sleep(3000);
			 
			 By ELin1 = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
				gl.clickLink(ELin1, "EntlLink1");
				Thread.sleep(5000);
				
				By Ebt1 = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
				// gl.clickElement(Ebt, "Link");

				gl.verifyElementVisible(Ebt1, "Entitlement Check page is open");

				driver.switchTo().frame(1);
				Thread.sleep(4000);
				
				By EntChk1= By.id("pg:FormId:main:search");
				gl.clickButton(EntChk1, "EntlMntChk1");
				Thread.sleep(20000);
				
				By Dne1 = By.xpath("(//input[@value='Done'])[1]");
				gl.clickElement(Dne1, "Done1");
				System.out.println("Clicked On Done Button ");
				Thread.sleep(20000);
				System.out.println("Case 12 Passed");

		}
	}

	public void afterMethod() {
		report.flush();
	}

}