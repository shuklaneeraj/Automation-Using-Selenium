package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobile;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobilePart;

public class TC_009 {
@DataProvider(name = "Schedule")
public Object[][] dataSdT() {
	ExcelLib xl = new ExcelLib("Sheet1", "Schedule");
	return xl.getTestdata();
	
}


@Test(dataProvider = "Schedule")
public void runSdT(String EmID, String Pwrd) throws Exception {
	
	/**SFDC_ClickMobilePart mobilePart  = new SFDC_ClickMobilePart();
	mobilePart.beforemethod();
	mobilePart.test(EmID,Pwrd);
	mobilePart.afterMethod();**/
	
}

}
