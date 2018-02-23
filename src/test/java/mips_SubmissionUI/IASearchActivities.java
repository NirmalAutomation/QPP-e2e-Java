package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pack_PageObject.B_LoginPage;
import pack_PageObject.C_AccountDashboard;
import pack_PageObject.D_GroupDashboard;
import pack_PageObject.G_IAPage;
import resources.Base;

import java.io.IOException;

public class IASearchActivities extends Base {

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

        // IA Reporting Button
        g.getIAButton().click();
        Log.info("Click action performed on IA Reporting button");

    }

    @Test
    public void enterIASearch() throws InterruptedException {

        // IA Page displayed
        G_IAPage ia = new G_IAPage(driver);
        Log.info("IA Page displayed");

        // Enter the keyword "test" in the IA Search Activities
        Thread.sleep(1000);
        ia.accessIASearch().sendKeys("test");
        Log.info("Entering the keyword test in the IA Search field");

        // Validate the Showing Activities
        Thread.sleep(2000);
        try {
            Assert.assertEquals(ia.getActivitiesShowing().getText(), "Showing 7 Activities");
            Log.info("The Showing Activities updated after entering the keyword");
        }
        catch (Exception g){
            Log.error("The Showing Activities haven't updated after entering the keyword");
        }

        // Clear the IA Search keyword
        Thread.sleep(1000);
        ia.clearIASearch().click();
        Log.info("Clearing the keyword test in the IA Search field");

    }

    @AfterClass
    public void logoutMIPS() throws InterruptedException {

        // IA Page displayed
        Thread.sleep(1000);
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
