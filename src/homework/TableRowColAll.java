package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TableRowColAll {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.primusbank.qedgetech.com/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
		//=============================================================
		/*//Table Data Access Started....
		WebElement table=driver.findElement(By.id("tab_10"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		System.out.println("Number of Rows Present is:="+rows.size());
		for(int i=0;i<rows.size();i++)
		{
		List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
		System.out.println("Row No("+i+") has Column Size:"+cols.size());			
		System.out.println("=========================================");
		for(int j=0;j<cols.size();j++)
		{
			System.out.println(cols.get(j).getText());
		}
		System.out.println("*****************************************");
		}*/
		//=============================================================
		//Use for each loop to access row and column data
		/*for(WebElement eachrow:rows)
		{
		//get collection of columns
			List<WebElement>cols=eachrow.findElements(By.tagName("td"));
			for(WebElement eachcell:cols)
			{
				if(eachcell.getText().isEmpty())
				{
			driver.findElement(By.xpath("//a[contains(text(),'...')]")).click();		
				}
				System.out.print("\n"+eachcell.getText());
			}
			System.out.println();
			System.out.println("=========================================================");
		}*/
		//===============================================================================
		for(int k=1;k<=121;k++)
		{			
			String s1="//a[contains(text(),'";
			String s2="')]";		
			
			//int[] var1= {1,11,21,31,41,51,61,71,81,91,101,111,121};
			if(k!=1 && k!=11 && k!=21 && k!=31 && k!=41 && k!=51 && k!=61 && k!=71 && k!=81 && k!=91 && k!=101 && k!=111 && k!=121)
			{
				if(k==22)
				{
					driver.findElement(By.xpath("//*[@id=\"DG_bankdetails\"]/tbody/tr[7]/td/span")).click();
					
					//span[contains(text(),'22')]
				}
				else
				{
					driver.findElement(By.xpath(s1+k+s2)).click();
					Thread.sleep(3000);
				}
			}
			Thread.sleep(3000);			
			
			//Table Data Access Started....
			WebElement table=driver.findElement(By.id("tab_10"));
			List<WebElement> rows=table.findElements(By.tagName("tr"));
			System.out.println("Page No("+k+")"+" Contains ("+rows.size()+") number of Rows"+"\n"+"\n");
			for(int i=2;i<rows.size()-1;i++)
			{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			//System.out.println("Row No("+i+") has Column Size:"+cols.size());			
			//System.out.println("=========================================");
			for(int j=0;j<cols.size();j++)
			{
				System.out.print(cols.get(j).getText()+"\t");				
			}
			System.out.println("");
			}//i for loop closed
			System.out.println("******************************************************************************************");
			String text=driver.findElement(By.xpath("//a[contains(text(),'...')]")).getText();
			if(k==10)
			{				
					driver.findElement(By.xpath("//a[contains(text(),'...')]")).click();	
					//count=count+10;
			}
			
			int[] var2= {20,30,40,50,60,70,80,90,100,110,120};
			for(int x=0;x<var2.length;x++)
			{
				if(k==var2[x])
				{
					driver.findElement(By.xpath("//body//a[11]")).click();
					break;
				}
			}
			
			
		}//K for loop closed...
		
	}

}
