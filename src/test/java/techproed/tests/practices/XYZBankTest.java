package techproed.tests.practices;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.XYZBankCustomerPage;
import techproed.pages.XYZBankManagerPage;
import techproed.pages.XYZBankPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {

    //Open 5 Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.
   /*
        Given
            Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        When
            Click on "Bank Manager Login" button
        And
            Click on "Add Customer" button
        And
            Fill inputs and click on "Add Customer" submit button
        And
            Accept alert
        And
            Add 4 more customers
        And
            Click on "Open Account"  button
        And
            Click on "Customer" dropdown
        And
            Select customer name
        And
            Click on "Currency" dropdown
        And
            Select "Dollar"
        And
            Click on "Process" button
        And
            Accept alert
        And
            Open 4 more accounts
        And
            Click on "Customers" button
        And
            Count table row numbers
        Then
            Assert that you created 5 customers
        When
            Click on "Home" button
        And
            Click on "Customer Login" button
        And
            Click on "Your Name" dropdown
        And
            Select the any name you created
        And
            Click on "Login" button
        And
            Click on "Deposit" button
        And
            Type 100 into "Amount to be Deposited" input
        Then
            Assert that "Deposit Successful" is displayed
        And
            Click on "Deposit"(Submit) button
        And
            Click on "Withdrawal" button
        And
            Type 100 into "Amount to be Withdrawn" input
        And
            Click on "Withdraw"(Submit) button
        Then
            Assert that "Transaction  Successful" is displayed
        When
            Click on "Logout" button
        And
            Click on "Home" button
        And
            Click on "Bank Manager Login" button
        And
            Click on "Customers" button
        And
            Click on each "Delete" button
        And
            Count table row numbers
        Then
            Assert that number of customers is 0
        */

    @Test(groups = "smoke-test")
    public void xyzBankTest(){

        XYZBankPage xyzBankPage = new XYZBankPage();
        // Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_url"));

        // Click on "Bank Manager Login" button
        xyzBankPage.bankManagerLoginButton.click();

        // Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

        // Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();

        for (int i=0; i<5; i++){

            xyzBankManagerPage.firstNameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastNameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

            // Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            }catch (Exception ignored){
            }

            // Add 4 more customers
        }

        // Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

        // Click on "Customer" dropdown
        // Select customer name
        Select customerDd = new Select(xyzBankManagerPage.customerDropdown);
        Select currencyDd = new Select(xyzBankManagerPage.currencyDropdown);

        for (int i=6; i<11; i++){
            // Click on "Currency" dropdown
            customerDd.selectByIndex(i);

            // Select "Dollar"
            currencyDd.selectByIndex(1);

            // Click on "Process" button
            xyzBankManagerPage.processButton.click();

            // Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            }catch (Exception ignored){

            }

            // Open 4 more accounts
        }

        // Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

        // Count table row numbers
        int numberOfCustomerRows = xyzBankManagerPage.numberOfCustomerRows.size();

        // Assert that you created 5 customers
        assertEquals(10,numberOfCustomerRows);

        // Click on "Home" button
        xyzBankManagerPage.homeButton.click();

        // Click on "Customer Login" button
        xyzBankPage.customerLoginButton.click();

        // Select any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
        Select yourNameDd = new Select(xyzBankCustomerPage.yourNameDropdown);
        yourNameDd.selectByIndex(9);

        // Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

        // Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

        // Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.depositAmountInput.sendKeys("100");

        // Click on "Deposit"(Submit) button
        xyzBankCustomerPage.depositSubmitButton.click();
        ReusableMethods.waitFor(2);

        // Assert that "Deposit Successful" is displayed\
        ReusableMethods.verifyElementDisplayed(xyzBankCustomerPage.depositSuccessfulMessage);

        // Click on "Withdrawal" button
        xyzBankCustomerPage.withdrawalButton.click();
        ReusableMethods.waitFor(2);

        // Type 100 into "Amount to be Withdrawn" input
        xyzBankCustomerPage.withdrawalAmountInput.sendKeys("100");
        ReusableMethods.waitFor(2);

        // Click on "Withdraw"(Submit) button
        xyzBankCustomerPage.withdrawSubmitButton.click();
        ReusableMethods.waitFor(4);

        // Assert that "Transaction  Successful" is displayed
        ReusableMethods.verifyElementDisplayed(xyzBankCustomerPage.transactionSuccessfulMessage);

        // Click on "Logout" button
        xyzBankCustomerPage.logOutButton.click();

        // Click on "Home" button
        xyzBankManagerPage.homeButton.click();

        // Click on "Bank Manager Login" button
        xyzBankPage.bankManagerLoginButton.click();

        // Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

        // Click on each "Delete" button
        for (WebElement w : xyzBankManagerPage.deleteButtonList){
            w.click();
        }

        // Count table row numbers
        // Assert that number of customers is 0
        assertEquals(0, xyzBankManagerPage.deleteButtonList.size());

        Driver.closeDriver();
    }
}
