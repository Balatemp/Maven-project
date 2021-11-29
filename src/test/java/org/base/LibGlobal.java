package org.base;
import java.awt.event.KeyEvent;
import java.awt.Robot;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	public  WebDriver driver;
	public File fi;
	public  Robot robot;
	public  Alert getalert;
	public static Actions actions;
	
	public WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balachandar\\java & selenium\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public void launch(String url) {
		driver.get(url);
	}
	public WebElement xpath(String xpathvalue) {
		WebElement element = driver.findElement(By.xpath(xpathvalue));
		return element;
	}
	public void insertValues(WebElement element, String values) {
		element.sendKeys(values);
	}
	public void buttonClick(WebElement element) {
		element.click();
	}
	public WebElement id(String idvalues) {
		WebElement element = driver.findElement(By.id(idvalues));
		return element;
	}
	public void windowmax() {
		driver.manage().window().maximize();
	}
	public void frameSwitch(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void sendKeyEnter(WebElement element,String values) {
		element.sendKeys(values,Keys.ENTER);
	}
	public  void screenShot(String name) throws IOException {
		TakesScreenshot tk= (TakesScreenshot)driver;
		File scr = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Balachandar\\java & selenium\\Selenium\\ScreenShot\\"+name+".png");
		FileUtils.copyFile(scr,des);
	}
	public void allSelectedOption(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {	
			WebElement x = options.get(i);
			String text = x.getText();
			System.out.println(text);
		}
	}
	public WebElement name(String namevalue) {
		WebElement element = driver.findElement(By.name(namevalue));
		return element;
	}
	public WebElement tag(String tagname) {
		WebElement element = driver.findElement(By.tagName(tagname));
		return element;
	}
	public void quit() {
		driver.close();
	}
	public void getsleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void navi(String naviName) {
		driver.navigate().to(naviName);
	}
	public void naviBack() {
		driver.navigate().back();
	}
	
	public void naviforword() {
		driver.navigate().forward();
	}
	public void naviRefresh() {
		driver.navigate().refresh();
	}
	public void setfolderdk(String foldername ) {
		 fi=new File(foldername);
		fi.mkdir();
	}
	public void setfile(String filename) {
		 fi=new File(filename);
	}
	public void filewrite() {
		boolean canWrite = fi.canWrite();
		System.out.println(canWrite);
	}
	public void fileread() {
		boolean canRead = fi.canRead();
		System.out.println(canRead);
	}
	public void fileexists() {
		boolean exists = fi.exists();
		System.out.println(exists);
	}
	public void filelocation() {
		String filepath = fi.getPath();
		System.out.println(filepath);
	}
	public void fileis() {
		boolean file1 = fi.isFile();
		System.out.println(file1);
	}
	public void isdir() {
		boolean directory = fi.isDirectory();
		System.out.println(directory);
	}
	public void incfile() {
		File[] listFiles = fi.listFiles();
		System.out.println(listFiles);
}
	public void gettheText(WebElement element) {
		element.getText();
	}
	public void robotEnter() {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
	}
	public void alert() {
		getalert = driver.switchTo().alert();
	}
	public void simpleAlert() {
		getalert.accept();
	}
	public void confirmAlert() {
		getalert.dismiss();
	}
	public void promptAlert(String value) {
		getalert.sendKeys(value);
	}

	public void actionDoubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}