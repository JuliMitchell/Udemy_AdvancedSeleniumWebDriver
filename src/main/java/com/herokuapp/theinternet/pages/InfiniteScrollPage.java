package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InfiniteScrollPage extends  BasePage {

    private By paragraphLocator = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public int getParagraphQuantity(){
        List<WebElement> paragraphs = findAll(paragraphLocator);
        return paragraphs.size();
    }

    public void scrollToTheBottom(int times) throws InterruptedException {
        for(int i=0;i<times;i++){
            scrollToBottom();
            Thread.sleep(1000);
        }
    }

}
