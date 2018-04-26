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

import static org.junit.Assert.assertTrue;

public class AccountPageSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private String commerceURL = "https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?page=%2Fcommerce%2Fbuyside%2Fdocument.jsp&_bm_cm_new_transaction_currency=EUR&document_id=36244034&formaction=create&partnerOpportunityId=261517&process=oraclecpqo&BM_URL_CAPTURE_COOKIE=coltuat1&BM_BROWSER_COOKIE=Netscape";

    @When("^user logs into CPQ$")
    public void user_logging_into_CPQ(){
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

    @Then("^user should be able to see OCN Number$")
    public void userShouldBeAbleToSeeOCNNumber() throws Throwable {
        ObjectRepo.driver.get(commerceURL);
        Thread.sleep(10000);
        Boolean bool = commercePage.getTextStatus(commercePage.ocNumber);
        Assert.assertTrue(bool);
    }

    @And("^user should be able to see Account Name$")
    public void userShouldBeAbleToSeeAccountName() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.accountName);
        Assert.assertTrue(bool);
    }

    @And("^user should be able to see Account Address$")
    public void userShouldBeAbleToSeeAccountAddress() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.accountAddress);
        Assert.assertTrue(bool);
    }

    @And("^user should be able to see Pricing Segment$")
    public void userShouldBeAbleToSeePricingSegment() throws Throwable {
        Assert.assertEquals("ENTS", commercePage.getPricingSegment());
    }
}
