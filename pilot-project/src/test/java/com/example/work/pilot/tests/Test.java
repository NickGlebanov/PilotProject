package com.example.work.pilot.tests;

import com.example.work.pilot.classes.NintendoSpecification;
import com.example.work.pilot.manager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Test extends TestBase {

  @org.testng.annotations.Test
  public void testS() throws Exception {
    app.enterWebsite();
    app.getSearchHelper().searchProduct("nintendo switch");
    app.getSearchHelper().clickProduct(By.linkText("Игровая приставка Nintendo Switch"));
    String oneTab = app.getSearchHelper().saveOldTab(); // сохраняем первую вкладку
    app.getSpecificationHelper().getWindow(1);
    app.getSearchHelper().getCharacteristic();
    List<WebElement> set = app.getSpecificationHelper().getSetColor();

    String colorSwitch = app.getSpecificationHelper().getColor();

    List<WebElement> list = app.getSpecificationHelper().getListPoints();

    NintendoSpecification nt = new NintendoSpecification().withType(list.get(1).getText()).withScreen(list.get(3).getText()).
            withController(list.get(16).getText()).withAccessories(list.get(17).getText()).
            withColor(colorSwitch).withMemory(list.get(8).getText()).withWeight(list.get(15).getText());

    app.getSearchHelper().searchProduct("nintendo switch");
    Thread.sleep(10000);
    app.getSearchHelper().clickProduct(By.linkText("Игровая приставка Nintendo Switch Lite"));
    Thread.sleep(10000);
    app.getSpecificationHelper().getWindow(2);
    app.getSearchHelper().getCharacteristic();
    String colorLite = app.getSpecificationHelper().getColor(); // сделать потом Коллекцию цветов и выбирать один из них

    List<WebElement> list1 = app.getSpecificationHelper().getListPoints();


    NintendoSpecification nt1 = new NintendoSpecification().withType(list1.get(1).getText()).withScreen(list1.get(2).getText()).
            withController(null).withAccessories(null).
            withColor(colorLite).withMemory(list1.get(12).getText()).withWeight(list1.get(19).getText());

    Assert.assertEquals(nt.getType(), nt1.getType()); // проверка совпадения типов
    Assert.assertEquals(nt.getColor(), nt1.getColor()); // проверка совпадения цветов
    Assert.assertEquals(nt.getMemory(), nt1.getMemory()); // проверка совпадения наличия слотов карты памяти
    Assert.assertEquals(nt.getScreen(), nt1.getScreen()); // проверка совпадения размера экранов
  }


}
