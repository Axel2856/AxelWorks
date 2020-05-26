package com.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgLogin_Report_Orange {
WebDriver driver;
FileInputStream fi;
FileOutputStream fo;
Workbook wb;
Sheet ws;
Row row;
ExtentReports report;
ExtentTest test;

@BeforeTest
public void setUp()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	report=new ExtentReports("./Report/Orange_Login.html");	
}
@Test
public void logIn() throws Throwable
{	
	fi=new FileInputStream("E:\\Selenium Materials and Setup\\ExcelData\\AllLoginInfo.xlsx");
	wb=WorkbookFactory.create(fi);
	ws=wb.getSheet("Data1");
	row=ws.getRow(0);
	int rc=ws.getLastRowNum();
	for(int i=1;i<=rc;i++)
	{
		test=report.startTest("Login Test");
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		String user=ws.getRow(i).getCell(0).getStringCellValue();
		String pass=ws.getRow(i).getCell(1).getStringCellValue();
		Thread.sleep(3000);
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.name("Submit")).click();
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			Reporter.log("Login Successful",true);
			test.log(LogStatus.INFO,"Login Info");
			test.log(LogStatus.PASS,"Login Successful");
			ws.getRow(i).createCell(2).setCellValue("Valid Information");
			ws.getRow(i).createCell(3).setCellValue("Pass");
		}
		else {
			Reporter.log("Login Failed",true);
			test.log(LogStatus.FAIL, "Invalid Login Data");
			String msg=driver.findElement(By.id("spanMessage")).getText();
			ws.getRow(i).createCell(2).setCellValue(msg);
			ws.getRow(i).createCell(3).setCellValue("Fail");
		}
		report.endTest(test);
		report.flush();
	}//for closed
	fi.close();
	fo=new FileOutputStream("E:\\Selenium Materials and Setup\\ExcelData\\FileOut\\Orange_Report.xlsx");
	wb.write(fo);
	fo.close();
	wb.close();
}//test close
@AfterTest
public void tearDown()
{
	driver.close();
}
}
