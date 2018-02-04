package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_QualityPage {

    WebDriver driver;

    public E_QualityPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // 1. Logos validation
    @FindBy(xpath = "//img[@class='qpp-logo']")
    WebElement qpplogo;

    @FindBy(xpath = "//img[@alt='Center for Medicaid & Medicare Services']")
    WebElement cmslogo;

    // 2. Header Elements
    @FindBy(css = "li.dropdown:nth-child(4)")
    WebElement myaccount;

    @FindBy(css = ".logout")
    WebElement logout;

    @FindBy(css = ".primary-action")
    WebElement confirm;

    // 3. Text "Quality"
    @FindBy(css = ".page-title")
    WebElement qualitytxt;

    // 4. Left hand navigation bar elements
    @FindBy(linkText = "Account Dashboard")
    WebElement accountDashboard;

    @FindBy(linkText = "Connected Clinicians")
    WebElement connectedClinicians;

    @FindBy(linkText = "Group Dashboard")
    WebElement groupDashboard;

    @FindBy(linkText = "Quality Measures")
    WebElement qualityNavigation;

    @FindBy(linkText = "Advancing Care Information")
    WebElement aciNavigation;

    @FindBy(xpath = "Improvement Activities")
    WebElement iaNavigation;

    @FindBy(css = "button.link-inline")
    WebElement groupReportDD;

    @FindBy(css = ".link-collapse")
    WebElement collapsebtn;

    // 5. Main Page Buttons
    // a) Full Instructions
    @FindBy(css = ".show-modal-btn")
    WebElement openFullInstructions;

    @FindBy(xpath = "//div[@class='modal-header']/h4")
    WebElement titleFullInstructions;

    @FindBy(css = "button.pull-right:nth-child(1)")
    WebElement closeFullInstructions;

    // b) File Upload
    @FindBy(css = ".file-upload-button")
    WebElement openFileUpload;

    @FindBy(xpath = "//button[@class='btn btn-default close-modal-btn']")
    WebElement closeFileUpload;

    // c) Delete Category Data
    @FindBy(linkText = "Delete Category Data")
    WebElement deleteData;

    // 1. Logos validation
    public WebElement getQPPLogo() {
        return qpplogo;
    }

    public WebElement getcmsLogo() {
        return cmslogo;
    }

    // 2. Header Elements
    public WebElement getMyAccount() {
        return myaccount;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getConfirmLogout() {
        return confirm;
    }

    // 3. Text "Quality"
    public WebElement assertQualityTxt() {
        return qualitytxt;
    }

    // 4. Left hand navigation bar elements

    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    public WebElement getConnectedClinicians() {
        return connectedClinicians;
    }

    public WebElement getGroupDashboard() {
        return groupDashboard;
    }

    public WebElement getQuality() {
        return qualityNavigation;
    }

    public WebElement getACI() {
        return aciNavigation;
    }

    public WebElement getIA() {
        return iaNavigation;
    }

    public WebElement closeGroupChevron() {
        return groupReportDD;
    }

    public WebElement getCollapseButton() {
        return collapsebtn;
    }

    // 5. Main Page Buttons
    // a) Full Instructions
    public WebElement openFullInstructions() {
        return openFullInstructions;
    }

    public WebElement closeFullInstructions() {
        return closeFullInstructions;
    }

    public WebElement titleFullInstructions() {
        return titleFullInstructions;
    }

    // b) File Upload
    public WebElement openFileUpload() {
        return openFileUpload;
    }

    public WebElement closeFileUpload() {
        return closeFileUpload;
    }

    // c) Delete Category Data
    public WebElement openDeleteData() {
        return deleteData;
    }
}



