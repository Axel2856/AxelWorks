package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameCount {

	public static void main(String[] args) throws InterruptedException {
		//Calculate Frames Present in WebSite	
				WebDriver driver=new FirefoxDriver();	
				driver.get("https://www.irctc.co.in/nget/train-search");
				String parentid=driver.getWindowHandle();
				System.out.println("Parent ID is:="+parentid);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
				Thread.sleep(5000);	//Time specification needed otherwise exceptions	
				
				List<WebElement> frame=driver.findElements(By.tagName("iframe"));
				System.out.println("Size:="+frame.size());

	}

}
