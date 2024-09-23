package com.workoutworks.gms.generic.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.workoutworks.gms.generic.fileutility.ExcelUtility;
import com.workoutworks.gms.generic.fileutility.FileUtility;
import com.workoutworks.gms.generic.objectrepositoryutility.Homepage;
import com.workoutworks.gms.generic.objectrepositoryutility.LoginPage;
import com.workoutworks.gms.generic.objectrepositoryutility.UserHomePage;
import com.workoutworks.gms.generic.webdriverutility.JavaUtility;
import com.workoutworks.gms.generic.webdriverutility.WebdriverUtility;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver edriver;
	public static WebDriver sdriver;
	public WebdriverUtility wu= new WebdriverUtility();
	public FileUtility fu= new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	public JavaUtility ju=new JavaUtility();


	@BeforeSuite(groups = {"smoke test","regression test"})
	public void configBS() {
		System.out.println("Connected to DataBase");
	}
	
	/* @Parameters("browser") */
	@BeforeClass(groups = {"smoke test","regression test"})
	public void configBC(/* String browserr */) throws IOException {

		String browser = /*browserr;*/
				System.getProperty("browser",fu.getDataFromPropertyFile("browser"));
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new FirefoxDriver();
		}
		sdriver = driver;
		wu.maximizePage(driver);
	}

	@BeforeMethod(groups = {"smoke test","regression test"})
	public void configBM() throws IOException{
		LoginPage lplib= new LoginPage(driver);
		String url = fu.getDataFromPropertyFile("url");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		lplib.loginToApp(url, username, password);

	}

	@AfterMethod(groups = {"smoke test","regression test"})
	public void configAM() {

		Homepage hp = null; 
		UserHomePage uhp=null; 
		String url = driver.getCurrentUrl();

		if(url.contains("admin")) {
			hp= new Homepage(driver);
			hp.logout(); 
		}else {
			uhp=new UserHomePage(driver); 
			uhp.getLogoutLink().click(); }

	}

	@AfterClass(groups = {"smoke test","regression test"})
	public void configAC() {
		driver.quit(); 
	}

	@AfterSuite(groups = {"smoke test","regression test"})
	public void configAS() {
		System.out.println("Disconnect the DB");
	}

}
