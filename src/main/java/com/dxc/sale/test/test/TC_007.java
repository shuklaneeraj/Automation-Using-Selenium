package com.dxc.sale.test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;

public class TC_007 {
@DataProvider(name = "Schedule")
public Object[][] dataSdT() {
	ExcelLib xl = new ExcelLib("Sheet1", "Schedule");
	return xl.getTestdata();
	
}


@Test(dataProvider = "Schedule")
public void runSdT(String EmID, String Pwrd) throws Exception {
	
		
	//Click Schedule
	/**SFDC_ClickSchedule Schedule  = new SFDC_ClickSchedule();
	Schedule.beforemethod();
	Schedule.test(EmID,Pwrd);
	Schedule.afterMethod();**/
	
}



}
