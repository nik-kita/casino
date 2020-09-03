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
        String result = element.findElement(By.cssSelector("a[href] span")).getText();
        result = filterQuotes(result, "\"");
        result = filterQuotes(result, "'");
        return result;
    }

    public String getPostInWeek() {
        List<WebElement> spans = element.findElements(By.cssSelector(".jktsbyx5 span"));
        String result = spans.get(spans.size() - 1).getText();
        result = filterQuotes(result, "\"");
        result = filterQuotes(result, "'");
        return result;
    }

    public String getMembers() {
        String result =  element.findElement(By.cssSelector("div.sjgh65i0.tr9rh885 span>span")).getText();
        result = filterQuotes(result, "\"");
        result = filterQuotes(result, "'");
        return result;
    }
    private String filterQuotes(String before, String vava) {
        if(before.indexOf(vava) >= 0 ) {
            String[] repair = before.split(vava);
            before = "";
            for(String s : repair) {
                before += s;
            }
        }
        return before;
    }
}
