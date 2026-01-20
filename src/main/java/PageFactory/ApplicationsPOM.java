package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationsPOM {

	@FindBy (xpath = "//img[@alt='CFS']")private WebElement btnURI;

	public WebElement getBtnURI() {
		return btnURI;
	}
	
	
}
