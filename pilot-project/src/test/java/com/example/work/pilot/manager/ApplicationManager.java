package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String getColor(By locator, String text) {
      return driver.findElement(locator).getAttribute(text);
    }

    public void getWindow(int i) {
      ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()); // список всех вкладок
      driver.switchTo().window(newTab.get(i)); // берем вторую вкладку
    }

    public void type(By locator) {
      driver.findElement(locator).click();
    }

    public void search(By locator, By locator1, String text) {
      driver.findElement(locator).sendKeys(text);
      driver.findElement(locator1).click();
    }

    public void enterWebsite() {
      driver.get("https://market.yandex.ru/");
    }

    public void stop() {
        driver.quit();
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
