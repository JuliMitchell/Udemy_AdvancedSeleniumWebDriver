package com.herokuapp.theinternet.hoverstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {
    @Test
    public void openProfileAvatarTwo(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        HoversPage hoversPage = mainPage.clickHoversLink();

        hoversPage.hoverAndOpenAvatar(2);

        Assert.assertTrue(hoversPage.getBrowserUrl().contains("/users/2"));
    }
}
