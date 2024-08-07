package io.loopcamp.pages;

import io.loopcamp.utility.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.loopcamp.data.User.userTypes;

public class LoginPage extends BasePage {

    /*
        Locate followings elements
            emailInputBox
            passwordInputBox
            loginButton


        Write a method the logins

     */

    @FindBy(xpath = "//input[@id='input-14']")
    WebElement emailBox;

    @FindBy(xpath = "//label[.='Password']")
    WebElement passwordBox;

    @FindBy(xpath = "//span[.=' Log in']")
    WebElement loginButton;

    public void loginAs (String userType){
        try{
            if (userTypes.contains(userType)){
    String username = ConfigurationReader.getProperty(userType + "_username"); //reffearing to Configuration Property
    String password = ConfigurationReader.getProperty(userType + "_password");

emailBox.sendKeys(username);
passwordBox.sendKeys(password);
loginButton.click();
} else {
    throw new RuntimeException("Invalid user type");

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}