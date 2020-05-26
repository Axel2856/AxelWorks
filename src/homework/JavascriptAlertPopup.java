package homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlertPopup {

	public static void main(String[] args) throws Throwable {
		// Work on Popup or Alert of JavaScript
		//http://www.seleniumframework.com/Practiceform/     (for practice purpose URL)
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		//driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("alert")).click();
		Alert alrt=driver.switchTo().alert();//focus goes to alert popup also import Alert class
		System.out.println(alrt.getText());//text of alert popup
		Thread.sleep(5000);
		alrt.accept();// for click on OK button
		//alrt.dismiss();// for click on Cancel button
		//driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\ASUS\\Desktop\\Daily task.txt");
		//driver.close();
	}
}
