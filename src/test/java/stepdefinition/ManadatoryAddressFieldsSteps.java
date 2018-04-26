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

public class ManadatoryAddressFieldsSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private ProductPage productPage;

    @When("^user is inside CPQ$")
    public void CPQLogin() throws Throwable{
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

    @Then("^user clicks on the add button$")
    public void userClicksOnTheAddButton() throws Throwable {
        Thread.sleep(10000);
        commercePage.addProduct.click();
    }


    @And("^user chooses ethernet hub and is inside config page$")
    public void userChoosesEthernetHub() throws Throwable {
        productPage = new ProductPage(ObjectRepo.driver);
        Thread.sleep(10000);
        productPage.addProductPageProduct("hub");
        Thread.sleep(10000);
        Assert.assertTrue(productPage.cancelConfiguration.isDisplayed());
    }

    @And("^he can enter the address in the address entry and choose google suggestion$")
    public void heCanEnterTheAddressInTheAddressEntry() throws Throwable {
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys("3, Julius-Tandler-Platz, Wien, Austria, Wien");
        Thread.sleep(10000);
        productPage.addressEntry.sendKeys(Keys.DOWN);
        productPage.addressEntry.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^he can see check connectivity button$")
    public void heCanSeeCheckConnectivityButton() throws Throwable {
        productPage.checkConnectivity.isDisplayed();
    }

    @Then("^he clicks on the detail dropdown and removes mandatory building number field$")
    public void heClicksOnTheDetailDropdownAndRemovesMandatoryZipCode() throws Throwable {
        productPage.collapseAddressDetails.click();
        Thread.sleep(10000);
        productPage.buildingNumberField.clear();
        productPage.updateButton.click();
    }

    @Then("^there should be a warning message about mandatory field$")
    public void thereShouldBeAWarningMessageAboutMandatoryField() throws Throwable {
        productPage.getWarningMessage(productPage.warningMsgBuildingNumber);
        Assert.assertEquals(productPage.getWarningMessage(productPage.warningMsgBuildingNumber), "Please enter either Building Name or Building Number.");
    }

    @Then("^there should be no check connectivity button$")
    public void thereShouldBeNoCheckConnectivityButton() throws Throwable {
        Assert.assertFalse(productPage.checkConnectivity.isDisplayed());
    }


}
