package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_AccountDashboard {

    public WebDriver driver;

    public C_AccountDashboard(WebDriver driver) {
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

    @FindBy(css = ".1logout")
    WebElement logout;

    @FindBy(css = ".primary-action")
    WebElement confirm;

    // 3. Text "Account Dashboard"
    @FindBy(css = ".title-container")
    WebElement accountdash;

    // 4. Reporting Group/Individual
    @FindBy(css = ".group-reporting-btn")
    WebElement group;

    @FindBy(css = ".individual-reporting-btn")
    WebElement individual;

    // 5. Left hand navigation bar elements
    @FindBy(linkText = "Account Dashboard")
    WebElement accountDashboard;

    @FindBy(css = ".link-collapse")
    WebElement collapsebtn;

    @FindBy(css = ".link-expand")
    WebElement expandbtn;

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

    // 3. Text "Account Dashboard"
    public WebElement assertAccountTxt() {
        return accountdash;
    }

    // 4. Reporting Group/Individual
    public WebElement getGroup() {
        return group;
    }

    public WebElement getIndividual() {
        return individual;
    }

    // 5. Left hand navigation bar elements
    public WebElement getAccountDashboard() {
        return accountDashboard;
    }

    public WebElement getCollapseButton() {
        return collapsebtn;
    }

    public WebElement getExpandButton() {
        return expandbtn;
    }
}
