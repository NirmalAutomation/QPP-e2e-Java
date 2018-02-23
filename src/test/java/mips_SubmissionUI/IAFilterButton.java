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

public class IAFilterButton extends Base {

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
    public void iaFiltersButton() throws InterruptedException {

        // IA Page displayed
        G_IAPage ia = new G_IAPage(driver);
        Log.info("IA Page displayed");

        // Open Filters Drop-down list
        Thread.sleep(1000);
        ia.openFiltersDD().click();
        Log.info("Click action on IA Filters Drop-down");

        // Assert the Sub Categories text
        try {
            Assert.assertEquals(ia.getSubCategoriesTxt().getText(), "SUB CATEGORIES\n" +
                    "Achieving Health Equity (4)\n" +
                    "Behavioral And Mental Health (8)\n" +
                    "Beneficiary Engagement (23)\n" +
                    "Care Coordination (14)\n" +
                    "Emergency Response And Preparedness (2)\n" +
                    "Expanded Practice Access (4)\n" +
                    "Patient Safety And Practice Assessment (21)\n" +
                    "Population Management (16)");
            Log.info("The popup contains the Sub Categories texts");
        } catch (Exception e) {
            Log.error("The popup doesn't contain the Sub Categories texts");
        }

        // Assert the Weight and CEHRT text
        try {
            Assert.assertEquals(ia.getTextWeightCEHRT().getText(), "WEIGHT\n" +
                    "Medium (78) High (14)\n" +
                    "CEHRT ELIGIBLE\n" +
                    "Yes (18)");
            Log.info("The popup contains the Weight and CEHRT texts");

        } catch (Exception f) {
            Log.error("The popup doesn't contain the Weight and CEHRT texts");


        }

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
