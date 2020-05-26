package homework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotTimeStamp {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");		
		//DateTime format for Screenshot Program to avoid the overwrite of .jpeg/.png files
		//"DD-MM-YY hh-mm-ss"//"dd-MM-yy hh-mm-ss"//"yyyy-MM-dd hh-mm-ss"
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		Date dt=new Date();
		String time=sdf.format(dt);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\"+time+"GooglePage.jpeg"));
		driver.close();
	}

}
