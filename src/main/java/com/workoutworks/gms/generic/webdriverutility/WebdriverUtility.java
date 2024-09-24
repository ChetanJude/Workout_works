package com.workoutworks.gms.generic.webdriverutility;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void selectBytext(WebElement element, String text) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element, int num) {
		Select s= new Select(element);
		s.selectByIndex(num);
	}

	public void selectByValue(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}

	/*-------------synchronize Utility-------------------*/

	public void waitUtilPageloads(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void waitUntilAlertIsPresent(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitURLContains(WebDriver driver, String data) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.urlContains(data));
	}

	/*-----------------Page manage utility-----------------*/

	public void maximizePage(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizePage(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	public void scrollToPagebottom(WebDriver driver) {
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/*-------------Alert Utility--------------*/
	public String switchToAlertGetTextAccept(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		return text;
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	/*--------------Screenshot Utility--------------*/


	public void getScreenShot(WebDriver driver) throws IOException { 
		String date = new Date().toString().replace(" ","_").replace(":","_"); 
		TakesScreenshot ts= (TakesScreenshot)driver; 
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".//Screenshot//BookingScreen_"+date+".png");
		FileUtils.copyFile(scr, dst); }

}
