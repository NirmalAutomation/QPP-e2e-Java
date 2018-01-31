package mips_SubmissionUI.TestCase;

import mips_SubmissionUI.pack_PageObject.A_HomePage;
import mips_SubmissionUI.pack_PageObject.B_LoginPage;
import mips_SubmissionUI.pack_PageObject.C_AccountDashboard;
import mips_SubmissionUI.pack_Resource.Base;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginLogout extends Base {

    @BeforeTest
    public void browserIni() throws IOException {
        // Browser Initialization from Base Class
        BrowserInitial();
    }

    @Test
    public void login() throws IOException {

        // QPP HomePage
        A_HomePage h = new A_HomePage(driver);
        h.getSignin().click();

        // QPP LoginPage
        B_LoginPage l = new B_LoginPage(driver);

        // Entering valid Username and Password
        l.getEmailId().sendKeys(prop.getProperty("username"));
        l.getPassword().sendKeys(prop.getProperty("password"));
        l.yesAgreeCheckbox().click();

        // QPP Account Login
        l.getSignin().click();

        // QPP AccountDashboard
        C_AccountDashboard a = new C_AccountDashboard(driver);
        a.getMyAccount().click();

        // QPP Account Logout
        a.getLogout().click();
        a.getConfirmLogout().click();

    }

    @AfterTest
    public void closingBrowser() throws InterruptedException {

        Thread.sleep(1000);
        // Browser closing
        driver.close();

    }
}
