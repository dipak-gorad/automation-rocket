package Utility;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.Driver;

public class Library extends BaseClass {

	
	// 1. Click=> customClick
	// 2. SendKeys=> customSendkeys
	// 3. CustomEnter after entering value => customSendkeyAndEnter
	// 4. ScreenShot => getCaptured
	// 5. drop down handling (by value) => customHandleDropDown
	// 6. drop down handling (by Visible text) => customHandleDropDown
	// 7. drop down handling (by Index number) => customHandleDropDown
	// 8. Handle alert ==> customAcceptAlert
	// 9. Handle alert ==> customDissmissAlert
	//		sendkey in allert ==> customSendkeyInAllert
	// 10. Excel reading ==>getExcelData
	// 		a. object of XSSFSheet ==> getExcelSheetObject
	// 11. Assertion ==> customAssertEquals
	// 		a. String type ==> customAssertEquals
	// b. boolean type ==> customAssertEquals
	// 12. Click by using javaScript ==> customClickByJS
	// 13. Scroll to element ==> customScrolling
	// 14. Scrolling by pixel ==> customScrolling
	// 15. Element isEnable ==> customIsEnabled
	// 16. Element is Display ==> customIsDisplayed
	// 17. Element is Selected ==> customIsSelected
	// 18. To clear text box==> customClear;
	// 19. Send keys by using JavaScriptExecutor by element Id ==> customSendkeysByJS
	// 20. file uploading using Send key ==> costumFileUploading
	// 21. Switch to frame ==> customSwitchToFrame
	// 		a. using index ==> customSwitchToFrame
	//		b. using webelement of frame ==> customSwitchToFrame
	// 		c. Switch to first main frame ==> customSwitchTodefaultConent
	// 		d. Switch to first main frame ==> customSwitchToParentFrame
	// 22. Switch to window ==> customSwitchToWindow
	// 23. Drag and drop ==> customDragAndDrop
	// 		a. drag and drop to targetElement ==> customDragAndDrop
	// 		b. drag and drop to particular location ==> customDragAndDrop
	// 24. Click using action class  ==> customClickByActionClass
	// 25. Double click on element  ==> customDoubleClick
	// 26. Right click on element  ==> customRightClick
	// 27. Move to element  ==> customMoveToElement
	// 28. Explicitly wait  ==> coustomWaitForVisibilityOfElement
	// 29. Explicitly wait  ==> coustomWaitForElementToBeClickable
	// 30. get Data for data provider ==> customGetDataForDataProvider
	// 31. get Screenshot and attach to Report ==> getScreeshotAndAttachToReport
	// 32. Refresh page ==> customBack
	// 33. Navigate back ==> customMoveToBackPage
	// 34. Navigate to next page ==> customMoveToNextPage
	// 35. read text ==> costomGetText
	// 36 sleep ==> customThread
	// 37 List of element==> customFindElemnts;
	

	
	// 1. Click=> customClick
	public static void customClick(WebElement element, String buttonName) {

		try {
			element.click();
			customThread(500);
			test.log(Status.PASS, "Clicked On '" + buttonName + "' button");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}

	}
	
	// 2. Method for SendKeys
	public static void customSendkeys(WebElement element, String Value, String fieldName) {

		try {
			element.sendKeys(Value);
			customThread(500);
			test.log(Status.PASS, "' " + Value + "' is send in '" + fieldName + "' textbox");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}

	}

	// 3. CustomEnter with key

	public static void customSendkeyAndEnter(WebElement element, String Value, String fieldName) {
		try {
			element.sendKeys(Value);
			element.sendKeys(Keys.ENTER);
			test.log(Status.PASS, Value + " is send in " + fieldName + "and clicked on Enter");
			customThread(500);
		} catch (Exception e) {

			test.log(Status.FAIL, e.getMessage());
		}

	}

	// 4. Screenshot

