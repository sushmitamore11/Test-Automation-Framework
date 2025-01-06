package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000L));
	}

	public BrowserUtility(String browserName) {

		logger.info("launching the browser for " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equals("edge")) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			logger.error("Invalid browser name.. please select chrome or edge");
			System.err.println("Invalid browser name.. please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("launching the browser for " + browserName);

		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			System.err.println("Invalid browser name.. please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("launching the browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--windows.size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {

				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				options.addArguments("--windows.size=1920,1080");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {

				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		} else {
			System.err.println("Invalid browser name.. please select chrome or edge");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximising the browser website");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		logger.info("Element found & performing click");
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("Finding the element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found & performing click");
		element.click();
	}

	public void clickOn(WebElement element) {
		logger.info("Element found & performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding the element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found & enter test " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		logger.info("Finding the element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Clearing the textbox field ");
		element.clear();
	}

	public void selectDromDropdown(By dropdownLocator, String optionToSelect) {
		logger.info("Finding the element with the locator " + dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);

		logger.info("Selecting the option " + optionToSelect);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding the element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found & now enter the special key " + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding the element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found & now returning the visible " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning the visible text " + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All Elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the List of Elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}

		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding the element with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found & now printing the list ");

		return elementList;
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File ScreenShotData = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + " .png";
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(ScreenShotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		driver.get().quit();
	}
}
