package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.className("radius");

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
}
