package com.herokuapp.theinternet.pages;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private Logger log;

    private String url = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public MainPage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    public void openPage(){
        log.info("Opening page: " + url);
        driver.get(url);
        log.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication link on Main Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }

}
