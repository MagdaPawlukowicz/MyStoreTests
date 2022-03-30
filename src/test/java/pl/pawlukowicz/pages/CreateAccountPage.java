package pl.pawlukowicz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CreateAccountPage {

    @FindBy(id = "id_gender1")
    private WebElement genderManRadio;

    @FindBy(id = "id_gender2")
    private WebElement genderWomanRadio;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "newsletter")
    private WebElement newsletterButton;

    @FindBy(id = "optin")
    private WebElement offerReceiveButton;

    @FindBy(id = "company")
    private WebElement companyNameInput;

    @FindBy(id = "address1")
    private WebElement streetNameInput;

    @FindBy(id = "address2")
    private WebElement adressNumberInput;

    @FindBy(id = "city")
    private WebElement cityNameInput;

    @FindBy(id = "id_state")
    private Select stateNameSelect;

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(id = "id_country")
    private Select countrySelect;

    @FindBy(id = "other")
    private WebElement additionalInformationInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasAdress;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage setGender(String gender) {
        if (gender.equals("woman")) {
            genderWomanRadio.click();
        } else if (gender.equals("man")) {
            genderManRadio.click();
        }
        return this;
    }

    public CreateAccountPage setCustomerFirstName(String firstName) {
        customerFirstNameInput.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage setCustomerLastName(String lastName) {
        customerLastNameInput.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public CreateAccountPage setDate(String day, String month, String year, WebDriver driver) {
        setDays(day, driver);
        setMonth(month, driver);
        setYear(year, driver);
        return this;
    }

    private void setDays(String dayNumber, WebDriver driver) {
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue(dayNumber);
    }

    private void setMonth(String monthNumber, WebDriver driver) {
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue(monthNumber);
    }

    private void setYear(String yearNumber, WebDriver driver) {
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue(yearNumber);
    }

    public CreateAccountPage clickNewsletter() {
        newsletterButton.click();
        return this;
    }

    public CreateAccountPage clickToReceiveOffer() {
        offerReceiveButton.click();
        return this;
    }

    public CreateAccountPage setCompanyName(String companyName) {
        companyNameInput.sendKeys(companyName);
        return this;
    }

    public CreateAccountPage setAddress(String streetName, String buildingNumber, String city, String postCode) {
        setStreetName(streetName);
        setBuildingNumber(buildingNumber);
        setCityName(city);
        setPostCode(postCode);
        return this;
    }

    private void setStreetName(String streetName) {
        streetNameInput.sendKeys(streetName);
    }

    private void setBuildingNumber(String buildingNumber) {
        adressNumberInput.sendKeys(buildingNumber);
    }

    private void setCityName(String cityName) {
        cityNameInput.sendKeys(cityName);
    }

    private void setPostCode(String postCode) {
        postCodeInput.sendKeys(postCode);
    }

    public CreateAccountPage setState(String country, String stateName, WebDriver driver) {
        setCountry(country, driver);
        setState(stateName, driver);
        return this;
    }

    private void setState(String stateName, WebDriver driver) {
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText(stateName);
    }

    private void setCountry(String country, WebDriver driver) {
        Select countrySelect = new Select(driver.findElement(By.id("id_country")));
        countrySelect.selectByVisibleText(country);
    }

    public CreateAccountPage sendMessage(String message) {
        additionalInformationInput.sendKeys(message);
        return this;
    }

    public CreateAccountPage setHomePhone(String homePhone) {
        homePhoneInput.sendKeys(homePhone);
        return this;
    }

    public CreateAccountPage setMobilePhone(String mobilePhone) {
        mobilePhoneInput.sendKeys(mobilePhone);
        return this;
    }

    public CreateAccountPage submit() {
        submitAccountButton.click();
        return this;
    }

    public void assertData(WebDriver driver) {
        String paraText = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();

        if(mobilePhoneInput.getAttribute("value").length() == 0 ||
                homePhoneInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("You must register at least one phone number."));
        }
        if(customerLastNameInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("lastname is required."));
        }
        if(customerFirstNameInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("firstname is required."));
        }
        if(emailInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("email is required."));
        }
        if(passwordInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("passwd is required."));
        }
        if(streetNameInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("address1 is required."));
        }
        if(cityNameInput.getAttribute("value").length() == 0) {
            Assert.assertTrue(paraText.contains("city is required."));
        }
        if(postCodeInput.getAttribute("value").length() == 0 ||
                postCodeInput.getAttribute("value").length()>5 ) {
            Assert.assertTrue(paraText.contains("The Zip/Postal code you've entered is invalid. " +
                    "It must follow this format: 00000"));
        }
        if(countrySelect.equals("-")) {
            Assert.assertTrue(paraText.contains("Country is invalid"));
        }
        if(stateNameSelect.equals("-")) {
            Assert.assertTrue(paraText.contains("This country requires you to choose a State"));
        }
    }
}
