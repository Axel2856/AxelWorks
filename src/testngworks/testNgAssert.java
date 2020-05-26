package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNgAssert {
	WebDriver driver;
	String expectedTitle="Google";
	@BeforeMethod
	public void setUp() throws InterruptedException
	{		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Materials and Setup\\SeleniumDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(4000);
	}
	@Test
	public void googleTitle()
	{
		//like if condition means not satisfied condition error message print
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"Title Mismatch");
		//Assert.assertEquals(actualTitle,"Google","If Title Mismatch This Error Message Display");		
	}
	@Test
	public void logoDisplay()
	{
		//if b stores false value then it's failure and return error Message
		boolean b=driver.findElement(By.xpath("//div[@id='hplogo']")).isDisplayed();
		//boolean b=false;
		Assert.assertTrue(b,"Google_Logo is not Displayed");
	}
	@Test
	public void conditionFalse()
	{
		//if a stores true value then it's failure and return error Message
		boolean a=false;
		Assert.assertFalse(a,"Condition is true so Error Message Print");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
