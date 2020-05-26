package testngworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Example {
WebDriver driver;
ExtentReports report;
ExtentTest test;
FileInputStream fi;
FileOutputStream fo;
Workbook wb;
Sheet ws;
@BeforeTest
public void reports()
{
	report=new ExtentReports("./Reports/login test.html");
	driver=new ChromeDriver();
}
@Test
public void logintest()throws Throwable
{
	test=report.startTest("login");
	fi=new FileInputStream("E:\\Selenium Materials and Setup\\ExcelData\\Book1.xlsx");
	wb=WorkbookFactory.create(fi);
	ws=wb.getSheetAt(0);
	int rows=ws.getLastRowNum();
	for(int i=1;i<=rows; i++)
	{
		driver.get("http://primusbank.qedgetech.com/");
		String username=ws.getRow(i).getCell(0).getStringCellValue();
		String pass=ws.getRow(i).getCell(1).getStringCellValue();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("minflow"))
		{
			Reporter.log("login successfull",true);
			test.log(LogStatus.PASS, "login successful");
			ws.getRow(i).createCell(2).setCellValue("login successfull");
			ws.getRow(i).createCell(3).setCellValue("pass");
		}
		else
		{
			Actions action = new Actions(driver);
			String message=driver.switchTo().alert().getText();
			Thread.sleep(4000);
			action.sendKeys(Keys.ESCAPE);			
			//driver.switchTo().alert().accept();
			Thread.sleep(2000);
			Reporter.log(message,true);
			test.log(LogStatus.FAIL, message);
			ws.getRow(i).createCell(2).setCellValue(message);
			ws.getRow(i).createCell(3).setCellValue("fail");
		}
		report.endTest(test);
		report.flush();
	}
    fi.close();
    fo=new FileOutputStream("E:\\logintest.xlsx");
    wb.write(fo);
    fo.close();
    wb.close();
}
@AfterTest
public void teardown()
{
	driver.close();
}
}

