package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.CommercePage.CommercePage;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import PageObjects.ProductPage.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ButtonsOfConfigPageSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private CommercePage commercePage;
    private ProductPage productPage;

    @When("^user is in CPQ$")
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

    @Then("^add product is clicked$")
    public void addProductIsClicked() throws Throwable {
        Thread.sleep(10000);
        productPage = new ProductPage(ObjectRepo.driver);
        productPage.addProduct.click();
        Thread.sleep(10000);
        Assert.assertTrue(productPage.quoteManager.isDisplayed());
    }

    @And("^user selects Hub$")
    public void userSelectsHub() throws Throwable {
        productPage.addProductPageProduct("hub");
        Thread.sleep(10000);
    }

    @And("^user clicks on \"([^\"]*)\" config button$")
    public void userClicksOnConfigButton(String arg0) throws Throwable {
        Thread.sleep(10000);
        productPage.clickOnButton(arg0);
        Thread.sleep(5000);
        try {
            ObjectRepo.driver.switchTo().alert().accept();
        }catch (Exception e){}
        Thread.sleep(5000);
    }

    @Then("^he should be back in CPQ$")
    public void heShouldBeBackInCPQ() throws Throwable {
        Thread.sleep(10000);
        commercePage.quoteDetails.isDisplayed();
    }

}
