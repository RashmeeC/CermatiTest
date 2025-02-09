package com.testAppRun;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import java.time.Duration;
import java.util.List;

import com.testapps.drivers.Driver;
import com.testapps.drivers.DriverFactory;
import com.testapps.pages.RegistrationPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {

	protected RegistrationPage regPage = new RegistrationPage();


	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

		Driver.initDriver(browser);
	}


	@AfterMethod
	public void tearDown() {
			Driver.quitDriver();
	}

	public WebElement waitUntilElementClickable(WebElement element) {
		element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));
		final WebElement e = element;
		await().atMost(50, SECONDS).pollDelay(2, SECONDS).pollInterval(2, SECONDS).ignoreExceptions()
				.until(e::isDisplayed);
		return element;

	}

	public WebElement waitUntilElementVisible(WebElement element) {
		element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(element));

		final WebElement e = element;

		await().atMost(50, SECONDS).pollDelay(2, SECONDS).pollInterval(2, SECONDS).ignoreExceptions()
				.until(e::isDisplayed);
		return element;

	}

	public List<WebElement> waitUntilListElementsVisible(List<WebElement> elements) {
		List<WebElement> visibleElements = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(elements));

		final List<WebElement> e = visibleElements;

		await().atMost(50, SECONDS).pollDelay(2, SECONDS).pollInterval(2, SECONDS).ignoreExceptions()
				.until(() -> e.stream().allMatch(WebElement::isDisplayed));
		return visibleElements;
	}


}
