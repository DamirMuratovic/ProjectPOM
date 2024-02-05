package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BaseTest {
    public AccountCreatedPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[data-qa='account-created']")
    public WebElement accountCreatedMessage;

    @FindBy(linkText = "Continue")
    public WebElement continueButton;

    //-------------------------------------------------------

    public void clickOnContinueButton(){
        continueButton.click();
    }
}