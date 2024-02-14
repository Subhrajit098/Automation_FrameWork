package vtiger.Organization.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.ContactsinfoPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups="RegressionSuit")
	public void createContactWithOrgTest() throws IOException
	
	{
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();

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
     		
	}

}
