package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//@Test(invocationCount=4)--> Functions as like loop, execute the method as per count value... 
public class TestNgLoop {

	WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Materials and Setup\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.primusbank.qedgetech.com/");		
	}
	@Test(invocationCount=4)
	public void Login()throws Throwable
	{
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		Reporter.log("Login Method");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
