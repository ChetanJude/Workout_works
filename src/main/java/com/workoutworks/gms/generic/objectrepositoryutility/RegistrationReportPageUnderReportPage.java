package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationReportPageUnderReportPage {


	/*---------Declaration------------*/
	@FindBy(id = "fdate")
	private WebElement fromDateTBX;
	
	@FindBy(id = "todate")
	private WebElement toDateTBX;
	
	@FindBy(id = "Submit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtbx;
	
	@FindBy(name = "sampleTable_length")
	private WebElement showEntriesDD;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public RegistrationReportPageUnderReportPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getFromDateTBX() {
		return fromDateTBX;
	}
	public WebElement getToDateTBX() {
		return toDateTBX;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getSearchtbx() {
		return searchtbx;
	}
	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}
}
