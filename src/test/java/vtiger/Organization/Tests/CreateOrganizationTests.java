package vtiger.Organization.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.ProperteyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTests extends BaseClass
{
	
	@Test(groups="SmokeSuite")
	public void createOrgTest() throws IOException
   	{
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		
				
				//Step 3: Navigate to Organizations link
				HomePage hp=new HomePage(driver);
				hp.ClickOnOrganizationLink();
				Reporter.log("Navigating Organization link",true);//print in report
				
				//Step 4: Click on Create Organization Look up Image
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrganizationLookUpImg();
				Reporter.log("Clicking on create org link");//not printing in report
				//Step 5: Create organization with mandatory Fields
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);

				//Assert.fail();
				
				//Step 7: Validate for Organization
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
				
				
				
   }
}
