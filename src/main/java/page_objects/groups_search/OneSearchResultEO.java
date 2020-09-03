package page_objects.groups_search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.BaseElemenObject;

import java.util.List;

public class OneSearchResultEO extends BaseElemenObject {

    public OneSearchResultEO(WebElement element) {
        super(element);
    }

    public String getTitle() {
        return element.findElement(By.cssSelector("a[href] span")).getText();
    }

    public String getPostInWeek() {
        List<WebElement> spans = element.findElements(By.cssSelector(".jktsbyx5 span"));
        return spans.get(spans.size() - 1).getText();
    }

    public String getMembers() {
        return element.findElement(By.cssSelector("div.sjgh65i0.tr9rh885 span>span")).getText();
    }
}
