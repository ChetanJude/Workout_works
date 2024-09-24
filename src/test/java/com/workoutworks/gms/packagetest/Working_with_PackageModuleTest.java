package com.workoutworks.gms.packagetest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
import com.workoutworks.gms.generic.objectrepositoryutility.PackageTypePage;
import com.workoutworks.gms.generic.webdriverutility.UtilityClassObject;
/**
 * @author Chetan
 * @throws Throwable
 * @throws IOException
 */
@Listeners(com.workoutworks.gms.generic.listenerutility.ListenerImplimentationClass.class)
public class Working_with_PackageModuleTest extends BaseClass {

	@Test(groups = "smoketest")
	/**
	 * Involved in "Package" creation and confirmation of creation Alert and in "Manage" page too. Also
	 * validating the same with Assertion.
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createPackageWithCategoryAndPackageTypeTest()
			throws EncryptedDocumentException, IOException, InterruptedException {
		/*----Object Creation----*/
		Homepage hp = new Homepage(driver);
		Dashboardpage dp = new Dashboardpage(driver);
		CategoriesPage cp = new CategoriesPage(driver);
		PackageTypePage ptp = new PackageTypePage(driver);
		AddPageUnderPackagePage appp = new AddPageUnderPackagePage(driver);

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
		
		/*-----------Getting confirmation is the 'package' is added-----------*/
		UtilityClassObject.getTest().log(Status.INFO, "Getting confirmation is the 'package' is added");
		String expectedAlertText = eu.getDataFromExcel("sheet1", 1, 10);
		String actualAlerttext = wu.switchToAlertGetTextAccept(driver);
		assertEquals(actualAlerttext, expectedAlertText);

		/*
		 * Getting confirmation for the created package in 'Manage' page under 'package'
		 * module
		 */
		UtilityClassObject.getTest().log(Status.INFO, "Getting confirmation for the created package in 'Manage' page under 'package'module");
		wu.scrollToPagebottom(driver);
		String actualCategory = driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[2]")).getText();
		assertEquals(actualCategory, expectCategory);
	}

	@Test(groups = "regressiontest")
	/**
	 * Involved in "Package" editing, confirmation with Alert and Validation with assertion.
	 * @throws Throwable
	 * @throws IOException
	 */
	public void editPackageInManagePageUnderPackageTest()
			throws EncryptedDocumentException, IOException, InterruptedException {
		/*----Object Creation----*/
		Homepage hp = new Homepage(driver);
		Dashboardpage dp = new Dashboardpage(driver);
		CategoriesPage cp = new CategoriesPage(driver);
		PackageTypePage ptp = new PackageTypePage(driver);
		AddPageUnderPackagePage appp = new AddPageUnderPackagePage(driver);

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

		/*-------Clicking on 'Add' page under 'Package' option------*/
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

		/*---Entering all the data in the fields in 'Add' under 'package' page--*/
		UtilityClassObject.getTest().log(Status.INFO, "Entering all the data in the fields in 'Add' under 'package' page");
		appp.getTitleNameTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 6));
		appp.getPackageDurationTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 7));
		appp.getPriceTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 8));
		appp.getDescriptionTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 9));
		wu.scrollToPagebottom(driver);
		appp.getSubmitBtn().click();
		
		/*----------Alert confirmation----------*/
		UtilityClassObject.getTest().log(Status.INFO, "Alert confirmation");
		wu.waitUntilAlertIsPresent(driver);
		wu.switchToAlertGetTextAccept(driver);


		/*--Getting confirmation for the created package in "Manage" page--*/ 
		UtilityClassObject.getTest().log(Status.INFO, "Alert confirmation");
		wu.scrollToPagebottom(driver);
		String actualCategory =driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[2]")).getText();
		assertEquals(actualCategory,expectCategory);
		
		/*Editing the create package and getting confirmation by assert*/
		UtilityClassObject.getTest().log(Status.INFO, "Editing the create package and getting confirmation by assert");
		driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[last()]/a")).click(); 
		appp.getPriceTBX().clear(); 
		appp.getPriceTBX().sendKeys(eu.getDataFromExcel("sheet1", 1, 12));
		wu.scrollToPagebottom(driver); 
		appp.getSubmitBtn().click(); 
		String expectedRecordAlertText = eu.getDataFromExcel("sheet1", 1, 11);
		String actualRecordAlertText = wu.switchToAlertGetTextAccept(driver);
		assertEquals(actualRecordAlertText,expectedRecordAlertText);
	}
}
