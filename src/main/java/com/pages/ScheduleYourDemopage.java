/**
 * 
 */
package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utilities.Utilities;


public class ScheduleYourDemopage extends TestBase {
	
	public ScheduleYourDemopage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="FirstName")
	@CacheLookup
	public WebElement txtFirstName;
	
	@FindBy(name="LastName")
	@CacheLookup
	public WebElement txtLastName;
	
	@FindBy(name="Email")
	@CacheLookup
	public WebElement txtEmail;
	
	@FindBy(id="Company")
	@CacheLookup
	public WebElement txtComapanyname;
	
	@FindBy(name="Phone")
	@CacheLookup
	public WebElement txtphoneNo;
	
	@FindBy(id="Unit_Count__c")
	@CacheLookup
	public WebElement dropdownunitcount;
	
	@FindBy(id="Title")
	@CacheLookup
	public WebElement txtjobTitle;
	
	
	
	public String VerifyScheduleYourDemopage() {
		return driver.getTitle();
	}
	
	public void enterFirstName(String fname) {
		Utilities.setText(txtFirstName,fname);
	}
	public void enterLastName(String fname) {
		Utilities.setText(txtLastName,fname);
	}
	public void enterEmail(String fname ) {
		Utilities.setText(txtEmail,fname);
	}
	public void entercompanyname(String fname) {
		Utilities.setText(txtComapanyname,fname);
	}
	public void enterphonenumber(String fname) {
		Utilities.setText(txtphoneNo,fname);
	}
	public void enterjobtitle(String fname) {
		Utilities.setText(txtjobTitle,fname);
	}
	
}

