package com.workoutworks.gms.usertest;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.workoutworks.gms.generic.baseclass.BaseClass;
import com.workoutworks.gms.generic.objectrepositoryutility.AddPageUnderPackagePage;
import com.workoutworks.gms.generic.objectrepositoryutility.CategoriesPage;
import com.workoutworks.gms.generic.objectrepositoryutility.Dashboardpage;
import com.workoutworks.gms.generic.objectrepositoryutility.Homepage;
import com.workoutworks.gms.generic.objectrepositoryutility.LoginPage;
import com.workoutworks.gms.generic.objectrepositoryutility.PackageTypePage;
import com.workoutworks.gms.generic.objectrepositoryutility.UserLoginPage;
import com.workoutworks.gms.generic.objectrepositoryutility.UserRegistrationPage;
import com.workoutworks.gms.generic.webdriverutility.UtilityClassObject;

/**
 * @author Chetan
 */
@Listeners(com.workoutworks.gms.generic.listenerutility.ListenerImplimentationClass.class)
public class Working_With_PricingPlanModuleTest extends BaseClass {

	@Test(groups = "smoketest")
	/**
	 * Involved in User booking the pricing Plansand confirmation of creation Alert and in "Manage" page too. Also
	 * validating the same with Assertion.
	 * @throws Throwable
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public void bookingPricingPlanWithPackagecreationTest() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		/*----Object Creation----*/
		Homepage hp = new Homepage(driver);
		Dashboardpage dp = new Dashboardpage(driver);
		CategoriesPage cp = new CategoriesPage(driver);
		LoginPage lp= new LoginPage(driver);
		PackageTypePage ptp = new PackageTypePage(driver);
		AddPageUnderPackagePage appp = new AddPageUnderPackagePage(driver);
		UserLoginPage ulp = new UserLoginPage(driver);
		UserRegistrationPage urp= new UserRegistrationPage(driver);

		/*---Clicking on Categories link---*/
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on Categories link");
		dp.getCategoriesLink().click();

		/*-----Getting data from Excel---*/
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from Excel");
		String expectCategory = eu.getDataFromExcel("sheet1", 1, 2) + ju.randomNum();

		/*--------Sending data to category text box---------*/
		UtilityClassObject.getTest().log(Status.INFO, "Sending data to category text box");
		cp.getAddCategorytbx().sendKeys(expectCategory);
		cp.getSumbitbtn().click();

		/*-------Clicking on "Dashboard" and list of "Package Type"------*/
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on 'Dashboard' and list of 'Package Type'");
		hp.getDashboardopt().click();
		dp.getPackagetypeLink().click();

		/*-------Selecting Category from Dropdown and creating package-------*/
		UtilityClassObject.getTest().log(Status.INFO, "Selecting Category from Dropdown and creating package");
		ptp.getAddCategoryDD().click();
		wu.selectBytext(ptp.getAddCategoryDD(), expectCategory);
		String expectedPackageType = eu.getDataFromExcel("sheet1", 1, 3);
		ptp.getAddPackageTbx().sendKeys(expectedPackageType);
		ptp.getSumbitbtn().click();

		/*-------Clicking on "Add"page under "Package" option------*/
		UtilityClassObject.getTest().log(Status.INFO, "Clicking on 'Add' page under 'Package' option");
		hp.packageAndAdd();

		/*---------Selecting category in category dropdown component--------*/
		UtilityClassObject.getTest().log(Status.INFO, "Selecting category in category dropdown component");
		appp.getCategoryDD().click();
		wu.selectBytext(appp.getCategoryDD(), expectCategory);

		/*---Selecting Package Type in Package Type Dropdown component---*/
		UtilityClassObject.getTest().log(Status.INFO, "Selecting Package Type in Package Type Dropdown component");
		appp.getPackageTypeDD().click();
		wu.selectBytext(appp.getPackageTypeDD(), expectedPackageType);

