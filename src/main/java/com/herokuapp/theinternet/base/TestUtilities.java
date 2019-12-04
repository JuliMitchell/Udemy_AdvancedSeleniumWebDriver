package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest{

    protected void sleep(long time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
