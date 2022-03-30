package pl.pawlukowicz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ContactUsPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderReferenceInput;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadButton;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(id = "submitMessage")
    private WebElement sumbmitButton;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage setSubjectHeading(String subjectHeading, WebDriver driver) {
        Select subject = new Select(driver.findElement(By.id("id_contact")));
        subject.selectByVisibleText(subjectHeading);
        return this;
    }

    public ContactUsPage setEmail(String emailAdress) {
        emailInput.sendKeys(emailAdress);
        return this;
    }

    public ContactUsPage setOrderReference(String orderReference) {
        orderReferenceInput.sendKeys(orderReference);
        return this;
    }

    public ContactUsPage uploadFile(String nameOfFile) {
        fileUploadButton.sendKeys((findFilePath(nameOfFile)));
        return this;
    }

    public ContactUsPage setMessage(String message) {
        messageInput.sendKeys(message);
        return this;
    }

    public ContactUsPage submit() {
        sumbmitButton.click();
        return this;
    }

    private String findFilePath(String relativePath) {
        File file;
        URL resource = getClass().getClassLoader().getResource(relativePath);
        try {
            file = new File(resource.toURI());
            return file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "no file path";
    }
}

