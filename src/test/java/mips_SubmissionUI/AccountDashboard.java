package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pack_PageObject.*;
import resources.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.io.IOException;

public class AccountDashboard extends Base {

    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {
        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("MIPS Application Launched and Home page displayed");

    }

    @BeforeClass
    public void loginMIPS() {

        // QPP qppHomePage
        A_HomePage h = new A_HomePage(driver);
        Log.info("MIPS Home page displayed");

        h.getSignin().click();
        Log.info("Click action performed on My Signin link");

        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);
        Log.info("Login page displayed");

        // Entering valid Username and Password
        l.getEmailId().sendKeys(prop.getProperty("username"));
        Log.info("Username entered in the Username text box");

        l.getPassword().sendKeys(prop.getProperty("password"));
        Log.info("Password entered in the Password text box");

        l.yesAgreeCheckbox().click();
        Log.info("Check on Yes, I agree");

        // QPP Account Login
        l.getSignin().click();
        Log.info("Click action performed on Signin button");
    }

    @Test(priority = 0)
    public void textAccount() {
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        //Verify the text "Account Dashboard" presented in the page
        try {
            Assert.assertEquals(a.assertAccountTxt().getText(), "Account Dashboard");
            Log.info("The page contains the text Account Dashboard");

        } catch (Exception e) {
            Log.error("The page doesn't contains the text Account Dashboard");
        }
    }

    @Test(priority = 1)
    public void logoQPP() {
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Verify that the QPP Logo presented in the page
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                a.getQPPLogo());
        if (ImagePresent) {
            Log.info("QPP Logo displayed.");
        } else {
            Log.info("QPP Logo not displayed.");
        }
    }

    @Test(priority = 2)
    public void logoCMS() {
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Verify that the CMS Logo presented in the page
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                a.getcmsLogo());
        if (ImagePresent) {
            Log.info("CMS Logo displayed.");
        } else {
            Log.info("CMS Logo not displayed.");
        }
    }

    @Test(priority = 3)
    public void groupReportingLink() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Report as Group User
        a.getGroup().click();
        Log.info("Click action performed on Group Reporting button");

        D_GroupDashboard g = new D_GroupDashboard(driver);
        Log.info("Group Dashboard displayed");

        // Verify the text "Group Reporting Dashboard" presented in the page
        try {
            Assert.assertEquals(g.assertGroupTxt().getText(), "Group Reporting Dashboard");
            Log.info("The page contains the text Group Reporting Dashboard");

        } catch (Exception e) {
            Log.error("The page doesn't contains the Group Reporting Dashboard");
        }
    }

    @Test(priority = 7)
    public void individualReportingLink() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Report as Individual User
        a.getIndividual().click();
        Log.info("Click action performed on Individual Reporting button");

        H_ConnectedClinicians c = new H_ConnectedClinicians(driver);
        Log.info("Clinical Clinicians displayed");

        // Verify the text "Connected Clinicians" presented in the page
        try {
            Thread.sleep(1000);
            Assert.assertEquals(c.assertCliniciansTxt().getText(), "Connected Clinicians");
            Log.info("The page contains the text Connected Clinicians Dashboard");

        } catch (Exception e) {
            Log.error("The page doesn't contains the Connected Clinicians Dashboard");
        }
    }

    @Test(priority = 4)
    public void sidebarCollapse() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Make Sidebar Collapse
        a.getCollapseButton().click();
        Log.info("Click action performed on Sidebar Collapse button");

    }

    @Test(priority = 5)
    public void sidebarExpand() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Make Sidebar Expand
        a.getExpandButton().click();
        Log.info("Click action performed on Sidebar Expand button");

    }

    @Test(priority = 6)
    public void accountDashboard() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Refresh the page
        a.getAccountDashboard().click();
        Log.info("Click action performed on Account Dashboard link");

    }

    @AfterClass
    public void logoutMIPS() {
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Logout
        a.getMyAccount().click();
        Log.info("Click action performed on MyAccount header link");

        a.getLogout().click();
        Log.info("Click action performed on Sign out link");

        a.getConfirmLogout().click();
        Log.info("Sign out confirmation");

    }

    @AfterTest
    public void closingBrowser() throws InterruptedException {

        Thread.sleep(1000);
        // Browser closing
        driver.close();
        Log.info("Browser closed");
        driver = null;
    }

}

