package techproed.tests.homeworks;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class NegativeLoginTest1 {
    /*
        Name:
            Login screen error messages
        Description:
            User should see error message when user tries to login with incorrect credentials
        Acceptance Criteria:
            As admin or customer, I should be able to see error message,
        when I provide a correct email address BUT incorrect password in a pop up window
        Error Message: Bad credentials
     */

    @Test
    public void negativeLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.homePageLoginLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_username"));
        loginPage.password.sendKeys("1234");
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage);
        Driver.closeDriver();
    }
}
