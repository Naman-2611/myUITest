/**
 * 
 */
package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.HomePage;
import com.pages.ScheduleYourDemopage;
import com.utilities.Utilities;

/**
 * @author This is Base class
 */
public class TestBase {
	
	public static final int MAX_WAIT_IN_SECONDS = 60;
	public static final int MAX_PAGE_LOAD_IN_SECONDS = 60;

	public static Properties properties;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static HomePage homePage;
	public static ScheduleYourDemopage scheduleYourDemopage;
	public static Logger logger;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	
	public TestBase() {

		try {
			properties = new Properties();
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/config/config.properties"));
			properties.load(fis);
		}
		catch (Exception e) {

		}
	}

	public static void launchBrowser() {

		if (properties.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (properties.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (properties.getProperty("Browser").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("");
		}
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		Utilities.implicitWait();
		Utilities.pageLoadTime();
		Utilities.waitforelement();
		driver.findElement(By.xpath("//a[@id='cookie-decline']")).click();
		driver.manage().deleteAllCookies();
	
	}
	
}
