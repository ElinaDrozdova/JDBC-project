package io.loopcamp.pages;

import io.loopcamp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@class='v-list-item__title']//span")
    List <WebElement> allModules ;


    @FindBy(xpath = "//div[@class=\"v-data-footer__pagination\"]")
    WebElement totalResultCount; // 1-4 of 4 ---- str.split(" ")[str.split(" ").length-1] --- >  4

    public void navigateToModule(String moduleName){
        for (WebElement eachModule : allModules) {
            if(eachModule.getText().equals(moduleName)){
                eachModule.click();
                break;
            }
        }
    }


    public int getTotalResultCount(){
        String actualResult = totalResultCount.getText().split(" ")[2];  // ["1-4", "of", "124"]
        return Integer.parseInt(actualResult);
    }
}