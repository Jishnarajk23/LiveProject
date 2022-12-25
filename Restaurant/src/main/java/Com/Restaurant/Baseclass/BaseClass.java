package Com.Restaurant.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Com.Restaurant.Action.ActionClass;
import Com.Restaurant.PageObject.CategoriesPage;
import Com.Restaurant.PageObject.LoginPage;
import Com.Restaurant.PageObject.PeoplePage;
import Com.Restaurant.PageObject.ProductPage;
import Com.Restaurant.PageObject.ReportPage;
import Com.Restaurant.PageObject.SelectLanguage;
import Com.Restaurant.PageObject.StoresPage;
import Com.Restaurant.Utilities.ExcelRead;
import Com.Restaurant.Utilities.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static ActionClass action;
	public static LoginPage Lp;
	public static PeoplePage Pp;
	public static ProductPage ProPp;
	public static ReportPage Rp;
	public static StoresPage Sp;
	public static CategoriesPage Cp;
	public static SelectLanguage Sl;
	public static ExcelRead Excel;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite(groups = "SMK")
	public void beoreSuite() 
	{
		ExtentReport.setExtent();
	}

	@BeforeTest(groups = "SMK")
	public void loadConfig() 
	{

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() 
	{
		return driver.get();
	}

	@Parameters("Browser")
	@BeforeMethod(groups = "SMK")
	public void FirstCall(String browser)
	{
		launchApp(browser);
		Lp = new LoginPage();
		Pp = new PeoplePage();
		ProPp = new ProductPage();
		Rp = new ReportPage();
		Sp = new StoresPage();
		Cp = new CategoriesPage();
		Sl = new SelectLanguage();
		Excel= new ExcelRead();
	}

	public void launchApp(String browserName)
	{
		// String browserName = prop.getProperty("Broswer");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver=new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		action = new ActionClass();
		// Implicit TimeOuts
		action.implicitWait(getDriver(), 10);
		// PageLoad TimeOuts
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}

	@DataProvider
	public Object[][] InvalidLoginDatas() 
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "uname";
		data[0][1] = "password";
		data[1][0] = "uname";
		data[1][1] = "pword";
		data[2][0] = "Admin";
		data[2][1] = "pasword";
		return data;
	}

	@AfterMethod(groups = "SMK")
	public void DriverClose() 
	{
		getDriver().close();
	}

	@AfterSuite(groups = "SMK")
	public void AfterSuit()
	{
		ExtentReport.endReport();

	}

}
