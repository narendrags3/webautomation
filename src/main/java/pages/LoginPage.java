package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By user=By.name("username");

    private By pwd=By.name("password");

    private By login=By.xpath("//button[@type='submit']");

    private By board= By.xpath("//span[text()='Dashboard']");


    public void enterUserName(String username) {
        log.info("enter the username :{}",username);
        driver.findElement(user).sendKeys(username);
    }

    public void enterPassword(String password) {
        log.info("enter the password :{}",password);
        driver.findElement(pwd).sendKeys(password);
    }

    public void clickLogin() {
        log.info("clicked the login");
        driver.findElement(login).click();
    }

    public void login(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
        log.info("login is successful");
    }

    public boolean dashboard() {
        log.info("dashboard page is displayed");
        return driver.findElement(board).isDisplayed();
    }
}

