package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OppertunitieLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOppertunitieLink() {
		return OppertunitieLink;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Libraries
	/**
	 * This method will click on organizationLink
	 */
	public void ClickOnOrganizationLink() {
		OrganizationsLink.click();
	}
	
	/**
	 * This method will click on contactsLink
	 */
	public void ClickOnContactsLink() {
		ContactsLink.click();
	}
	/**
	 * This method will perform sign out operation on web app
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdminstratorImg);
		SignOutLink.click();
	}
	
	
	
	
}
