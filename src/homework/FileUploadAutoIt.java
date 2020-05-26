package homework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadAutoIt {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		Actions ac=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		//HRM Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		//Navigate to Image Upload Page
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		//File Upload
		driver.findElement(By.id("firstName")).sendKeys("Axel");
		driver.findElement(By.id("lastName")).sendKeys("Blaze");
		ac.moveToElement(driver.findElement(By.id("photofile"))).click().perform();		
		Runtime.getRuntime().exec("E:\\Selenium Materials and Setup\\AutoitFileScript\\AitfileUpload.exe");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
