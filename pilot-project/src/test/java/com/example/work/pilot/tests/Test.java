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
    app.getSearchHelper().clickProduct("Игровая приставка Nintendo Switch");
    String oneTab = app.getSearchHelper().saveOldTab(); // сохраняем первую вкладку
    app.getSpecificationHelper().getWindow(1);
    app.getSearchHelper().clickCharacteristic();
    List<WebElement> list = app.getSpecificationHelper().getListPoints();

    NintendoSpecification nt = app.getSpecificationHelper().getNintendo(list.get(1).getText(), list.get(3).getText(), list.get(16).getText(),
            list.get(17).getText(), app.getSpecificationHelper().getColor(), list.get(8).getText(), list.get(15).getText());

    app.getSearchHelper().searchProduct("nintendo switch");
    app.getSearchHelper().clickProduct("Игровая приставка Nintendo Switch Lite");
    app.getSpecificationHelper().getWindow(2);
    app.getSearchHelper().clickCharacteristic();
    List<WebElement> list1 = app.getSpecificationHelper().getListPoints();

    NintendoSpecification nt1 = app.getSpecificationHelper().getNintendo(list1.get(1).getText(), list1.get(2).getText(),
            null, null, app.getSpecificationHelper().getColor(), list1.get(12).getText(), list1.get(19).getText());

    Assert.assertEquals(nt, nt1);

   // Assert.assertEquals(nt.getType(), nt1.getType()); // проверка совпадения типов
    //Assert.assertEquals(nt.getColor(), nt1.getColor()); // проверка совпадения цветов
    //Assert.assertEquals(nt.getMemory(), nt1.getMemory()); // проверка совпадения наличия слотов карты памяти
    //Assert.assertEquals(nt.getScreen(), nt1.getScreen()); // проверка совпадения размера экранов
  }


}
