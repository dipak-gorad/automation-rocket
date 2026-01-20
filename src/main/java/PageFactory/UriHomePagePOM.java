package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UriHomePagePOM {

	@FindBy (xpath = "//p[.='Masters']") private WebElement btnMaster;
	@FindBy (xpath = "//p[.='Vessel']") private WebElement btnVessel;
	
	
	public WebElement getBtnMaster() {
		return btnMaster;
	}
	public WebElement getBtnVessel() {
		return btnVessel;
	}
	
}
