package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AuthenticationPopup {

	public static void main(String[] args)throws Throwable {
		//Before enter into any website if any pop-up shows for Authentication means Login with Username and Password
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Syntax==>  http://username:password@(then rest of url till.com)
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String message=driver.findElement(By.tagName("p")).getText();
		System.out.println("AFTER LOGIN, WEBPAGE PARAGRAPH IS:: "+message);
		Thread.sleep(5000);
		driver.close();
	}

}
