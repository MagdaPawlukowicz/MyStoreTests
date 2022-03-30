package pl.pawlukowicz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    WebElement submitButton;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SignInPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignInPage submit() {
        submitButton.click();
        return this;
    }
}
