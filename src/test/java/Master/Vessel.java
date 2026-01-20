package Master;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactory.ApplicationsPOM;
import PageFactory.LogInPOM;
import PageFactory.UriHomePagePOM;
import PageFactory.VesselPOM;
import Utility.BaseClass;
import Utility.Library;

public class Vessel extends BaseClass {

//	@Test (priority = 0)
//	
//	public void addMultipleVessels() throws IOException, InterruptedException {
//		
//		//Page factory classes objects
//		LogInPOM log =new PageFactory().initElements(driver, LogInPOM.class);
//		ApplicationsPOM app=new PageFactory().initElements(driver, ApplicationsPOM.class);
//		UriHomePagePOM home=new PageFactory().initElements(driver, UriHomePagePOM.class);
//		VesselPOM vessel=new PageFactory().initElements(driver, VesselPOM.class);
//		
//		
//		
//		String username=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 1);
//		String password=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 2);
//		
//		//log in
//	 	Library.customThread(3000);
//		Library.customSendkeys(log.getFldUsername(),username , "Username");
//		Library.customSendkeys(log.getFldPassword(),  password, "Password");
//		Library.customThread(2000);
//		Library.coustomWaitForElementToBeClickable(3, log.getBtnSignIn(), "Sign In");
//		Library.getScreeshotAndAttachToReport("HomePage");
//		Library.customThread(4000);
//		
//		Library.customClick(app.getBtnURI(), "URI 2.0");
//		Library.customClickByJS(home.getBtnMaster(), "Master");
//		Library.customClickByJS(home.getBtnVessel(), "Vessel");
//		Library.customClickByJS(vessel.getBtnSearch(), "Search");
//		
//		int row=Library.getExcelSheetObject(".\\TestData\\Excel Data.xlsx", "AddVessel").getLastRowNum();
//		
//		for(int i=1; i<=row;i++) {
//			
//			String vesselCode=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", i, 0);
//			String vesselName=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", i, 1);
//			
//			Library.customClickByJS(vessel.getBtnAddVessel(), "Add Vessel icon");
//			Library.customSendkeys(vessel.getFldADDVesselCode(), vesselCode, "Vessel Code");
//			Library.customSendkeys(vessel.getFldADDVesselName(), vesselName, "Vessel Code");
//			Library.customClickByJS(vessel.getBtnADDSave(), "Save");
//			
//			Library.customThread(1000);
//			String actualResult=Library.customGetText(vessel.getMsgVesselAdded());
//			Library.customAssertEquals(actualResult, Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", 1, 2));
//	
//			Library.customThread(2000);
//			Library.customClickByJS(vessel.getBtnADDClose(), "Close");
//			Library.customRefresh();
//			Library.customThread(1000);
//		}	
//		
//	}
//	
	
	@Parameters ("BrowserName")
//	@Test (priority = 1, dependsOnMethods = "addMultipleVessels")
	@Test
	
	public void addExistingVessel(String browsername) throws IOException, InterruptedException {
		test.info("Browser Name => "+browsername);
		
		//Page factory classes objects
		LogInPOM log =new PageFactory().initElements(driver, LogInPOM.class);
		ApplicationsPOM app=new PageFactory().initElements(driver, ApplicationsPOM.class);
		UriHomePagePOM home=new PageFactory().initElements(driver, UriHomePagePOM.class);
		VesselPOM vessel=new PageFactory().initElements(driver, VesselPOM.class);
		
		
		
		String username=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 1);
		String password=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 2);
		
		//log in
	 	Library.customThread(3000);
		Library.customSendkeys(log.getFldUsername(),username , "Username");
		Library.customSendkeys(log.getFldPassword(),  password, "Password");
		Library.customThread(2000);
		Library.coustomWaitForElementToBeClickable(3, log.getBtnSignIn(), "Sign In");
		Library.getScreeshotAndAttachToReport("HomePage");
		Library.customThread(4000);
		
		Library.customClick(app.getBtnURI(), "URI 2.0");
		Library.customClickByJS(home.getBtnMaster(), "Master");
		Library.customClickByJS(home.getBtnVessel(), "Vessel");
		Library.customClickByJS(vessel.getBtnSearch(), "Search");
		
		String vesselCode=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", 1, 0);
		String vesselName=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", 1, 1);
		
		Library.customClickByJS(vessel.getBtnAddVessel(), "Add Vessel icon");
		Library.customSendkeys(vessel.getFldADDVesselCode(), vesselCode, "Vessel Code");
		Library.customSendkeys(vessel.getFldADDVesselName(), vesselName, "Vessel Code");
		Library.customClickByJS(vessel.getBtnADDSave(), "Save");
		
		Library.customThread(1000);
		String actualResult=Library.customGetText(vessel.getMsgExistingVesselAdd());
		
		Library.customAssertEquals(actualResult, "Vessel already present in the system.");

	}
	
	
	
