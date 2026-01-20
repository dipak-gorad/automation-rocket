package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VesselPOM {
	
	@FindBy (xpath = "(//select[@class='form-control form-control-sm'])[1]") private WebElement drpSearchBy; //search by dropdown
	@FindBy(xpath = "(//button[@type='submit'])[1]") private WebElement btnSearch;	//search button
	@FindBy (xpath = "(//input[@id='vesselName'])[1]") private WebElement fldSearchField;	//search text box
	@FindBy (xpath = "(//button[.=' Reset '])[1]") private WebElement btnReset;	//Reset button
	
	// to add vessels
	@FindBy (xpath = "//i[@class='far fa-square-plus']") private WebElement btnAddVessel;
	@FindBy (xpath = "//i[@class='fas fa-sliders']") private WebElement btnAdvanceSearch;
	@FindBy (xpath = "//input[@id='vesselCode']") private WebElement fldADDVesselCode;
	@FindBy (xpath = "(//input[@id='vesselName'])[2]") private WebElement fldADDVesselName;
	@FindBy (xpath = "//button[@class='btn btn-primary btn-xs']") private WebElement btnADDSave;
	@FindBy (xpath = "(//button[@class='close btn-sm'])[1]") private WebElement btnADDClose;
	
	@FindBy (xpath = "//a[@data-dt-idx='next']") private WebElement btnNext;
	@FindBy (xpath = "//a[@data-dt-idx='previous']") private WebElement btnPrevious;
	@FindBy (xpath = "//div[@role='alert']") private WebElement msgVesselAdded;
	@FindBy (xpath = "//p[.='Vessel already present in the system.']")private WebElement msgExistingVesselAdd;
	@FindBy (xpath = "//i[@class='fa-regular text-danger fa-trash-can']") private WebElement btnDelete;
	@FindBy (xpath = "//button[@id='confirmYes']") private WebElement btnDELETEok;
	
	public WebElement getDrpSearchBy() {
		return drpSearchBy;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getFldSearchField() {
		return fldSearchField;
	}
	public WebElement getBtnReset() {
		return btnReset;
	}
	public WebElement getBtnAddVessel() {
		return btnAddVessel;
	}
	public WebElement getBtnAdvanceSearch() {
		return btnAdvanceSearch;
	}
	public WebElement getFldADDVesselCode() {
		return fldADDVesselCode;
	}
	public WebElement getFldADDVesselName() {
		return fldADDVesselName;
	}
	public WebElement getBtnADDSave() {
		return btnADDSave;
	}
	public WebElement getBtnADDClose() {
		return btnADDClose;
	}
	public WebElement getBtnNext() {
		return btnNext;
	}
	public WebElement getBtnPrevious() {
		return btnPrevious;
	}
	public WebElement getMsgVesselAdded() {
		return msgVesselAdded;
	}
	public WebElement getMsgExistingVesselAdd() {
		return msgExistingVesselAdd;
	}
	public WebElement getBtnDelete() {
		return btnDelete;
	}
	public WebElement getBtnDELETEok() {
		return btnDELETEok;
	}
	
	
	
	
	
	

}
