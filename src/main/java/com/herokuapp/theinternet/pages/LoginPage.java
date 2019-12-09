package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.className("radius");
    private By errorMessageLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password){
        log.info("Executing logIn with username [" + username + "] and password [" + password + "]");
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public void negativeLogIn(String username, String password){
        log.info("Executing negativeLogIn with username [" + username + "] and password [" + password + "]");
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);
    }

    public void waitForErrorMessage(){
        waitForVisibilityOf(errorMessageLocator, 5);
    }

    public String getErrorMessage(){
        return find(errorMessageLocator).getText();
    }
}
