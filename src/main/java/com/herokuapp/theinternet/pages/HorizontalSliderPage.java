package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage {

    private By sliderLocator = By.tagName("input");
    private By rangeLocator = By.id("range");

    public HorizontalSliderPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void sliderToRange(String value){

        log.info("Moving slider to " + value);

        int steps = (int) (Double.parseDouble(value) / 0.5);

        pressKey(sliderLocator, Keys.ENTER);

        for(int i = 0; i < steps; i++){
            pressKey(sliderLocator, Keys.ARROW_RIGHT);
        }

    }

    public String getRangeValue(){
        return find(rangeLocator).getText();
    }

}
