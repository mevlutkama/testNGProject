package techproed.tests.practices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.MedunnaHomePage;
import techproed.pages.MedunnaLoginPage;
import techproed.pages.MedunnaPatientsPage;
import techproed.utilities.*;

public class MedunnaPatient {

    // Admin can create patients
    /*
        Given
            Go to https://medunna.com/
        When
            Click on user icon
        And
            Click on "Sign In" section
        And
            Enter username into "Username" input
        And
            Enter password into "Password" input
        And
            Check the "Remember Me" checkbox
        And
            Click on "Sign In" button
        And
            Click on "Items & Titles" menu
        And
            Click on "Patient" section
        And
            Click on "Create a new patient" button
        And
            Enter "First name" into "First Name" input
        And
            Enter "Last name" into "Last Name" input
        And
            Enter email into "Email" input
        And
            Enter phone number into "Phone" input
        And
            Click on "Save" button
       */

   @DataProvider
   public Object[][] medunnaCredentials(){
       ExcelUtils excelUtils = new ExcelUtils("./src/test/java/resources/MedunnaCredentials.xlsx","medunna01");
       Object[][] arr = excelUtils.getDataArrayWithoutFirstRow();

       return arr;
   }

    @Test(dataProvider = "medunnaCredentials", groups = "smoke-test")
    public void createPatientTest(String username, String password, String pFirstname, String pLastname, String pEmail, String pPhoneNumber){

        // Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

        // Click on user icon
        MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
        medunnaHomePage.userIcon.click();

        // Click on "Sign In" section
        medunnaHomePage.signInSection.click();

        // Enter username into "Username" input
        MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
        medunnaLoginPage.usernameInput.sendKeys(username);

        // Enter password into "Password" input
        medunnaLoginPage.passwordInput.sendKeys(password);

        // Check the "Remember Me" checkbox
        medunnaLoginPage.rememberMeCheckbox.click();

        // Click on "Sign In" button
        medunnaLoginPage.signInSubmitButton.click();

        // Click on "Items & Titles" menu
        medunnaHomePage.itemsAndTitlesMenu.click();

        // Click on "Patient" section
        medunnaHomePage.patientSection.click();

        // Click on "Create a new patient" button
        MedunnaPatientsPage medunnaPatientsPage = new MedunnaPatientsPage();
        medunnaPatientsPage.createNewPatientButton.click();

        // Enter "First name" into "First Name" input
        medunnaPatientsPage.patientFirstNameInput.sendKeys(pFirstname);

        // Enter "Last name" into "Last Name" input
        medunnaPatientsPage.patientLastNameInput.sendKeys(pLastname);

        // Enter email into "Email" input
        medunnaPatientsPage.patientEmailInput.sendKeys(pEmail);

        // Enter phone number into "Phone" input
        medunnaPatientsPage.patientPhoneInput.sendKeys(pPhoneNumber);

        // Click on "Save" button
        JSUtils.clickElementByJS(medunnaPatientsPage.saveButton);

        Driver.closeDriver();
   }

//   @AfterMethod
//    public void closeBrowser(){
//       ReusableMethods.waitFor(2);
//       Driver.closeDriver();
//   }
}
