package testngworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Demo {
WebDriver driver;
ExtentReports report;
ExtentTest test;
@BeforeTest
public void generateReport()
{
	report=new ExtentReports("./Report/ExtentReport.html");
}
@BeforeMethod
public void setUp()
{
driver=new ChromeDriver();
driver.get("https://google.com");
driver.manage().window().maximize();
}
@Test
public void verifyTitle()
{
	test=report.startTest("DemoTest");
	String exptitle="google";
	String acttitle=driver.getTitle();
	if(acttitle.equalsIgnoreCase(exptitle))
	{
	Reporter.log("Title is matching");
	test.log(LogStatus.PASS, "Title is matching::"+acttitle+"  "+exptitle);
	}
	else
	{
Reporter.log("Title is not matching");
test.log(LogStatus.FAIL, "Title is matching::"+acttitle+"  "+exptitle);		
	}
}
@Test
public void failTest()
{
	test=report.startTest("Fail Test");
	String exptitle="gmail";
	String acttitle=driver.getTitle();
	if(acttitle.equalsIgnoreCase(exptitle))
	{
	Reporter.log("Title is matching");
	test.log(LogStatus.PASS, "Title is not matching::"+acttitle+"  "+exptitle);
	}
	else
	{
Reporter.log("Title is not matching");
test.log(LogStatus.FAIL, "Title is matching::"+acttitle+"  "+exptitle);		
	}

}
@AfterMethod
public void endingReport()
{
	report.endTest(test);
	report.flush();//push reports into html
	driver.close();
}
}
