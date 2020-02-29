package Com.FreeCrm.qa.Utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Com.FreeCrm.qa.baseclass.TestBase;

public class TestUtill extends TestBase
{
	static Workbook book;
	File srcFile;
	static Sheet sheet;
	public static String screenshotlocation="C:\\Users\\Abdul Rajik shaik\\Desktop\\Abdul\\FreeCrmTest\\test-output";
  public static long PAGELOADTIMEOUT=15;
  public static long Implicit_timeout=15;
  public static String TEST_DATA_SHEET_PATH="C:\\Users\\Abdul Rajik shaik\\Desktop\\Abdul\\FreeCrmTest"
  		+ "\\src\\main\\java\\Com\\FreeCrm\\qa\\TestData\\Cogmento Crm_testdata.xlsx";
  
  public static Object[][] getTestData(String sheetname)
  {
	  FileInputStream file=null;
	  try{
		  file=new FileInputStream(TEST_DATA_SHEET_PATH);
	  }catch(FileNotFoundException fe)
	  {
		  fe.printStackTrace();
	  }
	   
	  try
	  {
		  book=WorkbookFactory.create(file);
	  }catch(InvalidFormatException ife)
	  {
		  ife.printStackTrace();
	  }catch(IOException ie)
	  {
		  ie.printStackTrace();
	  }
	  
	  sheet=book.getSheet(sheetname);
	  Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  for(int i=0;i<sheet.getLastRowNum();i++)
	  {
		  for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		  {
			  data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		  }
	  }	  
	return data;
  }
  public static void TakescreenshotatEndOfTest()throws IOException
  {
	  File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(screenshotlocation+"\\Screenshot"+".png"));
  }
  
  
  
  
}
