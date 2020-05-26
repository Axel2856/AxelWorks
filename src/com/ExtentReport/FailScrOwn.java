package com.ExtentReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class FailScrOwn {
WebDriver driver;
ExtentReports report;
ExtentTest test;
public String shot()throws Throwable
{
	String time=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//Below comment lines generate Test_output folder inside Project at runtime and also hold the html file which generate
	//String d=System.getProperty("user.dir")+"/test_output/filename.html";
	//report=new ExtentReports(d);
	String destination="E:\\";
	File dest1=new File(destination+"hrm.jpeg");
	File dest=new File(destination+time+"hrm.jpeg");
	FileUtils.copyFile(src, dest);
	FileUtils.copyFile(src, dest1);
	return destination;
}

@BeforeMethod
public void setUp()
{
	report=new ExtentReports("./Reports/hrm.html");
	driver=new ChromeDriver();	
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
}
@Test
public void login() throws Throwable
{
	test=report.startTest("Verify Login");
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#1");
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(3000);
	if(driver.getCurrentUrl().contains("dash"))
	{
		Reporter.log("Login Successful",true);
		test.log(LogStatus.PASS, "Valid Login Data");		
	}
	else
	{
		String message=driver.findElement(By.id("spanMessage")).getText();
		Reporter.log(message,true);
		Thread.sleep(4000);
		String path=shot();
		Thread.sleep(2000);
		test.log(LogStatus.FAIL,message);
		test.log(LogStatus.FAIL,test.addScreenCapture(path));
		//shot();
	}
	report.endTest(test);
	report.flush();
}
@AfterTest
public void tearDown()
	{
		/*ITestResult result
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL,"Test Failed"+result.getName());
			String path=FailScrShotExtent.shot();
		}*/
		driver.close();
	}
}
