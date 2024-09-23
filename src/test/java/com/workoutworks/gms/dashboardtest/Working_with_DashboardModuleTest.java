package com.workoutworks.gms.dashboardtest;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.workoutworks.gms.generic.baseclass.BaseClass;
import com.workoutworks.gms.generic.objectrepositoryutility.CategoriesPage;
import com.workoutworks.gms.generic.objectrepositoryutility.Dashboardpage;
import com.workoutworks.gms.generic.objectrepositoryutility.Homepage;
import com.workoutworks.gms.generic.objectrepositoryutility.PackageTypePage;
import com.workoutworks.gms.generic.webdriverutility.JavaUtility;

/**
 * @author Chetan
 * This class involved in Dashboard module
 */
@Listeners(com.workoutworks.gms.generic.listenerutility.ListenerImplimentationClass.class)
public class Working_with_DashboardModuleTest extends BaseClass{

	@Test(groups = "smoketest")
	/**
	 * Involved in category creation, deletion and confirmation by using "List Categories" available in bashboard
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createCategoryAndDeleteTest() throws Throwable, IOException {
		/*----Object Creation----*/
		Homepage hp= new Homepage(driver);
		Dashboardpage dp= new Dashboardpage(driver);
		CategoriesPage cp= new CategoriesPage(driver);

		/*---Waiting to page to load---*/
		wu.waitUtilPageloads(driver);

		/*---Clicking on Categories link---*/
		dp.getCategoriesLink().click();

		/*-----Getting data from Excel---*/
		String expectCategory = eu.getDataFromExcel("sheet1",1,2) + ju.randomNum();

		/*--------Sending data to category text box---------*/
		cp.getAddCategorytbx().sendKeys(expectCategory);
		cp.getSumbitbtn().click();

		/*-------Confirmation msg on creation of category-----*/
		String actualconfirmation = cp.getConfirmationPopUp().getText();
		String expectedConfirmation= eu.getDataFromExcel("sheet1",1,4);
		assertEquals(actualconfirmation, expectedConfirmation);
		System.out.println(actualconfirmation+"<======>"+expectedConfirmation);

		/*-------Confirmation category from table--------*/
		String actualCategory = driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[2]")).getText();
		System.out.println(actualCategory+"<======>"+expectCategory);
		assertEquals(actualCategory, expectCategory);

		/*--------Delete the category and confirmation of deletion-------*/
		wu.scrollToPagebottom(driver);
		driver.findElement(By.xpath("//tr[*]/td[2][text()='"+expectCategory+"']/following::td//button[@class='btn btn-danger']")).click();

		String expectedAlerttext= eu.getDataFromExcel("sheet1",1,5);
		String actualAlerttext = wu.switchToAlertGetTextAccept(driver);
		System.out.println(actualAlerttext);
		assertEquals(actualAlerttext, expectedAlerttext);
	}

	@Test(groups = "regressiontest")
	/**
	 * Involved in "PackageType" creation with category, deletion and confirmation by using "List Categories" available in bashboard.
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createPackageTypeAndDeletingWithCategoryTest() throws EncryptedDocumentException, IOException, InterruptedException {

		/*----Object Creation----*/
		Homepage hp= new Homepage(driver);
		Dashboardpage dp= new Dashboardpage(driver);
		CategoriesPage cp= new CategoriesPage(driver);
		PackageTypePage ptp= new PackageTypePage(driver);

		/*---Waiting to page to load---*/
		wu.waitUtilPageloads(driver);

		/*---Clicking on Categories link---*/
		dp.getCategoriesLink().click();

		/*-----Getting data from Excel---*/
		String expectCategory = eu.getDataFromExcel("sheet1",1,2) + ju.randomNum();

		/*--------Sending data to category text box---------*/
		cp.getAddCategorytbx().sendKeys(expectCategory);
		cp.getSumbitbtn().click();

		/*-------Clicking on "Dashboard" and list of "Package Type"------*/
		hp.getDashboardopt().click();
		dp.getPackagetypeLink().click();

		/*-------Selecting Category from Dropdown and creating package-------*/
		ptp.getAddCategoryDD().click();
		wu.selectBytext(ptp.getAddCategoryDD(), expectCategory);
		String expectedPackageType = eu.getDataFromExcel("sheet1",1,3);
		ptp.getAddPackageTbx().sendKeys(expectedPackageType);
		ptp.getSumbitbtn().click();

		/*---------Confirmation "Category" and "PackageType" from table-------------*/
		String actualCategory2 = driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[2]")).getText();
		System.out.println(actualCategory2+"<======>"+expectCategory);
		assertEquals(actualCategory2, expectCategory);

		String actualPackageType = driver.findElement(By.xpath("(//tr[*])[position()=last()]/td[3]")).getText();
		System.out.println(actualPackageType+"<======>"+expectedPackageType);
		assertEquals(actualPackageType, expectedPackageType);


		/*--------Delete the package Type with category-------*/
		wu.scrollToPagebottom(driver);

		driver.findElement(By.xpath("//tbody[last()]//td[text()='"+expectCategory+"']/following-sibling::td[last()]/a")).click();
		String expectedAlerttext= eu.getDataFromExcel("sheet1",1,5); 
		String actualAlertText = wu.switchToAlertGetTextAccept(driver);
		System.out.println(actualAlertText);
		assertEquals(actualAlertText,expectedAlerttext);

	}

}
