package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop;

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
        return driver;

    }

    public void getScreenshot(String result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\QPP\\src\\main\\java\\pack_Screenshot\\"+result+"screensjot.png"));
    }
}
