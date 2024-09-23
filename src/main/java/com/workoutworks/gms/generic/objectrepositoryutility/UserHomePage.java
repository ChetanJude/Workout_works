package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	/**------Declaration--------**/
	@FindBy(xpath = "//p[text()='My Profile']")
	private WebElement myProfileLink;

	@FindBy(xpath = "//p[text()='Change Password']")
	private WebElement changePasswordLink;

	@FindBy(xpath = "//p[text()='Logout']")
	private WebElement logoutLink;

	/**------Lazy Initialization--------**/
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**------Utilization--------**/

	public WebElement getMyProfileLink() {
		return myProfileLink;
	}

	public WebElement getChangePasswordLink() {
		return changePasswordLink;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}


}
