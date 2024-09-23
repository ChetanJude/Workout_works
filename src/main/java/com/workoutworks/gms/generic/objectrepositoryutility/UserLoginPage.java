package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Chetan
 */
public class UserLoginPage {

	/**------Declaration-------**/
	@FindBy(id = "email")
	private WebElement emailTbx;
	
	@FindBy(id = "password")
	private WebElement passwordTbx;
	
	@FindBy(id = "submit")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Registration']")
	private WebElement registrationBtn;
	
	@FindBy(xpath = "//div[@class='back-to-top']")
	private WebElement backToTopBtn;
	
	/**------Lazy initialization------**/
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**------------------Utilization (Getter method)--------------------------**/
	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getRegistrationBtn() {
		return registrationBtn;
	}

	public WebElement getBackToTopBtn() {
		return backToTopBtn;
	}

}
