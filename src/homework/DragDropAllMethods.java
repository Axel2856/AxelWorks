package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropAllMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		//========================Method(1)======================================
		Actions act=new Actions(driver);
		//frame count in webpage
		List<WebElement> frm=driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of Frames is:="+frm.size());
		driver.switchTo().frame(0);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		act.clickAndHold(src).moveToElement(dst).release().perform();
		//========================Method(2)======================================
		/*Actions act=new Actions(driver);
		driver.switchTo().frame(0);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		act.dragAndDrop(src, dst).build().perform();
		if(dst.getText().contains("Dropped!")){
			  System.out.println("Drag and Drop Sucessful...");}
		else {System.out.println("Drag and Drop Failed...");}*/
		//========================Method(3)======================================
		/*Actions act=new Actions(driver);
		driver.switchTo().frame(0);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		//dst coordinates detects
		int x=dst.getLocation().getX();
		int y=dst.getLocation().getY();
		act.dragAndDropBy(src, x, y).build().perform();
		if(dst.getText().contains("Dropped!")){
			  System.out.println("Drag and Drop Sucessful...");}
		else {System.out.println("Drag and Drop Failed...");}*/
		//=======================================================================
		if(dst.getText().equals("Dropped!")){
			System.out.println("Sucessfully Drag and Drop Event Happend");}
		else{System.out.println("Drag and Drop Event Failed");}		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.linkText("Button"))).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		Thread.sleep(5000);
		driver.close();
		System.out.println("WebBrowser Closed Sucessfully");


	}

}
