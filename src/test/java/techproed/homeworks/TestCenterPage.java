package techproed.homeworks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TestCenterPage {

    // https://testcenter.techproeducation.com/index.php?page=form-authentication
    // Login the application using page object model

    public TestCenterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement username;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @Test
    public void loginTest(){

        TestCenterPage testCenterPage = new TestCenterPage();
        Driver.getDriver().get(ConfigReader.getProperty("test_center_URL"));
        testCenterPage.username.sendKeys("techproed");
        testCenterPage.password.sendKeys("SuperSecretPassword");
        testCenterPage.loginButton.click();
        Driver.closeDriver();
    }
}

