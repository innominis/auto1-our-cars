package com.auto1.automation;

public class Strings {
    public static final String BaseUrl = "https://www.auto1.com/en";
    public static final String OurCarsUrl = BaseUrl + "/our-cars";
    public static final String CheckboxValue = "BMW";

    //XPathes
    public static final String CheckboxName = "//ul[@class='checkbox-list manufacturers-list']//span[@class='label' and text()='%s']";
}
