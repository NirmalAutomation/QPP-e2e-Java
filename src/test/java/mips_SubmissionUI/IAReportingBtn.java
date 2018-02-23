package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pack_PageObject.*;
import resources.Base;

import java.io.IOException;

public class IAReportingBtn extends Base{

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
    public void iaReportingBtn() throws InterruptedException {

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

        // IA Reporting Button
        g.getIAButton().click();
        Log.info("Click action performed on IA Reporting button");

        // IA Page displayed
        G_IAPage ia = new G_IAPage(driver);
        Log.info("Improvement Activities Page displayed");

        // Verify the text "Improvement Activities" presented in the page
        try {
            Assert.assertEquals(ia.assertIATxt().getText(), "Improvement Activities");
            Log.info("The page contains the text Improvement Activities");

        } catch (Exception e) {
            Log.error("The page doesn't contains the text Improvement Activities");
        }

    }

    @AfterClass
    public void logoutMIPS() {

        // IA Page displayed
        G_IAPage ia = new G_IAPage(driver);
        Log.info("Improvement Activities Page displayed");

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
