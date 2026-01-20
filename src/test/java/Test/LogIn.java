package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.LogInPOM;
import Utility.BaseClass;
import Utility.Library;

public class LogIn extends BaseClass {
	
	
	@DataProvider (name="log in data")
	public Iterator<Object[]> logInData() throws IOException {
		
		String sheetName="Sheet1";
		return Library.customGetDataForDataProvider("C:\\Users\\ESSENZAADEVPC17\\Desktop\\Excel Data.xlsx", sheetName);
		
	}
	
	
	@Test (dataProvider = "log in data")
	public void logIn(String testCase,String username,String password,String exprctedResult, String assertion_Xpath) throws InterruptedException, IOException {
		
	 	LogInPOM log =new PageFactory().initElements(driver, LogInPOM.class);

	 	Library.customThread(3000);
	 	test.info("Test Case Name ==>"+testCase);
		Library.customSendkeys(log.getFldUsername(),username , "Username");
		Library.customSendkeys(log.getFldPassword(),  password, "Password");
		Library.customThread(2000);
		Library.coustomWaitForElementToBeClickable(3, log.getBtnSignIn(), "Sign In");

		Library.getScreeshotAndAttachToReport("HomePage");
		Library.customThread(4000);

		String actualResult=Library.customGetText(driver.findElement(By.xpath(assertion_Xpath)));
		
		Library.customAssertEquals(actualResult, exprctedResult);
	
	
	}
	
	



}
