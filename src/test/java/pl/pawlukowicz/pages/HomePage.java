package pl.pawlukowicz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[text()='Contact us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[@class='sf-with-ul' and @title='Women']")
    public WebElement womenClothesButton;

    @FindBy (xpath = "//a[text()='T-shirts']")
    private WebElement tShirtButton;

    @FindBy (xpath = "//a[text()='Blouses']")
    private WebElement blousesButton;

    @FindBy (xpath = "//a[text()='Casual Dresses']")
    private WebElement casualDressesButton;

    @FindBy (xpath = "//a[text()='Evening Dresses']")
    private WebElement eveningDressesButton;

    @FindBy (xpath = "//a[text()='Summer Dresses']")
    private WebElement summerDressesButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public HomePage clickContactUsButton() {
        contactUsButton.click();
        return this;
    }

    public HomePage clickSignUpButton() {
        signUpButton.click();
        return this;
    }

    public HomePage clickOnBlausesButton() {
        blousesButton.click();
        return this;
    }

    public HomePage clickOnTShirtButton() {
        tShirtButton.click();
        return this;
    }

    public HomePage clickOnCasualDressButton() {
        casualDressesButton.click();
        return this;
    }

    public HomePage clickOnEveningDressButton() {
        eveningDressesButton.click();
        return this;
    }

    public HomePage clickOnSummerDressButton() {
        summerDressesButton.click();
        return this;
    }
}
