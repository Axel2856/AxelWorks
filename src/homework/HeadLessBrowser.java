package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {

	public static void main(String[] args)throws Throwable {
		//WebDriver driver=new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("window-size=1400,800");// some sites don't have auto size management so error occur, for avoid such statement used as general Size for all.
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.google.com");
		System.out.println("Before Navigate page Title:="+driver.getTitle());
		driver.navigate().to("https://www.facebook.com");	
		System.out.println("After Navigate Page Title:="+driver.getTitle());
		driver.navigate().back();
		System.out.println("Backward Navigate Page Title:="+driver.getTitle());
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Gm")).click();		
		System.out.println("After Link Click Current Page:="+driver.getTitle());
		driver.close();
	}

}
