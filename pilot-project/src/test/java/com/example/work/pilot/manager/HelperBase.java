package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void toPush(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, By locator1, String attributeName) {
        driver.findElement(locator).sendKeys(attributeName);
        toPush(locator1);
    }

    public String getAttribute(By locator, String text) {
        return driver.findElement(locator).getAttribute(text);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
