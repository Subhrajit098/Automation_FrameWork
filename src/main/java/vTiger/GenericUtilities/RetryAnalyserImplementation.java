package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is an implementation class for IRetryAnalyser Interface of TestNG
 * 
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count=0;
	int retryCount=4;

	@Override
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			
			count++;
			return true;
			
		}
		return false;
	}

}
