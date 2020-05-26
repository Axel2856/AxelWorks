package homework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopup {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a.black")).click();
		
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentnode=it.next();
		System.out.println("The Parent ID is:: "+parentnode);
		System.out.println("Title of Parent Node:: "+driver.getTitle());
		String parent=driver.getTitle();
		
		String childnode=it.next();
		driver.switchTo().window(childnode);
		System.out.println("The Child ID is:: "+childnode);
		System.out.println("Title of Child Node:: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentnode);
		if(parent.equals(driver.getTitle()))
		{
			System.out.println("Parent window Activated");
		}
		else
		{
			System.out.println("Error in Switching");
		}
		driver.close();
	}
}
