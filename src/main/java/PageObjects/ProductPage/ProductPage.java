package PageObjects.ProductPage;

import PageObjects.CommercePage.CommercePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommercePage {

    private WebDriver driver;
    private WebElement elementName;
    private String printedMessage;
    private String elementText;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id='dataVoice-ethernet']")
    public WebElement ethernet;

    @FindBy(xpath = "//a[contains(text(),'Ethernet Hub')]")
    public WebElement ethernetHub;

    @FindBy(xpath = "//td[contains(text(),'Cancel Configuration')]")
    public WebElement cancelConfiguration;

    @FindBy(xpath = "//input[@id='siteAddressAEnd']")
    public WebElement addressEntry;

    @FindBy(xpath = "//td[contains(text(),'Check Connectivity')]")
    public WebElement checkConnectivity;

    @FindBy(xpath = "//span[@class='collapsed']")
    public WebElement collapseAddressDetails;

    @FindBy(xpath = "(//input[contains(@id,'premiseNumberAEnd')])[2]")
    public WebElement buildingNumberField;

    @FindBy(xpath = "//a[@id='update']")
    public WebElement updateButton;

    @FindBy(xpath = "(//p)[2]")
    public WebElement warningMsgBuildingNumber;

    @FindBy(xpath = "(//span[contains(text(),'Site Details')])[1]")
    public WebElement siteDetails;

    @FindBy(xpath = "(//span[contains(text(),'Features')])[1]")
    public WebElement features;

    @FindBy(xpath = "(//span[contains(text(),'Site Address')])[1]")
    public WebElement siteAddress;

    @FindBy(xpath = "//select[contains(@id,'serviceBandwidth')]")
    public WebElement serviceDropDown;

    @FindBy(xpath = "((//*[contains(@class, 'general_fields')])[3]/td)[1]")
    public WebElement basePriceSiteDetails;

    @FindBy(xpath = "((//*[contains(@class, 'general_fields')])[5]/td)[1]")
    public WebElement grossPrice;

    @FindBy(xpath = "//input[contains(@id,'outsideBusinessHoursInstallationAEnd_true')]")
    public WebElement obh;

    @FindBy(xpath = "(//*[contains(@class, 'general_fields')])[4]/td")
    public WebElement obhPriceTable;

    @FindBy(xpath = "")
    public WebElement saveButton;

    public void clearFieldEntry(WebElement element){
        this.elementName = element;
        element.clear();
    }

    public String getWarningMessage(WebElement element){
        this.printedMessage = element.getAttribute("textContent");
        return printedMessage;
    }

    public void addProductPageProduct(String productName){
        switch (productName){
            case "hub":
                Actions actions = new Actions(driver);
                actions.moveToElement(ethernet).moveToElement(ethernetHub).click().perform();
                break;
        }
    }

}
