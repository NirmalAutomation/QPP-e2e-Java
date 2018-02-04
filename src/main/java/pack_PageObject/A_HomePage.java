package pack_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_HomePage {

    WebDriver driver;

    public A_HomePage (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // 1. SigninElement
    @FindBy(css=".nav-title")
            WebElement signin;

    //1. SigninElement
    public WebElement getSignin() {
        return signin;
    }

}