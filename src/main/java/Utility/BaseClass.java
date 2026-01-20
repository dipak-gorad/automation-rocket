package Utility;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static ConfigDataProvider config;
	public static ExcelDataProvider excle;
	public static ExtentTest test;

	@BeforeSuite
	public void befourSuite() throws IOException {
		
		config=new ConfigDataProvider();
		excle=new ExcelDataProvider();
		

	}

	@BeforeTest
	public void befourTest() {

	}

	@BeforeClass
	public void befourClass() {

	}
	
	@Parameters ("BrowserName")
	@BeforeMethod
	public void setUp(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		option.addArguments("--remote-allow-origins=*");
//		option.addArguments("--headless");
		driver=new ChromeDriver(option);
		
		}
		
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
		
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--private");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(options);
			
			}
			
		else if(BrowserName.equalsIgnoreCase("edge")) {
			
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--inprivate");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(options);
		
			}
	
		
		driver.get(config.GetBaseUrl_01());
//		driver.get(config.GetBaseUrl_02());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

	}
	
	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
	}

	@AfterClass
	public void AfterClass() {

	}

	@AfterTest
	public void AfterTest() {

	}

	@AfterSuite
	public void AfterSuite() throws EmailException {
		
	}

}
