package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPOM {
	
	@FindBy (xpath = "//input[@id='loginId']") private WebElement fldUsername;
	@FindBy (xpath = "//input[@id='password']") private WebElement fldPassword;
	@FindBy (xpath = "//button[@type='submit']") private WebElement btnSignIn;
	@FindBy (xpath = "//i[@class='fas fa-power-off']") private WebElement btnLogOut;
	
	
	public WebElement getFldUsername() {
		return fldUsername;
	}
	public WebElement getFldPassword() {
		return fldPassword;
	}
	public WebElement getBtnSignIn() {
		return btnSignIn;
	}
	public WebElement getBtnLogOut() {
		return btnLogOut;
	}
	
	
	

}


