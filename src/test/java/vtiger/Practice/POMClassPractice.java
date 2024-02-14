package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class POMClassPractice  {

	public static void main(String[] args) {
     
		WebDriver driver=new ChromeDriver();
		//WebDriverManager.chromedriver().setup()
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt.sendKeys("admin");
		//lp.getPasswordEdt.sendKeys("admin");
		//lp.getSubmitBtn.click();
		
		lp.LoginToApp("admin", "admin");
		
	}

}
