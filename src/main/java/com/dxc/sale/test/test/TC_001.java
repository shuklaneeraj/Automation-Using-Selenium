package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Updated2;
import com.dxc.sale.test.pom.sdt.SdT;


public class TC_001 {

	@DataProvider(name = "SdT")
	public Object[][] dataSdT() {
		ExcelLib xl = new ExcelLib("Sheet1", "SdT");
		return xl.getTestdata();
	}


	@Test(dataProvider = "SdT")
	public void runSdT(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
		
		//Login Application
		 Login_GSD_CSC Login = new Login_GSD_CSC();
		 Login.beforemethod();
		 Login.test(SdEmID,SdPwrd,SSrlNum);
		 Login.afterMethod();
	
		 //Creating Case
		 /**SFDC_Case_Created LightingCase = new SFDC_Case_Created();
		 LightingCase.beforemethod(); 
		 LightingCase.test(SdEmID,SdPwrd,SSrlNum);
		 LightingCase.afterMethod();**/
		
	}



}
