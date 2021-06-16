package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

// import statements
public class ExcelUtility {

final String POIWRITE_XLSX = "D:\\Project\\B_Cart\\src\\test\\resources\\TestCaseData.xlsx";
	
	
	public String readExcelFun(int row,int cell, String sheetname) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(POIWRITE_XLSX));
	
        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        
        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetname);
        
        XSSFRow obj1=sheet.getRow(row);
        XSSFCell objcell=obj1.getCell(cell);
        
        String returnValue="";
        
            // Check the cell type and format accordingly
            switch (objcell.getCellType()) {
            case NUMERIC:
              //  System.out.print(objcell.getNumericCellValue() + "\t");
                returnValue= Integer.toString((int) objcell.getNumericCellValue());
               break; 
                
            case STRING:
                System.out.print(objcell.getStringCellValue() + "\t");
                returnValue=objcell.getStringCellValue();
                break;
			
               
            }
            return  returnValue;
	}  

}

