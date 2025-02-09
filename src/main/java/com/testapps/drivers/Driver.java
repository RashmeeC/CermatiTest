package com.testapps.drivers;

import java.util.Objects;

import com.testapps.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) {

		switch (browser.toLowerCase()) {
			case "chrome":
				if (Objects.isNull(DriverFactory.getDriver())) {
					DriverFactory.setDriver(new ChromeDriver());
					DriverFactory.setBrowser("chrome");
					DriverFactory.getDriver().manage().window().maximize();
					DriverFactory.getDriver().manage().deleteAllCookies();
					DriverFactory.getDriver().get(FrameworkConstants.getUrl());
					Reporter.log("Chrome Browser Launched");
				}
				break;

			case "firefox":
				if (Objects.isNull(DriverFactory.getDriver())) {
					DriverFactory.setDriver(new FirefoxDriver());  // Firefox setup
					DriverFactory.setBrowser("firefox");
					DriverFactory.getDriver().manage().window().maximize();
					DriverFactory.getDriver().manage().deleteAllCookies();
					DriverFactory.getDriver().get(FrameworkConstants.getUrl());
					Reporter.log("Firefox Browser Launched");
				}
				break;

			default:
				System.out.println("Invalid browser specified");
				break;
		}
	}

	public static void quitDriver() {
			if (DriverFactory.getDriver() != null) { // Ensure driver exists before quitting
				DriverFactory.getDriver().quit(); // Quit browser
				DriverFactory.unload(); // Set driver to null
			}
		}
	}

