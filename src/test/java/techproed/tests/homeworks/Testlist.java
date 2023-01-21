package techproed.tests.homeworks;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.TechlistPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class Testlist {

    @Test
    public void test() {

        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        Driver.getDriver().get(ConfigReader.getProperty("techlistic_url"));
        TechlistPage techlistPage = new TechlistPage();

        // fill the firstname
        techlistPage.firstnameInput.sendKeys("kama");
        ReusableMethods.waitFor(2);

        // fill the lastname
        techlistPage.lastnameInput.sendKeys("kama");
        ReusableMethods.waitFor(2);

        // check the gender
        techlistPage.genderInput.click();
        ReusableMethods.waitFor(2);

        // check the experience
        techlistPage.experienceInput.click();
        ReusableMethods.waitFor(2);

        // fill the date
        techlistPage.dateInput.sendKeys("20.12.2023");
        ReusableMethods.waitFor(2);

        // choose your profession -> Automation Tester
        techlistPage.professionInput.click();
        ReusableMethods.waitFor(2);

        // choose your tool -> Selenium Webdriver
        techlistPage.toolInput.click();
        ReusableMethods.waitFor(2);

        // choose your continent -> Africa
        Select select = new Select(techlistPage.continents);
        select.selectByVisibleText("Africa");
        ReusableMethods.waitFor(2);

        // choose your command  -> Browser Commands
        JSUtils.clickElementByJS(techlistPage.commands);
        ReusableMethods.waitFor(2);

        // click submit button
        techlistPage.submitButton.click();
        ReusableMethods.waitFor(2);

        Driver.closeDriver();
    }
}