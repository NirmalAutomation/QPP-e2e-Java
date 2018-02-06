package mips_SubmissionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pack_PageObject.A_HomePage;
import pack_PageObject.B_LoginPage;
import pack_PageObject.C_AccountDashboard;
import resources.Base;

import java.io.IOException;

public class SidebarCollapse_Expand extends Base{
    private static Logger Log = LogManager.getLogger(LoginLogout.class.getName());

    @BeforeTest
    public void initializingBrowser() throws IOException {

        // Browser Initialization from Base Class
        BrowserInitial();
        Log.info("MIPS Application Launched and Home page displayed");

    }

    @BeforeClass
    public void loginMIPS() {

        // QPP qppHomePage
        A_HomePage h = new A_HomePage(driver);
        Log.info("MIPS Home page displayed");

        h.getSignin().click();
        Log.info("Click action performed on My Signin link");

        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);
        Log.info("Login page displayed");

        // Entering valid Username and Password
        l.getEmailId().sendKeys(prop.getProperty("username"));
        Log.info("Username entered in the Username text box");

        l.getPassword().sendKeys(prop.getProperty("password"));
        Log.info("Password entered in the Password text box");

        l.yesAgreeCheckbox().click();
        Log.info("Check on Yes, I agree");

        // QPP Account Login
        l.getSignin().click();
        Log.info("Click action performed on Signin button");

    }

    @Test(priority = 4)
    public void sidebarCollapse() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Make Sidebar Collapse
        a.getCollapseButton().click();
        Log.info("Click action performed on Sidebar Collapse button");

    }

    @Test(priority = 5)
    public void sidebarExpand() {

        C_AccountDashboard a = new C_AccountDashboard(driver);
        Log.info("Account Dashboard displayed");

        // Make Sidebar Expand
        a.getExpandButton().click();
        Log.info("Click action performed on Sidebar Expand button");

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

