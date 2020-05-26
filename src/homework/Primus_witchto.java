package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Primus_witchto {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		//click on branches 
		driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
		Thread.sleep(2000);
		//delete click
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[8]/a[1]/img[1]")).click();
		Thread.sleep(2000);
		//alert window
		driver.switchTo().alert();
		String alert=driver.switchTo().alert().getText();
		System.out.println(alert);
		Thread.sleep(3000);
		//accept 
		driver.switchTo().alert().accept();		
		Thread.sleep(3000);
		//confirm ok
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//click on users		
		driver.findElement(By.xpath("//tr[6]//td[1]//a[1]//img[1]")).click();
		String checkuser=driver.getCurrentUrl();
		System.out.println("User Link Url is:="+checkuser);
		Thread.sleep(2000);
		//Click Link On roles
		driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();
		String checkrole=driver.getCurrentUrl();
		System.out.println("Role Link Url is:="+checkrole);	
		Thread.sleep(2000);
		//Redirect or navigate to new Website
		Thread.sleep(3000);
		driver.get("https://www.google.com");
		System.out.println("Google Page Opened...");
		Thread.sleep(2000);
		driver.get("https://www.facebook.com");
		System.out.println("Facebook Page Opened...");
		Thread.sleep(2000);
		//back
		driver.navigate().back();//I took google and facebook sites to show navigate.back() method works.you can take any without Popup sites
		Thread.sleep(2000);
		driver.close();
		//below scripts are not working due to when it redirect back again alert popup prevent them to go backward
		//driver.navigate().back();
		//driver.navigate().back();		
			
	}

}
