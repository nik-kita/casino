package locators;

import org.openqa.selenium.By;

public enum HomeLoc implements Locator {
    GROUPS(By.cssSelector("[href='/groups/']"));
    private By path;

    HomeLoc(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
