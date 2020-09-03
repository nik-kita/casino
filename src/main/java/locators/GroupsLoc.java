package locators;

import org.openqa.selenium.By;

public enum GroupsLoc implements Locator {
    SEARCH_GROUPS_INPUT(By.cssSelector("[aria-label='Search Groups']"));

    private By path;

    GroupsLoc(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
