package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pack_PageObject.A_HomePage;
import pack_PageObject.B_LoginPage;
import pack_PageObject.C_AccountDashboard;
import resources.Base;
import org.testng.annotations.*;

import java.io.IOException;


public class LoginLogout extends Base {

    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {

        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("Browser launched and URL entered");

    }

    @Test(priority = 0)

    public void loginMIPS() {

        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);
        Log.info("Login page displayed");

        // QPP Account Login
        l.getSignin().click();
        Log.info("Click action performed on Signin button");

        // Account Dashboard
        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

    }

    @Test(priority = 1)

    public void logoutMIS() throws InterruptedException {

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