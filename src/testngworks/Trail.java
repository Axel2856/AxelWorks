package testngworks;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



public class Trail {
	
WebDriver driver;

	
@BeforeMethod
	
public void setUp() throws Throwable
	{
		
		
driver=new ChromeDriver();
		
driver.get(" http://primusbank.qedgetech.com/");
				
		
driver.manage().window().maximize();
		
driver.findElement(By.name("txtuId")).sendKeys("Admin"); 
		
driver.findElement(By.name("txtPword")).sendKeys("Admin");
	
driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
	
Reporter.log("running setUp",true);
	
Thread.sleep(4000);

	}
	
@Test
	
public void branches() throws Throwable
	{
		
driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
		 
		
Thread.sleep(4000);
		
Reporter.log("Executing branches Test",true);
		
	
}
	
@Test
	
public void roles()throws Throwable
	{
		
driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1] ")).click();
		
Thread.sleep(4000);
		
Reporter.log("Executing roles Test",true);
		
	
}
	
@Test
	
public void users() throws Throwable
	{
		
driver.findElement(By.xpath(" //tr[6]//td[1]//a[1]//img[1]")).click();
		
Thread.sleep(4000);
		
Reporter.log("Executing users Test",true);
	
}	
	
@AfterMethod
	
public void tearDown()throws Throwable
	{
		
Thread.sleep(4000);
	driver.close();	
	
Reporter.log("Running tearDown",true);
	
}
	

}
