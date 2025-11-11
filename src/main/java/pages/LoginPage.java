package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "username")
    private WebElement User;

    @FindBy(name = "password")
    private WebElement Pwd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Login;


    public void enterUserName(String username) {
        User.sendKeys(username);
        log.info("enter the username :{}",username);
    }

    public void enterPassword(String password) {
        Pwd.sendKeys(password);
        log.info("enter the password :{}",password);
    }

    public void clickLogin() {
        Login.click();
        log.info("clicked the login");
    }

    public void login(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
        log.info("login is successful");
    }
}

