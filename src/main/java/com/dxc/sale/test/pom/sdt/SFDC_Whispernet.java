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

public class SFDC_Whispernet {

	final static Logger log = LogManager.getLogger(SFDC_Whispernet.class);

	private GenericLib gl;
	private ExtentReports report;
	private ExtentTest test;

	private WebDriver driver;
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

	public void test(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {

		WebDriver driver = WebDriverManager.getstance().getDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		SFDC_Whispernet_Functions funcn = new SFDC_Whispernet_Functions();
		funcn.beforemethod();
	
		// 76 to 580
		
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//	
//			WebElement ele = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", ele);
//			Thread.sleep(2000);
//	
//			WebElement asset = driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Asset'])"));
//			String anchorType = asset.getText();
//	
//			executor.executeScript("arguments[0].click();", asset);
//			System.out.println("Anchor Type: " + anchorType);
//			Thread.sleep(1000);
//	
//			WebElement anchor = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("arguments[0].value='TC00000070';", anchor);
//			Thread.sleep(2000);
//	
//			WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", save);
//			Thread.sleep(10000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select category = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			category.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(6000);
//	
//			Select attribute = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attribute.selectByVisibleText("Penalties for missed SLA");
//			Thread.sleep(6000);
//	
//			Select language = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			language.selectByVisibleText("English");
//			Thread.sleep(6000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys(" SDI for Serial Number");
//			Thread.sleep(2000);
//	
//			WebElement sdi = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdi);
//			Thread.sleep(3000);
//	
//			WebElement saveCase = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCase);
//			Thread.sleep(20000);
//	
//			By anchr = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchr, "Anchor Type", "Asset");
//			Thread.sleep(1000);
//	
//			By anchrDtl = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
//			gl.elementShouldContain(anchrDtl, "Anchor", "TC00000070");
//			Thread.sleep(1000);
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//	
//			// Product Number
//	
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//	
//			WebElement elePrd = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", elePrd);
//			Thread.sleep(1000);
//	
//			WebElement Prd = driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Product'])"));
//			String anchorTypePrd = Prd.getText();
//	
//			executor.executeScript("arguments[0].click();", Prd);
//			System.out.println("Anchor Type: " + anchorTypePrd);
//			Thread.sleep(1000);
//	
//			WebElement anchorPrd = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
//	
//			jse.executeScript("arguments[0].value='QW968A';", anchorPrd);
//			Thread.sleep(1000);
//	
//			WebElement savePrd = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", savePrd);
//			Thread.sleep(8000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select categoryPrd = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			categoryPrd.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributePrd = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributePrd.selectByVisibleText("New SN/PN after unit exchange");
//			Thread.sleep(4000);
//	
//			Select languagePrd = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			languagePrd.selectByVisibleText("English");
//			Thread.sleep(4000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys("SDI for Product Number");
//			Thread.sleep(2000);
//	
//			WebElement sdiPrd = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdiPrd);
//			Thread.sleep(2000);
//	
//			WebElement saveCasePrd = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCasePrd);
//			Thread.sleep(20000);
//	
//			By anchrPrd = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchrPrd, "Anchor Type", "Product");
//			Thread.sleep(1000);
//	
//			By anchrDtlPrd = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
//			gl.elementShouldContain(anchrDtlPrd, "Anchor", "QW968A");
//			Thread.sleep(1000);
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//	
//			// Environment ID
//	
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//	
//			WebElement eleEnvId = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", eleEnvId);
//			Thread.sleep(1000);
//	
//			WebElement envId = driver
//					.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Environment ID'])"));
//			String anchorTypeEnvId = envId.getText();
//	
//			executor.executeScript("arguments[0].click();", envId);
//			System.out.println("Anchor Type: " + anchorTypeEnvId);
//			Thread.sleep(1000);
//	
//			WebElement anchorEnvId = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
//	
//			jse.executeScript("arguments[0].value='000002000000000630';", anchorEnvId);
//			Thread.sleep(2000);
//	
//			WebElement saveEnvId = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", saveEnvId);
//			Thread.sleep(8000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select categoryEnvId = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			categoryEnvId.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributeEnvId = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributeEnvId.selectByVisibleText("Onshore support only");
//			Thread.sleep(4000);
//	
//			Select languageEnvId = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			languageEnvId.selectByVisibleText("English");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys("SDI for Environment ID");
//			Thread.sleep(2000);
//	
//			WebElement sdiEnvId = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdiEnvId);
//			Thread.sleep(2000);
//	
//			WebElement saveCaseEnvId = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCaseEnvId);
//			Thread.sleep(20000);
//	
//			By anchrEnvId = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchrEnvId, "Anchor Type", "Environment ID");
//			Thread.sleep(1000);
//	
//			By anchrDtlEnvId = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
//			gl.elementShouldContain(anchrDtlEnvId, "Anchor", "000002000000000630");
//			Thread.sleep(1000);
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//	
//			// Contract
//	
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//	
//			WebElement eleContract = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", eleContract);
//			Thread.sleep(1000);
//	
//			WebElement Contract = driver
//					.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Contract'])"));
//			String anchorTypeContract = Contract.getText();
//	
//			executor.executeScript("arguments[0].click();", Contract);
//			System.out.println("Anchor Type: " + anchorTypeContract);
//			Thread.sleep(1000);
//	
//			WebElement anchorContract = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
//	
//			jse.executeScript("arguments[0].value='4000054077';", anchorContract);
//			Thread.sleep(1000);
//	
//			WebElement saveanchorContract = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", saveanchorContract);
//			Thread.sleep(8000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select categoryContract = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			categoryContract.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributeContract = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributeContract.selectByVisibleText("Contract under renewal");
//			Thread.sleep(4000);
//	
//			Select languageContract = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			languageContract.selectByVisibleText("English");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys("SDI for Contract");
//			Thread.sleep(2000);
//	
//			WebElement sdiContract = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdiContract);
//			Thread.sleep(2000);
//	
//			WebElement saveCaseContract = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCaseContract);
//			Thread.sleep(20000);
//	
//			By anchrContract = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchrContract, "Anchor Type", "Contract");
//			Thread.sleep(1000);
//	
//			By anchrDtlContract = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
//			gl.elementShouldContain(anchrDtlContract, "Anchor", "4000054077");
//			Thread.sleep(1000);
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//			
//			//SFDC_Whispernet_Functions.whispernetLightning();
//			
//			//Account
//			
//			
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//			
//			WebElement acc = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[6]"));
//			//executor.executeScript("arguments[0].click();", acc);
//			//executor.executeScript("arguments[0].value='The Coca-Cola Bottling Company of New York Inc';", acc);
//			acc.sendKeys("The Coca-Cola Bottling Company of New York Inc ");
//			Thread.sleep(10000);
//			Robot ro = new Robot();
//			ro.keyPress(KeyEvent.VK_DOWN); 
//			Thread.sleep(4000); 
//			gl.keyBoardEvents("Enter");
//			
//			WebElement combo = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", combo);
//			Thread.sleep(2000);
//	
//			WebElement accnt = driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Account'])"));
//			String anchorTypeAccnt = accnt.getText();
//	
//			executor.executeScript("arguments[0].click();", accnt);
//			System.out.println("Anchor Type: " + anchorTypeAccnt);
//			Thread.sleep(1000);
//			
//	
//			WebElement accntSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", accntSave);
//			Thread.sleep(10000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select accntCategory = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			accntCategory.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributeAccnt = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributeAccnt.selectByVisibleText("Penalties for missed SLA");
//			Thread.sleep(4000);
//	
//			Select accntLanguage = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			accntLanguage.selectByVisibleText("English");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys(" SDI for Account");
//			Thread.sleep(2000);
//	
//			WebElement accntSdi = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", accntSdi);
//			Thread.sleep(3000);
//	
//			WebElement accntSaveCase = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", accntSaveCase);
//			Thread.sleep(20000);
//	
//			By accntAnchr = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(accntAnchr, "Anchor Type", "Account");
//			Thread.sleep(1000);
//			
//			WebElement ele1 = driver.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
//			executor.executeScript("arguments[0].click();", ele1);
//			Thread.sleep(2000);
//	
//			Robot re = new Robot();
//			re.keyPress(KeyEvent.VK_PAGE_UP);
//	
//			Thread.sleep(2000);
//	
//			driver.switchTo().defaultContent();
//			Thread.sleep(2000);
//			
//			By anchrDtlAnchr = By.xpath("(//span[@force-hoverablelink_hoverablelink=''])[2]");
//			gl.elementShouldContain(anchrDtlAnchr, "Account", "The Coca-Cola Bottling Company of New York Inc");
//			Thread.sleep(1000);
//	
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//	
//			// Product Number
//	
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//	
//			WebElement eleLcn = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[4]"));
//			//jse.executeScript("arguments[0].value='4433444';", eleLcn);
//			eleLcn.sendKeys("2002081552 ");
//			Thread.sleep(10000);
//			
//			ro.keyPress(KeyEvent.VK_DOWN); 
//			Thread.sleep(4000); 
//			gl.keyBoardEvents("Enter");
//			
//			WebElement comboLcn = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", comboLcn);
//			Thread.sleep(2000);
//	
//			WebElement lcn = driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Location'])"));
//			String anchorTypeLcn = lcn.getText();
//	
//			executor.executeScript("arguments[0].click();", lcn);
//			System.out.println("Anchor Type: " + anchorTypeLcn);
//			Thread.sleep(1000);
//	
//			
//	
//			WebElement saveLcn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", saveLcn);
//			Thread.sleep(8000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select categoryLcn = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			categoryLcn.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributeLcn = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributeLcn.selectByVisibleText("New SN/PN after unit exchange");
//			Thread.sleep(4000);
//	
//			Select languageLcn = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			languageLcn.selectByVisibleText("English");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys("SDI for Location");
//			Thread.sleep(2000);
//	
//			WebElement sdiLcn = driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdiLcn);
//			Thread.sleep(2000);
//	
//			WebElement saveCaseLcn = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCaseLcn);
//			Thread.sleep(20000);
//	
//			By anchrLcn = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchrLcn, "Anchor Type", "Location");
//			Thread.sleep(1000);
//			
//			WebElement lcntext = driver.findElement(By.xpath("(//a[@class='tabHeader slds-context-bar__label-action '])[2]"));
//			executor.executeScript("arguments[0].click();", lcntext);
//			Thread.sleep(2000);
//	
//			
//			re.keyPress(KeyEvent.VK_PAGE_UP);
//	
//			Thread.sleep(2000);
//	
//			driver.switchTo().defaultContent();
//			Thread.sleep(2000);
//			
//			
//			By anchrDtlLcn = By.xpath("//div[@class='windowViewMode-maximized active lafPageHost']/descendant::span[position()=20]");
//			gl.elementShouldContain(anchrDtlLcn, "Location", "2002081552");
//			Thread.sleep(1000);
//			
//	
//			SFDC_Whispernet_Functions.whispernetCreation();
//	
//			// Zip/Postal Code
//	
//			funcn.test(SdEmID, SdPwrd, SSrlNum);
//			WebElement elepstl = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[5]"));
//			//jse.executeScript("arguments[0].value='4433444';", eleLcn);
//			elepstl.sendKeys("US ");
//			Thread.sleep(5000);
//			
//			gl.keyBoardEvents("Enter");
//			Thread.sleep(5000);
//			
//			WebElement selectCountry = driver.findElement(By.xpath("(//a[@title='US'])"));
//			executor.executeScript("arguments[0].click();", selectCountry);
//			Thread.sleep(6000);
//	
//			WebElement eleZip = driver.findElement(By.xpath("(//input[@lightning-basecombobox_basecombobox=''])[7]"));
//			executor.executeScript("arguments[0].click();", eleZip);
//			Thread.sleep(1000);
//	
//			WebElement zipCode = driver
//					.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='Zip/Postal Code'])"));
//			String anchorTypePostal = zipCode.getText();
//	
//			executor.executeScript("arguments[0].click();", zipCode);
//			System.out.println("Anchor Type: " + anchorTypePostal);
//			Thread.sleep(1000);
//	
//			WebElement anchorZip = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
//	
//			jse.executeScript("arguments[0].value='10303-1199';", anchorZip);
//			Thread.sleep(2000);
//	
//			WebElement saveZipCode = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
//			executor.executeScript("arguments[0].click();", saveZipCode);
//			Thread.sleep(8000);
//	
//			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='accessibility title'])[1]")));
//			Thread.sleep(1000);
//	
//			Select categoryZipCode = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=1]")));
//			categoryZipCode.selectByVisibleText("[ENTITLEMENT]");
//			Thread.sleep(4000);
//	
//			Select attributeZipCode = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=2]")));
//			attributeZipCode.selectByVisibleText("Onshore support only");
//			Thread.sleep(4000);
//	
//			Select languageZipCode = new Select(
//					driver.findElement(By.xpath("//table[@class='detailList']/descendant::select[position()=3]")));
//			languageZipCode.selectByVisibleText("English");
//			Thread.sleep(4000);
//	
//			driver.findElement(By.xpath("//table[@class='detailList']/descendant::textarea[position()=2]"))
//					.sendKeys("SDI for Zip/Postal Code");
//			Thread.sleep(2000);
//			
//	
//			WebElement sdiZipCode= driver.findElement(By.xpath("//input[@value='Generate SDI Text']"));
//			executor.executeScript("arguments[0].click();", sdiZipCode);
//			Thread.sleep(2000);
//	
//			WebElement saveCaseZipCode = driver.findElement(By.xpath("//input[@value='Save']"));
//			executor.executeScript("arguments[0].click();", saveCaseZipCode);
//			Thread.sleep(20000);
//	
//			By anchrZipCode = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[16]");
//			gl.elementShouldContain(anchrZipCode, "Anchor Type", "Zip/Postal Code");
//			Thread.sleep(1000);
//			
//			By anchrDtlZipcode = By.xpath("(//lightning-formatted-text[@data-output-element-id='output-field'])[17]");
//			gl.elementShouldContain(anchrDtlZipcode, "Zip/ Postal Code", "10303-1199");
//			Thread.sleep(1000);
//			
//
//		SFDC_Whispernet_Functions.whispernetCreation();

	SFDC_Whispernet_Functions.whispernet_Entitlement_AccountSearch();
		
		System.out.println("Case 13 Passed");

	}

	public void afterMethod() {
		report.flush();
	}

}