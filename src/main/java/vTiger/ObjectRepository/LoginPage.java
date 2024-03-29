package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1: create a separate pom class for every page
	
//Rule 2:Identify all the web elements using elements
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement SubmitBtn;

	//Rule3: Initialize these elements with a constructor
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
    //Rule4:Provide getters to access these elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business library - Generic Methods -project specified
	/**
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void LoginToApp(String USERNAME,String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
	
	
}
