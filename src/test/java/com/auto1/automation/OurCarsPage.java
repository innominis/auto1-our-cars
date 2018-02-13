package com.auto1.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OurCarsPage {
    WebDriver driver;

    public OurCarsPage(WebDriver driver) {
        this.driver = driver;
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
}
