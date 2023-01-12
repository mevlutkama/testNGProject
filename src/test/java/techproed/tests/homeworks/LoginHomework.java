package techproed.tests.homeworks;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestHomePage;
import techproed.pages.TestLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class LoginHomework {

    // https://testcenter.techproeducation.com/index.php?page=form-authentication
    // Login the application using page object model

        /*
            Given
                Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
            When
                Type "techproed" into username input
            And
                Type "SuperSecretPassword" into password input
            And
                Click submit button
            Then
                Verify user signed in
         */

    @Test
    public void loginTest(){
        // Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("test_center_URL"));

        TestLoginPage testLoginPage = new TestLoginPage();
        TestHomePage testHomePage = new TestHomePage();

        // Type "techproed" into username input
        testLoginPage.username.sendKeys("techproed");

        // Type "SuperSecretPassword" into password input
        testLoginPage.password.sendKeys("SuperSecretPassword");

        // Click submit button
        testLoginPage.submitButton.click();

        // Verifying login is successful
        // Assert.assertTrue(testHomePage.loginMessage.isDisplayed());
        ReusableMethods.verifyElementDisplayed(testHomePage.loginMessage);// Done with reusable method. Recommended
        Driver.closeDriver();
    }
}

