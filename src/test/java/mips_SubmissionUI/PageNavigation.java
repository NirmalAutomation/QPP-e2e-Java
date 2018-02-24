package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pack_PageObject.*;
import resources.Base;
import org.testng.annotations.*;

import java.io.IOException;

public class PageNavigation extends Base {

    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {

        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("MIPS Application Launched and HomePage displayed");

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
    public void pageNavigation() throws InterruptedException {

        // Account Dashboard
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");


        // Navigate to Group Reporting Dashboard
        Thread.sleep(1000);
        a.getGroup().click();
        Log.info("Click action performed on Group Reporting button");

        // Group Reporting Dashboard
        D_GroupDashboard g = new D_GroupDashboard(driver);
        Log.info("Group Dashboard displayed");

        // Navigate to Quality page
        Thread.sleep(1000);
        g.getQualityButton().click();
        Log.info("Click action performed on Quality link");

        // Quality page
        E_QualityPage q = new E_QualityPage(driver);
        Log.info("Quality Page displayed");

        // Navigate to ACI page
        Thread.sleep(1000);
        q.getACI().click();
        Log.info("Click action performed on ACI link");

        // ACI page
        F_ACIPage ac = new F_ACIPage(driver);
        Log.info("ACI Page displayed");

        // Navigate to IA page
        Thread.sleep(1000);
        ac.getIA().click();
        Log.info("Click action performed on IA link");

        // IA page
        G_IAPage ia = new G_IAPage(driver);
        Log.info("IA Page displayed");

        // Header element "My Account"
        ia.getAccountDashboard().click();
        Log.info("Click action performed on Account Dashboard link");

    }

    @AfterClass
    public void logoutMIPS() {

        // IA page
        G_IAPage ia = new G_IAPage(driver);
        Log.info("IA Page displayed");

        // Logout
        ia.getMyAccount().click();
        Log.info("Click action performed on MyAccount header link");

        ia.getLogout().click();
        Log.info("Click action performed on Sign out link");

        ia.getConfirmLogout().click();
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
