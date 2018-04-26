package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.CommercePage.CommercePage;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginToCPQSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;

    @When("^User has logged into C4C$")
    public void user_has_logged_into_C4C() throws Throwable{
        ObjectRepo.driver.get("http://my325462-sso.crm.ondemand.com/sap/byd/runtime");
        homePage = new HomePage(ObjectRepo.driver);
        homePage.loginToHomePage();
        Thread.sleep(10000);
    }

    @Then("^User navigates to CPQ$")
    public void user_navigate_to_cpq() throws Throwable{
        mainPage = new MainPage(ObjectRepo.driver);
        mainPage.navigateToCPQ();
        commercePage = new CommercePage(ObjectRepo.driver);
        Assert.assertEquals(commercePage.quoteDetails.getText(), "QUOTE DETAILS");
    }
}
