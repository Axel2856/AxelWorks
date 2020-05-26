package com.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FailScrShotExtent {
WebDriver driver;
public ExtentReports report;
public ExtentTest test;
public static String screenshot(WebDriver driver,String scrshotname) throws IOException
{
	String time=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String dest="E:\\Selenium_Evengbatch\\AxelWorks";
	File finaldest=new File(dest+time+"TFail_shot.jpg");
	FileUtils.copyFile(src, finaldest);
	return dest;
}
@BeforeTest
public void extentsetUp()
{
	report=new ExtentReports("./Reports/Google_Title.html",true);
}
@BeforeMethod
public void setUp()
{
	driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	//driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

}
@Test
public void logIn() throws Throwable
{
	test=report.startTest("Google Automation");
	String title=driver.getTitle();
	Assert.assertEquals(title,"Google123");
	//report.flush();
}
@AfterMethod
public void tearDown(ITestResult result) throws IOException, Throwable
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(LogStatus.FAIL,"Test Case Failed is: "+result.getName());
		test.log(LogStatus.FAIL, "Test case Failed is: "+result.getThrowable());
		Thread.sleep(3000);
		String screenshotpath=FailScrShotExtent.screenshot(driver,result.getName());
		test.log(LogStatus.FAIL,test.addScreenCapture(screenshotpath));
	}
	/*else 
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(LogStatus.FAIL,"Test Case Failed is: "+result.getName());
	}*/
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(LogStatus.SKIP, "Test Case is Skipped:"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(LogStatus.PASS, "Test Case is Passed:"+result.getName());
	}
	report.endTest(test);//test is the reference we create for ExtentTest test------------->imp
	driver.close();
}
@AfterTest
public void extentquit()
{
	report.flush();
	report.close();
}
}//class closed
