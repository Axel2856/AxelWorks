package homework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {
	//Using return type
	static WebDriver driver;
	public static String ss(String filename) throws Throwable
	{	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest="E:\\Selenium_Evengbatch\\AxelWorks\\src\\homework\\";
		FileUtils.copyFile(src,new File(dest+filename+".jpg"));
		return dest;
	}
	public static void main(String[] args) throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();		
		ss("google_Home1");
		//Without Return Type
		/*static WebDriver driver;
		public static void ss(String filename) throws Throwable
		{	
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String dest="E:\\Selenium_Evengbatch\\AxelWorks\\src\\homework\\";
			FileUtils.copyFile(src,new File(dest+filename+".jpg"));
		}
		public static void main(String[] args) throws Throwable {
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();		
			ss("google_Home");*/
	
		//================================Notes===========================================================
		//TakesScreenshot is an interface it's also used to typecast WebDriver Object 
		//Everytime you execute the program it replace the old picture to current picture with same name.
		//you can save the image with any format like(jpeg,jpg,png...)
		//file class and TakesScreenshot,FileUtils interface package must be import.
		//=================================End============================================================		
		
		//==========================AnotherWay===========================================================
		/*TakesScreenshot scrshot=(TakesScreenshot)driver;
		File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("E:\\Selenium_Evengbatch\\FlipKartAutomation\\src\\homework\\youtube.jpeg");
		FileUtils.copyFile(SrcFile, DestFile);*/
		driver.close();
	}

}
