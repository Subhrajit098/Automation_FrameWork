package vtiger.Organization.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.ProperteyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.ContactsinfoPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest2 {

	@Test
	public void createContactWithOrgTest() throws IOException
	
	{
		// Step 1: Create Object of Utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		ProperteyFileUtility pUtil = new ProperteyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		

		// Step 2: Read all the necessary Data
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();

		WebDriver driver = null;

		// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to App
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);

		// Step 5: Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrganizationLink();

		// Step 6: Click on Create Organization Look up Image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImg();
		
		// Step 7: Create organization with mandatory Fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		

		// Step 9: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));

		// Step 10: Navigate Contacts Link
		hp.ClickOnContactsLink();
		// Step 11: Click on create Contact Look Up Image
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickOnCreateContactLookUpImg();

		// Step 12: Create contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
     // Step 13: Validate for Contacts
     		ContactsinfoPage cip = new ContactsinfoPage(driver);
     		String ContactHeader = cip.getContactHeader();
     		Assert.assertTrue(ContactHeader.contains(LASTNAME));

     		// Step 13: Logout
     		hp.logoutOfApp(driver);
     		System.out.println("Sign out successful");

     		// Step 11: close the browser
     		driver.quit();


	}

}
