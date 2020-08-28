package com.example.work.pilot.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    private SpecificationHelper specificationHelper;
    private SearchHelper searchHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {
        if(browser == BrowserType.CHROME){
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        searchHelper = new SearchHelper(driver);
        specificationHelper = new SpecificationHelper(driver, this);
    }

    public void enterWebsite() {
      driver.get("https://market.yandex.ru/");
    }

    public void stop() {
        driver.quit();
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    public SpecificationHelper getSpecificationHelper() {
        return specificationHelper;
    }
}
