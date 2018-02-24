package resources;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pack_PageObject.A_HomePage;
import pack_PageObject.B_LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop;
    private static Logger Log = LogManager.getLogger(Base.class.getName());


    public WebDriver BrowserInitial() throws IOException

    {
        prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\QPP\\src\\main\\java\\resources\\Data.properties");
        prop.load(file);

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "D:\\QPP\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", "D:\\QPP\\BrowserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equals("ie")) {

            System.setProperty("webdriver.ie.driver", "D:\\QPP\\BrowserDrivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

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

        return driver;

    }

    public void getScreenshot(String result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\QPP\\src\\main\\java\\pack_Screenshot\\"+result+"screensjot.png"));
    }

}
