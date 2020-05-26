package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {		
		WebDriver driver=new FirefoxDriver();		
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");//=======URL FOR FIRST SCRIPTS==========
		//driver.get("https://jqueryui.com/droppable/");		//=======URL FOR SECOND SCRIPTS==========		
		/*driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'tryhtml5')]")));
		Actions action=new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//img[@id='drag1'and@alt='W3Schools']"))).
		moveToElement(driver.findElement(By.xpath("//html//body//div[6]//div[1]//div[1]//div[4]"))).release().build().perform();*/
		Actions action=new Actions(driver);
		WebElement src=driver.findElement(By.xpath("//img[@id='drag1']"));
		WebElement dst=driver.findElement(By.xpath("(//div[@id='div2'])[1]"));
		//action.dragAndDrop(src,dst).build().perform();	
		action.clickAndHold(src).moveToElement(dst).release().perform();
		
		/*//For jquery site and for 2nd URL
		//============================================================================================================
		//Xpaths	//iframe[@class='demo-frame']  OR //iframe[contains(@src,'demos')]
		//css selectors  //iframe.demo-frame //https://www.youtube.com/watch?v=G25caLTE9zc  check video for frame
		
		//-------------can use any one of below scripts...---------------------------------		
		driver.switchTo().frame(0);		//directly put id value if only one frame in webpage then value=0
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'demos')]")));
		
		//-------------below codes for drag and drop----------------------------
		Actions action=new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable"))).
		moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();	
		//=============================================================================================================*/		
	}

}
