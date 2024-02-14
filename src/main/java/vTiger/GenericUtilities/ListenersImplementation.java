package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide implementation for ITestListener Interface of TestNG.
 */

public class ListenersImplementation implements ITestListener {
	

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"*** Test script execution started ***");
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+"==== Test Script Execution Started ===="); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "==== Execution PASS ====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "==== Execution FAIL ====");
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wUtil=new WebDriverUtility();

		String screenShotName = methodName+"."+new JavaUtility().getSystemdateInFormat();
		
		try {
			String path=wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);// it will go to the screenshot location and attached to the report 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "==== Test Script Execution Skipped ====");
		test.log(Status.INFO, result.getThrowable()); // This method print the exception
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("***** Exetution Started *****");     
		//Extent Report Configuration Report-dt month year time
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemdateInFormat()+".html");
		htmlReporter.config().setDocumentTitle("Vtiger Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Automation Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Base URL", "http:www.localhost:8888");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Subhrajit Barik");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("***** Execution Finshed *****");
		report.flush();//Generate the report
	}

	
	
}
