package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobile;

public class TC_008 {
@DataProvider(name = "Schedule")
public Object[][] dataSdT() {
	ExcelLib xl = new ExcelLib("Sheet1", "Schedule");
	return xl.getTestdata();
	
}


@Test(dataProvider = "Schedule")
public void runSdT(String EmID, String Pwrd) throws Exception {
	
	//Click mobile
	/**SFDC_ClickMobile mobile  = new SFDC_ClickMobile();
	mobile.beforemethod();
	mobile.test(EmID,Pwrd);
	mobile.afterMethod();**/
	
}



}
