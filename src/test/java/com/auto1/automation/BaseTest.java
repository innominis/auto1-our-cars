package com.auto1.automation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.log4testng.Logger;

public class BaseTest {

    protected static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 1600));
        }
        return driver;
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
            } catch (WebDriverException ex) {
                // it can already be dead or unreachable
            }
        }
    }
}