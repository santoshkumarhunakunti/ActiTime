package genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	String excelPath = "C:\\Users\\SANTOSH CHAVAN\\Desktop\\Book1.xlsx";
	
	public String getExcelData(String sheetName , int rowNum , int columnNum) throws IOException{
		  // get the test from excel
		  FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  Row row = sh.getRow(rowNum);
		  String data = row.getCell(columnNum).getStringCellValue();
		  return data;
	}

	public int getRowCount(String sheetName) throws IOException
	{
		 FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
	      int rowCount = sh.getLastRowNum();
	      return rowCount;
	}
	
	public void setExclData(String sheetName , int rowNum , int columnNum ) throws IOException{		
		  FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  Row row = sh.getRow(rowNum);
		  Cell cel = row.createCell(columnNum);
		  cel.setCellType(cel.CELL_TYPE_STRING);
		//  cel.setCellValue(stringData);
		  
		  FileOutputStream fos = new FileOutputStream(excelPath);
		  wb.write(fos);
	}
	
}
