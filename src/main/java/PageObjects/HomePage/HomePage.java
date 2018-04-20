package PageObjects.HomePage;

import Helper.WaitHelper;
import PageObjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class HomePage extends BasePage {

    private WebDriver driver;
    private WaitHelper wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='No']")
    public WebElement no;

    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPwd(String pwd) {
        password.sendKeys(pwd);
    }

    public void loginToMainPage() {
        submitButton.click();
    }


    public void loginToHomePage() {
        enterUsername("Abhishek.bahadur@colt.net");
        enterPwd("Colt1234");
        loginToMainPage();
        wait = new WaitHelper(this.driver);
        try {
            wait.waitForElement(no);
            no.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
