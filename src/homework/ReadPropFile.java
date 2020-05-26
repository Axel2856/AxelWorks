package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream io=new FileInputStream("E:\\Selenium_Evengbatch\\FlipKartAutomation\\src\\homework\\config.properties");
		prop.load(io);
		
		System.out.println(prop.getProperty("name"));//name=KEY and Axel=VALUE
		System.out.println(prop.getProperty("age"));
		String URL=prop.getProperty("url");
		System.out.println("URL NAME= "+URL);
		System.out.println(prop.getProperty("contact"));//return null if not found that element/key
		
		String brw=prop.getProperty("browser");
		if(brw.equals("Chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome Browser Lunched...");
		}else if(brw.equals("Firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("Firefox Browser Lunched...");
		}
		else{System.out.println("Invalid Browser Choose...BrowserName="+brw);}
		if(brw.equals("Chrome") || brw.equals("Firefox"))
		    {driver.get(URL);}
		//===============facebook login===============Elements assign=========
		Thread.sleep(3000);
		/*String username=prop.getProperty("USERNAME");
		String password=prop.getProperty("PASSWORD");
		String login=prop.getProperty("LOGIN");*/
		driver.findElement(By.xpath(prop.getProperty("USERNAME"))).sendKeys(prop.getProperty("USERVALUE"));
		driver.findElement(By.xpath(prop.getProperty("PASSWORD"))).sendKeys(prop.getProperty("PASSVALUE"));
		driver.findElement(By.xpath(prop.getProperty("LOGIN"))).click();
		/*driver.findElement(By.xpath(username)).sendKeys(prop.getProperty("USERVALUE"));
		driver.findElement(By.xpath(password)).sendKeys(prop.getProperty("PASSVALUE"));
		driver.findElement(By.xpath(login)).click();*/
	}

}
