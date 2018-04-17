package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.dataprovider.LoginData;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        log("go to Login page");
        loginPage = headerPage.clickUserName();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        log("logOut: go to Home page");
        if (!headerPage.getUserName().equals("СЛУЖБОВИЙ ВХІД")) {
            headerPage.logOut();
        }
    }

    @Test(groups = "positive",
            dataProvider = "validLogIn", dataProviderClass = LoginData.class)
    public void validLogIn(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = companyId.toUpperCase();
        String actResult = headerPage.getUserName();
        assertEquals(actResult, expResult, "user name equals");
        log("assert: user name equals");
    }

    @Test(dataProvider = "totalError", dataProviderClass = LoginData.class)
    public void checkTotalErrorMessage(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = LoginPage.TOTAL_ERROR_MESSAGE;
        String actResult = loginPage.getTotalErrorText();
        assertEquals(actResult, expResult, "error message equals");
        log("assert: error message equals");
    }

    @Test(dataProvider = "emptyCompanyId", dataProviderClass = LoginData.class)
    public void checkEmptyCompanyIdErrorMessage(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = LoginPage.EMPTY_FIELD_ERROR_MESSAGE;
        String actResult = loginPage.getLoginErrorText();
        assertEquals(actResult, expResult, "error message equals");
        log("assert: error message equals");
    }

    @Test(dataProvider = "emptyPassword", dataProviderClass = LoginData.class)
    public void checkEmptyPasswordErrorMessage(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = LoginPage.EMPTY_FIELD_ERROR_MESSAGE;
        String actResult = loginPage.getPasswordErrorText();
        assertEquals(actResult, expResult, "error message equals");
        log("assert: error message equals");
    }

    @Test(dataProvider = "less4Sign", dataProviderClass = LoginData.class)
    public void checkLess4SignErrorMessage(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = LoginPage.LESS_4SIGN_ERROR_MESSAGE;
        String actResult = loginPage.getLoginErrorText();
        assertEquals(actResult, expResult, "error message equals");
        log("assert: error message equals");
    }

    @Test(dataProvider = "more12Sign", dataProviderClass = LoginData.class)
    public void checkMore12SignErrorMessage(String companyId, String password) {
        log("logIn");
        loginPage.logIn(companyId, password);

        String expResult = LoginPage.MORE_12SIGN_ERROR_MESSAGE;
        String actResult = loginPage.getLoginErrorText();
        assertEquals(actResult, expResult, "error message equals");
        log("assert: error message equals");
    }
}
