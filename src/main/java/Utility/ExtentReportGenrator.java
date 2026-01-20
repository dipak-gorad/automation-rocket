package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenrator {

	public static ExtentReports extent;
	
	public static ExtentReports getReports() {
		
		String path=".\\Report\\Automation Testing Report.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName("Essenzaa Solutions");
		reporter.config().setTheme(Theme.DARK);
	
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "URI 2.0");
		extent.setSystemInfo("Application Version", "2.0");
		extent.setSystemInfo("Selenium Verion", "4.11.0");
		extent.setSystemInfo("QA Name", "Akshay Malwadkar");
		
		
		return extent;
	}
}
