package com.meetsky.step_definitions;

import com.meetsky.utilities.Driver;
import io.cucumber.java.After;

public class Hook {


    @After
    public void quitDriver(){
        Driver.closeDriver();
    }


}
