package Helper;

import PageObjects.HomePage.HomePage;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HomePage {

    private WebDriver driver;

    public LoginHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
