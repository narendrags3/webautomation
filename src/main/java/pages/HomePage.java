package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement board;

    @FindBy(tagName = "img")
    private List<WebElement> images;

    //@FindBy(linkText = "OrangeHRM, Inc")
    //private WebElement link;

    @FindBy(partialLinkText = "OrangeHRM,")
    private WebElement link;

    @FindBy(css = "p.oxd-userdropdown-name")
    private WebElement validUser;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath = "//button[@title='Help']")
    private WebElement help;

    @FindBy(xpath = "//span[text()='Maintenance']")
    private WebElement main;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement pwd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button;

    @FindBy(xpath = "//h6[text()='Maintenance']")
    private WebElement checkMain;

    public boolean dashboard() {
        log.info("dashboard page is displayed");
        return board.isDisplayed();
    }

    public String theTitle() {
        log.info("titles are matched");
        return driver.getTitle();
    }

    public void imagesCount() {
        log.info("total number of images :{}",images.size());
    }

    public void theLink() {
        log.info("the text is :{}",link.getText());
    }

    public void clickValidUser() {
        validUser.click();
        log.info("clicked the valid user");
    }

    public void clickLogout() {
        logout.click();
        log.info("clicked the logout");
    }

    public void clickHelp() {
        help.click();
        log.info("clicked the help button");
    }

    public void clickMaintenance() {
        main.click();
        log.info("clicked the maintenance");
    }

    public void enterPassword(String password) {
        pwd.sendKeys(password);
        log.info("enter the password :{}",password);
    }

    public void clickSubmit() {
        button.click();
        log.info("clicked the submit");
    }

    public String mainVisible() {
        log.info("maintenance page is displayed");
        return checkMain.getText();
    }
}
