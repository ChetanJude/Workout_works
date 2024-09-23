package com.workoutworks.gms.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.workoutworks.gms.generic.baseclass.BaseClass;
import com.workoutworks.gms.generic.fileutility.FileUtility;
import com.workoutworks.gms.generic.objectrepositoryutility.AddPageUnderPackagePage;
import com.workoutworks.gms.generic.objectrepositoryutility.Homepage;
import com.workoutworks.gms.generic.objectrepositoryutility.LoginPage;

@Listeners(com.workoutworks.gms.generic.listenerutility.ListenerImplimentationClass.class)
public class Test{

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		FileUtility fu= new FileUtility();
		String url = fu.getDataFromPropertyFile("url");
		String browser = fu.getDataFromPropertyFile("browser");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		
		if(browser.contains("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.contains("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		LoginPage lp= new LoginPage(driver);
		Homepage hp= new Homepage(driver);
		int time = 4000;
		lp.loginToApp(url, username, password);
		
		  hp.categoryAndAddCategory(); 
			/*
			 * Thread.sleep(time); hp.packageTypeAndAddPackage(); Thread.sleep(time);
			 */
		 
		
		/*
		 * hp.packageAndAdd(); AddPageUnderPackagePage ap= new
		 * AddPageUnderPackagePage(driver); ap.getDescriptionTBX().sendKeys("Hello");
		 */
		
		/*
		 * Thread.sleep(time); hp.packageAndManage(); Thread.sleep(time);
		 * hp.bookingHistoryAndNew(); Thread.sleep(time); hp.bookingHistoryAndPartial();
		 * Thread.sleep(time); hp.bookingHistoryAndFull(); Thread.sleep(time);
		 * hp.bookingHistoryAndAll(); Thread.sleep(time); hp.reportAndBookingReport();
		 * Thread.sleep(time); hp.reportAndRegistrationReport(); Thread.sleep(time);
		 */
	
		/*
		 * hp.logout(); driver.quit();
		 */
	}

}
