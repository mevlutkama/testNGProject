package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(name = "email")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Bad credentials']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[.='email must be a valid email']")
    public WebElement invalidMailMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement errorMessage_incorrectEmailPass;

}
