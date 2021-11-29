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

public class DataDriven {
	public static void main(String[] args) throws IOException {
		
	// To configure the location of Excel Sheet
		File f= new File("C:\\Users\\Balachandar\\java & selenium\\FirstMavenClass\\TestData\\Book1.xlsx");
		
		FileInputStream fi =new FileInputStream(f);
		
		Workbook wb=new XSSFWorkbook(fi);
		
		//To read or get the sheet from the WorkBook
		Sheet sheet = wb.getSheet("DataDriven");
		
		//To read or get the row form the sheet
		Row row = sheet.getRow(3);
		
		//To read or get the cell form row
		Cell cell = row.getCell(0);

		//To read or get the Data form the Cell
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);

	}

}
