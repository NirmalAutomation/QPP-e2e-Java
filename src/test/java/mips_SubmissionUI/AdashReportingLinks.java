package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pack_PageObject.*;
import resources.Base;
import org.testng.annotations.*;

import java.io.IOException;

public class AdashReportingLinks extends Base {

    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {
        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("MIPS Application Launched and Home page displayed");

    }

    @BeforeClass
    public void loginMIPS() {

        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);
        Log.info("Login page displayed");

        // QPP Account Login
        l.getSignin().click();
        Log.info("Click action performed on Signin button");

    }

    @Test(priority = 0)
    public void groupReportingLink() throws InterruptedException {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Report as Group User
        Thread.sleep(1000);
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

        // Navigate to Account Dashboard
        g.getAccountDashboard().click();
    }

    @Test(priority = 1)
    public void individualReportingLink() throws InterruptedException {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Report as Individual User
        Thread.sleep(1000);
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