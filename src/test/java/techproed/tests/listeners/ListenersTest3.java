package techproed.tests.listeners;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class ListenersTest3 {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void US100201_Admin_Login(){

        // going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();

        ReusableMethods.waitFor(2);
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(2);

        // sending credentials and clicking on login button
        loginPage.username.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(2);
        loginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);

        // verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userId);

        // Alternatively we can assert if home page login link is not displayed. Not recommended
        // ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);

        Driver.closeDriver();
    }
}
