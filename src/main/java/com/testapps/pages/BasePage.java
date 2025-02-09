package com.testapps.pages;

import java.time.Duration;
import java.util.List;

import com.testapps.drivers.DriverFactory;
import com.testapps.utils.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	WebElement element;
	List<WebElement> elements;
	
	
	protected void waitForLoad() {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(60));
		wait.until(pageLoadCondition);
	}

	
	
	protected void waitForElement(By by) {
		
		waitForLoad();
		element = ExplicitWaitFactory.performExplicitWait(by);
		waitForLoad();
	}
	
	protected void waitForElement(List<WebElement> element) {
		
		waitForLoad();
		elements = ExplicitWaitFactory.performExplicitWait(element);
		waitForLoad();
	
	}
	
	protected void click(By by) {
		waitForLoad();
		element = ExplicitWaitFactory.performExplicitWait(by);
		element.click();
		waitForLoad();
	}
	
	protected void sendKeys(By by, String text) {
		waitForLoad();
		element = ExplicitWaitFactory.performExplicitWait(by);
		element.sendKeys(text);
		waitForLoad();
		
	}
	
	protected void sendTabKeys(By by) {
		element = ExplicitWaitFactory.performExplicitWait(by);
		element.sendKeys(Keys.TAB);
	}

	protected void sendEnterKey(By by) {
		element = ExplicitWaitFactory.performExplicitWait(by);
		element.sendKeys(Keys.ENTER);
	}

	

}
