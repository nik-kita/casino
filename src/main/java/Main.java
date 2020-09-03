import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.LoginPO;
import page_objects.groups_search.OneSearchResultEO;
import tools.PerfectDriver;
import tools.SqLiteManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Main {
    String email, password, searchWord, baseURL = "https://www.facebook.com/";
    WebDriver driver;
    SqLiteManager sql;
    Connection connection;
    Properties needData;

    @BeforeClass
    public void initialization() throws SQLException, IOException {
        driver = new PerfectDriver().getAnonimNoAlertsChrome();
        driver.manage().window().maximize();
        driver.get(baseURL);

        sql = new SqLiteManager();
        String createTable = "CREATE TABLE IF NOT EXISTS fb_groups (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + " members text NOT NULL,\n"
                + " postInWeek text NOT NULL\n"
                + ");";
        connection = sql.getConnection();
        connection.createStatement().execute(createTable);

        needData = new Properties();
        needData.load(new BufferedReader(new FileReader("fb.properties")));
        email = needData.getProperty("email");
        password = needData.getProperty("password");
        searchWord = needData.getProperty("searchWord");
    }

    @Test
    public void test() throws SQLException {
        List<OneSearchResultEO> allGroups = new LoginPO(driver).login(email, password)
                .toGroupsPO()
                .findGroup(searchWord)
                .getAllResults();

        for (OneSearchResultEO r : allGroups) {
            System.out.println("------------------------------------------------------");
            System.out.println();
            System.out.println(r.getTitle());
            System.out.format("%12s| %s", r.getMembers(), r.getPostInWeek());

            connection.createStatement().executeUpdate("INSERT INTO fb_groups(name, members, postInWeek)" +
                    " VALUES(\"" + r.getTitle() + "\", \"" + r.getMembers() + "\", \"" + r.getPostInWeek() + "\");");
        }
    }

    @AfterClass
    public void closeEverithing() {
        sql.closeConnection();
        driver.quit();
    }
}
