package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHelper {
    public WebDriver driver;

    public SearchHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator) {
      driver.findElement(locator).click();
    }

    public void search(By locator, By locator1, String text) {
      driver.findElement(locator).sendKeys(text);
      driver.findElement(locator1).click();
    }
}
