package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pack_PageObject.B_LoginPage;
import pack_PageObject.C_AccountDashboard;
import pack_PageObject.D_GroupDashboard;
import pack_PageObject.F_ACIPage;
import resources.Base;

import java.io.IOException;

public class ACITrackSelection extends Base {

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
    public void aciTrackSelection() throws InterruptedException {

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // Select the "ACI Transition" Button
        Thread.sleep(1000);
        ac.getTransitionACI().click();
        Log.info("Click action on ACI Transition Button");

        // Select the "ACI Regular" Button
        Thread.sleep(1000);
        ac.getRegularACI().click();
        Log.info("Click action on ACI Regular Button");

        // Select the "ACI Combination" Button
        Thread.sleep(5000);
        ac.getComboACI().click();
        Log.info("Click action on ACI Combination Button");

        // Assert the ACI Combination information
        try {
            Assert.assertEquals(ac.getACIComboTxt().getText(), "Selection of the Combination Track will allow the user to select measures from both Advancing Care Information Measures and 2017 Advancing Care Information Transition Measures. The Combination Track will only allow the user to select only one associated measure from each track, if applicable.");
            Log.info("ACI page has Combination Information Text");
        }
        catch (Exception e){
            Log.error("ACI page doesn't have Combination Information Text");
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
