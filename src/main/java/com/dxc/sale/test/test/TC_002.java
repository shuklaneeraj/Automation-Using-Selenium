package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Updated1;
import com.dxc.sale.test.pom.sdt.SdT;


public class TC_002 {

	@DataProvider(name = "SdT")
	public Object[][] dataSdT() {
		ExcelLib xl = new ExcelLib("Sheet1", "SdT");
		return xl.getTestdata();
	}


	@Test(dataProvider = "SdT")
	public void runSdT(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
		
		//Update Location
	/**SFDC_Case_Updated1 UpdateCase1 = new SFDC_Case_Updated1();
		 UpdateCase1.beforemethod(); 
	 	 UpdateCase1.test(SdEmID,SdPwrd,SSrlNum);
	 	UpdateCase1.afterMethod();**/
		
	}



}
