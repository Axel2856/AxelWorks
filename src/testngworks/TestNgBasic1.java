package testngworks;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*-----Execute Test Like Below-------
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * 
 * @BeforeMethod
 * @Test
 * @AfterMethod
 */
//Reporter.log()-->It shows Output in HtmlReport Page,if take true parameter then shows both in console and HtmlReportPage.
//Reporter.log("First TestCase",true);
//System.out.println()--> shows output only in console tab
public class TestNgBasic1 {
	//Pre-conditions annotation----starting with @Before 
	@BeforeSuite
	public void setUp()
	{
		System.out.println("Setup Running");
	}
	@BeforeClass
	public void lunchBrowser()
	{
		System.out.println("Browser Lunching");	
	}
	@BeforeTest
	public void lunchUrl()
	{
		System.out.println("URL Lunching");
	}
	@BeforeMethod
	public void login()
	{
		System.out.println("Login into Application");
		Reporter.log("BeforeMethod Executed...");
	}
	//Test-conditions annotation----only using @Test
	@Test
	public void testCase1()
	{//Reporter.log()-->It shows Output in HtmlReport Page,if take true parameter then shows both in console and HtmlReportPage.
	//Reporter.log("First TestCase",true);
	//System.out.println()--> shows output only in console tab
		System.out.println("TestCase1 Executing...");
		Reporter.log("First TestCase",true);
	}
	@Test
	public void testCase2()
	{
		System.out.println("TestCase2 Executing...");
		Reporter.log("Second TestCase",true);
	}
	//Post-conditions annotation-----starting with @After
	@AfterMethod
	public void deleteAllCookies()
	{
		System.out.println("Delete All cookies");
		Reporter.log("AfterMethod Executed...");
	}
	@AfterTest
	public void logout()
	{
		System.out.println("Logout of Application");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close Browser");
	}
	@AfterSuite
	public void tearDown()
	{
		System.out.println("tearDown method call finally");
	}

}
