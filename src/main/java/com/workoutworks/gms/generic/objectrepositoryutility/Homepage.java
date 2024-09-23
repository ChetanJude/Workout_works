package com.workoutworks.gms.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Chetan
 */
public class Homepage {
	
	/**------Declaration-------**/
	@FindBy(xpath = "//a[@href='login.php']/p[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='app-sidebar__toggle']")
	private WebElement hamburgarLink;
	
	@FindBy(xpath = "//a[ @class='app-nav__item' and contains(text(),'Welcome : Admin ')]")
	private WebElement profileMenuLink;
	
	@FindBy(xpath = "//a[contains(text(),'Password')]")
	private WebElement changePasswordLink;
	
	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	private WebElement profileLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logoutLink;
	
	/*------Dashboard-------*/
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardopt;
	
	/*-----Category------*/	
	@FindBy(xpath = "//span[text()='Category']")
	private WebElement categoryopt;
	
	@FindBy(xpath = "//a[contains(text(),' Add Category')]")
	private WebElement addCategoryopt;
	
	/*-----Package Type-------*/
	@FindBy(xpath = "//span[text()='Package Type']")
	private WebElement packageTypeopt;
	
	@FindBy(xpath = "//a[contains(text(),'Add Package')]")
	private WebElement addpackagetypeopt;
	
	/*-----Package-------*/
	@FindBy(xpath = "//span[text()='Package']")
	private WebElement packageopt;
	
	@FindBy(xpath = "//a[text()='Add']")
	private WebElement addPackageopt;
	
	@FindBy(xpath = "//a[contains(text(),'Manage')]")
	private WebElement managePackageopt;
	
	/*-----Booking History-------*/
	@FindBy(xpath = "//span[text()='Booking History']")
	private WebElement bookingHistoryopt;
	
	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newBookingsopt;
	
	@FindBy(xpath = "//a[contains(text(),'Partial Payment')]")
	private WebElement partialBookingsopt;
	
	@FindBy(xpath = "//a[contains(text(),'Full Payment')]")
	private WebElement fullPaymentBookingsopt;
	
	@FindBy(xpath = "//a[contains(text(),'All')]")
	private WebElement allPaymentBookingsopt;
	
	/*------Report------*/
	
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement reportopt;
	
	@FindBy(xpath = "//a[contains(text(),'Booking Report')]")
	private WebElement bookingReportopt;
	
	@FindBy(xpath = "//a[contains(text(),'Registration Report')]")
	private WebElement registrationReportopt;
	
	
	/**------Lazy initialization------**/
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/**------------------Utilization (Getter method)--------------------------**/
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getHamburgarLink() {
		return hamburgarLink;
	}
	public WebElement getProfileMenuLink() {
		return profileMenuLink;
	}
	public WebElement getChangePasswordLink() {
		return changePasswordLink;
	}
	public WebElement getProfileLink() {
		return profileLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getCategoryopt() {
		return categoryopt;
	}
	public WebElement getAddCategoryopt() {
		return addCategoryopt;
	}
	public WebElement getPackageTypeopt() {
		return packageTypeopt;
	}
	public WebElement getAddpackagetypeopt() {
		return addpackagetypeopt;
	}
	public WebElement getPackageopt() {
		return packageopt;
	}
	public WebElement getAddPackageopt() {
		return addPackageopt;
	}
	public WebElement getManagePackageopt() {
		return managePackageopt;
	}
	public WebElement getBookingHistoryopt() {
		return bookingHistoryopt;
	}
	public WebElement getNewBookingsopt() {
		return newBookingsopt;
	}
	public WebElement getPartialBookingsopt() {
		return partialBookingsopt;
	}
	public WebElement getFullPaymentBookingsopt() {
		return fullPaymentBookingsopt;
	}
	public WebElement getAllPaymentBookingsopt() {
		return allPaymentBookingsopt;
	}
	public WebElement getReportopt() {
		return reportopt;
	}
	public WebElement getBookingReportopt() {
		return bookingReportopt;
	}
	public WebElement getRegistrationReportopt() {
		return registrationReportopt;
	}
	public WebElement getDashboardopt() {
		return dashboardopt;
	}
	
	
	/*------------------Business Logic--------------------------*/

	public void logout()
	{
		profileMenuLink.click();
		logoutLink.click();
	}
	
	public void categoryAndAddCategory() throws InterruptedException {
		categoryopt.click();
		addCategoryopt.click();
	}
	
	public void packageTypeAndAddPackage() {
		packageTypeopt.click();
		addpackagetypeopt.click();
	}
	
	public void packageAndAdd() {
		packageopt.click();
		addPackageopt.click();
	}
	
	public void packageAndManage() {
		packageopt.click();
		managePackageopt.click();
	}
	
	public void bookingHistoryAndNew() {
		bookingHistoryopt.click();
		newBookingsopt.click();
	}
	public void bookingHistoryAndPartial() {
		bookingHistoryopt.click();
		partialBookingsopt.click();
	}
	public void bookingHistoryAndFull() {
		bookingHistoryopt.click();
		fullPaymentBookingsopt.click();
	}
	public void bookingHistoryAndAll() {
		bookingHistoryopt.click();
		allPaymentBookingsopt.click();
	}
	
	public void reportAndBookingReport() {
		reportopt.click();
		bookingReportopt.click();
	}
	public void reportAndRegistrationReport() {
		reportopt.click();
		registrationReportopt.click();
	}
}
