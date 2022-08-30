package com.inetBanking.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadConfig;

//@slf4j
public class BaseClass {

	ReadConfig rc = new ReadConfig();

	// public String baseURL = rc.getApplicationURL();
	// public String username = rc.getusername();
	// public String passwrd = rc.getpwd();
	public static WebDriver driver;
	public String url;
	public static Logger logger;

	@BeforeSuite(alwaysRun = true)
	public void setup() {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\jagalram\\New
		// folder\\inetBankingV1\\Drivers\\chromedriver.exe");
		logger = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4j.properties");
		 driver = BrowserFactory.getDefaultDriver();
		 launchApplication();

	}

	
	public void launchApplication() {
		url = ReadConfig.getApplicationURL();
		// Launching Application URL
		driver.get(url);
		logger.info("URL is opening");
		logger.info("Application is launched and It is up and running");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		//driver.quit();
	}

	public void CaptureScreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot s = (TakesScreenshot) driver;
		File source = s.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

}
