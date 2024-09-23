package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
	
	
	/*---------Declaration------------*/
	@FindBy(id = "category")
	private WebElement addCategorytbx;
	
	@FindBy(xpath = "//input[@id = 'submit']")
	private WebElement sumbitbtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtbx;
	
	@FindBy(name = "sampleTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deletebtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirmationPopUp;
	
	@FindBy(xpath="//li[@class='paginate_button page-item active']")
	private WebElement pageNum;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public CategoriesPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getAddCategorytbx() {
		return addCategorytbx;
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
	public WebElement getConfirmationPopUp() {
		return confirmationPopUp;
	}

	public WebElement getPageNum() {
		return pageNum;
	}
}
