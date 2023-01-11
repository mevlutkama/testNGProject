package techproed.tests.day17;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_OpenSourceLogin_ {
    /*
        POM:
        1. Locate the page objects in the pages package
        -username input
        -password input
        -login button
        Note: Use constructor to instantiate page object
     */

    @Test
    public void loginTest(){

        OpenSourcePage openSourcePage = new OpenSourcePage();
        Driver.getDriver().get(ConfigReader.getProperty("open_source_URL"));
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("open_source_admin_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_admin_password"));
        openSourcePage.submitButton.click();

        Driver.closeDriver();
    }


}
