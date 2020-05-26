package homework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IrctcWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();		
		driver.get("https://www.irctc.co.in/nget/train-search");
		String parentid=driver.getWindowHandle();
		System.out.println("Parent ID is:="+parentid);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Thread.sleep(5000);	//Time specification needed otherwise exceptions			
		
		//Remove add otherwise Gallery Link not working so below line must execute for remove add
		driver.findElement(By.xpath("//div[contains(text(),'X')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("FLIGHTS")).click();												//FLIGHTS
		driver.findElement(By.xpath("//span[@class='allcircle circletwo']")).click();					//STAY
		driver.findElement(By.xpath("//span[@class='railDrishti fa fa-line-chart']")).click();			//RAIL DRISHIT
		driver.findElement(By.xpath("//span[contains(@class,'allcircle circlefour')]")).click();		//E-Caterin		
		Thread.sleep(5000);		
		
		driver.findElement(By.xpath("//span[@class='allcircle circlefive']")).click();			//HOLIDAY
		driver.findElement(By.xpath("//span[@class='allcircle circlesix']")).click();			//TOURIST
		driver.findElement(By.xpath("//span[@class='allcircle circleseven']")).click();			//HILL RAILWAYS
		driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();			//CHARTER TRAIN
		driver.findElement(By.xpath("//span[@class='allcircle circlenine']")).click();			//GALLERY
		
		//driver.findElement(By.xpath("(//a[@href='https://www.irctctourism.com/gallery/'])[2]")).click();				//GALLERY
		Thread.sleep(7000);
		ArrayList<String> allwindowid=new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total number of windows open is:="+allwindowid.size());
		Thread.sleep(5000);
		for(int i=0;i<allwindowid.size();i++)
		{			
			String wintitle=driver.switchTo().window(allwindowid.get(i)).getTitle();
			System.out.println("WindowTitle of index ("+i+") is:="+wintitle);			
		}
		/*//ForEach Loop for access all the WindowID......USE it OR PreviousOne Same Function But 1St one ArrayList
		for(String each:allwindowid)
		{
			String windowtitle=driver.switchTo().window(each).getTitle();
			System.out.println("Window Title is:="+windowtitle);
		}*/
		System.out.println("====================Windows Closed By there Specific Index Position===========================");
		Thread.sleep(3000);
		//E-CATERIN(6)
		String wintitle6=driver.switchTo().window(allwindowid.get(6)).getTitle();
		System.out.println("Window Title of index (6) is:="+wintitle6);
		String winid6=driver.getWindowHandle();
		System.out.println("E-Catering WindowID is:="+winid6);
		System.out.println("E-Catering Window Closed\n");
		driver.close();Thread.sleep(3000);		
		//CHARTER TRAIN(2)
		String wintitle2=driver.switchTo().window(allwindowid.get(2)).getTitle();
		System.out.println("Window Title of index (2) is:="+wintitle2);
		String winid2=driver.getWindowHandle();
		System.out.println("CHARTER TRAIN WindowID is:="+winid2);
		System.out.println("CHARTER TRAIN Window Closed\n");
		driver.close();Thread.sleep(3000);
		//RAIL DRISHIT(7)
		String wintitle7=driver.switchTo().window(allwindowid.get(7)).getTitle();
		System.out.println("Window Title of index (7) is:="+wintitle7);
		String winid7=driver.getWindowHandle();
		System.out.println("RAIL DRISHIT WindowID is:="+winid7);
		System.out.println("RAIL DRISHIT Window Closed\n");
		driver.close();Thread.sleep(3000);
		//HOLIDAY(5)
		String wintitle5=driver.switchTo().window(allwindowid.get(5)).getTitle();
		System.out.println("Window Title of index (5) is:="+wintitle5);
		String winid5=driver.getWindowHandle();
		System.out.println("HOLIDAY WindowID is:="+winid5);
		System.out.println("HOLIDAY Window Closed\n");
		driver.close();Thread.sleep(3000);
		//FLIGHTS(9)
		String wintitle9=driver.switchTo().window(allwindowid.get(9)).getTitle();
		System.out.println("Window Title of index (9) is:="+wintitle9);
		String winid9=driver.getWindowHandle();
		System.out.println("FLIGHTS WindowID is:="+winid9);
		System.out.println("FLIGHTS Window Closed\n");
		driver.close();Thread.sleep(3000);
		//TOURIST(4)
		String wintitle4=driver.switchTo().window(allwindowid.get(4)).getTitle();
		System.out.println("Window Title of index (4) is:="+wintitle4);
		String winid4=driver.getWindowHandle();
		System.out.println("TOURIST WindowID is:="+winid4);
		System.out.println("TOURIST Window Closed\n");
		driver.close();Thread.sleep(3000);
		//STAY(8)
		String wintitle8=driver.switchTo().window(allwindowid.get(8)).getTitle();
		System.out.println("Window Title of index (8) is:="+wintitle8);
		String winid8=driver.getWindowHandle();
		System.out.println("STAY WindowID is:="+winid8);
		System.out.println("STAY Window Closed\n");
		driver.close();Thread.sleep(3000);
		//HILL RAILWAYS(3)
		String wintitle3=driver.switchTo().window(allwindowid.get(3)).getTitle();
		System.out.println("Window Title of index (2) is:="+wintitle3);
		String winid3=driver.getWindowHandle();
		System.out.println("HILL RAILWAYS WindowID is:="+winid3);
		System.out.println("HILL RAILWAYS Window Closed\n");
		driver.close();
		//GALLARY(1)
		String wintitle1=driver.switchTo().window(allwindowid.get(1)).getTitle();
		System.out.println("Window Title of index (1) is:="+wintitle1);
		String winid1=driver.getWindowHandle();
		System.out.println("GALLARY WindowID is:="+winid1);
		System.out.println("GALLARY Window Closed\n");
		driver.close();Thread.sleep(3000);
		//PARENT WINDOW
		driver.switchTo().window(parentid);
		System.out.println("Parent Window Closed...");
		driver.close();
		
		/*driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Bhubaneswar");
		//driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).click();
		//driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).sendKeys("15-04-2020");
		driver.findElement(By.cssSelector("//label[@class='ng-tns-c11-6 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")).sendKeys("AC First Class (1A) ");
		//driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		//driver.quit();
*/
	}

}
