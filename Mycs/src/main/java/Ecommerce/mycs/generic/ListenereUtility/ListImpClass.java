package Ecommerce.mycs.generic.ListenereUtility;
/**
 * @author Gurup
 */
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Ecommerce.mycs.generic.baseclass.BaseClass;

public class ListImpClass extends BaseClass implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;
	String time;	String methodName;

	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Gurup\\git\\repository7\\Mycs\\Screenshots.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("ReportName");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "chrome-103");
		report.setSystemInfo("Environment", "TestingEnvironment");
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		time = new Date().toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot ts = (TakesScreenshot) UtilityObjectClass.getSdriver();
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src,methodName+time);

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());

		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onFinish(ISuite suite) {
		report.flush();
	}

}
