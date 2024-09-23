package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PackageTypePage {
	
	/*---------Declaration------------*/
	@FindBy(id = "category")
	private WebElement addCategoryDD;
	
	@FindBy(id = "addPackage")
	private WebElement addPackageTbx;
	
	@FindBy(id = "submit")
	private WebElement sumbitbtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtbx;
	
	@FindBy(name = "sampleTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deletebtn;

	
	/*---------Initialization------------*/
	WebDriver driver;
	public PackageTypePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getAddCategoryDD() {
		return addCategoryDD;
	}
	public WebElement getAddPackageTbx() {
		return addPackageTbx;
	}
	public WebElement getSumbitbtn() {
		return sumbitbtn;
	}
	public WebElement getSearchtbx() {
		return searchtbx;
	}
	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
}
