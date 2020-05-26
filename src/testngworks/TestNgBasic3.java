package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//@Test(description="Employee Section Access",enabled=true)
//description="Employee Section Access"---> used for shows the description of the Test methods
//enabled=true-->used for active status of Test method means true if false then it hides to execute and shows skip in report
public class TestNgBasic3 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Materials and Setup\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.primusbank.qedgetech.com/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		Reporter.log("Login Successful",true);
		Thread.sleep(4000);
	}
	@Test(description="Branches Section Access",enabled=true)
	public void primusBranches()throws Throwable
	{
		driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
		Reporter.log("Branches Page Access",true);
		Thread.sleep(4000);
	}
	@Test(description="Roles Section Access",enabled=false)
	public void primusRoles()throws Throwable
	{
		driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();
		Reporter.log("Roles Page Access",true);
		Thread.sleep(4000);
	}
	@Test(description="Users Section Access",enabled=true)
	public void primusUsers()throws Throwable
	{
		driver.findElement(By.xpath("//tr[6]//td[1]//a[1]//img[1]")).click();
		Reporter.log("Users Page Access",true);
		Thread.sleep(4000);
	}
	@Test(description="Employee Section Access",enabled=true)
	public void primusEmployee()throws Throwable
	{
		driver.findElement(By.xpath("//tr[8]//td[1]//a[1]//img[1]")).click();
		Reporter.log("Employee Page Access",true);
		Thread.sleep(4000);
	}
	@AfterMethod
	public void tearDown()
	{
		Reporter.log("All Window closed",true);
		driver.close();
	}

}
