package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BaseTest {
    public AccountDeletedPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[data-qa='account-deleted']")
    public WebElement accountDeletedMessage;

    @FindBy(linkText = "Continue")
    public WebElement continueButton;

    //-------------------------------------------------------

    public void clickOnContinueButton(){
        continueButton.click();
    }
}