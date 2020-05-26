package testngworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.ExpectedExceptionsHolder;

public class PopUpPrimus {
	WebDriver driver;
	@Test//(expectedExceptions=UnhandledAlertException.class)
	public void logIn() throws Exception
	{
	//DesiredCapabilities dc = new DesiredCapabilities();
	//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	

	driver=new ChromeDriver(); 
	driver.get("http://primusbank.qedgetech.com/");
	driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin1");
	driver.findElement(By.xpath("//input[@id='login']")).click();
	
	/*try {
		driver.findElement(By.xpath("//input[@id='login']")).click();
		} catch (UnhandledAlertException f) {
			throw f;}
			//System.out.println("unhandle");
		    try {		        
		         driver.switchTo().alert().accept();
		    	} catch (NoAlertPresentException e) {
		    		System.out.println("NoAlert");
		    	}
		    }
		finally
		{
			System.out.println("Game over");
		}
	
	
	
	Thread.sleep(2000);*/
	if(driver.getCurrentUrl().contains("minflow"))
	{
		Reporter.log("login successfull",true);
	}
	/*else
	{
		//Actions act=new Actions(driver);
		//act.sendKeys(Keys.ESCAPE);
		//driver.switchTo().alert().accept();
		try {
		  driver.switchTo().alert();
		} catch (UnhandledAlertException f) {
			System.out.println("un handled");
		    try {		        
		        String alertText =driver.switchTo().alert().getText();
		        System.out.println("Alert data: " + alertText);
		        driver.switchTo().alert().accept();
		    	} catch (NoAlertPresentException e) {
		    		System.out.println("NoAlert");
		    	}
		    }
		finally
		{
			System.out.println("Game over");
		}
				
	}
*/	
}
}

