package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertPage extends BasePage {

    private By jsAlertButtonLocator = By.xpath("//button[text() = 'Click for JS Alert']");
    private By resultTextLocator = By.id("result");

    public JSAlertPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void clickJSAlert(){
        log.info("Clicking 'Click for JS Alert' button on JavaScript Alerts page");
        click(jsAlertButtonLocator);
    }

    public void acceptAlert(){
        log.info("Accepting alert.");
        Alert alert = switchToAlert();
        alert.accept();
    }

    public String getAlertText(){
        log.info("Getting alert text");
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert text: " + alertText);
        return alertText;
    }

    public String getResultText(){
        String resultText = find(resultTextLocator).getText();
        log.info("Result text is '" + resultText + "'");
        return resultText;
    }



}
