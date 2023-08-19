package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	
	private WebDriver driver;
	public WebDriverWait wait;
	public ExtentTest logger;
	public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver =driver;	
		this.logger=logger;
		 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	
	
	
	public void entervalue(WebElement elm, String value,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error = "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void clickelement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();	
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error = "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void elementexist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();	
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error = "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void GetTextValidate(WebElement elm,String exp,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		
		if(exp.equals(elm.getText()))
		{
		logger.pass(msg);
		}
		else
		{
			logger.fail("comparison failed expected data was "+exp+ " and found "+elm.getText());
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error = "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public  String getscreenshot() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	

}
