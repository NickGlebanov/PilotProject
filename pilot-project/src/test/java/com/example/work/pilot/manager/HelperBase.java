package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void pick() {
        type(By.linkText("Характеристики"));
    }

    public void type(By locator) {
        driver.findElement(locator).click();
    }

    public void search(By locator, By locator1, String text) {
        driver.findElement(locator).sendKeys(text);
        type(locator1);
    }

    public String getAttribute(By locator, String text) {
        return driver.findElement(locator).getAttribute(text);
    }
}
