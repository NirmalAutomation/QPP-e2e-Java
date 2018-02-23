package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import pack_PageObject.B_LoginPage;
import pack_PageObject.C_AccountDashboard;
import pack_PageObject.D_GroupDashboard;
import pack_PageObject.F_ACIPage;
import resources.Base;

import java.io.IOException;

public class ACINonBaseYellow extends Base {
    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {

        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("MIPS Application Launched and Home page displayed");
    }

    @BeforeClass
    public void loginMIPS() throws InterruptedException {
        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);
        Log.info("Login page displayed");

        // QPP Account Login
        l.getSignin().click();
        Log.info("Click action performed on Signin button");

        // Account Dashboard
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Report as Group User
        Thread.sleep(1000);
        a.getGroup().click();
        Log.info("Click action performed on Group Reporting button");

        // Group Dashboard
        D_GroupDashboard g = new D_GroupDashboard(driver);
        Log.info("Group Dashboard displayed");

        // ACI Reporting Button
        g.getACIButton().click();
        Log.info("Click action performed on ACI Reporting button");

    }

    @Test
    public void aciOptionalYellow() throws InterruptedException {

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");


        // Assert the Optional Yellow Banner
        try {
            Assert.assertEquals(ac.getOptionalYellow().getText(), "You will be unable to attest to these measures until you have completed both the Attestation Statements and Required for Base Score measures above.");
            Log.info("ACI Page contains the Optional measures yellow Banner");
        } catch (Exception e) {
            Log.error("ACI Page doesn't contain the Optional measures yellow Banner");
        }

        // Assert the Additional Base Yellow Banner
        try {
            Assert.assertEquals(ac.getBonusYellow().getText(), "You will be unable to attest to these measures until you have completed both the Attestation Statements and Required for Base Score measures above.");
            Log.info("ACI Page contains the Additional Base measures yellow Banner");
        } catch (Exception e) {
            Log.error("ACI Page doesn't contain the Additional Base measures yellow Banner");
        }

        // Assert the CEHRT Yellow Banner
        try {
            Assert.assertEquals(ac.getCEHRTYellow().getText(), "You will be unable to attest to these measures until you have completed both the Attestation Statements and Required for Base Score measures above.");
            Log.info("ACI Page contains the CEHRT measures yellow Banner");
        } catch (Exception e) {
            Log.error("ACI Page doesn't contain the CEHRT measures yellow Banner");
        }

    }

    @AfterClass
    public void logoutMIPS() throws InterruptedException {

        // ACI Page displayed
        Thread.sleep(1000);
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // Logout
        ac.getMyAccount().click();
        Log.info("Click action performed on MyAccount header link");

        ac.getLogout().click();
        Log.info("Click action performed on Sign out link");

        ac.getConfirmLogout().click();
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
