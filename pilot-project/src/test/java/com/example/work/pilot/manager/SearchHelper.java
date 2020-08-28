package com.example.work.pilot.manager;

import org.openqa.selenium.*;

public class SearchHelper extends HelperBase{

    public SearchHelper(WebDriver driver) {
        super(driver);
    }

    public void clickProduct(String text) {
        click(By.linkText(text));
    }

    public void searchProduct(String attributeName) {
        type(By.id("header-search"), By.xpath("//div[text()='Найти']/.."), attributeName);
    }

    public void clickCharacteristic() {
        click(By.linkText("Характеристики"));
    }

    public String saveOldTab(){
        return driver.getWindowHandle();
    }

}
