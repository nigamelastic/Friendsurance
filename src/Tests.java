import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests {
    PageObjects pageObjects;
    WebDriver driver;
    int i;

    @Test(priority = 2)
    @Parameters({"username", "password"})
    public void S1TC1VerifyExpense(@Optional("jeher1231") String username, @Optional("jeher") String password) {
        pageObjects.loginUser(username, password);
        Assert.assertEquals(username, pageObjects.getUsername());
    }

    @Test(priority = 1)
    @Parameters({"username", "password"})
    public void S7TC1UserRegistration(@Optional("jeher1231") String username, @Optional("jeher") String password) {
        pageObjects.clickRegisterNewUser();
        pageObjects.registerUser(username, password);
        Assert.assertEquals(username, pageObjects.getUsername());
        pageObjects.clickLogout();
    }

    @Test(priority = 3, invocationCount = 4)
    @Parameters("Category")
    public void S4TC1AddCategories(@Optional("yoyo") String category) {
        i++;
        pageObjects.addCategory(category + i);
        Assert.assertEquals(category + i, pageObjects.getLatestCategoryAdded());
    }

    @Test(priority = 4, invocationCount = 4)
    @Parameters({"day", "month", "year", "amount", "category", "reason"})
    public void S2TC1CreateExpenses(@Optional("1") String day, @Optional("1") String month, @Optional("2001") String year, @Optional("10") String amount, @Optional("yoyo") String category, @Optional("reason") String reason) {
        i++;
        pageObjects.addNewExpense(day, month, year, amount + i, category + 2, reason + i);
        Assert.assertEquals(category + 2, pageObjects.getLatestExpenseCategory());
        Assert.assertEquals(reason + i, pageObjects.getLatestExpenseReason());
        pageObjects.addNewExpense(day, month, year, amount, category + 4, reason);
        Assert.assertEquals(category + 4, pageObjects.getLatestExpenseCategory());
        Assert.assertEquals(reason, pageObjects.getLatestExpenseReason());
    }

    @BeforeClass
    public void beforemethod() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver2");
        driver = new ChromeDriver();
        driver.get("http://thawing-shelf-73260.herokuapp.com/");
        pageObjects = new PageObjects(driver);
        i = 0;
    }

    @AfterClass
    public void aftermethod() {
        driver.quit();
    }
}
