package stepdefinition;

import Helper.LoginHelper;
import ObjectRepo.ObjectRepo;
import PageObjects.HomePage.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {

    private HomePage homePage;

    @Then("^am at the home page of C4C$")
    public void home_page() throws Throwable{
        ObjectRepo.driver.get("http://my325462-sso.crm.ondemand.com/sap/byd/runtime");
        homePage = new HomePage(ObjectRepo.driver);
        homePage.loginToHomePage();
    }

}
