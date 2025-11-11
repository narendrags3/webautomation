package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviders;

//@Listeners(utilities.ExtentReportManager.class)
public class HomePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @Test(priority = 2)
    public void home() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.dashboard(), "unsuccessful login");
        Assert.assertEquals(homePage.theTitle(), "OrangeHR", "titles are not matched");
        homePage.imagesCount();
        homePage.theLink();
    }

    @Test(dependsOnMethods = {"home"})
    public void maintenancePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMaintenance();
        homePage.enterPassword("admin123");
        homePage.clickSubmit();
        Assert.assertEquals(homePage.mainVisible(), "Maintenance", "maintenance page is not visible");
    }

    @Test(dependsOnMethods = {"maintenancePage"},alwaysRun = true)
    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.clickValidUser();
        homePage.clickLogout();
    }

}
