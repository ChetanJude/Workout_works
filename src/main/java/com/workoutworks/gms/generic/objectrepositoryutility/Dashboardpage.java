package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {
	@FindBy(xpath ="//div[contains(@class,'widget-small')]//h4[contains(text(),'Categories')]")
	private WebElement categoriesLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'Package Type')]")
	private WebElement packagetypeLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'Packages')]")
	private WebElement packageLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'Total Bookings')]")
	private WebElement totalBookingsLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'New Bookings')]")
	private WebElement newBookingsLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'Partial')]")
	private WebElement partialPaymentBookingsLink;
	
	@FindBy(xpath="//div[contains(@class,'widget-small')]//h4[contains(text(),'Full Payment')]")
	private WebElement fullPaymentBookingsLink;
	
	WebDriver driver;
	public Dashboardpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCategoriesLink() {
		return categoriesLink;
	}
	public WebElement getPackagetypeLink() {
		return packagetypeLink;
	}
	public WebElement getPackageLink() {
		return packageLink;
	}
	public WebElement getTotalBookingsLink() {
		return totalBookingsLink;
	}
	public WebElement getNewBookingsLink() {
		return newBookingsLink;
	}
	public WebElement getPartialPaymentBookingsLink() {
		return partialPaymentBookingsLink;
	}
	public WebElement getFullPaymentBookingsLink() {
		return fullPaymentBookingsLink;
	}	
}
