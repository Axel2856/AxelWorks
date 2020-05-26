package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;//select this one as package

public class HtmlUnitDriverHeadLess {

	public static void main(String[] args) {
		//WebDriver driver=new ChromeDriver();	
		//=========================================NOTES====================================================
		//download HtmlUnitDriver jar file
		//Right click on project(FlipKartAuto..)->Properties->javaBuildpath->choose library from above->addexternaljar->apply&close
		//It's not working for Action class like events(MouseMovement,drag and drop,double click)
		//Selenium 3.0 onwards use external jar of HtmlUnitDriver as like ChromeDriver,geckodriver as it separate
		//used for AWS case and faster execution, execute behind the scene,very fast--performance of script
		//Ghostdriver --HeadLess Browser 
		// HtmlUnitDriver--java
		//	phantomjs--javascript
		//============================================END====================================================
		WebDriver driver=new HtmlUnitDriver();
		driver.get("https://www.google.com");
		System.out.println("Current Page Title is:="+driver.getTitle());		
		driver.findElement(By.partialLinkText("Gm")).click();
		System.out.println("After click on Gmail link Page Title is:="+driver.getTitle());
		driver.close();

	}

}
