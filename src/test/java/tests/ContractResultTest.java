package tests;

import org.testng.annotations.*;
import pages.ContractPage;
import pages.ContractResultPage;
import pages.LoginPage;
import utilities.dataprovider.ContractData;

public class ContractResultTest extends BaseTest {
    ContractPage contractPage;

    @Parameters({"login", "password"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional("qaAutomation") String login, @Optional("qaAutomation!2") String password) {
        log("go to Login page");
        headerPage.clickUserName();
        log("logIn");
        new LoginPage(driver).logIn(login, password);
        log("go to Contract page");
        contractPage = headerPage.clickContractLink();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        log("logOut");
        headerPage.logOut();
    }


    @Test(groups = "positive",
            dataProvider = "contractData", dataProviderClass = ContractData.class)
    public void checkSearchForContractNumber(String number,
                                             String date,
                                             String contractorName,
                                             String cost,
                                             String currency,
                                             String apps,
                                             String acts,
                                             String actCost,
                                             String fines) {

        log("input the contract number and click 'Find' button");
        ContractResultPage contractResultPage =
                contractPage.findResultForInputContractNumber(number);

        softAssert.assertEquals(contractResultPage.getNumber(), number, "number equals");
        softAssert.assertEquals(contractResultPage.getDate(), date, "date equals");
        softAssert.assertEquals(contractResultPage.getContractorName(), contractorName, "contractor name equals");
        softAssert.assertEquals(contractResultPage.getCost(), cost, "cost equals");
        softAssert.assertEquals(contractResultPage.getCurrency(), currency, "currency equals");
        softAssert.assertEquals(contractResultPage.getApps(), apps, "apps equals");
        softAssert.assertEquals(contractResultPage.getActs(), acts, "acts equals");
        softAssert.assertEquals(contractResultPage.getActCost(), actCost, "act cost equals");
        softAssert.assertEquals(contractResultPage.getFines(), fines, "fines equals");
        softAssert.assertAll();
        log("assert: contract data true");
    }
}
