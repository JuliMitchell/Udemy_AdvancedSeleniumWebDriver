package com.herokuapp.theinternet.horizontalslidertests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {

    @Test
    public void moverSlider(){
        MainPage mainPage = new MainPage(driver, log);

        mainPage.openPage();

        HorizontalSliderPage horizontalSliderPage = mainPage.clickHorizontalSliderLink();

        String range = "2.5";
        horizontalSliderPage.sliderToRange(range);

        Assert.assertTrue(horizontalSliderPage.getRangeValue().equals(range), "Range number isn't correct");

    }
}
