package io.loopcamp.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends BasePage {

    /* locate following
            mainSearchButon
            searchButton
            roleDropDown
            radioButtons


     */
    @FindBy (xpath = "//span[.='Search']")
    public WebElement mainSearchButton;

    @FindBy (xpath = "//span[.=' Search ']")
    public WebElement searchButton;

    @FindBy (xpath = "//label[.='Role']/following-sibling::input[1]")
    WebElement roleDropDownButton;

    @FindBy (xpath = "//div[@role=\"radiogroup\"]//label")
    List <WebElement> radioButtons;

    public void clickRadioButton (String radioButtonName) {
        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getText().equals(radioButtonName)) {
                eachRadioButton.click();
                break;
            }
        }
    }
}