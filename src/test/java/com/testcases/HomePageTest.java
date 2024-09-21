/**
 * 
 */
package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;

/**
 * 
 */
public class HomePageTest extends TestBase {

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		logger = LogManager.getLogger(HomePage.class);
		launchBrowser();
		homePage= new HomePage();
		logger.info("Redirected to Home Page");
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			logger.info(properties.getProperty("Browser")+" Browser Closed");
		}

	}
	
	//Test Case 1: Home Page Title:
	//Verifies that the homepage loads by checking the title contains "Entrata."
	@Test(priority = 1)
	public void verifygetAppHomeTitle() {
		String expectedTitle = "Property Management Software | Entrata";
		String actual = homePage.getAppHomeTitle();
		Assert.assertTrue(actual.contains(expectedTitle), "Test Case Failed!!");
		logger.info("HomePage TC1 - Verify Homepage Title - Test case passed");
	}
	//Test Case 2: About Page Navigation:
	//Navigates to the "About" page and verifies the page title contains "About."
	@Test(priority = 2)
	public void verifylinkScheduleYourDemo() {
		boolean status = homePage.linklnkScheduleYourDemo();
		Assert.assertTrue(status, "Test Case Failed!!");
		logger.info("HomePage TC2 - Verify Link Schedule Your Demo is present - Test case passed");

	}
	
	// Test Case 3: 
	@Test(priority = 3)
	public void verifylinkExploreMore() {
		boolean status = homePage.linkExploreMore();
		Assert.assertTrue(status,"Test Case Failed!!");
		logger.info("LoginPage TC3 - Verify link Explore More - Test case passed");
	}
	
	//// Test Case 4: Verify that the navigation bar links are present
	@Test(priority = 4)
	public void testNavigationBarLinks() {
		boolean status = homePage.NavigationBarLinks();
		Assert.assertTrue(status,"Test Case Failed!!");
        logger.info("LoginPage TC4 - Verify link navigation bar - Test case passed");
    }
	
}
