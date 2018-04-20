package stepdefinition;

import ObjectRepo.ObjectRepo;
import PageObjects.HomePage.HomePage;
import PageObjects.MainPage.MainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class CreateAccount {

    private HomePage homePage;
    private MainPage mainPage;
    private WebDriver driver;

    @When("^user has logged in$")
    public void user_login() throws Throwable{
        this.driver = ObjectRepo.driver;
        ObjectRepo.driver.get("http://my325462-sso.crm.ondemand.com/sap/byd/runtime");
        homePage = new HomePage(driver);
        homePage.loginToHomePage();
    }

    @Then("^enter the account details$")
    public void enter_account_details() throws Throwable{
        Thread.sleep(20000);
        mainPage = new MainPage(driver);
        mainPage.accountCreate();
    }

}
