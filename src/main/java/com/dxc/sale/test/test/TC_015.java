package com.dxc.sale.test.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.dxc.sale.test.framework.excel.ExcelLib;
import com.dxc.sale.test.pom.Login.Login_GSD_CSC;
import com.dxc.sale.test.pom.sdt.SFDC_ClickSchedule;
import com.dxc.sale.test.pom.sdt.SFDC_DateValidation_Whispernet;
import com.dxc.sale.test.pom.sdt.SFDC_KM_CreateArticle_CoveoCase;
import com.dxc.sale.test.pom.sdt.SFDC_KM_CreateArticle_Knowledge_Approve;
import com.dxc.sale.test.pom.sdt.SFDC_KM_CreateArticle_Knowledge_Reject;
import com.dxc.sale.test.pom.sdt.SFDC_KM_CreateArticle_Knowledge_SecondLevelApprove;
import com.dxc.sale.test.pom.sdt.SFDC_KM_info_CreateArticle_Knowledge;
import com.dxc.sale.test.pom.sdt.SFDC_KM_HomePage;
import com.dxc.sale.test.pom.sdt.SFDC_KM_HowTos_CreateArticle_Knowledge;
import com.dxc.sale.test.pom.sdt.SFDC_KM_TB_CreateArticle_Knowledge;
import com.dxc.sale.test.pom.sdt.SFDC_Persona_CSR;
import com.dxc.sale.test.pom.sdt.SFDC_Persona_NewOnsiteTask;
import com.dxc.sale.test.pom.sdt.SFDC_Whispernet;

import com.dxc.sale.test.pom.sdt.SFDC_CaseCreation_Loop;
import com.dxc.sale.test.pom.sdt.SFDC_Case_Created;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobile;
import com.dxc.sale.test.pom.sdt.SFDC_ClickMobilePart;

public class TC_015 {

	@DataProvider(name = "KMApprover")
	public Object[][] dataSdT() {
		ExcelLib xl = new ExcelLib("Sheet1", "KMApprover");
		return xl.getTestdata();

	}

	@Test(dataProvider = "KMApprover")
	public void runSdT(String SdEmID, String SdPwrd, String SSrlNum,String Title,String ReslnTitle,String PublishedArticle,String CaseNo) throws Exception {
		// L0.5 Persona

		 
//		 SFDC_KM_TB_CreateArticle_Knowledge_SecondLevelApprove scndlvl = new  SFDC_KM_TB_CreateArticle_Knowledge_SecondLevelApprove();
//		 scndlvl.beforemethod(); 
//		 scndlvl.test(SdEmID, SdPwrd,SSrlNum,Title,ReslnTitle,PublishedArticle);
//		 scndlvl.afterMethod();
		 
//		 SFDC_KM_CreateArticle_Knowledge_Reject reject = new  SFDC_KM_CreateArticle_Knowledge_Reject();
//		 reject.beforemethod(); 
//		 reject.test(SdEmID, SdPwrd,SSrlNum,Title,ReslnTitle);
//		 reject.afterMethod();
		
//		 SFDC_KM_TB_CreateArticle_Knowledge trouble= new  SFDC_KM_TB_CreateArticle_Knowledge();
//		 trouble.beforemethod(); 
//		 trouble.test(SdEmID, SdPwrd,SSrlNum,Title,ReslnTitle,PublishedArticle);
//		 trouble.afterMethod();
		 
//		 SFDC_KM_HowTos_CreateArticle_Knowledge howtos= new  SFDC_KM_HowTos_CreateArticle_Knowledge();
//		 howtos.beforemethod(); 
//		 howtos.test(SdEmID, SdPwrd,SSrlNum,Title,ReslnTitle,PublishedArticle);
//		 howtos.afterMethod();
		 
//		 SFDC_KM_info_CreateArticle_Knowledge info= new  SFDC_KM_info_CreateArticle_Knowledge();
//		 info.beforemethod(); 
//		 info.test(SdEmID, SdPwrd,SSrlNum,Title,ReslnTitle,PublishedArticle);
//		 info.afterMethod();
		 
//		 SFDC_KM_HomePage homePg = new  SFDC_KM_HomePage();
//		 homePg.beforemethod(); 
//		 homePg.test(SdEmID, SdPwrd,SSrlNum,CaseNo);
//		 homePg.afterMethod();

	}

}
