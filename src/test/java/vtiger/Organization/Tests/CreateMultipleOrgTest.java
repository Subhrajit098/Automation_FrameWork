package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgTest extends BaseClass {
	
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG,String INDUSTRY) throws IOException {
		//Step 1: Create Object of Generic Utilities
		
				String ORGNAME=ORG+jUtil.getRandomNumber();
			
						//Step 3: Navigate to Organizations link
						HomePage hp=new HomePage(driver);
						hp.ClickOnOrganizationLink();
						
						//Step 4: Click on Create Organization Look up Image
						OrganizationsPage op=new OrganizationsPage(driver);
						op.clickOnCreateOrganizationLookUpImg();
						
						//Step 5: Create organization with mandatory Fields
						CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
						cnop.createNewOrganization(ORGNAME, INDUSTRY);
						
						
						//Step 7: Validate for Organization
						OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
						String OrgHeader=oip.getOrganizationHeader();
						
						Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data=eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
		return data;
	}
	
	
}
