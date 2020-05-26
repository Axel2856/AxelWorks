package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//priority used to specify which test execute at which number means first,2nd...
//@Test(priority=0)---> 0 represent highest priority and then 1,2,3... 
public class TestNgBasic2 {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Materials and Setup\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
	}
	//priority used to specify which test execute at which number means first,2nd...
	@Test(priority=2)
	public void googleTitle()
	{
		String title=driver.getTitle();
		System.out.println("Title is:="+title);
	}
	@Test(priority=0)
	public void googleLogo()
	{
		boolean a=driver.findElement(By.xpath("//div[@id='hplogo']")).isDisplayed();
		System.out.println("Logo Test:="+a);
	}
	@Test(priority=1)
	public void googleLink()
	{
		boolean b=driver.findElement(By.partialLinkText("Gmai")).isDisplayed();
		System.out.println("Link Test:="+b); 
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("All Browser Closed...");
		driver.close();
	}
}
