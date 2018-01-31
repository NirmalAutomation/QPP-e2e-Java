package mips_SubmissionUI.pack_Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public void BrowserInitial() throws IOException

    {
        prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\QPP\\src\\main\\java\\mips_SubmissionUI\\pack_Resource\\Data.properties");
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

    }

}
