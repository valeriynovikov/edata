package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractPage extends BasePage {

    @FindBy(css = "#numDogId")
    private WebElement contractNumberField;

    @FindBy(css = ".button.flr")
    private WebElement findButton;

    public ContractPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContractPage inputContractNumber(String contractNumber){
        contractNumberField.clear();
        contractNumberField.sendKeys(contractNumber);
        return this;
    }

    public ContractResultPage clickFindButton(){
        findButton.click();
        return new ContractResultPage(driver);
    }

    public ContractResultPage findResultForInputContractNumber(String contractNumber){
        return inputContractNumber(contractNumber)
                .clickFindButton();
    }
}
