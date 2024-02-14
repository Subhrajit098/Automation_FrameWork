package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	//Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement OrgHeaderText;
		
		//Initialization
		public OrganizationsInfoPage(WebDriver driver) {//test script 
			PageFactory.initElements(driver, this);
		}

		public WebElement getOrgHeaderText() {
			return OrgHeaderText;
		}
		
		//business library
		
		public String getOrganizationHeader() {
			return OrgHeaderText.getText();
		}
		
}
