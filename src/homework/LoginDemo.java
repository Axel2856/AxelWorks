package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

	public static void main(String[] args)throws Throwable{
		WebDriver driver=new ChromeDriver();//use ctrl+shift+o for import all package
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		//Right click css selector(automatic generate).................
		
		//driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(1) > input")).sendKeys("7978490788");
		//driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div:nth-child(2) > input")).sendKeys("dipti@2856");
		//driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div._1avdGP > button")).click();
		
		//Create my own Xpath..........................................
		
		//input[@class='_2zrpKA _1dBPDZ']
		//input[@type='password']   
		//button[@class='_2AkmmA _1LctnI _7UHT_c' and @type='submit']
		//driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("7978490788");
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dipti@2856");
		//driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c' and @type='submit']")).click();
		
		//create my own css selector....................................
		
		//input[type='text'][class='_2zrpKA _1dBPDZ']//input[type='text']._2zrpKA._1dBPDZ  Both same for user name
		//._2zrpKA._3v41xv._1dBPDZ  //input[type$='word']//input[type*='pass']//input[type^='pass'] all same for password
		//div._1avdGP+div//div._1avdGP+div.puBGSV(sibling case) this is click on otp next one
		//button._2AkmmA._1LctnI._7UHT_c      for login button
		driver.findElement(By.cssSelector("input[type='text']._2zrpKA._1dBPDZ")).sendKeys("7978490788");
		driver.findElement(By.cssSelector("._2zrpKA._3v41xv._1dBPDZ")).sendKeys("dipti@2856");
		driver.findElement(By.cssSelector("button._2AkmmA._1LctnI._7UHT_c")).click();
		Thread.sleep(6000);
		driver.close();
	}
}
