package pl.pawlukowicz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class TShirtPage {
    private final WebDriver driver;

    @FindBy (xpath="//div[@id='layered_price_slider']//a[1]")
    WebElement leftSlider;

    @FindBy (xpath="//div[@id='layered_price_slider']//a[2]")
    WebElement rightSlider;

    private Map<Size, String> sizeCheckboxes = Map.of(
            Size.S, "layered_id_attribute_group_1",
            Size.M, "layered_id_attribute_group_2",
            Size.L, "layered_id_attribute_group_3");

    private Map<Color, String> colorCheckboxes = Map.of(
            Color.BLUE, "//a[text()='Orange']",
            Color.ORANGE, "//a[text()='Blue']");

    private Map<Compositions, String> compositionCheckboxes = Map.of(
            Compositions.COTTON, "layered_id_feature_5");

    private Map<Styles, String> stylesCheckboxes = Map.of(
            Styles.CASUAL, "layered_id_feature_11");

    private Map<Properties, String> propertiesCheckboxes = Map.of(
            Properties.SHORT_SLEEVE, "layered_id_feature_17");

    private Map<Availability,String> availabilityCheckboxes = Map.of(
            Availability.IN_STOCK,"layered_quantity_1");

    private Map<Manufacturer,String> manufacturerCheckboxes = Map.of(
            Manufacturer.FASHION_MANUFACTURER,"layered_manufacturer_1");

    private Map<Condition,String> conditionCheckboxes = Map.of(
            Condition.NEW,"layered_condition_new");

    public TShirtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public TShirtPage setSize(Size size) {
        String id = sizeCheckboxes.get(size);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }

    public TShirtPage setColor (Color color) {
        String xpath = colorCheckboxes.get(color);
        WebElement element =driver.findElement(By.xpath(xpath));
        element.click();
        return this;
    }

    public TShirtPage setCompositions (Compositions compositions) {
        String id = compositionCheckboxes.get(compositions);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }
    public TShirtPage setStyles (Styles styles) {
        String id = stylesCheckboxes.get(styles);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }
    public TShirtPage setProperties (Properties properties) {
        String id = propertiesCheckboxes.get(properties);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }

    public TShirtPage setAvailability (Availability availability) {
        String id = availabilityCheckboxes.get(availability);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }

    public TShirtPage setManufacturer (Manufacturer manufacturer) {
        String id = manufacturerCheckboxes.get(manufacturer);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }

    public TShirtPage setCondition (Condition condition) {
        String id = conditionCheckboxes.get(condition);
        WebElement element = driver.findElement(By.id(id));
        element.click();
        return this;
    }

    public TShirtPage changePriceValue (int percentLeftSlider, int percentRightSlider) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(leftSlider,percentLeftSlider*25/10,0).perform();
        action.dragAndDropBy(rightSlider,percentRightSlider*25/10, 0).perform();
        return this;
    }

    public enum Size {
        S, M, L;
    }

    public enum Color {
        BLUE, ORANGE;
    }

    public enum Compositions {
        COTTON;
    }

    public enum Styles {
        CASUAL;
    }

    public enum Properties {
        SHORT_SLEEVE;
    }

    public enum Availability {
        IN_STOCK;
    }

    public enum Manufacturer {
        FASHION_MANUFACTURER;
    }

    public enum Condition {
        NEW;
    }
}