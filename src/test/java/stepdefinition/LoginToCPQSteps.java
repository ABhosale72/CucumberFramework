package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.HomePage.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginToCPQSteps {

    private HomePage homePage;

    @When("^User has logged into C4C$")
    public void user_has_logged_into_C4C() throws Throwable{
        ObjectRepo.driver.get("http://my325462-sso.crm.ondemand.com/sap/byd/runtime");
        homePage = new HomePage(ObjectRepo.driver);
        homePage.loginToHomePage();
        Thread.sleep(10000);
    }

    @Then("^User navigates to CPQ$")
    public void user_navigate_to_cpq() throws Throwable{
        homePage.navigateToCPQ();
        homePage.quoteDetails.isDisplayed();
        Assert.assertEquals(homePage.quoteDetails.getText(), "QUOTE DETAILS");
    }
}
