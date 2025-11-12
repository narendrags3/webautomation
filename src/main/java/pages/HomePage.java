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

    //Dashboard page
    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement board;

    @FindBy(tagName = "img")
    private List<WebElement> images;

    //@FindBy(linkText = "OrangeHRM, Inc")
    //private WebElement link;

    @FindBy(partialLinkText = "OrangeHRM,")
    private WebElement link;


    //PIM page
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pim;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement emp;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement empFirstName;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    private WebElement empMiddleName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement empLastName;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input')])[5]")
    private WebElement empId;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save;


    //Maintenance page
    @FindBy(xpath = "//span[text()='Maintenance']")
    private WebElement main;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement pwd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button;

    @FindBy(xpath = "//h6[text()='Maintenance']")
    private WebElement checkMain;


    //Logout
    @FindBy(css = "p.oxd-userdropdown-name")
    private WebElement validUser;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;


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

    public void clickPim() {
        pim.click();
        log.info("clicked the PIM page");
    }

    public void clickAddEmployee() {
        emp.click();
        log.info("Add employee details are visible");
    }

    public void enterFirstName(String FirstName) {
        empFirstName.sendKeys(FirstName);
        log.info("enter the first name :{}", FirstName);
    }

    public void enterMiddleName(String MiddleName) {
        empMiddleName.sendKeys(MiddleName);
        log.info("enter the middle name :{}", MiddleName);
    }

    public void enterLastName(String LastName) {
        empLastName.sendKeys(LastName);
        log.info("enter the last name :{}", LastName);
    }

    public void enterEmpId(String EmployeeID) {
        empId.sendKeys(EmployeeID);
        log.info("enter the employee ID :{}", EmployeeID);
    }

    public void clickSave() {
        save.click();
        log.info("clicked the save button");
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

    public void clickValidUser() {
        validUser.click();
        log.info("clicked the valid user");
    }

    public void clickLogout() {
        logout.click();
        log.info("clicked the logout");
    }
}
