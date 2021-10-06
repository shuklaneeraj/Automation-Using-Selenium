package com.dxc.sale.test.framework.generic;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

	private static volatile WebDriverManager mgr = null;
	private WebDriver driver;
	
	private WebDriverManager() {
		initDriver();
	}
	
	public static WebDriverManager getstance() {
		if (mgr == null) {
	         synchronized(WebDriverManager.class) {
	            if (mgr == null) {
	               mgr = new WebDriverManager();
	            }
	         }
	      }
	      return mgr;
	}
	
	private void initDriver() {
		String browserName = PropertyLoader.getProperty("browser");
		String basedir = System.getProperty("user.dir");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					basedir + File.separator + "drivers/chromedriver.exe");
		//driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "localhost:9014");
			driver =new ChromeDriver(options);
			
	
			 
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					basedir + File.separator + "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					basedir + File.separator + "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
