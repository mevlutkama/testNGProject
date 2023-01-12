package techproed.tests.smoketest.logintests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest_ {

    // Name: US100201_Admin_Login
    // Description:
    // User should be able login as admin
    // Acceptance Criteria:
    // As  admin, I  should be able to log in the application  https://www.bluerentalcars.com/
    // Admin email: john@doe.com
    // Admin password: John.123

    /*
        Given
            Go to https://www.bluerentalcars.com/
        When
            Click on login button
        And
            Type john@doe.com into email input
        And
            Type John.123 into password input
        And
            Click on login submit button
        Then
            Verify user logged in
     */

    @Test
    public void US100201_Admin_Login(){

        // Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Click on login button
        HomePage homePage = new HomePage();
        homePage.homePageLoginLink.click();

        // Type john@doe.com into email input
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("john@doe.com");

        // Type John.123 into password input
        loginPage.password.sendKeys("John.123");

        // Click on login submit button
        loginPage.loginButton.click();

        // Verify user logged in
        ReusableMethods.verifyElementDisplayed(homePage.userId);

        Driver.closeDriver();
    }
}
