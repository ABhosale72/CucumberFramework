package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.CommercePage.CommercePage;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LegalContactSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private String commerceURL = "https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?page=%2Fcommerce%2Fbuyside%2Fdocument.jsp&_bm_cm_new_transaction_currency=EUR&document_id=36244034&formaction=create&partnerOpportunityId=261517&process=oraclecpqo&BM_URL_CAPTURE_COOKIE=coltuat1&BM_BROWSER_COOKIE=Netscape";

    @When("^logged into CPQ$")
    public void loggedIntoCPQ() throws Throwable{
        ObjectRepo.driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
        homePage = new HomePage(ObjectRepo.driver);
        homePage.loginToHomePage();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage = new MainPage(ObjectRepo.driver);
        mainPage.navigateToCPQ();
        commercePage = new CommercePage(ObjectRepo.driver);
        Assert.assertEquals(commercePage.quoteDetails.getText(), "QUOTE DETAILS");
    }

    @Then("^user should see first name$")
    public void firstNameLastNameEmailPhoneNo(){
        ObjectRepo.driver.get(commerceURL);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Boolean bool = commercePage.getTextStatus(commercePage.firstName);
        Assert.assertTrue(bool);
    }

    @Then("^user should see last name$")
    public void userShouldSeeLastName() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.lastName);
        Assert.assertTrue(bool);
    }

    @Then("^user should see email$")
    public void userShouldSeeEmail() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.email);
        Assert.assertTrue(bool);
    }

    @Then("^user should see phone number$")
    public void userShouldSeePhoneNumber() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.phoneNo);
        Assert.assertTrue(bool);
    }

    @And("^user should see address$")
    public void userShouldSeeAddress() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.legalAddress);
        Assert.assertTrue(bool);
    }
}