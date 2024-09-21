/**
 * 
 */
package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.ScheduleYourDemopage;
import com.utilities.ExcelData;
import com.utilities.Utilities;

/**
 * 
 */
public class ScheduleYourDemopageTest extends TestBase {

	public ScheduleYourDemopageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		logger = LogManager.getLogger(ScheduleYourDemopageTest.class);
		launchBrowser();
		homePage= new HomePage();
		scheduleYourDemopage = new ScheduleYourDemopage();
		homePage.goToScheduleYourDemopage();
		logger.info("Redirected to Schedule Your Demo page Page");

	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info(properties.getProperty("Browser") + " Browser Closed");
		}
	}

	@Test
	public void verifyScheduleYourDemopage() {
		String expectedTitle = "Property Management Software | Entrata";
		String actual = scheduleYourDemopage.VerifyScheduleYourDemopage();
		Assert.assertEquals(actual,expectedTitle, "Test Case Failed!!");
		logger.info("Registration Page TC1 - Verify Registration Page Text - Test case passed");
	}

	@Test(dataProvider = "data")
	public void scheduleYourDemopage(String fname, String lname, String email, String companyname, String phonenumber, String jobtitle
			) {
		scheduleYourDemopage.enterFirstName(fname);
		scheduleYourDemopage.enterLastName(lname);
		scheduleYourDemopage.enterEmail(email);
		scheduleYourDemopage.entercompanyname(companyname);
		scheduleYourDemopage.enterphonenumber(phonenumber);
		scheduleYourDemopage.enterjobtitle(jobtitle);
		Utilities.pageLoadTime();
		logger.info("Schedule Your Demo page Page TC2 - Test case passed");
	}

	@DataProvider(name = "data")
	public String[][] getExcelData() {
		ExcelData data = new ExcelData(System.getProperty("user.dir")+"/resources/testdata1.xlsx");
		int rows = data.getrowCount("Sheet1");
		int columns = data.getColumnCount("Sheet1", 1);

		String[][] demodata = new String[rows][columns];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < columns; j++) {
				demodata[i - 1][j] = data.getCellData("Sheet1", i, j);
			}
		}
		return demodata;
	}

}
