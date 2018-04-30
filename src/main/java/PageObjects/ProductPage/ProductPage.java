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

    @FindBy(xpath = "(//a[contains(text(),'Manager')])[1]")
    public WebElement quoteManager;

    @FindBy(xpath = "//li[@id='dataVoice-ethernet']")
    public WebElement ethernet;

    @FindBy(xpath = "//a[contains(text(),'Ethernet Hub')]")
    public WebElement ethernetHub;

    @FindBy(xpath = "//td[contains(text(),'Cancel Configuration')]")
    public WebElement cancelConfiguration;

    @FindBy(xpath = "//span[contains(text(),'EUR - Euro')]")
    public WebElement configCurrency;

    @FindBy(xpath = "//input[@id='siteAddressAEnd']")
    public WebElement addressEntry;

    @FindBy(xpath = "(//p[contains(@class,'message constraint-message')])[1]")
    public WebElement constraintMsg;

    @FindBy(xpath = "//td[contains(text(),'Check Connectivity')]")
    public WebElement checkConnectivity;

    @FindBy(xpath = "//span[@class='collapsed']")
    public WebElement collapseAddressDetails;

    @FindBy(xpath = "(//input[contains(@id,'premiseNumberAEnd')])[2]")
    public WebElement buildingNumberField;

    @FindBy(xpath = "//a[@id='update']")
    public WebElement updateButton;

    @FindBy(xpath = "//a[contains(@id,'start_over')]")
    public WebElement startOver;

    @FindBy(xpath = "//span[contains(text(),'Hub Site Address Details')]")
    public WebElement addressEntryDropdown;

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

    @FindBy(xpath = "//select[contains(@id,'resiliencyServiceLevel')]")
    public WebElement resiliencyDrop;

    @FindBy(xpath = "(//span[contains(@class,'attribute-field read-only')])[3]")
    public WebElement endAddress;

    @FindBy(xpath = "(//span[contains(@class,\"attribute-field read-only\")])[6]")
    public WebElement buildingType;

    @FindBy(xpath = "((//*[contains(@class, 'general_fields')])[3]/td)[1]")
    public WebElement basePriceSiteDetails;

    @FindBy(xpath = "((//*[contains(@class, 'general_fields')])[5]/td)[1]")
    public WebElement grossPrice;

    @FindBy(xpath = "//input[contains(@id,'outsideBusinessHoursInstallationAEnd_true')]")
    public WebElement obh;

    @FindBy(xpath = "(//*[contains(@class, 'general_fields')])[4]/td")
    public WebElement obhPriceTable;

    @FindBy(xpath = "//a[contains(@id,'add_to_transaction')]")
    public WebElement saveButton;

    public void clearFieldEntry(WebElement element){
        this.elementName = element;
        element.clear();
    }

    @FindBy(xpath = "(//p)[1]")
    public WebElement siteAddressMsg;

    @FindBy(xpath = "(//p)[2]")
    public WebElement bldgMsg;

    @FindBy(xpath = "(//p)[3]")
    public WebElement bldgNoMsg;

    @FindBy(xpath = "(//p)[4]")
    public WebElement streetMsg;

    @FindBy(xpath = "(//p)[5]")
    public WebElement cityMsg;

    @FindBy(xpath = "(//p)[6]")
    public WebElement cntryMsg;

    @FindBy(xpath = "(//p)[7]")
    public WebElement postCodeMsg;

    @FindBy(xpath = "//input[contains(@id,'roomNumberAEnd')]")
    public WebElement roomNumb;

    @FindBy(xpath = "//input[contains(@id,'buildingNameAEnd')]")
    public WebElement bldgName;

    @FindBy(xpath = "//input[contains(@id,'premiseNumberAEnd')]")
    public WebElement bldgNo;

    @FindBy(xpath = "//input[contains(@id,'streetNameAEnd')]")
    public WebElement strtName;

    @FindBy(xpath = "//input[contains(@id,'cityAEnd')]")
    public WebElement cityName;

    @FindBy(xpath = "//input[contains(@id,'countryAEnd')]")
    public WebElement cntryName;

    @FindBy(xpath = "//input[contains(@id,'postCodeAEnd')]")
    public WebElement postCode;

    @FindBy(xpath = "(//div[contains(@class,'pac-container pac-logo')]/div)[2]/span[contains(@class,'pac-item-query')]")
    public WebElement googleSuggestions;

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

    public void clickOnButton(String button){
        switch (button){
            case "cancel":
                cancelConfiguration.click();
                break;
            case "start over":
                startOver.click();
                break;
        }
    }

}
