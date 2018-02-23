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

public class ACIOptionalAttestation extends Base {

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

    @Test(priority = 0)
    public void aciOptionalHeaderPopup() throws InterruptedException {

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // ACI Optional Measure help popup
        Thread.sleep(1000);
        ac.getOptionalPopup().click();
        Log.info("Click action on Optional help icon");

        // ACI Page Scrolling
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");

    }

    @Test(priority = 1)
    public void aciOptionalAttestation() throws InterruptedException {

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // Immunization Registry Reporting ACI_TRANS_PHCDRR_1
        ac.getYesACI_TRANS_PHCDRR_1().click();
        Log.info("Click action 'Yes' radio button for Immunization Registry Reporting ACI_TRANS_PHCDRR_1");

        // Patient-Specific Education ACI_TRANS_PSE_1
        ac.getNumACI_TRANS_PSE_1().sendKeys("1");
        ac.getDenACI_TRANS_PSE_1().sendKeys("1");
        Log.info("Click action 'Yes' radio button for Patient-Specific Education ACI_TRANS_PSE_1");

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
