package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable driver
	}

	public BrowserUtility(String browserName) {

		logger.info("launching the browser for " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equals("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid browser name.. please select chrome or edge");
			System.err.println("Invalid browser name.. please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("launching the browser for " + browserName);

		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
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
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				options.addArguments("--windows.size=1920,1080");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
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
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found & performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding the element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found & enter test " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding the element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found & now returning the visible " + element.getText());
		return element.getText();
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
