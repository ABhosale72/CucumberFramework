package PageObjects.CommercePage;

import PageObjects.MainPage.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommercePage extends MainPage{

    private WebDriver driver;
    private String offerTypeText;
    private String technicalComplexityText;
    private String legalComplexityText;
    private String dealClassText;
    private String go0ApprovalText;
    private String pricingSegmentText;

    public CommercePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Quote Details']")
    public WebElement quoteDetails;

    @FindBy(xpath = "//input[contains(@id,'opportunityID_t')]")
    public WebElement opportunityID;

    @FindBy(xpath = "//span[contains(@id,'opportunityName')]")
    public WebElement opportunityName;

    @FindBy(xpath = "//span[contains(@id,'offerType')]")
    public WebElement offerType;

    @FindBy(xpath = "//span[contains(@id,'opportunityCreatedBy')]")
    public WebElement opportunityCreatedBy;

    @FindBy(xpath = "//span[contains(@id,'technicalComplexity')]")
    public WebElement technicalComplexity;

    @FindBy(xpath = "//span[contains(@id,'legalComplexity')]")
    public WebElement legalComplexity;

    @FindBy(xpath = "//span[contains(@id,'dealClass')]")
    public WebElement dealClass;

    @FindBy(xpath = "//span[contains(@id,'go0Approval')]")
    public WebElement go0Approval;

    @FindBy(xpath = "//input[contains(@id,'oCN')]")
    public WebElement ocNumber;

    @FindBy(xpath = "//span[contains(@id,'accountName_t')]")
    public WebElement accountName;

    @FindBy(xpath = "//span[contains(@id,'address_t')]")
    public WebElement accountAddress;

    @FindBy(xpath = "//span[contains(@id,'pricingSegment')]")
    public WebElement pricingSegment;

    @FindBy(xpath = "//input[contains(@id,'customerContactName')]")
    public WebElement firstName;

    @FindBy(xpath = "//input[contains(@id,'customerlastName')]")
    public WebElement lastName;

    @FindBy(xpath = "//input[contains(@id,'contactEmailAddress')]")
    public WebElement email;

    @FindBy(xpath = "//input[contains(@id,'customerContactPhone')]")
    public WebElement phoneNo;

    @FindBy(xpath = "//input[contains(@id,'_customer_t_address')]")
    public WebElement legalAddress;

    @FindBy(xpath = "//a[contains(@id,'add_product')]")
    public WebElement addProduct;

    public String getOfferType(){
        this.offerTypeText = offerType.getText();
        return offerTypeText;
    }

    public String getTechnicalComplexity(){
        this.technicalComplexityText = technicalComplexity.getText();
        return technicalComplexityText;
    }

    public String getLegalComplexity(){
        this.legalComplexityText = legalComplexity.getText();
        return legalComplexityText;
    }

    public String getDealClass(){
        this.dealClassText = dealClass.getText();
        return dealClassText;
    }

    public String getGo0Approval(){
        this.go0ApprovalText = go0Approval.getText();
        return go0ApprovalText;
    }

    public String getPricingSegment(){
        this.pricingSegmentText = pricingSegment.getAttribute("innerHTML");
        return pricingSegmentText;
    }

    public Boolean getTextStatus(WebElement element){
        if(element.getText()==null){
            return false;
        } else return true;
    }

    public Boolean getTextAttributeStatus(WebElement element){
        if(element.getAttribute("textContent")==null){
            return false;
        } else return true;
    }
}
