package com.inetBanking.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import com.inetBanking.utilities.ReadConfig;

public class BrowserFactory extends BaseClass {
	private static String browserName = "";

	public static WebDriver getDefaultDriver() {
		browserName = ReadConfig.getBrowser();
		if (browserName.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\jagalram\\New folder\\inetBankingV1\\Drivers\\chromedriver.exe");
			// initializing driver variable using ChromeDriver
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else if (browserName.equalsIgnoreCase("safari")) {

		} else if (browserName.equalsIgnoreCase("opera")) {

		} else {
			// IE
		}

		// maximized the browser window
		driver.manage().window().maximize();

		// Delete All cookies
		// driver.manage().deleteAllCookies();

		// // Pageload timeout
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//
		// // Implicit wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
