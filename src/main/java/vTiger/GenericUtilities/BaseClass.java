package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations
 * @author subhrajit
 *
 */
public class BaseClass {
	//Step 1: Create Object of Generic Utilities
			public ExcelFileUtility eUtil = new ExcelFileUtility();
			public ProperteyFileUtility pUtil = new ProperteyFileUtility();
			public JavaUtility jUtil = new JavaUtility();
			public WebDriverUtility wUtil = new WebDriverUtility();
			
			
			
			public WebDriver driver = null;	
			public static WebDriver sDriver; // This is for Listener
			
	@BeforeSuite(alwaysRun =true)
	public void bsConfig() {
		System.out.println("--------Database connection successful----------");
	}
	//---------For CrossBrowser Execution----------
	//@Parameters("browser")
	
	//---------For Distributed Parallel Execution----------
	//@BeforeTest 
	@BeforeClass(groups={"SmokeSuite", "RegressionSuit"})
	
	public void bcConfig(/*String BROWSER*/) throws IOException {
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			driver=new ChromeDriver();
			System.out.println("-----"+BROWSER+ " launched ------");
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{

            
			driver = new EdgeDriver();
			System.out.println("-----"+BROWSER+ " launched ------");
		}
		else
		{
			System.out.println("invalid browser name");
			
		}
		sDriver=driver; //  This is for Listeners
		wUtil.maximizeWindow(driver);
		wUtil.waitPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups={"SmokeSuite", "RegressionSuit"})
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		System.out.println("-----Login to app successful------");
	}
	
	@AfterMethod(groups={"SmokeSuite", "RegressionSuit"})
	public void amConfig() {
		HomePage hp= new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("------Logout APP successful------");
	}
	//---------For Distributed Parallel Execution----------
	//@AfterTest
	//-----------------------------------------------------
	@AfterClass(groups={"SmokeSuite", "RegressionSuit"})
	public void acConfig() {
		driver.quit();	
		System.out.println("-------Browser is  closed--------");
	}
	
	@AfterSuite(groups={"SmokeSuite", "RegressionSuit"})
	public void asConfig() {
		System.out.println("---------Database closed successful-----------");
	}

}
