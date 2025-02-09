package com.testAppRun;

import org.testng.annotations.Test;

public class RegisterAnAccount extends BaseTest{

    @Test
    public void register(){
        regPage.registerAcc();
    }
}
