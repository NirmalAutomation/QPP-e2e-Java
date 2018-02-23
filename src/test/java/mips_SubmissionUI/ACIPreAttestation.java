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

public class ACIPreAttestation extends Base{
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
    public void aciPreAttestation() throws InterruptedException {

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");

        // Select the "ACI Transition" Button
        Thread.sleep(10000);
        ac.getTransitionACI().click();
        Log.info("Click action on ACI Transition Button");


        // Pre-attestation help icon
        Thread.sleep(1000);
        ac.getPreAttestPopup().click();
        Log.info("Click action on Pre-attestation help icon");

        // Assert the Pre-Attestation help popup text
        try {
            Assert.assertEquals(ac.getPrePopupTxt().getText(), "You must attest Yes to these Attestation Statements in order to move forward with the Advancing Care Information category. You can read more about these statements by clicking the arrow to the left of each statement.");
            Log.info("Pre-Attestation help popup contains appropriate text");
        } catch (Exception e) {
            Log.error("Pre-Attestation help popup doesn't contain appropriate text");
        }

        // Select the Pre-attestation statements
        Thread.sleep(1000);
        ac.attestACI_INFBLO_1().click();
        Log.info("Click action on 'Yes' radio button for Prevention of Info Pre-attestation");

        Thread.sleep(1000);
        ac.attestACI_ONCDIR_1().click();
        Log.info("Click action on 'Yes' radio button for ONC Direct Review Pre-attestation");

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
