package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataProviders;
import utilities.Messages;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.dashboard(), Messages.dashBoardMsg);
    }
}

