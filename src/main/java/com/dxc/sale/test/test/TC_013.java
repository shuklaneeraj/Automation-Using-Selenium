	package com.dxc.sale.test.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_DateValidation_Whispernet;
import com.dxc.sale.test.pom.sdt.SFDC_Whispernet;

import com.dxc.sale.test.pom.sdt.SFDC_CaseCreation_Loop;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobile;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobilePart;

public class TC_013 {

	@DataProvider(name = "SdT")
	public Object[][] dataSdT() {
		ExcelLib xl = new ExcelLib("Sheet1", "SdT");
		return xl.getTestdata();

	}

	@Test(dataProvider = "SdT")
	public void runSdT(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
		// Whispernet creation for all Anchor Types
	
//		SFDC_Whispernet Case_Creation = new SFDC_Whispernet();
//		Case_Creation.beforemethod(); 
//		Case_Creation.test(SdEmID, SdPwrd, SSrlNum);
//		Case_Creation.afterMethod();
//		

		// Whispernet Date validation
		
//		  SFDC_DateValidation_Whispernet dateVal = new SFDC_DateValidation_Whispernet(); 
//		  dateVal.beforemethod();
//		 dateVal.test(SdEmID, SdPwrd, SSrlNum); 
//		 dateVal.afterMethod();
		

	}

}
