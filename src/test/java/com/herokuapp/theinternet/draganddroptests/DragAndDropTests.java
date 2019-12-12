package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAtoB(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        DragAndDropPage dragAndDropPage = mainPage.clickDragAndDropLink();

        dragAndDropPage.dragAtoB();

        Assert.assertTrue(dragAndDropPage.getValueSquare1().equals("B"), "Square 1 text isn't correct");

        Assert.assertTrue(dragAndDropPage.getValueSquare2().equals("A"), "Square 2 text isn't correct");
    }
}
