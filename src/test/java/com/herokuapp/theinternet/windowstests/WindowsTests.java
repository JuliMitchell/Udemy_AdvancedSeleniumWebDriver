package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MainPage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {
    @Test
    public void openNewWindows(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        WindowsPage windowsPage = mainPage.clickMultipleWindowsLink();

        windowsPage.openNewWindow();

        windowsPage.switchToNewWindowsPage();

        String pageSource = windowsPage.getCurrentPageSource();

        Assert.assertTrue(pageSource.contains("New Window"), "Message 'New Window' isn't visible");

    }
}
