package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Day21_DataProvider3_ {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;

    @DataProvider
    public Object[][] customerData() {

        excelUtils = new ExcelUtils("./src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        Object[][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();

                /*{{"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };*/
        return customerCredentials;
    }
    public void login(){

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(1);

        try {
            homePage.homePageLoginLink.click();
        }catch (Exception e){
        }

        try {
            ReusableMethods.waitFor(1);
            homePage.userId.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }

    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){

        login();
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
