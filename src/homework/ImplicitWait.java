package homework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions ac=new Actions(driver);
		//implicit wait used for each and every element present on this webpage wait 30sec if not appear
		//if it appear in 5sec then rest wait time ignore automatically
		//Thread.sleep() case what is the time fix ,wait for that time if it appear or not.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.Flipkart.com");
		ac.sendKeys(Keys.ESCAPE).click().perform();
		driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//li[@class='Wbt_B2 _3mmoXN']//li[2]//ul[1]//li[4]//a[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]")).click();
		driver.close();
	}

}
