package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pack_PageObject.*;
import resources.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.io.IOException;

public class AdashLogoVerification extends Base {

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
    public void logoQPP() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Verify that the QPP Logo presented in the page
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                a.getQPPLogo());
        if (ImagePresent) {
            Log.info("QPP Logo displayed.");
        } else {
            Log.info("QPP Logo not displayed.");
        }

    }

    @Test(priority = 1)
    public void logoCMS() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Verify that the CMS Logo presented in the page
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                a.getcmsLogo());
        if (ImagePresent) {
            Log.info("CMS Logo displayed.");
        } else {
            Log.info("CMS Logo not displayed.");
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

