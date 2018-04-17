package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public static final String EMPTY_FIELD_ERROR_MESSAGE = "Це поле необхідно заповнити!";
    public static final String LESS_4SIGN_ERROR_MESSAGE = "Будь ласка, введіть не менше 4 символів!";
    public static final String MORE_12SIGN_ERROR_MESSAGE = "Будь ласка, введіть не більш 12 символів!";
    public static final String TOTAL_ERROR_MESSAGE = "Сталася помилка при авторизації!";

    @FindBy(css = "#login")
    private WebElement companyIdField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-submit-btn")
    private WebElement sendButton;

    @FindBy(css = "#login-error")
    private WebElement loginErrorText;

    @FindBy(css = "#password-error")
    private WebElement passwordErrorText;

    @FindBy(css = ".alert-error")
    private WebElement totalErrorText;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public LoginPage inputCompanyId(String companyId) {
        companyIdField.clear();
        companyIdField.sendKeys(companyId);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public NewsPage clickSendButton() {
        sendButton.click();
        return new NewsPage(driver);
    }

    public NewsPage logIn(String companyId, String password) {
        return inputCompanyId(companyId)
                .inputPassword(password)
                .clickSendButton();
    }

    public String getLoginErrorText() {
        return loginErrorText.getText();
    }

    public String getPasswordErrorText() {
        return passwordErrorText.getText();
    }

    public String getTotalErrorText() {
        return totalErrorText.getText();
    }
}
