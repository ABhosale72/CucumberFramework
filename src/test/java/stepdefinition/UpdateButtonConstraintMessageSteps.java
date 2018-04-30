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
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class UpdateButtonConstraintMessageSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private ProductPage productPage;

    @When("^user is inside the commerce page$")
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

    @Then("^he clicks the add button$")
    public void heClicksTheAddButton() throws Throwable {
        productPage = new ProductPage(ObjectRepo.driver);
        Thread.sleep(10000);
        commercePage.addProduct.click();
        Thread.sleep(10000);
        Assert.assertTrue(productPage.quoteManager.isDisplayed());
    }

    @And("^he chooses ethernet hub in the product list page$")
    public void heChoosesEthernetHubInTheProductListPage() throws Throwable {
        productPage.addProductPageProduct("hub");
        Thread.sleep(10000);
    }

    @Then("^he is inside the config page$")
    public void heIsInsideTheConfigPage() throws Throwable {
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
    }

    @Then("^he enters the \"([^\"]*)\" into the field$")
    public void heEntersTheIntoTheField(String arg0) throws Throwable {
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(arg0);
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(Keys.DOWN);
        productPage.addressEntry.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^he does connectivity check$")
    public void heDoesConnectivityCheck() throws Throwable {
        productPage.checkConnectivity.click();
        Thread.sleep(10000);
    }

    @Then("^he should be seeing three tabs$")
    public void heShouldBeSeeingThreeTabs() throws Throwable {
        Assert.assertTrue(productPage.siteDetails.isDisplayed());
        Assert.assertTrue(productPage.features.isDisplayed());
        Assert.assertTrue(productPage.siteAddress.isDisplayed());
        Thread.sleep(10000);
    }


    @Then("^he enters the other \"([^\"]*)\" into the field$")
    public void heEntersTheOtherIntoTheField(String arg0) throws Throwable {
        productPage.addressEntry.clear();
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(arg0);
        productPage.addressEntry.sendKeys(Keys.DOWN);
        productPage.addressEntry.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^he should see the \"([^\"]*)\"$")
    public void heShouldSeeThe(String arg0) throws Throwable {
        Assert.assertEquals(productPage.getWarningMessage(productPage.constraintMsg),arg0);
    }
}
