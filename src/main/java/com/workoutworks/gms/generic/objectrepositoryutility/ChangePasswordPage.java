package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
	/*---------Declaration------------*/
	@FindBy(id="password")
	private WebElement oldPasswordTBX;
	
	@FindBy(id="newpassword")
	private WebElement newPasswordTBX;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmationPasswordTBX;
	
	@FindBy(id = "submit")
	private WebElement submitTBX;
	
	/*---------Initialization------------*/
	WebDriver driver;
	public ChangePasswordPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Utilization------------*/
	public WebElement getOldPasswordTBX() {
		return oldPasswordTBX;
	}
	public WebElement getNewPasswordTBX() {
		return newPasswordTBX;
	}
	public WebElement getConfirmationPasswordTBX() {
		return confirmationPasswordTBX;
	}
	public WebElement getSubmitTBX() {
		return submitTBX;
	}
}
