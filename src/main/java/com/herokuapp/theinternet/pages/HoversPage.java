package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoversPage extends BasePage {

    private By avatarLocator = By.className("figure");
    private By avatarViewProfileLinkLocator= By.xpath(".//a[contains(text(),'View profile')]");

    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    private List<WebElement> getAllAvatars(){
        return findAll(avatarLocator);
    }

    public void hoverAndOpenAvatar(int avatarNumber){
        List<WebElement> avatars = getAllAvatars();
        WebElement avatar = avatars.get(avatarNumber - 1 );
        hoverElement(avatar);
        avatar.findElement(avatarViewProfileLinkLocator).click();
    }

}
