package homework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadRobot {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		Actions ac=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Axel");
		driver.findElement(By.id("lastName")).sendKeys("Blaze");
		ac.moveToElement(driver.findElement(By.id("photofile"))).click().perform();
		Robot robo=new Robot();
		StringSelection str=new StringSelection("E:\\DemoImages\\music.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