	public static void getCaptured(String ScreenShotName) throws IOException {

		try {
			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\Screenshots\\" + ScreenShotName + ".png");
			FileUtils.copyFile(src, dest);
			test.pass("Screenshot taken And stored in Screenshot folder by name '" + ScreenShotName + "'");
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 5. drop down handling (by value)

	public static void customHandleDropDown(WebElement element, String Value, String DropDownName) {

		try {
			Select slt = new Select(element);
			slt.selectByValue(Value);
			test.log(Status.PASS, Value + " is selected from " + DropDownName + " dropdown");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// 6. drop down handling (by Visible Text)

	public static void customHandleDropDown(String VisibleText, WebElement element, String DropDownName) {

		try {
			Select slt = new Select(element);
			slt.selectByVisibleText(VisibleText);
			test.log(Status.PASS, VisibleText + " is selected from " + DropDownName + " dropdown");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// 7. drop down handling (by index)

	public static void customHandleDropDown(WebElement element, int index, String DropDownName) {

		try {
			Select slt = new Select(element);
			slt.selectByIndex(index);
			test.log(Status.PASS, "Value selected from " + DropDownName + " dropdown having index number " + index);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// 8. Alert handling => Accept

	public static void customAcceptAlert( ) {

		try {
			driver.switchTo().alert().accept();
			test.log(Status.PASS, " Successfully clicked on ok button on alert");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// 9. Alert handling => Dismiss

	public static void customDismissAlert( ) {

		try {
			driver.switchTo().alert().dismiss();
			test.log(Status.PASS, " Successfully clicked on Cancel button on alert");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	// a. sendkey in allert ==> customSendkeyInAllert
	
	public static void customSendkeyInAllert(String text) {

		try {
			driver.switchTo().alert().sendKeys(text);
			test.log(Status.PASS, "'"+text+"'enter in alert text box");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// 10. Excel reading

	public static String getExcelData(String path, String SheetName, int rowNumb, int cellNumb) throws IOException {
		String data = "";
		try {
//			String path="..\\Project\\TestData\\Excel Data.xlsx";

			FileInputStream file = new FileInputStream(path);
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheet(SheetName);
			// return sheet.getRow(rowNumb).getCell(cellNumb).getStringCellValue();
			XSSFCell cell = sheet.getRow(rowNumb).getCell(cellNumb);
			DataFormatter formate = new DataFormatter();
			String Exceldata = formate.formatCellValue(cell);
			data = Exceldata;
			book.close();
			file.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

	// a. object of XSSFSheet ==> getExcelSheetObject
	public static XSSFSheet getExcelSheetObject(String path, String SheetName) throws IOException {

		// String path="..\\Project\\TestData\\Excel Data.xlsx";

		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(SheetName);
		return sheet;
	}

	// 11. Assertion
	// a. String type
	public static void customAssertEquals(String actual, String expected) {

		try {
			if(actual.equals(expected)) {
				test.log(Status.INFO, "Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			
			}
			
			else {
				
				test.fail("Assertion is faild becouse actual Result not match with expected result."+ "Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			}
			Assert.assertEquals(actual, expected);
		}
		catch (Exception e) {

			test.fail(e.getMessage());
		}
		
		
	}
	
	// b. boolean type
	public static void customAssertEquals(boolean actual, boolean expected) {

		try {
			if(Boolean.compare(expected, expected)==0) {
				test.pass("Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			}
			
			else {
				
				test.fail("Assertion is failed becouse actual Result not match with expected result." +"Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			}
			Assert.assertEquals(actual, expected);
		}
		catch (Exception e) {

			test.fail(e.getMessage());
		}
		
		
	}
	

	// c. int type
	public static void customAssertEquals(int actual, int expected) {
		try {
			
			if(actual==expected) {
			test.log(Status.PASS, "Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			}
			
			else {
				test.fail("Assertion is failed becouse actual Result not match with expected result." +"Actual Result ==> " + actual + " :: Expected Result ==> " + expected);
			}
			Assert.assertEquals(actual, expected);
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
			
		}
		

	}

	// 12. Click by using javaScript
	public static void customClickByJS(WebElement element, String ButtonName) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			test.log(Status.PASS, "Clicked On '" + ButtonName + "' button");
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 13. Scroll to element
	public static void customScrolling(WebElement element) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			test.pass("Scrolling done");
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 14. Scrolling by pixel
	public static void customScrolling(WebElement element, int x, int y) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(" + x + "," + y + ");", element);
			test.log(Status.PASS, "Scrolling done");

		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 15. Element isEnable
	public static void customIsEnabled(WebElement element, String buttonName) {
		try {
			if (BooleanUtils.compare(element.isEnabled(), true) == 0) {
				test.info(buttonName + "is Enable ==> " + element.isEnabled());
			} else {
				test.info(buttonName + "is Enable ==> " + element.isEnabled());
			}
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 16. Element is Display ==> customIsDisplayed
	public static void customIsDisplayed(WebElement element, String buttonName) {
		try {
			if (BooleanUtils.compare(element.isDisplayed(), true) == 0) {
				test.info(buttonName + "is Enable ==> " + element.isDisplayed());
			} else {
				test.info(buttonName + "is Enable ==> " + element.isDisplayed());
			}
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 17. Element is Selected ==> customIsSelected
	public static void customIsSelected(WebElement element, String buttonName) {
		try {
			if (BooleanUtils.compare(element.isSelected(), true) == 0) {
				test.info(buttonName + "is Enable ==> " + element.isSelected());
			} else {
				test.info(buttonName + "is Enable ==> " + element.isSelected());
			}
		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 18. To clear textbox==> customClear;
	public static void customClear(WebElement element, String fieldName) {

		try {

			element.clear();
			test.pass(fieldName + "field is Cleared");
		} catch (Exception e) {

			test.fail(e.getMessage());
		}
	}

	// 19. Sendkeys by using JavaScriptExecutor by element Id ==> customSendkeysByJS
	public static void customSendkeysByJS(String elementId, String value, String fieldName) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String argument = "document.getElementById('" + elementId + "').value='" + value + "';";
			js.executeScript(argument);
			test.pass("'" + value + "' value send in '" + fieldName + "'");

		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 20. file uploading using Sendkey ==> costumFileUploading

	public static void costumFileUploading(WebElement element, String filePath) {

		try {
			element.sendKeys(filePath);
			test.pass("File uploading done having path '" + filePath + "'");

		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}

	// 21. handle iframes
	// a. using index

	public static void customSwitchToFrame(int frameIndex) {

		try {

			driver.switchTo().frame(frameIndex);

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}

	// b. using webelement of frame ==> customSwitchToFrame
	public static void customSwitchToFrame(WebElement frameElement) {

		try {

			driver.switchTo().frame(frameElement);

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}

	// c. using id of frame
	public static void customSwitchToFrame(String frameId) {

		try {

			driver.switchTo().frame(frameId);

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}

	// c. Switch to first main frame ==> customSwitchTodefaultConent
	public static void customSwitchTodefaultConent() {

		try {

			driver.switchTo().defaultContent();

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}

	// d. Switch to first main frame ==> customSwitchToParentFrame
	public static void customSwitchToParentFrame() {

		try {

			driver.switchTo().parentFrame();

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}

	// 22. Switch to window ==> customSwitchToWindow

	public static void customSwitchToWindow(String textOnChildWindow) {

		try {
			
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindow = driver.getWindowHandles();

			Iterator<String> it = allWindow.iterator();

			while (it.hasNext()) {

				String childWindow = it.next();
				driver.switchTo().window(childWindow);

				if (driver.getPageSource().contains(textOnChildWindow)) {

					test.pass("Successfully Switched to window ==> "+ driver.getPageSource().contains(textOnChildWindow));
					break;
				}

			}
		} catch (Exception e) {
			
			test.fail(e.getMessage());
		}

	}
	
	// 23. Drag and drop ==> customDragAndDrop
	
	// a. drag and drop to targetElement ==> customDragAndDrop
	public static void customDragAndDrop(WebElement srcElement, WebElement targetElement, String srcElementName) {
		
		try {
			
		Actions action=new Actions(driver);
		action.dragAndDrop(srcElement, targetElement).build().perform();;
		test.pass(srcElementName+" element drage and droped");
		
		}
		catch (Exception e) {
			
			test.fail(e.getMessage());
		}
		
	}
	
	// b. drag and drop to particular location ==> customDragAndDrop

	public static void customDragAndDrop(WebElement srcElement, String srcElementName, int xOffset, int yOffset) {
		
		try {
			
		Actions action=new Actions(driver);
		action.dragAndDropBy(srcElement, xOffset, yOffset ).build().perform();;
		test.pass(srcElementName+" element drage and droped");
		
		}
		catch (Exception e) {
			
			test.fail(e.getMessage());
		}
		
	}
	
	// 24. Click using action class  ==> customClickByActionClass
	
	public static void customClickByActionClass(WebElement srcElement, String srcElementName) {
		
		try {
			
			Actions action=new Actions(driver);
			action.click(srcElement).build().perform();
			test.pass("Clicked on '"+srcElementName+"' element" );
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
		}
		
	}
	
	// 25. Double click on element  ==> customDoubleClick
	
	public static void customDoubleClick(WebElement srcElement, String srcElementName) {

		try {
			
			Actions action=new Actions(driver);
			action.doubleClick(srcElement).build().perform();
			test.pass("Double clicked on '" + srcElementName + "' element");

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}
	
	// 26. Right click on element  ==> customRightClick
	
	public static void customRightClick(WebElement srcElement, String srcElementName) {

		try {

			Actions action=new Actions(driver);
			action.contextClick(srcElement).build().perform();
			test.pass("Double clicked on '" + srcElementName + "' element");

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}
	
	// 27. Move to element  ==> customMoveToElement
	
	public static void customMoveToElement(WebElement srcElement  ) {

		try {
			Actions action=new Actions(driver);
			action.moveToElement(srcElement).build().perform();

		} catch (Exception e) {

			test.fail(e.getMessage());
		}

	}
	
	// 28. Explicitly wait until element is visible  ==> coustomWaitVisibilityOfElement
	
	public static void coustomWaitforVisibilityOfElement(int timeInSeconds, WebElement element) {
		
		try {
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Exception e) {
			test.fail(e.getMessage());
		}
		
	}
	
	// 29. Explicitly wait  ==> coustomWaitElementToBeClickable
	
	public static void coustomWaitForElementToBeClickable(int timeInSeconds, WebElement element, String elementName) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			customClick(element, elementName);

		} catch (Exception e) {
			test.fail(e.getMessage());
		}

	}
	
	// 30. get Data for data provider ==> customGetDataForDataProvider
	
	public static Iterator<Object[]> customGetDataForDataProvider(String sheetPath, String sheetName) throws IOException {

		List<Object[]> data = new ArrayList<Object[]>();
		
		try {
			final String path = sheetPath;
			int row = Library.getExcelSheetObject(path, sheetName).getLastRowNum();

			for (int i = 1; i <= row; i++) {

				int cell = Library.getExcelSheetObject(path, sheetName).getRow(i).getLastCellNum();
				Object[] ob = new Object[cell];
				
				for (int j = 0; j < cell; j++) {
					String testdata = Library.getExcelData(path, sheetName, i, j);

					ob[j] = testdata;
				}

				data.add(ob);
			}
	
		}
		catch (Exception e) {
			
			test.fail(e.getMessage());
			
		}
		return data.iterator();
		
	}
	
	// 31. get Screenshot and attach to Report ==> getScreeshotAndAttachToReport
	
	public static String screenCapture(String ScreenshotName) throws IOException, InterruptedException {

		String path = ".//Screenshots//" + ScreenshotName + ".png";

			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);

			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;

	}
	
	public static void getScreeshotAndAttachToReport(String ScreenshotName) throws IOException, InterruptedException {

		String imgPath = Library.screenCapture(ScreenshotName);
		Listeners.extenttest.get().addScreenCaptureFromPath(imgPath);
	}
	
	// 32. Refresh page  customBack
	
	public static void customRefresh() {
		
		try {
			
			driver.navigate().refresh();
			test.pass("Page refresh");
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
			
		}
		
	}
	
	// 33. Navigate back ==> customBack
	
	public static void customMoveToBackPage() {
		
		try {
			
			driver.navigate().back();
			test.pass("Navigate to back page");
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
			
		}
		
	}

	// 34. Navigate to next page ==> customMoveToNextPage
	
	
	public static void customMoveToNextPage() {
			
			try {
				
				driver.navigate().back();
				test.pass("Navigate to next page");
				
			} catch (Exception e) {
				
				test.fail(e.getMessage());
				
			}
			
		}
		
	// 35. read text ==> costomGetText
		
	public static String customGetText(WebElement element) {
			String text="";
			try {
				
				text=element.getText();
				
			} catch (Exception e) {
				
				test.fail(e.getMessage());
				
			}
			return text;
			
		}
		
	// 36. sleep ==> customThread
		
	public static void customThread(int miliSeconds) throws InterruptedException {
			
			Thread.sleep(miliSeconds);
			
		}
		
	// 37. FindElements
	
	public static List<WebElement> customFindElements(String xPath) {
		
		List<WebElement> list = null;
		try {
			
		return	driver.findElements(By.xpath(xPath));
			
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
		}
		return list;
		
	}
	
	//38. findelement
	
public static WebElement customFindElement(String xPath) {
		
		WebElement element = null;
		try {
			
		return	driver.findElement(By.xpath(xPath));
			
			
		} catch (Exception e) {
			
			test.fail(e.getMessage());
		}
		return element;
		
	}
		
	
	
	
	
}
