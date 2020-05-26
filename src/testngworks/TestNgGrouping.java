package testngworks;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgGrouping {
	WebDriver driver;
	@BeforeMethod
	public void setUp() 
	{
		Reporter.log("SetUp Method Calling...");
	}
	@Test(groups="demo")
	public void demo()
	{
		Reporter.log("Demo Method Access");
	}
	@Test(groups="demo")
	public void demo1()
	{
		Reporter.log("Demo1 Method Access");
	}
	@Test(groups="logIn")
	public void logIn()
	{
		Reporter.log("Login Section Access...");
	}
	@Test(groups="test1")
	public void test1()
	{
		Reporter.log("Inside Test1 Method");
	}
	@Test(groups="test1")
	public void test2()
	{
		Reporter.log("Inside Test2 Method");
	}
	@Test(groups="test1")
	public void test3()
	{
		Reporter.log("Inside Test3 Method");
	}
	@AfterMethod
	public void tearDown()
	{
		Reporter.log("TearDown Method Called...");
	}

}
