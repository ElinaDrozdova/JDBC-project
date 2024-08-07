package io.loopcamp.steps;
import io.cucumber.java.en.*;
import io.loopcamp.pages.UserPage;
import io.loopcamp.utility.BrowserUtil;
import io.loopcamp.utility.DB_Utility;
import org.junit.Assert;

public class UserPageStepsDef {

    UserPage userPage = new UserPage();
    int uiTotalResultCount;

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        userPage.navigateToModule(moduleName);
    }


    @When("the user gets total user count")
    public void the_user_gets_total_user_count() {
        BrowserUtil.waitForClickablility(userPage.mainSearchButton, 2);
        userPage.mainSearchButton.click();
        userPage.clickRadioButton("All");
        userPage.searchButton.click();
        BrowserUtil.waitFor(3);
        uiTotalResultCount = userPage.getTotalResultCount();
        //System.out.println(uiTotalResultCount);

    }


    @Then("verify user count information match in DB")
    public void verify_user_count_information_match_in_db() {
        DB_Utility.runQuery("SELECT * FROM identity.users");
        int dbTotalResultCount = DB_Utility.getRowCount();

        Assert.assertEquals(uiTotalResultCount, dbTotalResultCount);
    }


}