package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    //Dashboard page

    private By images=By.tagName("img");

    private By link=By.partialLinkText("OrangeHRM,");

    //PIM page
    private By pim= By.xpath("//span[text()='PIM']");

    private By emp= By.xpath("//a[text()='Add Employee']");

    private By empFirstName= By.xpath("//input[@placeholder='First Name']");

    private By empMiddleName= By.xpath("//input[@placeholder='Middle Name']");

    private By empLastName= By.xpath("//input[@placeholder='Last Name']");

    private By empId= By.xpath("//div[label[text()='Employee Id']]/following::input[contains(@class, 'oxd-input')]");

    private By save= By.xpath("//button[@type='submit']");

    private By empName= By.xpath("//h6[text()='Narendra S']");

    //Maintenance page
    private By main= By.xpath("//span[text()='Maintenance']");

    private By pwd= By.xpath("//input[@type='password']");

    private By button= By.xpath("//button[@type='submit']");

    private By checkMain= By.xpath("//h6[text()='Maintenance']");

    //Logout
    private By validUser= By.cssSelector("p.oxd-userdropdown-name");

    private By logout= By.xpath("//a[text()='Logout']");

    private By verifyLogout= By.xpath("//h5[text()='Login']");



    public String theTitle() {
        log.info("titles are matched");
        return driver.getTitle();
    }

    public void imagesCount() {
        int count = driver.findElements(images).size();
        log.info("total number of images :{}",count);
    }

    public void theLink() {
        String text=driver.findElement(link).getText();
        log.info("the text is :{}",text);
    }

    public void clickPim() {
        log.info("clicked the PIM page");
        driver.findElement(pim).click();
    }

    public void clickAddEmployee() {
        log.info("clicked the Add employee");
        driver.findElement(emp).click();
    }

    public void enterFirstName(String FirstName) {
        log.info("enter the first name :{}", FirstName);
        driver.findElement(empFirstName).sendKeys(FirstName);
    }

    public void enterMiddleName(String MiddleName) {
        log.info("enter the middle name :{}", MiddleName);
        driver.findElement(empMiddleName).sendKeys(MiddleName);
    }

    public void enterLastName(String LastName) {
        log.info("enter the last name :{}", LastName);
        driver.findElement(empLastName).sendKeys(LastName);
    }

    public void enterEmpId(String EmployeeID) {
        log.info("enter the employee ID :{}", EmployeeID);
        driver.findElement(empId).sendKeys(EmployeeID);
    }

    public void clickSave() {
        log.info("clicked the save button");
        driver.findElement(save).click();
    }

    public String verifyEmp(){
        log.info("Employee added successfully");
        return driver.findElement(empName).getText();
    }

    public void clickMaintenance() {
        log.info("clicked the maintenance");
        driver.findElement(main).click();
    }

    public void enterPassword(String password) {
        log.info("enter the password :{}",password);
        driver.findElement(pwd).sendKeys(password);
    }

    public void clickSubmit() {
        log.info("clicked the submit");
        driver.findElement(button).click();
    }

    public String mainVisible() {
        log.info("maintenance page is displayed");
        return driver.findElement(checkMain).getText();
    }

    public void clickValidUser() {
        log.info("clicked the valid user");
        driver.findElement(validUser).click();
    }

    public void clickLogout() {
        log.info("clicked the logout");
        driver.findElement(logout).click();
    }

    public boolean logout(){
        log.info("Logout is successful");
        return driver.findElement(verifyLogout).isDisplayed();
    }
}