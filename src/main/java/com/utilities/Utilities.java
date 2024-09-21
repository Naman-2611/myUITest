package com.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.TestBase;

public class Utilities extends TestBase {
	

	public static Select select;
	public static WebDriverWait waiter;
	
	public static String captureSS() {
	 
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			File dest = new File(currentDir + "/screenshots/" + "SS_" + System.currentTimeMillis() + ".jpg");
	 
			try {
				FileUtils.copyFile(source, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			return dest.getAbsolutePath();
		}
	
		public static String captureSSUsing64Base() {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			String source = screenshot.getScreenshotAs(OutputType.BASE64);
			return source;
		}
	 
		public static void implicitWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_WAIT_IN_SECONDS));
			
		}
		
		public static void pageLoadTime() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(MAX_PAGE_LOAD_IN_SECONDS));
		}
		
		public static void waitforelement() {
			waiter=new WebDriverWait(driver,Duration.ofSeconds(30));
		}
		
		
		public static void setText(WebElement element, String text) {
			waiter.until(ExpectedConditions.visibilityOf(element));
			setTextNoEnter(element, text);
			element.sendKeys(Keys.RETURN);
		}
		
		public void setTextToFieldNoEnter(By by, String text) {
			waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
			setTextNoEnter(findElement(by), text);
		}
		
		public  static void setTextNoEnter(WebElement element, String text) {
			
			waiter.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
		}
		
		public WebElement findElement(By by) {
			waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
			return driver.findElement(by);
		}
	 
		public static void selectDDByText(WebElement element, String text) {
			waiter.until(ExpectedConditions.visibilityOf(element));
			select = new Select(element);
			select.selectByVisibleText(text);
	 
		}
	 
		public static void selectDDByValue(WebElement element, String value) {
			waiter.until(ExpectedConditions.visibilityOf(element));
			select = new Select(element);
			select.selectByValue(value);
	 
		}
	 
		public static void selectDDByIndex(WebElement element, int index) {
			waiter.until(ExpectedConditions.visibilityOf(element));
			select = new Select(element);
			select.selectByIndex(index);
	 
		}
	 
		public static void generateReport(String reportHTMLPath, String reportTitle, String reportName) {
	 
			extentSparkReporter = new ExtentSparkReporter(reportHTMLPath);
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
	 
			extentSparkReporter.config().setDocumentTitle(reportTitle);
			extentSparkReporter.config().setTheme(Theme.DARK);
			extentSparkReporter.config().setReportName(reportName);
			extentSparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
	 
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Env", "QA");
			extentReports.setSystemInfo("Application Type", "Web");
			extentReports.setSystemInfo("Testing", "Smoke");
			extentReports.setSystemInfo("Tester", "Naman Kalra");
	 
		}
		
		public static void saveReport() {
			extentReports.flush(); 
		}
}
