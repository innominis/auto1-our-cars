package com.auto1.automation;

import org.openqa.selenium.WebElement;
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
    OurCarsPage ourCarsPage;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
        ourCarsPage = new OurCarsPage(driver);
    }

    @Test
    public void filterByChosenCheckbox() {
        ourCarsPage.goToPage();
        WebElement checkbox = ourCarsPage.findSpecifiedCheckbox(Strings.CheckboxValue);
        ourCarsPage.clickCheckbox(checkbox);
        Assert.assertTrue(ourCarsPage.checkThatCheckboxIsChecked(checkbox), "Checkbox isn't selected");
    }

    @Test(dependsOnMethods = "filterByChosenCheckbox")
    public void verifyCarBrandAccordingFilter() throws InterruptedException {
        ourCarsPage.waitUntilFilterIsApply();
        ourCarsPage.areCarNamesValid(Strings.CheckboxValue);
    }

    @Test(dependsOnMethods = "verifyCarBrandAccordingFilter")
    public void verifyEachCarHasPicture() {
        ourCarsPage.checkThatCarsHavePicture();
    }

    @Test(dependsOnMethods = "verifyEachCarHasPicture")
    public void verifyCompleteInformationOfEachCar() {
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getLisOfStockNumberElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getOdometerReadingElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getFirstRegistrationElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getHorsepowerElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getBodyTypeElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getFuelTypeElements());
        ourCarsPage.checkThatCarsHaveSpecifiedAttribute(ourCarsPage.getGearBoxElements());
    }
}