//	@Test (priority = 2, dependsOnMethods = "addMultipleVessels")
//	public void deleteVessels() throws IOException, InterruptedException {
//		
//		//Page factory classes objects
//		LogInPOM log =new PageFactory().initElements(driver, LogInPOM.class);
//		ApplicationsPOM app=new PageFactory().initElements(driver, ApplicationsPOM.class);
//		UriHomePagePOM home=new PageFactory().initElements(driver, UriHomePagePOM.class);
//		VesselPOM vessel=new PageFactory().initElements(driver, VesselPOM.class);
//		
//		
//		
//		String username=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 1);
//		String password=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "Sheet1", 1, 2);
//		
//		//log in
//	 	Library.customThread(3000);
//		Library.customSendkeys(log.getFldUsername(),username , "Username");
//		Library.customSendkeys(log.getFldPassword(),  password, "Password");
//		Library.customThread(2000);
//		Library.coustomWaitForElementToBeClickable(3, log.getBtnSignIn(), "Sign In");
//		Library.getScreeshotAndAttachToReport("HomePage");
//		Library.customThread(4000);
//		
//		Library.customClick(app.getBtnURI(), "URI 2.0");
//		Library.customClickByJS(home.getBtnMaster(), "Master");
//		Library.customClickByJS(home.getBtnVessel(), "Vessel");
//		
//		int row=Library.getExcelSheetObject(".\\TestData\\Excel Data.xlsx", "AddVessel").getLastRowNum();
//		
//		for(int i=1; i<=row;i++) {
//			
////			String vesselName=Library.getExcelData("C:\\Users\\ESSENZAADEVPC17\\Desktop\\Excel Data.xlsx", "AddVessel", i, 1);
//			String vesselCode=Library.getExcelData(".\\TestData\\Excel Data.xlsx", "AddVessel", i, 0);
//			
//			Library.customSendkeys(vessel.getFldSearchField(), vesselCode, "Search");
//			Library.customClickByJS(vessel.getBtnSearch(), "Search");
//			Library.customThread(1000);
//			
//			List<WebElement> vesselCountOnPage=Library.customFindElements("//*[@id='dataTable_vesselListTable']/tbody/tr");
//			
//			for(int j=1; j<=vesselCountOnPage.size(); j++) {
//				
//				String ActualVesselCode=Library.customGetText(Library.customFindElement("(//*[@id='dataTable_vesselListTable']/tbody/tr["+j+"]/td)[4]"));
//				
//				if(vesselCode.equals(ActualVesselCode)) {
//					
//			
//				Library.customClickByJS(Library.customFindElement("(//*[@id='dataTable_vesselListTable']/tbody/tr["+j+"]/td)[4]"), "Check box");
//				Library.customThread(3000);
//				Library.customClickByJS(vessel.getBtnDelete(), "Delete");
//				Library.customThread(1000);
//				Library.customClickByActionClass(vessel.getBtnDELETEok(), "OK");
//				Library.customThread(1000);
////				Library.customClear(vessel.getFldSearchField(), "Search");
////				Library.customClickByJS(vessel.getBtnReset(), "Reset");
//				Library.customThread(1000);
//				Library.customRefresh();
//				
//				break;
//				}
//			}
//	
//			
//		}
//	
//				
//		
//	}
}
