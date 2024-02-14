package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will return a random number after every run
	 * @return
	 */
   public int getRandomNumber() 
    {
      Random r=new Random();
     return r.nextInt(1000);
    }
    /**
    * this method will return the current system date
    * @return
    */
   public String  getSystemDate() {
	   Date d=new Date();
	   return d.toString();
	   
	   
   }
   /**
    * this method will return the date in specific format
    * @return
    */
   public String getSystemdateInFormat() {
	   Date d=new Date();
	   String[] dArr=d.toString().split(" ");
	   String date=dArr[2];
	   String month=dArr[1];
	   String year=dArr[5];
	   String time =dArr[3].replace(":", "-");
       String dateValue =date+"_"+month+"-"+year+"_"+time;
       return dateValue;
   }

}
