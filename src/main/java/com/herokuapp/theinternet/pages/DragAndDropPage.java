package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage {

    private By square1Locator = By.id("column-a");
    private By square2Locator = By.id("column-b");


    public DragAndDropPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void dragAtoB(){
        dragAndDrop(find(square1Locator), find(square2Locator));
    }

    public String getValueSquare1(){
        return find(square1Locator).getText();
    }

    public String getValueSquare2(){
        return find(square2Locator).getText();
    }

}
