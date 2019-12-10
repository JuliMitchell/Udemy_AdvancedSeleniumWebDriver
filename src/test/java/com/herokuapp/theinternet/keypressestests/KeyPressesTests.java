package com.herokuapp.theinternet.keypressestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {
    @Test
    public void pressEscapeButton(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        KeyPressesPage keyPressesPage = mainPage.clickKeyPressesLink();

        keyPressesPage.pressKey(Keys.ESCAPE);

        String resultText = keyPressesPage.getResultText();
        Assert.assertTrue(resultText.equals("You entered: ESCAPE"), "Result text isn't correct");
    }

    @Test
    public void pressShiftButton(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        KeyPressesPage keyPressesPage = mainPage.clickKeyPressesLink();

        keyPressesPage.pressKey(Keys.SHIFT);

        String resultText = keyPressesPage.getResultText();
        Assert.assertTrue(resultText.equals("You entered: SHIFT"), "Result text isn't correct");
    }
}
