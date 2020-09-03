package page_objects;

import locators.GroupsLoc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.groups_search.GroupsSearchPO;
import tools.Helper;

public class GroupsPO extends BasePO {

    public GroupsPO(WebDriver driver) {
        super(driver);
    }

    public GroupsSearchPO findGroup(String name) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(GroupsLoc.SEARCH_GROUPS_INPUT.getPath()));
        driver.findElement(GroupsLoc.SEARCH_GROUPS_INPUT.getPath()).sendKeys(name);
        new Helper(driver).pressKey(Keys.ENTER);

        return new GroupsSearchPO(driver);
    }
}
