package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePageUnderPackagepage {

	/*---------Declaration------------*/
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtbx;
	
	@FindBy(name = "sampleTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deletebtn;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public ManagePageUnderPackagepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	public WebElement getSearchtbx() {
		return searchtbx;
	}
	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}
}
