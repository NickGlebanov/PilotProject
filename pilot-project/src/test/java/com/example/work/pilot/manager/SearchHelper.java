package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SearchHelper {
    public WebDriver driver;

    public SearchHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void ntStandart() {
        type(By.linkText("Игровая приставка Nintendo Switch"));
    }

    public void ntLite() {
        type(By.linkText("Игровая приставка Nintendo Switch Lite"));
    }

    public void pick() {
        type(By.linkText("Характеристики"));
    }

    public void type(By locator) {
        driver.findElement(locator).click();
    }

    public void searchProduct() {
        search(By.id("header-search"), By.xpath("//button[@class='_1XiEJDPVpk']"), "nintendo switch");
    }

    public void search(By locator, By locator1, String text) {
        driver.findElement(locator).sendKeys(text);
        type(locator1);
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
