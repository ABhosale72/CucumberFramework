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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductAdditionWithAddOnsSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private ProductPage productPage;

    @When("^user has logged into CPQ$")
    public void userLoginCPQ()throws Throwable{
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

    @And("^user clicks add button$")
    public void userClicksAddButton() throws Throwable {
        Thread.sleep(10000);
        commercePage.addProduct.click();
    }


    @Then("^he selects \"([^\"]*)\" on the product page$")
    public void heSelectsOnTheProductPage(String arg0) throws Throwable {
        productPage = new ProductPage(ObjectRepo.driver);
        Thread.sleep(10000);
        productPage.addProductPageProduct(arg0);
        Thread.sleep(10000);
    }

    @Then("^he is on the config page$")
    public void heIsOnTheConfigPage() throws Throwable {
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
    }

    @And("^he enters the \"([^\"]*)\" on the  page$")
    public void heEntersTheOnThePage(String arg0) throws Throwable {
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(arg0);
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(Keys.DOWN);
        productPage.addressEntry.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^he clicks on check connectivity button$")
    public void heClicksOnCheckConnectivityButton() throws Throwable {
        productPage.checkConnectivity.click();
        Thread.sleep(10000);
    }

    @Then("^he should see 3 tabs of site address, site details and features$")
    public void heShouldSeeTabsOfSiteAddressSiteDetailsAndFeatures(int arg0) throws Throwable {
        Assert.assertTrue(productPage.siteDetails.isDisplayed());
        Assert.assertTrue(productPage.features.isDisplayed());
        Assert.assertTrue(productPage.siteAddress.isDisplayed());
        Thread.sleep(10000);
    }

    @Then("^he moves to site details$")
    public void heMovesToSiteDetails() throws Throwable {
        productPage.siteDetails.click();
        Thread.sleep(10000);
    }

    @And("^he chooses \"([^\"]*)\"$")
    public void heChooses(String arg0) throws Throwable {
        Select dropdown = new Select(productPage.serviceDropDown);
        dropdown.selectByValue(arg0);
        Thread.sleep(10000);
    }

    @Then("^he should see base price table$")
    public void heShouldSeeBasePriceTable() throws Throwable {
        Assert.assertTrue(productPage.basePriceSiteDetails.isDisplayed());
        Thread.sleep(10000);
    }

    @Then("^he click on features$")
    public void heClickOnFeatures() throws Throwable {
        productPage.features.click();
        Thread.sleep(10000);
    }

    @And("^chooses OBH$")
    public void choosesOBH() throws Throwable {
        productPage.obh.click();
        Thread.sleep(10000);
    }

    @Then("^he should see base price and obh in the table below$")
    public void heShouldSeeBasePriceAndObhInTheTableBelow() throws Throwable {
        Assert.assertEquals(productPage.getWarningMessage(productPage.grossPrice),"Gross Price");
        Assert.assertEquals(productPage.getWarningMessage(productPage.obhPriceTable), "Outside Business Hours Installation");
        Thread.sleep(10000);
    }

    @Then("^he clicks save to quote$")
    public void heClicksSaveToQuote() throws Throwable {
        productPage.saveButton.click();
        Thread.sleep(20000);
    }

    @Then("^he should be in CPQ$")
    public void heShouldBeInCPQ() throws Throwable {
        Assert.assertEquals(commercePage.quoteDetails.getText(), "QUOTE DETAILS");
    }
}
