package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPratice {
     @Test(dataProvider = "getData") 
	public void addTocart(String name,int price,int qty,String color,boolean isAvailable) {
		System.out.println("------"+name+"---"+price+"----"+qty+"--"+color+"---"+isAvailable+"-------");
	}
	
     @DataProvider
     public Object[][] getData()
     {
    	 Object[][] data=new Object[2][5];
    	 data[0][0]="Samsung";
    	 data[0][0]=1000;
    	 data[0][0]=12;
    	 data[0][0]="black";
    	 data[0][0]=true;
    	 
    	 data[0][0]="Iphone";
    	 data[0][0]=12000;
    	 data[0][0]=12;
    	 data[0][0]="Red";
    	 data[0][0]=false;
    	 
    	 
    	 return data;
    	 
 		 
    	 
		
     }
	
	
}
