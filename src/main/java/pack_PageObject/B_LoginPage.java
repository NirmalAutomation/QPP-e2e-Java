package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_LoginPage {

    WebDriver driver;

    // 1. Login

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "accuracy-agreement")
    WebElement agree;

    @FindBy(css = ".login-btn")
    WebElement signin;

    public B_LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

        // 1. Login
        public WebElement getEmailId (){
           return username;
        }

        public WebElement getPassword () {
           return password;
        }

        public WebElement yesAgreeCheckbox () {
            return agree;
        }

        public WebElement getSignin () {
            return signin;
        }

    }
