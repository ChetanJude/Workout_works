package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Chetan
 */
public class UserRegistrationPage {
	/**------Declaration-------**/
	
	@FindBy(id = "fname")
	private WebElement firstNameTbx;
	
	@FindBy(id = "lname")
	private WebElement lastNameTbx;
	
	@FindBy(id = "email")
	private WebElement emailTbx;
	
	@FindBy(id = "mobile")
	private WebElement mobileTbx;
	
	@FindBy(id="state")
	private WebElement stateTbx;
	
	@FindBy(id="city")
	private WebElement cityTbx;
	
	@FindBy(id="password")
	private WebElement passwordTbx;
	
	@FindBy(id="RepeatPassword")
	private WebElement confirmPasswordTbx;
	
	@FindBy(id="submit")
	private WebElement registerNowBtn;
	
	@FindBy(xpath = "//div[@class='back-to-top']")
	private WebElement backToTopBtn;
	
	/**------Lazy initialization------**/
	public UserRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**------------------Utilization (Getter method)--------------------------**/
	public WebElement getFirstNameTbx() {
		return firstNameTbx;
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getMobileTbx() {
		return mobileTbx;
	}

	public WebElement getStateTbx() {
		return stateTbx;
	}

	public WebElement getCityTbx() {
		return cityTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getConfirmPasswordTbx() {
		return confirmPasswordTbx;
	}

	public WebElement getRegisterNowBtn() {
		return registerNowBtn;
	}

	public WebElement getBackToTopBtn() {
		return backToTopBtn;
	}

}
