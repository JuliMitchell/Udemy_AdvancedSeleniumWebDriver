package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePage {

    private By iFrameEditor = By.id("mce_0_ifr");
    private By textEditor = By.xpath("//html/body/p");

    public IFramePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void switchToFrameEditor(){
        log.info("Switching to Frame Editor");
        switchToFrame(iFrameEditor);
    }

    public String getTextEditor(){
        return find(textEditor).getText();
    }
}
