package com.testapps.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class RegistrationPage extends BasePage {

    private By handphoneTxt = By.id("mobilePhone");
    private By emailIDTxt = By.id("email");
    private By firstNameTxt = By.id("firstName");
    private By lastNameTxt = By.id("lastName");
    private By loginBtn = By.xpath(".//button[contains(.,'Daftar')]");


    public void registerAcc(){
        sendKeys(handphoneTxt, "081777777777");
        Reporter.log("Phone number entered");
        
        sendKeys(emailIDTxt, "test@yopmail.com");
        Reporter.log("Entered Email ID");
        
        sendKeys(firstNameTxt,"test");
        Reporter.log("Entered first name");
        
        sendKeys(lastNameTxt,"Cermati");
        Reporter.log("Entered last name");
        
        click(loginBtn);
        Reporter.log("Clicked Login button successfully");
    }


}
