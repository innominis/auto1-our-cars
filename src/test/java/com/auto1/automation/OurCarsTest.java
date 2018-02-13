package com.auto1.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 Automated scenario:
 1. Open https://auto1.com/en/our-cars
 2. Filter by manufacture by clicking checkbox(BMW)
 3. Verify filter was selected
 4. Verify all cars are BMW’s on the page
 5. Verify each car has picture
 6. Verify each car has complete information (Mileage, Registration is not empty etc.)
*/

public class OurCarsTest extends BaseTest {
    WebDriverWait wait;
    OurCarsPage ourCarsPage;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
        wait = new WebDriverWait(driver, 30);
        ourCarsPage = new OurCarsPage(driver);
    }

    @Test
    public void filterByChosenCheckbox() {
    }

    @Test(dependsOnMethods = "filterByChosenCheckbox")
    public void verifyCarBrandAccordingFilter() throws InterruptedException {
    }

    @Test(dependsOnMethods = "verifyCarBrandAccordingFilter")
    public void verifyEachCarHasPicture() {
    }

    @Test(dependsOnMethods = "verifyEachCarHasPicture")
    public void verifyCompleteInformationOfEachCar() {
    }
}
