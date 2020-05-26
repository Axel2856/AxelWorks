package testngworks;

import org.testng.annotations.Test;

public class TestNgExplicitTimeOut {
//Both are used for specified some time interval to execute the scripts
	//@Test(timeOut=1)
	@Test(invocationTimeOut=2000)
	public void infinity()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
}
