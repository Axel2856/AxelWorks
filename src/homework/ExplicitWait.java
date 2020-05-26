package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Explicit wait-->here driver is WebDriver driver and 200 seconds wait
		WebDriverWait wait=new WebDriverWait(driver, 200);
		Actions ac=new Actions(driver);
		driver.get("https://www.Flipkart.com");
		ac.sendKeys(Keys.ESCAPE).click().perform();
		driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][contains(text(),'Men')]")).click();	
		//ExpectedConditions is a class here and explicitwait used for specific element which take time 
		//which element take more time than common time for all,there we use ex(Ajax methods elements)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Electronics')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
		driver.navigate().refresh();
		//you have to specify which method select from 18 method of ExpectedConditions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'TVs & Appliances')]")));
		driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]")).click();
		driver.close();

	}

}
