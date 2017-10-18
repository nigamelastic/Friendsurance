import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Contains Webelements (Page Factory) for all the pages
 */
public class PageObjects {
    WebDriver driver;
    @FindBy(linkText = "Register new user")
    private WebElement registerNewUserButton;
    @FindBy(id = "login")
    private WebElement usernameTxtField;
    @FindBy(id = "password1")
    private WebElement passwordTxtField;
    @FindBy(id = "password2")
    private WebElement repeatPasswordTxtField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "password")
    private WebElement loginPasswordTxtField;
    @FindBy(id = "editaccount")
    private WebElement editAccountButton;
    @FindBy(id = "newpassword1")
    private WebElement newPassword1TxtField;
    @FindBy(id = "newpassword2")
    private WebElement newPassword2TxtField;
    @FindBy(id = "go_list_categories")
    private WebElement listCategories;
    @FindBy(id = "go_add_category")
    private WebElement addCategory;
    @FindBy(id = "name")
    private WebElement categoryNameTxtField;
    @FindBy(id = "logout")
    private WebElement logoutButton;
    @FindBy(id = "category")
    private WebElement categorySelectDropDown;
    @FindBy(id = "day")
    private WebElement dayTxtField;
    @FindBy(id = "month")
    private WebElement monthTxtField;
    @FindBy(id = "year")
    private WebElement yearTxtField;
    @FindBy(id = "amount")
    private WebElement amountTxtField;
    @FindBy(id = "reason")
    private WebElement reasonTxtField;
    @FindBy(id = "go_add_expense")
    private WebElement addExpenseButton;
    @FindBy(xpath = "/html/body/div/table/tbody/tr[1]/td[2]")
    private WebElement latestExpenseCategory;
    @FindBy(xpath = "/html/body/div/table/tbody/tr[1]/td[4]")
    private WebElement latestExpenseReason;

    public PageObjects(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterNewUser() {
        registerNewUserButton.click();
    }

    /**
     * Method for Registering Users
     *
     * @param username
     * @param password
     */
    public void registerUser(String username, String password) {
        usernameTxtField.clear();
        usernameTxtField.sendKeys(username);
        passwordTxtField.clear();
        passwordTxtField.sendKeys(password);
        repeatPasswordTxtField.clear();
        repeatPasswordTxtField.sendKeys(password);
        submitButton.click();
    }

    /**
     * Method for Login
     *
     * @param username
     * @param password
     */
    public void loginUser(String username, String password) {
        usernameTxtField.clear();
        usernameTxtField.sendKeys(username);
        loginPasswordTxtField.clear();
        loginPasswordTxtField.sendKeys(password);
        submitButton.click();
    }

    /**
     * method for changing passwords
     *
     * @param password
     * @param newPassword
     */
    public void changePassword(String password, String newPassword) {
        loginPasswordTxtField.clear();
        loginPasswordTxtField.sendKeys(password);
        loginPasswordTxtField.sendKeys(newPassword);
        submitButton.click();
    }

    /**
     * method for adding a category
     *
     * @param categoryName
     */
    public void addCategory(String categoryName) {
        listCategories.click();
        addCategory.click();
        categoryNameTxtField.clear();
        categoryNameTxtField.sendKeys(categoryName);
        submitButton.click();
    }

    /**
     * Clicks the logout button
     */
    public void clickLogout() {
        logoutButton.click();
    }

    /**
     * returns the username of the user logged in
     *
     * @return username
     */
    public String getUsername() {
        return editAccountButton.getText();
    }

    /**
     * returns the Category of the latest Expense created
     *
     * @return latestExpenseCategory
     */
    public String getLatestExpenseCategory() {
        return latestExpenseCategory.getText();
    }

    /**
     * returns the Reason of the latest Expense created
     *
     * @return latestExpenseCategory
     */
    public String getLatestExpenseReason() {
        return latestExpenseReason.getText();
    }

    /**
     * Adds a new expense in the system
     *
     * @param day
     * @param month
     * @param year
     * @param amount
     * @param category
     * @param reason
     */
    public void addNewExpense(String day, String month, String year, String amount, String category, String reason) {
        addExpenseButton.click();
        dayTxtField.clear();
        dayTxtField.sendKeys(day);
        monthTxtField.clear();
        monthTxtField.sendKeys(month);
        yearTxtField.clear();
        yearTxtField.sendKeys(year);
        Select dropdown = new Select(categorySelectDropDown);
        dropdown.selectByVisibleText(category);
        amountTxtField.clear();
        amountTxtField.sendKeys(amount);
        reasonTxtField.clear();
        reasonTxtField.sendKeys(reason);
        submitButton.click();
    }
}

