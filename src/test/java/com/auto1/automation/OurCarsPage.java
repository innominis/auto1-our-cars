package com.auto1.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class OurCarsPage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger();

    public OurCarsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='car-list']//div[@class='car-name']")
    private List<WebElement> listOfCarNameElements;

    @FindBy(xpath = "//*[@id='car-list']//div[@class='car-img']/img")
    private List<WebElement> lisOfImageElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[1]/td[2]")
    private List<WebElement> lisOfStockNumberElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[2]/td[2]")
    private List<WebElement> odometerReadingElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[3]/td[2]")
    private List<WebElement> firstRegistrationElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[4]/td[2]")
    private List<WebElement> horsepowerElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[5]/td[2]")
    private List<WebElement> bodyTypeElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[6]/td[2]")
    private List<WebElement> fuelTypeElements;

    @FindBy(xpath = "//*[@id='car-list']/li/div[@class='car-info']/table/tbody/tr[7]/td[2]")
    private List<WebElement> gearBoxElements;

    public List<WebElement> getListOfCarNameElements() {
        return listOfCarNameElements;
    }

    public List<WebElement> getLisOfImageElements() {
        return lisOfImageElements;
    }

    public List<WebElement> getLisOfStockNumberElements() {
        return lisOfStockNumberElements;
    }

    public List<WebElement> getOdometerReadingElements() {
        return odometerReadingElements;
    }

    public List<WebElement> getFirstRegistrationElements() {
        return firstRegistrationElements;
    }

    public List<WebElement> getHorsepowerElements() {
        return horsepowerElements;
    }

    public List<WebElement> getBodyTypeElements() {
        return bodyTypeElements;
    }

    public List<WebElement> getFuelTypeElements() {
        return fuelTypeElements;
    }

    public List<WebElement> getGearBoxElements() {
        return gearBoxElements;
    }

    public void goToPage() {
        logger.info("Go to Our cars page");
        driver.get(Strings.OurCarsUrl);
    }

    public WebElement findSpecifiedCheckbox(String name) {
        logger.info("Find " + name.toUpperCase() + " checkbox");
        return driver.findElement(By.xpath(String.format(Strings.CheckboxName, name)));
    }

    public void waitUntilFilterIsApply() {
        logger.info("Waiting for applying the filter...");
        try {
            wait.until(ExpectedConditions.attributeContains(getListOfCarNameElements().get(0),"innerText", Strings.CheckboxValue));
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.attributeContains(getListOfCarNameElements().get(0),"innerText", Strings.CheckboxValue));
        }
    }

    public void clickCheckbox(WebElement checkbox) {
        logger.info("Select " + checkbox.getText().toUpperCase() + " checkbox");
        checkbox.click();
        if (!checkThatCheckboxIsChecked(checkbox)) {
            logger.info("Had to click a second time");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", checkbox);
            checkbox.click();
        }
    }

    public boolean checkThatCheckboxIsChecked(WebElement checkbox) {
        logger.info("Find ancestor of checkbox to check className is 'checked'");
        WebElement ancestor = checkbox.findElement(By.xpath(".."));
        String classNameValue = ancestor.getAttribute("className");
        return classNameValue.equals("checked") ? true : false;
    }

    public void areCarNamesValid(String name) {
        logger.info("Check that each car name in the list is " + name.toUpperCase());
        List<String> names = getListOfCarNamesFromCarElements();
        if (!names.isEmpty()) {
            for (int i = 0; i < names.size(); i++) {
                Assert.assertTrue(names.get(i).contains(name),
                        "Actual car name is " + names.get(i).toUpperCase() + ", but expected " + name.toUpperCase());
            }
        } else {
            throw new RuntimeException("List of names is empty!");
        }
    }

    private List<String> getListOfCarNamesFromCarElements() {
        logger.info("Get all car names from the page");
        List<WebElement> elements = getListOfCarNameElements();
        List<String> names = new ArrayList<String>();
        if (!elements.isEmpty()) {
            for (int i = 0; i < elements.size(); i++) {
                names.add(elements.get(i).getText());
            }
        }
        return names;
    }

    public void checkThatCarsHavePicture() {
        logger.info("Check that each car in the list has a picture");
        List<WebElement> pictures = getLisOfImageElements();
        if (!pictures.isEmpty()) {
            for (int i = 0; i < pictures.size(); i++) {
                Assert.assertNotNull(pictures.get(i).getAttribute("currentSrc")
                        ,"Car in the list doesn't have a pictures");
            }
        } else {
            throw new RuntimeException("List of pictures is empty!");
        }
    }

    public void checkThatCarsHaveSpecifiedAttribute(List<WebElement> elements) {
        logger.info("Check that cars attribute " + findSibling(elements).getText().toUpperCase() + " isn't null");
        if (!elements.isEmpty()) {
            for (int i = 0; i < elements.size(); i++) {
                Assert.assertNotNull(elements.get(i).getText(),"Car in the list doesn't have a pictures");
            }
        } else {
            throw new RuntimeException("List of elements is empty!");
        }
    }

    private WebElement findSibling(List<WebElement> elements) {
        String xpathToString = elements.get(0).toString();
        String xpathString1 = xpathToString.substring(xpathToString.indexOf("//*"));

        String xpathString2 = xpathString1.substring(0, xpathString1.length() - 1);
        String index = xpathString2.substring(xpathString2.indexOf("tr"), xpathString2.length() - 1).substring(3,4).toString();

        String correctXpath = xpathString2.replace("/li/", "/li[" + index + "]/");
        WebElement sibling = driver.findElement(By.xpath(correctXpath + "/preceding-sibling::td"));

        return sibling;
    }
}
