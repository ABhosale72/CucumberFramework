package Helper;

import PageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper extends BasePage{

    private WebDriver driver;

    public WaitHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(10000, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
    }
}
