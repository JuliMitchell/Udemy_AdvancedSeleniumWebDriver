package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage {

    private By squareALocator = By.id("column-a");
    private By squareBLocator = By.id("column-b");


    public DragAndDropPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void dragAtoB(){
        dragAndDrop(find(squareALocator), find(squareBLocator));
    }

}
