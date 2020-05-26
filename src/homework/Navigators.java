package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigators {

	public static void main(String[] args)throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();//Maximize Windows
		driver.manage().deleteAllCookies();//delete all cookies before lunching
		driver.get("https://google.com");// To lunch URL
		
		driver.navigate().to("https://www.gmail.com");//From current url to anothersite url lunching
		driver.navigate().back();//navigate towards backward stimulation
		driver.navigate().forward();//navigate towards forward stimulation
		driver.navigate().refresh();//refresh the current page
		Thread.sleep(5000);
		driver.close();
		
	}

}