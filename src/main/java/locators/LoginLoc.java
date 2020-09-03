package locators;

import org.openqa.selenium.By;

public enum LoginLoc implements Locator {
    EMAIL_INPUT(By.cssSelector("#email")),
    PASSWORD_INPUT(By.cssSelector("#pass")),
    LOGIN_BUTTON(By.cssSelector("#u_0_b"));

    private By path;

    LoginLoc(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
