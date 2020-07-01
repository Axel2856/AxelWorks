package homework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendUsingWebDriver {

	public static void main(String[] args) {

		ExtentReports report;
		ExtentTest test;
		test = null;
		report = new ExtentReports("E:\\WebReport.html");

		for (int i = 1; i <= 3; i++) {
			test = report.startTest("Navigation Testing");
			if (i == 2) {
				System.out.println("Matched Value");
				test.log(LogStatus.PASS, "Matched Value");
			} else {
				System.out.println("Value Mis_Matched");
				test.log(LogStatus.FAIL, "Value not Matched");
			}
		}
		report.endTest(test);
		report.flush();
	}
}
