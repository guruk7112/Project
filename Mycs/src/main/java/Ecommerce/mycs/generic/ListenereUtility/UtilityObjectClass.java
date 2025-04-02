package Ecommerce.mycs.generic.ListenereUtility;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {

	public static ThreadLocal<WebDriver> sdriver=new ThreadLocal<WebDriver>();
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	

	public static ThreadLocal<WebDriver> getSdriver() {
		return sdriver;
	}

	public static void setSdriver(ThreadLocal<WebDriver> sdriver) {
		UtilityObjectClass.sdriver = sdriver;
	}

	public static ThreadLocal<ExtentTest> getTest() {
		return test;
	}

	public static void setTest(ThreadLocal<ExtentTest> test) {
		UtilityObjectClass.test = test;
	}
}
