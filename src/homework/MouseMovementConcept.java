package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
//mouse over any menu/links/etc and then from sub menu click on specific one 
	public static void main(String[] args)throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);//wait till web elements load properly otherwise error
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Fri")).click();
		driver.close();		
		//=======================================================================================
		/*driver.get("https://www.spicejet.com/");
		Thread.sleep(9000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(5000);
		//driver.findElement(By.partialLinkText("Friends")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Friends and Family')]")).click();
		driver.close();*/

	}

}
