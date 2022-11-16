package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver d;
		public static Actions ac;
		public static Robot r;
	

	public static void ChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
	}
	
	public static void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		d=new FirefoxDriver();
	}
	
	public static void urlLaunch(String url) {
		d.get(url);
	}
	
	public static void maxWindow() {
		d.manage().window().maximize();
	}
	
	public static void miniWindow() {
		d.manage().window().minimize();
	}
	
	public static void passValues(WebElement ele, String s) {
		ele.sendKeys(s);
	}
	
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	
	public static void toRightClick(WebElement ele) {
		ac=new Actions(d);
		ac.contextClick(ele).perform();
	}
	
	public static void toDoubleClick(WebElement ele) {
		ac = new Actions(d);
		ac.contextClick(ele).perform();
	}
	
	public static void toMouseOver(WebElement ele) {
		ac=new Actions(d);
		ac.moveToElement(ele).perform();
	}
	
	public static void toDragAndDrop(WebElement src,WebElement des) {
		ac=new Actions(d);
		ac.dragAndDrop(src, des).perform();
	}
	
	public static void toCopy() throws AWTException {
		r=new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void toTakeSnap(String name) throws IOException {
		TakesScreenshot tk =(TakesScreenshot)d;
		File f =tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Venkatanathan\\eclipse-workspace\\MavenProject\\ScreenShot\\"+name+".png");
		FileUtils.copyFile(f, dest);
	}
	
	public static void toApplyImplicit(long s) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
	}
	
	public static String pageTitle() {
		String t = d. getTitle();
		return t;
	}
	
	public static String readFromExcel(String fname, String shname, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\Venkatanathan\\eclipse-workspace\\MavenProject\\folder\\"+fname+".xlsx");
		FileInputStream fin=new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(shname);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		
		String val;
		
		if (type==1) {
			val = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)){
			java.util.Date d= c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			val = sim.format(d);
		}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			val = String.valueOf(l);
		}
		
		return val;
		}
	
	public static void scrolldown(WebElement sd) {
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(true)", sd);
	}
	
	public static void scrollUp(WebElement su) {
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(false)", su);
	}
	
	public static void setAttribute(String s1, WebElement sa) {
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].setAttribute('value','"+s1+"')", sa);
	}
	
	public static void getAttribute(String s, WebElement ga) {
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("return arguments[0].getAttribute('"+s+"')", ga);
	}
	public static void jsClick(WebElement c) {
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].click()", c);
	}
	
	
	}
