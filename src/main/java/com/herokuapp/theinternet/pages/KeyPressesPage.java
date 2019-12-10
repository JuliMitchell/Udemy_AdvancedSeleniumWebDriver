package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage {

    private By body = By.xpath("//body");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void pressKey(Keys key){
        log.info("Pressing " + key.name());
        pressKey(body, key);
    }

    public String getResultText(){
        return find(resultText).getText();
    }
}
