package com.vtiger.test;

import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class LeadTest extends BaseTest {
	
	@Test
	public void TC03_CreateLeadWithMandatoryFields()
	{
		String TCName = "TC03_CreateLeadWithMandatoryFields";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);		
		lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("password"));
		LeadPage ldp = new LeadPage(driver,logger);
		ldp.clickNewLead();
		ldp.createLeadwithMandatoryFields(td.get(TCName).get("Lname"), td.get(TCName).get("Company"));
		ldp.verifyLeadCreation(td.get(TCName).get("Lname"), td.get(TCName).get("Company"));
		ldp.clickLogout();
		extent.flush();
		
	}
	

}
