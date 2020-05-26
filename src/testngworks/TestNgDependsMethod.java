package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgDependsMethod {
//dependsOnMethod use for execution of rest methods till the depend Method Executed...
//if depend Method not executed or any error occur then rest Methods skips which are depend on that
	
WebDriver driver;
@Test
public void logIn() throws InterruptedException
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
@Test(dependsOnMethods="logIn")
public void branches() throws InterruptedException
{
	driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
	Reporter.log("Branches Page Access",true);
	Thread.sleep(4000);
}
@Test(dependsOnMethods="logIn")
public void role() throws InterruptedException
{
	//driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();---->Original/Right one then execute all
	driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[3]")).click();
	Reporter.log("Roles Page Access",true);
	Thread.sleep(4000);
}
@Test(dependsOnMethods="role")
public void user()
{
	driver.findElement(By.xpath("//tr[6]//td[1]//a[1]//img[1]")).click();
	Reporter.log("Users Page Access",true);
}
}
