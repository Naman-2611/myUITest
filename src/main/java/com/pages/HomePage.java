/**
 * 
 */
package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

/**
 * 
 */
public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='white-button hover_white w-inline-block']")
	@CacheLookup
	public WebElement lnkExploreMore;

	@FindBy(xpath = "//a[@class='red-button-2 red hover-black w-inline-block']")
	@CacheLookup
	public WebElement lnkScheduleYourDemo;

	@FindBy(xpath = "//div[@id='w-dropdown-toggle-7']//div[@class='dropdown-menu-text---brix'][normalize-space()='Products']")
	@CacheLookup
	public WebElement lnknavBar;

	public String getAppHomeTitle() {
		return driver.getTitle();
	}

	public boolean linklnkScheduleYourDemo() {
		return lnkScheduleYourDemo.isDisplayed();
	}

	public boolean linkExploreMore() {
		return lnkExploreMore.isDisplayed();

	}

	public boolean NavigationBarLinks() {

		return lnknavBar.isDisplayed();
	}

	public ScheduleYourDemopage goToScheduleYourDemopage() {
		lnkScheduleYourDemo.click();
		return new ScheduleYourDemopage();
	}

}
