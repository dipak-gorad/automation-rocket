package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {

	public static ExtentReports extent = ExtentReportGenrator.getReports();
	public static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent
				.createTest(result.getTestClass().getName() + "==>" + result.getMethod().getMethodName());
		extenttest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		extenttest.get().log(Status.PASS, "Test Case Pass");

	}

	public void onTestFailure(ITestResult result) {

		extenttest.get().addScreenCaptureFromBase64String(getCapture());
		extenttest.get().log(Status.FAIL, "Test Case Fail");
		
	}

	public void onTestSkipped(ITestResult result) {

		extenttest.get().log(Status.SKIP, "Test Case Skip");

	}

	public void onFinish(ITestContext context) {

		extent.flush();
//		ITestListener.super.onFinish(context);
	}

	public static String getCapture() {

		TakesScreenshot tc=(TakesScreenshot) driver;
		return tc.getScreenshotAs(OutputType.BASE64);

	}

}
