package pl.pawlukowicz.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.pawlukowicz.pages.ContactUsPage;
import pl.pawlukowicz.pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test
    public void contactUsTest() {
        int randomNumber = (int) (Math.random() * 1000);

        HomePage homePage = new HomePage(driver);
        homePage.clickContactUsButton();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setSubjectHeading("Customer service", driver)
                .setEmail("test2@test.pl")
                .setOrderReference("Order number " + randomNumber)
                .uploadFile("imgdress.jpg")
                .setMessage("Hi! I want to give back the dress from order number " + randomNumber)
                .submit();

        String paraText = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
        Assert.assertEquals(paraText, "Your message has been successfully sent to our team.");

    }

}
