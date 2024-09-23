package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	@FindBy(id = "name")
	private WebElement nameTBX;
	
	@FindBy(id="email")
	private WebElement emailTBX;
	
	@FindBy(id = "mobile")
	private WebElement mobileTBX;
	
	@FindBy(id = "reg")
	private WebElement regDateTBX;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getNameTBX() {
		return nameTBX;
	}
	public WebElement getEmailTBX() {
		return emailTBX;
	}
	public WebElement getMobileTBX() {
		return mobileTBX;
	}
	public WebElement getRegDateTBX() {
		return regDateTBX;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
