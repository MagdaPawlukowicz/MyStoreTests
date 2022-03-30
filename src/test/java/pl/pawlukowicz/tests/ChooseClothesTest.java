package pl.pawlukowicz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pl.pawlukowicz.pages.HomePage;
import pl.pawlukowicz.pages.TShirtPage;

public class ChooseClothesTest extends BaseTest{

    @Test
    public void choosetShirt(){
        HomePage homePage = new HomePage(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.womenClothesButton).perform();

        homePage.clickOnTShirtButton();

        TShirtPage tShirtPage = new TShirtPage(driver);
        tShirtPage.setSize(TShirtPage.Size.S)
                  .setColor(TShirtPage.Color.BLUE)
                .setCompositions(TShirtPage.Compositions.COTTON)
                .setAvailability(TShirtPage.Availability.IN_STOCK)
                .setManufacturer(TShirtPage.Manufacturer.FASHION_MANUFACTURER)
                .setProperties(TShirtPage.Properties.SHORT_SLEEVE)
                .setCondition(TShirtPage.Condition.NEW)
                .setStyles(TShirtPage.Styles.CASUAL)
                .changePriceValue(4,-90);

        String expected = "Faded Short Sleeve T-shirts";
        String result = driver.findElement(By.
                xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']")).getText();
        Assert.assertEquals(result, expected);
    }
}
