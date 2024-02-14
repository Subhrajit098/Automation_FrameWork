package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business libraries
	/**
	 * This method will create organization with mandatory information
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY) {
		OrgNameEdt.sendKeys(ORGNAME);
		HandleDropDown(IndustryDropDown,INDUSTRY);
		SaveBtn.click();

	}
	
}
