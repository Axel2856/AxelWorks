package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*===================XML file For Parameters Case==============================
 * <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNg Parameter Value Pass">
<test name="PrimusBank Login Test">
<parameter name="url" value="http://www.primusbank.qedgetech.com/"/>
<parameter name="user" value="Admin"/>
<parameter name="pass" value="Admin"/>
<classes>
<class name="testngworks.TestNgParameter"></class>
</classes>
</test>
</suite>
 */
public class TestNgParameter {
	@Test
	@Parameters({"url","user","pass"})
	public void logIn(String surl,String suser,String spass) throws InterruptedException
	{
		//surl,suser,spass stores the values of Parameters sequentially and pass them in Method present below. (logIn method parameters Send to methods as same name)
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(surl);
		driver.findElement(By.id("txtuId")).sendKeys(suser);
		driver.findElement(By.id("txtPword")).sendKeys(spass);
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
