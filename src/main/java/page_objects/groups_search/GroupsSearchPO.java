package page_objects.groups_search;

import locators.GroupsSearchLoc;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.BasePO;

import java.util.ArrayList;
import java.util.List;

public class GroupsSearchPO extends BasePO {
    public GroupsSearchPO(WebDriver driver) {
        super(driver);
    }

    private GroupsSearchPO clickSeeAll() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(GroupsSearchLoc.SEE_ALL_BUTTON.getPath()));
        driver.findElement(GroupsSearchLoc.SEE_ALL_BUTTON.getPath()).click();

        return this;
    }

    private GroupsSearchPO viewAllResults() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (driver.findElements(GroupsSearchLoc.END_OF_RESULTS_LABEL.getPath()).size() != 1) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        return this;
    }

    public List<OneSearchResultEO> getAllResults() {
        clickSeeAll();
        viewAllResults();
        List<OneSearchResultEO> result = new ArrayList<>();
        for (WebElement e : driver.findElements(GroupsSearchLoc.RESULT_LI.getPath())) {
            result.add(new OneSearchResultEO(e));
        }

        return result;
    }
}


