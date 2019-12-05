package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private WebDriver driver;
    private Logger log;

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.className("radius");

    public LoginPage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    public SecureAreaPage logIn(String username, String password){
        log.info("Executing logIn with username [" + username + "] and password [" + password + "]");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return new SecureAreaPage(driver, log);
    }
}