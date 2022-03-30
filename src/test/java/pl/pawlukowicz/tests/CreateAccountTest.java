package pl.pawlukowicz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.pawlukowicz.pages.CreateAccountPage;
import pl.pawlukowicz.pages.HomePage;
import pl.pawlukowicz.pages.SignInPage;
import pl.pawlukowicz.utils.ExcelReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateAccountTest extends BaseTest {

    @Test(dataProvider = "data")
    public void createAnAccount(String name, String lastName, String password, String company, String street,
                                String city, String state, String country) {

        int randomNumber = (int) (Math.random() * 1000);

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.setEmail("test" + randomNumber + "@test.pl")
                .submit();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.setGender("man")
                .setCustomerFirstName(name)
                .setCustomerLastName(lastName)
                .setPassword(password)
                .setDate("1", "12", "2020", driver)
                .clickNewsletter()
                .clickToReceiveOffer()
                .setCompanyName(company)
                .setAddress(street, "11", city, "11111")
                .setState(country, state, driver)
                .sendMessage("Hello!")
                .setHomePhone("22122322")
                .setMobilePhone("756888999");
//              .submit();
//
//        String paraText = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
//        Assert.assertEquals(paraText, "Welcome to your account. " +
//                "Here you can manage all of your personal information and orders.");
    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExel("datatest.xlsx");
    }

    @Test
    public void wrongEmailAdress() {
        int randomNumber = (int) (Math.random() * 1000);

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.setEmail("tests" + randomNumber)
                .submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));

        String paraText = driver.findElement(By.id("create_account_error")).getText();
        Assert.assertEquals(paraText, "Invalid email address.");
    }

    @Test
    public void wrongData() {
        int randomNumber = (int) (Math.random() * 1000);

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.setEmail("t" + randomNumber + "@tests.pl")
                .submit();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[@class='alert alert-danger']")));

        createAccountPage.assertData(driver);
    }
}
