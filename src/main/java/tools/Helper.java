package tools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Helper {
    WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void pressKey(Keys key) {
        new Actions(driver).sendKeys(key).perform();
    }
}
