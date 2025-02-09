package com.testapps.utils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import java.time.Duration;
import java.util.List;

import com.testapps.drivers.DriverFactory;
import com.testapps.frameworkConstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitFactory {
	
	
	public static WebElement performExplicitWait(WebElement element) {
		
		WebDriver driver = DriverFactory.getDriver();
		 element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		            .until(ExpectedConditions.elementToBeClickable(element));
		 
		 final WebElement e = element;
		    await().atMost(5, SECONDS)
		            .pollDelay(2, SECONDS)
		            .pollInterval(2, SECONDS)
		            .ignoreExceptions()
		            .until(() -> e.isDisplayed());
		    
		    return element;
		
	}
	
public static WebElement performExplicitWait(By by) {
		
		WebDriver driver = DriverFactory.getDriver();
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		            .until(ExpectedConditions.elementToBeClickable(by));
		 
		 final WebElement e = element;
		    await().atMost(5, SECONDS)
		            .pollDelay(2, SECONDS)
		            .pollInterval(2, SECONDS)
		            .ignoreExceptions()
		            .until(() -> e.isDisplayed());
		    
		    return element;
		
	}
	

	public static List<WebElement> performExplicitWait(List<WebElement> element) {
		
		WebDriver driver = DriverFactory.getDriver();
		 element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
		            .until(ExpectedConditions.visibilityOfAllElements(element));
		 
		 final List<WebElement> e = element;
		    await().atMost(5, SECONDS)
		            .pollDelay(2, SECONDS)
		            .pollInterval(2, SECONDS)
		            .ignoreExceptions()
		            .until(() -> e.size()==0);
		    
		    return element;
		
	}
	

}
