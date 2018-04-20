package PageObjects.MainPage;

import Helper.WaitHelper;
import PageObjects.BasePage;
import PageObjects.HomePage.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

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

    @FindBy(xpath = "//span[contains(@id,'panel0')]")
    public WebElement customer;

    //@FindBy(xpath = "//a[contains(text(),'Accounts')]")
    //public WebElement accountsHome;

    public void accountCreate(){
        wait = new WaitHelper(this.driver);
        wait.waitForElement(plusHome);
        plusHome.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountsHome.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.waitForElement(name);
        name.sendKeys("AdityaTestAutomation");
        wait.waitForElement(countryDropTextField);
        countryDropTextField.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countryDropTextField.sendKeys(Keys.DOWN);
        countryDropTextField.sendKeys(Keys.RETURN);
        wait.waitForElement(salesChannelDrop);
        salesChannelDrop.sendKeys("Direct");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.waitForElement(businessSectorDrop);
        businessSectorDrop.sendKeys("Information");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        street.sendKeys("Julius-Tandler-Platz");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        city.sendKeys("Wien");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zipcode.sendKeys("1010");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        country.sendKeys("AT - Austria");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        save.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
