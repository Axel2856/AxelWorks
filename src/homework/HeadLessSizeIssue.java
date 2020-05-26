package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessSizeIssue {

	public static void main(String[] args) throws InterruptedException {
		
		//Throws Exception as NoSuchElementFound because size issue of WebPage
		//option.addArguments("window-size=1400,800");  -->Default Size for all WebPage
		
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("window-size=1400,800");//After uncomment this error will go...
		option.addArguments("headless");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.emilywilliamswheeler.com/#/");
		Thread.sleep(5000);
		System.out.println("Starting Page Title is:="+driver.getTitle());
		driver.findElement(By.partialLinkText("PORT")).click();
		System.out.println("Current Page Title is:="+driver.getTitle());
		driver.close();
	}

}
