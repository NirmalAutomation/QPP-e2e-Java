package mips_SubmissionUI;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pack_PageObject.*;
import resources.Base;

import java.io.IOException;

public class LeftHandNavbarElements extends Base {

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

    @Test
    public void lefthandNavElements() throws InterruptedException {

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

        // Left hand Navigation bar
        // Quality anchor text
        Thread.sleep(1000);
        g.getQuality().click();
        Log.info("Click action performed on Quality Measures button");

        // Quality Page displayed
        E_QualityPage q = new E_QualityPage(driver);
        Log.info("Quality Page displayed");

        // ACI anchor text
        Thread.sleep(1000);
        q.getACI().click();
        Log.info("Click action performed on ACI Measures button");

        // ACI Page displayed
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // IA anchor text
        Thread.sleep(1000);
        ac.getIA().click();
        Log.info("Click action performed on IA Measures button");

        // IA Page displayed
        G_IAPage ia = new G_IAPage(driver);
        Log.info("IA Page displayed");

        // Group Chevron button
        Thread.sleep(1000);
        ia.closeGroupChevron().click();
        Log.info("Click action performed on Group Chevron button");

        // Connected Clinicians button
        Thread.sleep(1000);
        ia.getConnectedClinicians().click();
        Log.info("Click action performed on Connected Clinicians button");

        // Connected Clinicians displayed
        H_ConnectedClinicians c = new H_ConnectedClinicians(driver);
        Log.info("Connected Clinicians page displayed");

        // Account Dashboard anchor text
        Thread.sleep(1000);
        c.getAccountDashboard().click();
        Log.info("Click action performed on Account Dashboard button");

    }

    @AfterClass
    public void logoutMIS() throws InterruptedException {

        // Account Dashboard
        C_AccountDashboard a = new C_AccountDashboard(driver);

        // Logout
        a.getMyAccount().click();
        Log.info("Click action performed on MyAccount header link");

        Thread.sleep(1000);
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
