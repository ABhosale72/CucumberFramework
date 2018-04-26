package PageObjects.MainPage;

import Helper.WaitHelper;
import PageObjects.BasePage;
import PageObjects.HomePage.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends HomePage{

    private WebDriver driver;
    private WaitHelper wait;
    //private HomePage hPage;

    public MainPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//footer/button/span/span")
    public WebElement plusHome;

    @FindBy(xpath = "//div/section/div/div/div/div/div/span")
    public WebElement accountsHome;

    @FindBy(xpath = "(//span[contains(@id,'jpKk')])[2]")
    public WebElement createAccount;

    @FindBy(xpath = "(//input[contains(@id,'inputfield')])[1]")
    public WebElement name;

    @FindBy(xpath = "(//input[contains(@id,'dropdownlist')])[1]")
    public WebElement countryDropTextField;

    @FindBy(xpath = "(//input[contains(@id,'dropdownlist')])[2]")
    public WebElement salesChannelDrop;

    @FindBy(xpath = "(//input[contains(@id,'dropdownlist')])[3]")
    public WebElement businessSectorDrop;

    @FindBy(xpath = "(//input[contains(@id,'inputfield')])[5]")
    public WebElement street;

    @FindBy(xpath = "(//input[contains(@id,'inputfield')])[6]")
    public WebElement city;

    @FindBy(xpath = "(//input[contains(@id,'inputfield')])[7]")
    public WebElement zipcode;

    @FindBy(xpath = "(//input[contains(@id,'dropdownlist')])[4]")
    public WebElement country;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement save;

    @FindBy(xpath = "//span[contains(@id,'CollapsedImg')]")
    public WebElement customer;

    @FindBy(xpath = "//a[contains(text(),'Accounts')]")
    public WebElement accounts;

    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public WebElement firstSearchButton;

    @FindBy(xpath = "//input[contains(@id,'searchField')]")
    public WebElement searchFieldforAccount;

    @FindBy(xpath = "//a[contains(text(),'AutomationTesting')]")
    public WebElement automationTesting;

    @FindBy(xpath = "(//div[contains(@id,'tabstrip-tabs')]/div)[4]/span")
    public WebElement automationOpportunities;

    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public WebElement automationPageSearchButton;

    @FindBy(xpath = "//input[contains(@id,'searchField')]")
    public WebElement automationSearchFieldforOppo;

    @FindBy(xpath = "//a[contains(text(),'Test_Nam')]")
    public WebElement TestNam;

    @FindBy(xpath = "(//div[contains(@id,'tabstrip')]/div)[2]/div/div[3]/span")
    public WebElement quotes;

    @FindBy(xpath = "//span[text()='Add']")
    public WebElement addButton;


    /*  *   *   *   *  *   *   *    *  *   *   *    *   *   *   *  *   *   *    *  *   *   *
    *   *    *   *   *  This method is used for navigating from C4C to CPQ   *  *   *   *    *
    *   *   *   *   *  *   *   *    *  *   *   *    *   *   *   *  *   *   *    *  *   *   *
    */

    public void navigateToCPQ(){
        tryCatchWait();
        customer.click();
        accounts.click();
        tryCatchWait();
        firstSearchButton.click();
        tryCatchWait();
        searchFieldforAccount.sendKeys("AutomationTesting");
        tryCatchWait();
        searchFieldforAccount.sendKeys(Keys.ENTER);
        tryCatchWait();
        automationTesting.click();
        tryCatchWait();
        automationOpportunities.click();
        tryCatchWait();
        automationPageSearchButton.click();
        tryCatchWait();
        Actions actions = new Actions(driver);
        actions.moveToElement(automationSearchFieldforOppo).click().sendKeys("Test_Nam").sendKeys(Keys.ENTER).build().perform();
        tryCatchWait();
        TestNam.click();
        tryCatchWait();
        quotes.click();
        tryCatchWait();
        addButton.click();
        tryCatchWait();

    }

    private void tryCatchWait(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
