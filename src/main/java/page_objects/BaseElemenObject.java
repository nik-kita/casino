package page_objects;

import org.openqa.selenium.WebElement;

public abstract class BaseElemenObject {
    protected WebElement element;

    public BaseElemenObject(WebElement element) {
        this.element = element;
    }
}
