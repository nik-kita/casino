package page_objects;

import locators.HomeLoc;
import org.openqa.selenium.WebDriver;

public class HomePO extends BasePO {

    public HomePO(WebDriver driver) {
        super(driver);
    }

    public GroupsPO toGroupsPO() {
        driver.findElement(HomeLoc.GROUPS.getPath()).click();

        return new GroupsPO(driver);
    }
}
