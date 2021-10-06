package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_CVS_CSR;
import com.dxc.sale.test.pom.sdt.SFDC_CVS_OnsiteTask;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Updated1;
import com.dxc.sale.test.pom.sdt.SdT;


public class TC_011 {

	@DataProvider(name = "SdT")
	public Object[][] dataSdT() {
		ExcelLib xl = new ExcelLib("Sheet1", "SdT");
		return xl.getTestdata();
	}


	@Test(dataProvider = "SdT")
	public void runSdT(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
		
		//CVS check for Onsite
//		SFDC_CVS_OnsiteTask cvsOnsite = new SFDC_CVS_OnsiteTask();
//		cvsOnsite.beforemethod(); 
//		cvsOnsite.test(SdEmID,SdPwrd,SSrlNum);
//		cvsOnsite.afterMethod();
		
	}



}
