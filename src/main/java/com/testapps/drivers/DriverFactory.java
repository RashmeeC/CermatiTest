package com.testapps.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private DriverFactory() {
	}

	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static final ThreadLocal<String> browser = new ThreadLocal<String>();

	static void unload() {
		driver.remove();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			driver.set(driverref);
		}
	}

	public static String getBrowser() {
		return browser.get();
	}

	static void setBrowser(String currentBrowser) {
		browser.set(currentBrowser);
	}

}
