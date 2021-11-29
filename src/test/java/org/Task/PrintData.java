package org.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintData {
	
	public static void main(String[] args) throws IOException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		
	driver.get("https://www.amazon.in/s?k=iphone+12+pro&dc&ref=a9_sc_1");
		
	List<WebElement> allData = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	
	File file= new File("C:\\Users\\Balachandar\\Documents\\allData.xlsx");
//	FileInputStream fi=new FileInputStream(file);
	FileOutputStream fileOut= new FileOutputStream(file);

	Workbook wb= new XSSFWorkbook();
	
	Sheet createSheet = wb.createSheet("iphoneData");

	for (int i = 0; i < allData.size(); i++) {
		WebElement we = allData.get(i);
		String text = we.getText();
		System.out.println(text);
		
		Row createRow = createSheet.createRow(i);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(text);
	}
	wb.write(fileOut);

}
}
