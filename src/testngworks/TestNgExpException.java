package testngworks;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgExpException {
	//If we know any Exception occur at run time and type of Exception also known then
	//use exceptedException to avoid failure status
@Test(expectedExceptions=NumberFormatException.class)
public void Conversion()
	{
		String str="100A";
		Integer.parseInt(str);
		//int x=Integer.parseInt(str);
		//Reporter.log(x);// shows error only take String data for Printing not integer imp...
	}
}
