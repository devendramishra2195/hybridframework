package com.vtiger.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {
	
	
	
	
	
	
	@Test
	public void TC01_InValidLogin()
	{		
		String TCName = "TC01_InValidLogin";
		logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("password"));
		lp.verifyErrorMsg();	
		extent.flush();
	}
	
	@Test
	public void TC02_ValidLogin()
	{
		String TCName = "TC02_ValidLogin";
	   logger = extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(prop.getProperty("Userid"), prop.getProperty("Password"));
		HomePage hp = new HomePage(driver,logger);
		hp.verifyLogout();
		hp.clickLogout();
		extent.flush();
	}

}
