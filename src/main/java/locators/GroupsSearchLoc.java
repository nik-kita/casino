package locators;

import org.openqa.selenium.By;

public enum GroupsSearchLoc implements Locator {
    SEE_ALL_BUTTON(By.cssSelector("[aria-label='See All']")),
    END_OF_RESULTS_LABEL(By.cssSelector("div.l29c1vbm")),
    RESULT_LI(By.cssSelector("div.sjgh65i0.tr9rh885"));

    private By path;

    GroupsSearchLoc(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
