package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertPage extends BasePage {

    private By jsAlertButtonLocator = By.xpath("//button[text() = 'Click for JS Alert']");
    private By jsConfirmButtonLocator = By.xpath("//button[text() = 'Click for JS Confirm']");
    private By jsPromptButtonLocator = By.xpath("//button[text() = 'Click for JS Prompt']");
    private By resultTextLocator = By.id("result");

    public JSAlertPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Click buttons
    public void clickJSAlert(){
        log.info("Clicking 'Click for JS Alert' button on JavaScript Alerts page");
        click(jsAlertButtonLocator);
    }

    public void clickJSConfirm(){
        log.info("Clicking 'Click for JS Confirm' button on JavaScript Alerts page");
        click(jsConfirmButtonLocator);
    }

    public void clickJSPrompt(){
        log.info("Clicking 'Click for JS Prompt' button on JavaScript Alerts page");
        click(jsPromptButtonLocator);
    }

    //Alert actions
    public void acceptAlert(){
        log.info("Accepting alert.");
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void rejectAlert(){
        log.info("Rejecting alert");
        Alert alert = switchToAlert();
        alert.dismiss();
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

    public void writeOnAlert(String text){
        Alert alert = switchToAlert();
        alert.sendKeys(text);
    }

}
