package page_objects;

import org.openqa.selenium.WebDriver;

public abstract class BasePO {
    protected WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

}
