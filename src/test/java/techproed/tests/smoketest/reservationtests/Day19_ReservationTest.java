package techproed.tests.smoketest.reservationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Day19_ReservationTest {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;
    @Test
    public void reservationTest(){

        // Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        // Login the App
        loginPage = new LoginPage();
        homePage = new HomePage();

        ReusableMethods.waitFor(2);
        homePage.homePageLoginLink.click();

        ReusableMethods.waitFor(2);

        // Sending credentials and clicking on login button
        loginPage.username.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(2);
        loginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);

        // verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userId);

        // Now that You logged in the application, we can enter the required fields
        // And select a car
        Select carSelect = new Select(homePage.selectACar);
        carSelect.selectByIndex(3);

        // And enter pick up field
        faker = new Faker();
        homePage.pickUpLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

        // And enter drop off field
        homePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

        // Pick up date
        // Pick up time
        // Drop off date
        // Drop off time

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();

        // Enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2023");

        // Enter pick up hour
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));

        // Enter drop off date
        homePage.dropOffDate.sendKeys("12/11/2023");

        // Enter drop off hour
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));

        // And click continue reservation
        JSUtils.clickElementByJS(homePage.continueReservationButton);

        // Car is not reserved There is a blocker

        // And verify complete reservation screen pops up

        // And enter card number
        // And enter name on the card
        // And enter expire date and CVC
        // And checks the agreement
        // And click complete reservation

        Driver.closeDriver();

    }
}
