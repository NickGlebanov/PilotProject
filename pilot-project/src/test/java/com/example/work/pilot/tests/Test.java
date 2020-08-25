package com.example.work.pilot.tests;

import com.example.work.pilot.classes.NintendoSpecification;
import com.example.work.pilot.manager.TestBase;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Test extends TestBase {

  @org.testng.annotations.Test
  public void testS() throws Exception {
    app.enterWebsite();
    app.search(By.id("header-search"), By.xpath("//button[@class='_1XiEJDPVpk']"), "nintendo switch");
    app.type(By.linkText("Игровая приставка Nintendo Switch"));
    String oneTab = app.driver.getWindowHandle(); // сохраняем первую вкладку
    app.getWindow(1);
    //new Select(driver.findElement(By.id("dropdown-control-1597759688456"))).selectByVisibleText("нет");
    app.type(By.linkText("Характеристики"));
    String colorSwitch = app.getColor(By.xpath("//div[@class='_2PZFauqN3Y']"), "title");


    List<WebElement> list = app.getWebElements();

    NintendoSpecification nt = new NintendoSpecification().withType(list.get(1).getText()).withScreen(list.get(3).getText()).
            withController(list.get(16).getText()).withAccessories(list.get(17).getText()).
            withColor(colorSwitch).withMemory(list.get(8).getText()).withWeight(list.get(15).getText());


    app.search(By.id("header-search"),By.xpath("//button[@class='_1XiEJDPVpk']"), "nintendo switch");
    Thread.sleep(10000);
    app.type(By.linkText("Игровая приставка Nintendo Switch Lite"));
    Thread.sleep(10000);
    app.getWindow(2);
    app.type(By.linkText("Характеристики"));
    String colorLite = app.getColor(By.xpath("//div[@class='_2PZFauqN3Y']"), "title"); // сделать потом Коллекцию цветов и выбирать один из них

    List<WebElement> list1 = app.getWebElements();

    NintendoSpecification nt1 = new NintendoSpecification().withType(list1.get(1).getText()).withScreen(list1.get(2).getText()).
            withController(null).withAccessories(null).
            withColor(colorLite).withMemory(list1.get(12).getText()).withWeight(list1.get(19).getText());

    Assert.assertEquals(nt.getType(), nt1.getType()); // проверка совпадения типов
    Assert.assertEquals(nt.getColor(), nt1.getColor()); // проверка совпадения цветов
    Assert.assertEquals(nt.getMemory(), nt1.getMemory()); // проверка совпадения наличия слотов карты памяти
    Assert.assertEquals(nt.getScreen(), nt1.getScreen()); // проверка совпадения размера экранов
  }


}
