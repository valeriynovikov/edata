package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractResultPage extends BasePage {

    @FindBy(css = ".search_table div[data-title=\"Номер\"]")
    private WebElement number;

    @FindBy(css = ".search_table div[data-title=\"Від\"]")
    private WebElement date;

    @FindBy(css = ".search_table div[data-title=\"Найменування контрагента\"]")
    private WebElement contractorName;

    @FindBy(css = ".search_table div[data-title=\"Вартість\"]")
    private WebElement cost;

    @FindBy(css = ".search_table div[data-title=\"Валюта\"]")
    private WebElement currency;

    @FindBy(css = ".search_table div[data-title=\"Додатки\"]")
    private WebElement apps;

    @FindBy(css = ".search_table div[data-title=\"Акти\"]")
    private WebElement acts;

    @FindBy(css = ".search_table div[data-title=\"Акти на сумму\"]")
    private WebElement actCost;

    @FindBy(css = ".search_table div[data-title=\"Штрафи\"]")
    private WebElement fines;

    public ContractResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public String getNumber(){
        return number.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getContractorName() {
        return contractorName.getText();
    }

    public String getCost() {
        return cost.getText();
    }

    public String getCurrency() {
        return currency.getText();
    }

    public String getApps() {
        return apps.getText();
    }

    public String getActs() {
        return acts.getText();
    }

    public String getActCost() {
        return actCost.getText();
    }

    public String getFines() {
        return fines.getText();
    }
}
