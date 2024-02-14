package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This method read data from excel sheet
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String SheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException {


  FileInputStream fis =new FileInputStream(IConstantsUtility.excelFilepath);
  Workbook wb=WorkbookFactory.create(fis);
  String value= wb.getSheet(SheetName).getRow(rowno).getCell(cellno).getStringCellValue();
  return value;
}

public void writeDataFromExcel(String Sheetname,int rowno,int cellno,String value) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis =new FileInputStream(IConstantsUtility.excelFilepath);
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(Sheetname).createRow(rowno).createCell(cellno).setCellValue(value);
	FileOutputStream fos =new FileOutputStream(IConstantsUtility.excelFilepath);
	wb.write(fos);
	wb.close();
}

/**
 * This method will read data excel sheet n return it to data provider
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public Object[][] readDatafromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException{
	FileInputStream fis =new FileInputStream(IConstantsUtility.excelFilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	int lastRow=sh.getLastRowNum();
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastRow][lastCell];
	for(int i=0; i<lastRow;i++) //row
	{
		for(int j=0; j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
         return data;	
}

}
