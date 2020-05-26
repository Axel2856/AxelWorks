package com.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportStyle1 {

	WebDriver driver;
	ExtentReports report;
	//ExtentHtmlReporter htmlreport;
	
	@Test
	public void logIn()
	{
		//Environment Variable SetUp
		report=new ExtentReports("./Reports/Extent_Automation.html",true);
		report.addSystemInfo("Host Name", "Axel_PC");
		report.addSystemInfo("User Name", "Axel");
		report.addSystemInfo("Environment", "Automation");
		//Test Scripts
		System.out.println("Login to Gmail...");		
		ExtentTest logger=report.startTest("Login Test");
		Reporter.log("Login Test Access...");
		logger.log(LogStatus.INFO, "Login info Status...");
		logger.log(LogStatus.PASS, "Login Sucessful");
		report.flush();
		
		ExtentTest logger2=report.startTest("Logoff Test");
		logger2.log(LogStatus.INFO, "Logoff info Status...");
		logger2.log(LogStatus.FAIL, "Logoff failed");
		logger2.addScreenCapture("C:\\Users\\ASUS\\Desktop\\Gallery.jpg");
		report.flush();
	}	
}
