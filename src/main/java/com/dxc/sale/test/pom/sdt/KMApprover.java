package com.dxc.sale.test.pom.sdt;

import java.io.IOException;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.generic.GenericLib;
import com.dxc.sale.test.framework.generic.SeliniumUtil;
import com.dxc.sale.test.framework.generic.WebDriverManager;
import com.dxc.sale.test.framework.generic.PropertyLoader;
import com.dxc.sale.test.framework.report.ExtentManager;

public class KMApprover {

	final static Logger log = LogManager.getLogger(KMApprover.class);

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

	public void test(String SdEmID, String SdPwrd, String SSrlNum,String Title,String ReslnTitle,String PublishedArticle, String CaseNo) throws Exception {
		
		
//		WebDriver driver = WebDriverManager.getstance().getDriver();
//
//		
//		List<WebElement> tabnos = driver.findElements(By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']"));
//
//		if (tabnos.size() >= 0) {
//
//			By crossbtn = By.xpath(
//					"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and contains(@title,'Close')])[1]");
//			gl.clickElement(crossbtn, "Close ");
//			Thread.sleep(5000);
//
//		}
//
//		By NlC = SeliniumUtil.getElement("NlC");
//		gl.clickImage(NlC, "NlC");
//		Thread.sleep(5000);
//
//		By ELin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
//		gl.clickLink(ELin, "EntlLink");
//		Thread.sleep(5000);
//
//		System.out.println("Clicked Entitlement Link and next page loded");
//		Thread.sleep(10000);
//
//		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
//		gl.clickElement(Ebt, "Link");
//		System.out.println("Clicked Entitlement Link and next page loded _ Link");
//
//		driver.switchTo().frame(1);
//		System.out.println("Clicked Entitlement Link and next page loded_ Iframe");
//		Thread.sleep(5000);
//
//		By SerlNum = By.xpath("//input[@id='pg:FormId:main:serialNo']");
//		gl.inputText(SerlNum, "SlrNO", "SGH233ATKN");
//
//		WebElement elementtxt = driver.findElement(By.id("pg:FormId:main:contractId"));
//		elementtxt.sendKeys("Test");
//
//		By CntryCode = By.xpath("//Select[@id='pg:FormId:main:countries']");
//		gl.selectByText(CntryCode, "Country", "United States");
//
//		By EntChk = By.id("pg:FormId:main:search");
//		gl.clickButton(EntChk, "EntlMntChk");

		
		WebDriver driver = WebDriverManager.getstance().getDriver();

		driver.manage().deleteAllCookies();
		gl.launchApplication("https://hp--test.my.salesforce.com/");
		
		// Enter Value in SdEmailId Field
		By SdEmailId = SeliniumUtil.getElement("SdEmailId");
		gl.inputText(SdEmailId, "SdEmailId", SdEmID);
		
		// Enter Value in SdPsswrd Field
		By SdPsswrd = SeliniumUtil.getElement("SdPsswrd");
		gl.inputText(SdPsswrd, "SdPsswrd", SdPwrd);
		
//		Click Webelemnt
		// By SbxLgn = SeliniumUtil.getElement("SbxLgn");
		// gl.clickElement(SbxLgn,"SbxLgn");
		// Click Link

		Thread.sleep(20000);

		List<WebElement> tabnos = driver.findElements(By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']"));

		if (tabnos.size() >= 0) {

			By crossbtn = By.xpath(
					"(//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and contains(@title,'Close')])[1]");
			gl.clickElement(crossbtn, "Close ");
			Thread.sleep(5000);

		}

		By NlC = SeliniumUtil.getElement("NlC");
		gl.clickImage(NlC, "NlC");
		Thread.sleep(5000);
		
		
		By Dcrt= By.xpath("//span[.=\"DLVR Case Record Type\"]");
		gl.verifyElementVisible(Dcrt, "DLVRCaseRecordType");
		Thread.sleep(5000);
		
		System.out.println("Case Type is GSD CSC Case Creation");
		Thread.sleep(3000);
		

		By ELin = By.xpath("//*[@id=\"mainDiv1\"]/div[1]/p[1]/a");
		gl.clickLink(ELin, "EntlLink");
		Thread.sleep(5000);

		System.out.println("Clicked Entitlement Link and next page loded");
		Thread.sleep(10000);

		By Ebt = By.xpath("//*[contains(@class,'slds-show_inline-block') and @title='Entitlement']");
		gl.clickElement(Ebt, "Link");
		System.out.println("Clicked Entitlement Link and next page loded _ Link");

		driver.switchTo().frame(1);
		System.out.println("Clicked Entitlement Link and next page loded_ Iframe");
		Thread.sleep(5000);

		By SerlNum = By.xpath("//input[@id='pg:FormId:main:serialNo']");
		gl.inputText(SerlNum, "SlrNO", "SGH233ATKN");

		By CntryCode = By.xpath("//Select[@id='pg:FormId:main:countries']");
		gl.selectByText(CntryCode, "Country", "United States");

		By EntChk = By.id("pg:FormId:main:search");
		gl.clickButton(EntChk, "EntlMntChk");
		Thread.sleep(1000);
		
		//Verify Product Description text on the page
		By ProdDes= By.id("pg:FormId:main:j_id56:AllProducts:j_id75header:sortDiv");
		gl.verifyElementVisible(ProdDes, "ProductDescription");
		System.out.println("Product Description Element is present ");
		 	 
		//Click on Done Button
		 By Dne= By.xpath("//*[@id=\"pg:FormId:main:j_id256:doneBotButton\"]");
		 gl.clickElement(Dne, "Done");
		 System.out.println("Clicked On Done Button ");
		 Thread.sleep(5000);
		 
		//Click on Ok Button
		 By Oky = By.xpath("//*[@id=\"pg:FormId:j_id263:j_id278\"]");
		 gl.clickButton(Oky, "Okay");
		 System.out.println("Clicked On Okay Button ");
		 Thread.sleep(8000);
	 		 
		 driver.switchTo().defaultContent();
		 Thread.sleep(8000);

		 driver.switchTo().frame(1);
		 
 By Dne2=By.xpath("//*[@id=\"pg:FormId:main:j_id256:doneBotButton\"]");
		 
		 gl.clickButton(Dne2, "Done");
		 Thread.sleep(10000);
		 System.out.println("Clicked On second Done Button");
 
 driver.switchTo().frame(1);
	Thread.sleep(5000);
 
	 By R1= By.xpath("//div[@id='accId']/descendant::span[position()=3]");
	 gl.clickRadioButton(R1, "FromPreviousCase1");
	 System.out.println("FromPreviousCase1 Radion Button Clicked");
	 Thread.sleep(5000);
		 
	 By R2= By.xpath("(//span[@lightning-input_input=''])[11]");
	 gl.clickButton(R2, "FromPreviousCase2");
	 System.out.println("FromPreviousCase2 Radion Button Clicked");
	 Thread.sleep(5000);
	 
	 By Uc=By.xpath("//div[@id='assLocId']/descendant::button[position()=1]");
	 gl.clickButton(Uc, "UpdateCase");
	 System.out.println("UpdateCase Button Clicked");
		 Thread.sleep(8000);
 
	By Dtls= By.xpath("//a[@data-tab-value='detailTab']");
    gl.clickLink(Dtls, "Details");
    Thread.sleep(3000);
		 
		 System.out.println("Case record type is GSD CSC Case Open");
		 Thread.sleep(3000);
   
    By Smry= By.xpath("//a[text()='Summary']");
    gl.clickElement(Smry, "SummaryLink");
    Thread.sleep(3000);
    System.out.println("Summary Link clicked");
    
//    //Chaithra have to take a look at
////    By Edt = By.xpath("//slot[@name='main']/descendant::lightning-primitive-icon[position()=7]");
////    gl.clickElement(Edt, "EditButton");
////   Thread.sleep(3000);
////  
////    By Sbjt= By.xpath("//input[@required='']");
////    gl.inputText(Sbjt, "Subject", "Test");
////    Thread.sleep(3000);
////
////    gl.scrollPageDown();
////    Thread.sleep(10000);
////   
////    
////   By ConNam= By.xpath("//input[@placeholder='Search Contacts...']");
////    gl.inputText(ConNam, "ContactName", "AbhijithTest Test");
////    Thread.sleep(8000);
////
////driver.findElement(By.xpath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")).click();
////Thread.sleep(3000);
//
////    By Gtal= By.xpath("//Select[(//a[@class='select'])[7]]");
////    gl.selectByText(Gtal, "Gtal", "Passed");
////    Thread.sleep(2000);
//    
////By Otge= By.xpath("//Select[(//a[@class='select'])[8]]");
////    gl.selectByText(Otge, "Outage", "No");
////   Thread.sleep(3000);
//  
////   By NwInstl= By.xpath("//Select[(//a[@class='select'])[9]]");
////   gl.selectByText(NwInstl, "NewInstall", "No");
//  
////By svae= By.xpath("(//*[@class="slds-button slds-button_brand"])[1]"));
////   gl.clickButton(svae, "Save");
////   Thread.sleep(5000);
////    System.out.println("Save Button Clicked");
//    
//    
//    //Clicking On Issue Mapping
//    By IsueMpng= By.xpath("//span[contains(text(),'Issue Mapping')]");
//    gl.clickElement(IsueMpng, "IssueMapping");
//    Thread.sleep(3000);
//    System.out.println("Clicked On Issue Mapping");
//    
//    By IsueTyp= By.xpath("//select[@name='Issue Type']");
//    gl.selectByText(IsueTyp, "IssueType", "Product Non-functional/Not working as Expected");
//   Thread.sleep(3000);
//   
//   By IsueCtgry= By.xpath("//select[@name='Issue Category']");
//   gl.selectByText(IsueCtgry, "Issue Category", "Other");
//   Thread.sleep(2000);
//   System.out.println("Issue Category Selected");
//   
//   By Oicd= By.xpath("//input[@name='Other Issue Category Description']");
//   gl.inputText(Oicd, "Other Issue Category Description", "Test");
//   Thread.sleep(3000);
//      
//   By Se= By.xpath("//button[@title='Save']");
//   gl.clickElement(Se, "Save");
//   Thread.sleep(3000);
//   System.out.println("Updated Cases Successfully");
   
	}

	public void afterMethod() {
		report.flush();
	}

}