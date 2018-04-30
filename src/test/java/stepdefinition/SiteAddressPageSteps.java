package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.CommercePage.CommercePage;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import PageObjects.ProductPage.ProductPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;

public class SiteAddressPageSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private ProductPage productPage;

    @When("^I have logged into CPQ$")
    public void userInsideCPQ(){
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


    @Then("^I click on add product and select HUB$")
    public void iClickOnAddProductAndSelectHUB() throws Throwable {
        Thread.sleep(10000);
        productPage = new ProductPage(ObjectRepo.driver);
        productPage.addProduct.click();
        Thread.sleep(10000);
        Assert.assertTrue(productPage.quoteManager.isDisplayed());
        productPage.addProductPageProduct("hub");
        Thread.sleep(10000);
    }

    @When("^I am inside config page$")
    public void iAmInsideConfigPage() throws Throwable {
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
        Thread.sleep(10000);
    }

    @Then("^currency should be same as the one in commerce page$")
    public void currencyShouldBeSameAsTheOneInCommercePage() throws Throwable {
        Assert.assertEquals(productPage.configCurrency.getText(), "EUR - Euro");
    }

    @Then("^update, start over, cancel configuration buttons should be present$")
    public void updateStartOverCancelConfigurationButtonsShouldBePresent() throws Throwable {
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
        Assert.assertTrue(productPage.startOver.isDisplayed());
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
    }

    @Then("^hub site details drop down should populate entry fields with proper message$")
    public void hubSiteDetailsDropDownShouldPopulateEntryFields() throws Throwable {
        Thread.sleep(10000);
        productPage.addressEntryDropdown.click();
        Assert.assertEquals(productPage.getWarningMessage(productPage.siteAddressMsg),
                "Site Address field for Hub. Please enter a valid address.");
        Assert.assertEquals(productPage.getWarningMessage(productPage.bldgMsg),
                "Please enter either Building Name or Building Number.");
        Assert.assertEquals(productPage.getWarningMessage(productPage.bldgNoMsg),
                "Please enter either Building Name or Building Number.");
        Assert.assertEquals(productPage.getWarningMessage(productPage.streetMsg),
                "Please enter the appropriate Street Name of atleast 3 characters. This is a mandatory field.");
        Assert.assertEquals(productPage.getWarningMessage(productPage.cityMsg),
                "Please enter the appropriate City of atl east 3 characters. This is a mandatory field");
        Assert.assertEquals(productPage.getWarningMessage(productPage.cntryMsg),
                "Please enter the appropriate Country");
        Assert.assertEquals(productPage.getWarningMessage(productPage.postCodeMsg),
                "Please enter the appropriate Post Code / Zip Code of at least 3 characters. This is a mandatory field");
    }

    @Then("^Google should show suggestions in drop down for entered address$")
    public void googleShouldShowSuggestionsInDropDownForEnteredAddress() throws Throwable {
        Thread.sleep(10000);
        productPage.addressEntryDropdown.click();
        productPage.addressEntry.sendKeys("3, Julius-Tandler-Platz, Wien, Austria, Wien");
        Thread.sleep(5000);
        Assert.assertTrue(StringUtils.isNotBlank(productPage.getWarningMessage(productPage.googleSuggestions)));
    }

    @Then("^user should be able to select the address$")
    public void userShouldBeAbleToSelectTheAddress() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^address drop down fields should get populated$")
    public void addressDropDownFieldsShouldGetPopulated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^check connectivity button should get generated$")
    public void checkConnectivityButtonShouldGetGenerated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Site Details, Features tab should not be present$")
    public void siteDetailsFeaturesTabShouldNotBePresent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^check connectivity button is clicked it should generate three tabs$")
    public void checkConnectivityButtonIsClickedItShouldGenerateThreeTabs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^new address is selected it should show message to recheck connectivity$")
    public void newAddressIsSelectedItShouldShowMessageToRecheckConnectivity() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
