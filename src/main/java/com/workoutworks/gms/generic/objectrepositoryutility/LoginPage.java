package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="email")
	private WebElement usernametbx;
	
	@FindBy(id="password")
	private WebElement passwordtbx;
	
	@FindBy(id="submit")
	private WebElement loginbtn;
	
	@FindBy(xpath ="//a[text()='Back to Home Page']")
	private WebElement homepagelnk;
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHomepagelnk() {
		return homepagelnk;
	}
	public void setHomepagelnk(WebElement homepagelnk) {
		this.homepagelnk = homepagelnk;
	}
	public WebElement getUsernametbx() {
		return usernametbx;
	}
	public WebElement getPasswordtbx() {
		return passwordtbx;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void loginToApp(String url, String username, String password) {
		driver.get(url);
		usernametbx.sendKeys(username);
		passwordtbx.sendKeys(password);
		loginbtn.click();
	}
	
}
