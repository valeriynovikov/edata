package utilities.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "validLogIn")
    public Object[][] validLogIn() {
        return new Object[][]{
                {"qaAutomation", "qaAutomation!2"},
                {"qaautomation", "qaAutomation!2"},
                {"QAAUTOMATION", "qaAutomation!2"},
                {"qAauToMaTioN", "qaAutomation!2"}
        };
    }

    @DataProvider(name = "totalError")
    public Object[][] totalError() {
        return new Object[][]{
                //for invalid password
                {"qaAutomation", "qaautomation!2"},
                {"qaAutomation", " qaAutomation!2"},
                {"qaAutomation", "qaAutomation!2 "},
                {"qaAutomation", "aAutomation!2"},
                {"qaAutomation", "qaAutomation!"},
                //for invalid companyId
                {"qaAutomatio", "qaAutomation!2"},
                {"111111111111", "qaAutomation!2"},
                {"qaAu", "qaAutomation!2"},
        };
    }

    @DataProvider(name = "emptyCompanyId")
    public Object[][] emptyCompanyId() {
        return new Object[][]{
                {"", "qaAutomation!2"},
                {"            ", "qaAutomation!2"},
        };
    }

    @DataProvider(name = "emptyPassword")
    public Object[][] emptyPassword() {
        return new Object[][]{
                {"qaAutomation", ""}
        };
    }

    @DataProvider(name = "less4Sign")
    public Object[][] less4Sign() {
        return new Object[][]{
                {"q", "qaAutomation!2"},
                {"qa", "qaAutomation!2"},
                {"qaA", "qaAutomation!2"}
        };
    }

    @DataProvider(name = "more12Sign")
    public Object[][] more12Sign() {
        return new Object[][]{
                {"qaAutomation!", "qaAutomation!2"},
                {"qaAutomation!2", "qaAutomation"},
                {"qaAutomationqaAutomation", "qaAutomation!2"}
        };
    }
}
