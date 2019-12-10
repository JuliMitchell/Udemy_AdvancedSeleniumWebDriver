package com.herokuapp.theinternet.jsalerttests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSAlertPage;
import com.herokuapp.theinternet.pages.MainPage;
import javafx.scene.control.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertTests extends TestUtilities {

    @Test
    public void acceptJSAlert(){

        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSAlert();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS Alert"), "Alert text isn't correct");

        jsAlertPage.acceptAlert();

        Assert.assertTrue(jsAlertPage.getResultText().contains("You successfuly clicked an alert"), "Result text isn't correct.");
    }

    @Test
    public void acceptJSConfirm(){

        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSConfirm();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS Confirm"), "Alert text isn't correct");

        jsAlertPage.acceptAlert();

        Assert.assertTrue(jsAlertPage.getResultText().contains("You clicked: Ok"), "Result text isn't correct");
    }

    @Test
    public void rejectJSConfirm(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSConfirm();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS Confirm"), "Alert text isn't correct");

        jsAlertPage.rejectAlert();

        Assert.assertTrue(jsAlertPage.getResultText().contains("You clicked: Cancel"), "Result text isn't correct");
    }

    @Test
    public void acceptJSPromptWithoutInput(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSPrompt();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS prompt"), "Alert text isn't correct");

        String text = "";
        jsAlertPage.writeOnAlert(text);

        jsAlertPage.acceptAlert();

        String resultText = jsAlertPage.getResultText();
        Assert.assertTrue(resultText.contains("You entered:"), "Result text isn't correct");
    }

    @Test
    public void acceptJSPromptWithInput(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();
        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSPrompt();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS prompt"), "Alert text isn't correct");

        String text = "I'm the alert text";
        jsAlertPage.writeOnAlert(text);

        jsAlertPage.acceptAlert();

        String resultText = jsAlertPage.getResultText();
        Assert.assertTrue(resultText.contains("You entered: " + text), "dResult text isn't correct");
    }

    @Test
    public void rejectJSPromptWithoutInput(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();
        JSAlertPage jsAlertPage = mainPage.clickJSAlertLink();

        jsAlertPage.clickJSPrompt();

        String alertText = jsAlertPage.getAlertText();
        Assert.assertTrue(alertText.contains("I am a JS prompt"), "Alert text isn't correct");

        String text = "";
        jsAlertPage.writeOnAlert(text);

        jsAlertPage.rejectAlert();

        String resultText = jsAlertPage.getResultText();
        Assert.assertTrue(resultText.contains("You entered: null"), "Result text isn't correct");
    }
}
