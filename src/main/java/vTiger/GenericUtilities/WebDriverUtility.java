package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method will wait for 20sec for the page load
	 * @param driver
	 */
	public void waitPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		/**
		 * 
		 */
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void HandleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void HandleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by visible text
	 * @param Text
	 * @param element
	 */
	public void HandleDropDown(String Text,WebElement element) {
		Select s=new Select(element);
        s.selectByVisibleText(Text);
	}
	
	
	/**
	 * This method will handle the mouse hover Action on webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
		/**
		 * This method will perform right click anywhere on the page
		 * @param driver
		 */
	public void rightClickAction(WebDriver driver) {
		
		Actions act=new Actions(driver);
		act.contextClick().perform();	
	}
	
	
   /**
    * This method will perform right click on particular webelement
    * @param driver
    * @param element
    */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * This method will perform double click anywhere on the page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on particular webelement
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * This method will perform drag and drop from one element to another
	 * @param driver
	 * @param srcelement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement dstElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelement, dstElement).perform();
	}
	/**
	 * This method will press the enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method will release the enter key
	 * @throws AWTException
	 */
	public void releaseEnterKey() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method will handle frame with index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
	
	/**
	 * This method will handle the frame with nameorId
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**
	 * This method will handle frame with webelement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void handleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
		
	}
	
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method will capture and return the alert text
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	
	/**
	 * This method will take screen shots and save it in screenshots folder
	 * @return 
	 * @throws IOException 
	 */
	public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst =new File(".\\Screenshots\\"+screenshotName+".png");
		FileUtils.copyFile(src, dst);//commons io dependency
		
		return dst.getAbsolutePath();  // used in extent reports
	}
	
	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		
		//step1: capture all the window IDs
		Set<String> winIds=driver.getWindowHandles();
		
		//step2: use a for each loop and navigate to each window
		for(String win:winIds) 
		{
			//step4: capture the title of each window
			String currentTitle=driver.switchTo().window(win).getTitle();
			
			//Step4: compare the current Title with partial window title
			if(currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method will scroll randomly downwords
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy (0.500","");
	}
	
	/**
	 * This method will scroll the particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);

	}
	
	
	
	
	
	
}	
	

