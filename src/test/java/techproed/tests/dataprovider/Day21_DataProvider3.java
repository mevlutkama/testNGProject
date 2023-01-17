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

public class Day21_DataProvider3 {


    /*
        In this method, we will get the data from Excel using Data Provider
        The only difference between class 2 and class 3 is the place where we get the data
        In class 2, we received the data from the class itself. In this class, we get the data from excel
     */

    HomePage homePage;
    LoginPage loginPage;

    @DataProvider
    public Object[][] customerData(){

        // Test Data. Get data from excel
        // Path of excel sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";

        // Sheet name
        String sheetName = "customer_info";

        // Call excel util class
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        // Use one of the Excel Util method to receive the data from the excel
        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();

        // Object [][] customerCredentials = {
        // {"sam.walker@bluerentalcars.com", "c!fas_art"},
        // {"kate.brown@bluerentalcars.com", "tad1$Fas"},
        // {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
        // {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        // };
        return customerCredentials;
    }

    // 1.Create a login method
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

        // Takes us to the login page
        login();
        loginPage.username.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);

        // Verify if login is successfull
        // If user id is displayed then login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userId);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
