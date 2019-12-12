package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAtoB(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        DragAndDropPage dragAndDropPage = mainPage.clickDragAndDropLink();

        sleep(6000);

        dragAndDropPage.dragAtoB();

        sleep(6000);
    }
}
