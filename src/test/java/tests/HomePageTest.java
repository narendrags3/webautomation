package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviders;
import utilities.Messages;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void home(String username,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        HomePage homePage = new HomePage(driver);
        homePage.imagesCount();
        homePage.theLink();
        Assert.assertEquals(homePage.theTitle(), Messages.expectedTitle, Messages.titleMsg);
    }

    @Test(priority = 2, dataProvider = "employeeData", dataProviderClass = DataProviders.class)
    public void pimPage(String FirstName,String MiddleName,String LastName,String EmployeeID){
        HomePage homePage=new HomePage(driver);
        homePage.clickPim();
        homePage.clickAddEmployee();
        homePage.enterFirstName(FirstName);
        homePage.enterMiddleName(MiddleName);
        homePage.enterLastName(LastName);
        homePage.enterEmpId(EmployeeID);
        homePage.clickSave();
        Assert.assertEquals(homePage.verifyEmp(),Messages.EmpName, Messages.EmpNameMsg);
    }

    @Test(priority = 3, dependsOnMethods = {"home"})
    public void maintenancePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMaintenance();
        homePage.enterPassword(p.getProperty("password"));
        homePage.clickSubmit();
        Assert.assertEquals(homePage.mainVisible(), Messages.expectedText , Messages.textMsg);
    }

    @Test(dependsOnMethods = {"maintenancePage"},alwaysRun = true)
    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.clickValidUser();
        homePage.clickLogout();
        Assert.assertTrue(homePage.logout(), Messages.logoutMsg);
    }

}
