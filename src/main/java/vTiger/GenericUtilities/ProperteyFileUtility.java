package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperteyFileUtility {
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException 
{
    FileInputStream fis =new FileInputStream(IConstantsUtility.propertyFilepath);	
	Properties pobj=new Properties();
	pobj.load(fis);
	String value=pobj.getProperty(key);
	return value;
	
	
}

}
