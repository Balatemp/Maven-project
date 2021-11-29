package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven1 {

	public static void main(String[] args) throws IOException {
		
		// To configure the location of Excel Sheet
				File f= new File("C:\\Users\\Balachandar\\java & selenium\\FirstMavenClass\\TestData\\Book1.xlsx");
				
				FileInputStream fi =new FileInputStream(f);
				
				//1) XSSFWorkbook ---> .xlsx
				//2) HSSFWorkbook ---> .xls
				
				Workbook wb=new XSSFWorkbook(fi);
				
				//superclass of all the checked exception is IOexception
				
				// getSheet is the method which is present in the workbook interface
				
				//To Print all the Data's inside the Excel sheet
				Sheet sheet = wb.getSheet("DataDriven");
				
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {	
					Row row = sheet.getRow(i);
					
					for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
						Cell cell = row.getCell(j);
						String stringCellValue = cell.getStringCellValue();
						System.out.println(stringCellValue);
					}
					
				}
		
	}
	
}
