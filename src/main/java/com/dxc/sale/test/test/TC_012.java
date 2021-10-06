package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_CaseCreation_Loop;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobile;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobilePart;

public class TC_012 {
@DataProvider(name = "SdT")
public Object[][] dataSdT() {
	ExcelLib xl = new ExcelLib("Sheet1", "SdT");
	return xl.getTestdata();
	
}


@Test(dataProvider = "SdT")
public void runSdT(String SdEmID, String SdPwrd, String SSrlNum) throws Exception {
	
	//Case Creation LOOP
	/**SFDC_CaseCreation_Loop createLoop  = new SFDC_CaseCreation_Loop();
	createLoop.beforemethod();
	createLoop.test(SdEmID,SdPwrd,SSrlNum);
	createLoop.afterMethod();**/
	
}



}
