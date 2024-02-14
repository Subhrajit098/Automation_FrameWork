package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsinfoPage {

	//Declaration
			@FindBy(xpath = "//span[@class='dvHeaderText']")
			private WebElement ContactHeaderText;
			
			//Initialization
			public ContactsinfoPage(WebDriver driver) {  //test script 
				PageFactory.initElements(driver, this);
			}
			//Utilization

			public WebElement getContactHeaderText() {
				return ContactHeaderText;
			}
			//business libraries
			/**
			 * This method will return the header text and return it to caller
			 * @return
			 */
			public String getContactHeader() {
				return ContactHeaderText.getText();
			}
}