		/*---Entering all the data in the fields in "Add" under "package" page--*/
		UtilityClassObject.getTest().log(Status.INFO, "Entering all the data in the fields in 'Add' under 'package' page");
		appp.getTitleNameTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 6));
		appp.getPackageDurationTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 7));
		appp.getPriceTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 8));
		appp.getDescriptionTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 9));
		wu.scrollToPagebottom(driver);
		appp.getSubmitBtn().click();
		
		/*---------Alert Confirmation of package creation and explicit wait---------*/
		UtilityClassObject.getTest().log(Status.INFO, "Alert Confirmation of package creation and explicit wait");
		wu.waitUntilAlertIsPresent(driver);
		wu.switchToAlertAndAccept(driver);
		
		/*-------Logout from Admin module and navigate to Homepage-------*/
		UtilityClassObject.getTest().log(Status.INFO, "Logout from Admin module and navigate to Homepage");
		hp.logout();
		ju.zoomOutPage(driver);
		lp.getHomepagelnk().click();
		
		/*-------Click on User Login--------*/
		UtilityClassObject.getTest().log(Status.INFO, "Click on User Login");
		hp.getLoginBtn().click();
		ju.zoomOutPage(driver);
		ulp.getRegistrationBtn().click();
		
		/*----------Entering all the user details for registration----------*/
		UtilityClassObject.getTest().log(Status.INFO, "Entering all the user details for registration");
		urp.getFirstNameTbx().sendKeys(eu.getDataFromExcel("UserDetails", 1, 0));
		urp.getLastNameTbx().sendKeys(eu.getDataFromExcel("UserDetails", 1, 1));
		String userEmail = eu.getDataFromExcel("UserDetails", 1, 2) +ju.randomNum();
		urp.getEmailTbx().sendKeys(userEmail);
		urp.getMobileTbx().sendKeys(eu.getDataFromExcel("UserDetails", 1, 3) +ju.randomNum());
		urp.getStateTbx().sendKeys(eu.getDataFromExcel("UserDetails", 1, 4));
		urp.getCityTbx().sendKeys(eu.getDataFromExcel("UserDetails", 1, 5));
		String userPassword = eu.getDataFromExcel("UserDetails", 1, 6);
		urp.getPasswordTbx().sendKeys(userPassword);
		urp.getConfirmPasswordTbx().sendKeys(userPassword);
		urp.getRegisterNowBtn().click();
		
		/*---------Alert Confirmation of Registration successful---------*/
		UtilityClassObject.getTest().log(Status.INFO, "Alert Confirmation of Registration successful");
		String expectedRegisterAlertTxt=eu.getDataFromExcel("UserDetails", 1, 8);
		String actualRegisterAlertTxt = wu.switchToAlertGetTextAccept(driver);
		assertEquals(actualRegisterAlertTxt, expectedRegisterAlertTxt);
		
		/*-------Login to user account and booking the package------*/
		UtilityClassObject.getTest().log(Status.INFO, "Login to user account and booking the package");
		ulp.getEmailTbx().sendKeys(userEmail);
		ulp.getPasswordTbx().sendKeys(userPassword);
		ulp.getLoginBtn().click();
		driver.findElement(By.xpath("//h4[text()='FestivalOffer']/parent::div/following-sibling::form/input[@name='submit']")).click();
		wu.switchToAlertAndAccept(driver);
		wu.waitUntilAlertIsPresent(driver);
		wu.switchToAlertGetTextAccept(driver);
		driver.findElement(By.xpath("//tbody//child::td[text()='FestivalOffer']/following-sibling::td[last()]/a")).click();
		
		/*-----------Waiting till URL contains booking ID and take Screen-------------*/
		UtilityClassObject.getTest().log(Status.INFO, "Waiting till URL contains booking ID and take Screen");
		  wu.waitURLContains(driver, "bookingid"); wu.getScreenShot(driver);
		 
	}
}
