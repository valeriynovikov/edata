package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    @FindBy(css = ".auth_link")
    private WebElement userName;

    @FindBy(css = "#wrapper a[data-hover=\"Договори\"]")
    private WebElement contractLink;

    @FindBy(css = "#wrapper a[data-hover=\"Вихід\"]")
    private WebElement exitLink;

    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public HomePage logOut() {
        exitLink.click();
        return new HomePage(driver);
    }

    public LoginPage clickUserName(){
        userName.click();
        return new LoginPage(driver);
    }

    public ContractPage clickContractLink(){
        contractLink.click();
        return new ContractPage(driver);
    }

    public String getUserName() {
        return userName.getText();
    }


}
