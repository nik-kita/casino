package page_objects;

import locators.LoginLoc;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePO {

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public HomePO login(String email, String password) {
        driver.findElement(LoginLoc.EMAIL_INPUT.getPath()).sendKeys(email);
        driver.findElement(LoginLoc.PASSWORD_INPUT.getPath()).sendKeys(password);
        driver.findElement(LoginLoc.LOGIN_BUTTON.getPath()).click();

        return new HomePO(driver);
    }
}
