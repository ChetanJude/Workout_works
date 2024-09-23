package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPageUnderPackagePage {

	/*---------Declaration------------*/
	@FindBy(id = "category")
	private WebElement categoryDD;
	
	@FindBy(id = "package")
	private WebElement packageTypeDD;
	
	@FindBy(id = "titlename")
	private WebElement titleNameTBX;
	
	@FindBy(name = "packageduratiobn")
	private WebElement packageDurationTBX;
	
	@FindBy(id = "Price")
	private WebElement priceTBX;
	
	@FindBy(xpath = "//div[contains(@class,' nicEdit-main')]")
	private WebElement descriptionTBX;
	
	@FindBy(id = "Submit")
	private WebElement submitBtn;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public AddPageUnderPackagePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getCategoryDD() {
		return categoryDD;
	}
	public WebElement getPackageTypeDD() {
		return packageTypeDD;
	}
	public WebElement getTitleNameTBX() {
		return titleNameTBX;
	}
	public WebElement getPackageDurationTBX() {
		return packageDurationTBX;
	}
	public WebElement getPriceTBX() {
		return priceTBX;
	}
	public WebElement getDescriptionTBX() {
		return descriptionTBX;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
