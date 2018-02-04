package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class H_ConnectedClinicians {

    WebDriver driver;

    public H_ConnectedClinicians(WebDriver driver) {
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

    // 3. Text "Connected Clinicians"
    @FindBy(xpath = "//div[@class='flex-column-reverse']/h1")
    WebElement connectedclini;

    // 4. Category Pages
    @FindBy(css = "div.category-card:nth-child(1) > a:nth-child(2)")
    WebElement quality;

    @FindBy(css = "div.category-card:nth-child(2) > a:nth-child(2)")
    WebElement aci;

    @FindBy(css = "div.category-card:nth-child(3) > a:nth-child(2)")
    WebElement ia;

    // 5. Left hand navigation bar elements
    @FindBy(linkText = "Account Dashboard")
    WebElement accountDashboard;

    @FindBy(linkText = "Connected Clinicians")
    WebElement connectedclinicians;

    @FindBy(linkText = "Group Dashboard")
    WebElement groupDashboard;

    @FindBy(linkText = "Quality Measures")
    WebElement qualityNavigation;

    @FindBy(linkText = "Advancing Care Information")
    WebElement aciNavigation;

    @FindBy(linkText = "Improvement Activities")
    WebElement iaNavigation;

    @FindBy(css = "button.link-inline")
    WebElement groupReportDD;

    @FindBy(css = ".link-collapse")
    WebElement collapsebtn;

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

    // 3. Text "Group Reporting Dashboard"
    public WebElement assertCliniciansTxt() {
        return connectedclini;
    }

    // 4. Category Pages
    public WebElement getQualityButton() {
        return quality;
    }

    public WebElement getACIButton() {
        return aci;
    }

    public WebElement getIAButton() {
        return ia;
    }

    // 5. Left hand navigation bar elements

    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    public WebElement getConnectedClinicians() {
        return connectedclinicians;
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
}

