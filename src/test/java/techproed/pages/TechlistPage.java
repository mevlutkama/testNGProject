package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechlistPage {

    public TechlistPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ez-accept-all")
    public WebElement acceptCookies;

    @FindBy(id = "google_esf")
    public WebElement iframe;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstnameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastnameInput;

    @FindBy(id = "sex-0")
    public WebElement genderInput;

    @FindBy(id = "exp-1")
    public WebElement experienceInput;

    @FindBy(id = "datepicker")
    public WebElement dateInput;

    @FindBy(id = "profession-1")
    public WebElement professionInput;

    @FindBy(id = "tool-2")
    public WebElement toolInput;

    @FindBy(id = "continents")
    public WebElement continents;

    @FindBy(xpath = "//option[.='Browser Commands']")
    public WebElement commands;

    @FindBy(xpath = "//button[@name='submit']")
    public WebElement submitButton;
}
