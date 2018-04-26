package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.CommercePage.CommercePage;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import static org.junit.Assert.*;

public class CommercePageSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private String commerceURL = "https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?page=%2Fcommerce%2Fbuyside%2Fdocument.jsp&_bm_cm_new_transaction_currency=EUR&document_id=36244034&formaction=create&partnerOpportunityId=261517&process=oraclecpqo&BM_URL_CAPTURE_COOKIE=coltuat1&BM_BROWSER_COOKIE=Netscape";

    @When("^User login to CPQ$")
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

    @Then("^Opportunity ID should be populated$")
    public void opportunityIDShouldBePopulated() throws Throwable {
        ObjectRepo.driver.get(commerceURL);
        Thread.sleep(10000);
        Boolean bool = commercePage.getTextStatus(commercePage.opportunityID);
        Assert.assertTrue(bool);
    }

    @And("^User sees Opportunity Name$")
    public void userSeesOpportunityName() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.opportunityName);
        Assert.assertTrue(bool);
    }

    @And("^Opportunity Name should be either New Business or Existing Business$")
    public void opportunityNameShouldBeEitherNewBusinessOrExistingBusiness() throws Throwable {
        assertTrue(commercePage.getOfferType().equals("New Business")||
                commercePage.getOfferType().equals("Existing Business"));
    }

    @And("^Opportunity created by should be populated$")
    public void opportunityCreatedByShouldBePopulated() throws Throwable {
        Boolean bool = commercePage.getTextStatus(commercePage.opportunityCreatedBy);
        Assert.assertTrue(bool);
    }

    @And("^Technical complexity should be either 01 or 02$")
    public void technicalComplexityShouldBeEitherOr() throws Throwable {
        assertTrue(commercePage.getTechnicalComplexity().equals("01")||
                commercePage.getTechnicalComplexity().equals("02"));
    }

    @And("^Legal Complexity should be Standard or Non-Standard$")
    public void legalComplexityShouldBeStandardOrNonStandard() throws Throwable {
        Assert.assertEquals(commercePage.getLegalComplexity(), "Standard");
    }

    @And("^Deal class should be either gold, silver or bronze$")
    public void dealClassShouldBeEitherGoldSilverOrBronze() throws Throwable {
        assertTrue(commercePage.getDealClass().equals("Bronze")||
                commercePage.getDealClass().equals("Silver")||
                commercePage.getDealClass().equals("Gold"));
    }

    @And("^go0 approval should either be Y or N$")
    public void goApprovalShouldEitherBeYOrN() throws Throwable {
        assertTrue(commercePage.getGo0Approval().equals("Y")||
                commercePage.getGo0Approval().equals("N"));
    }
}
