package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseTest {
    public PaymentPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='name-on-card']")
    public WebElement nameOnCardField;

    @FindBy(css = "input[data-qa='card-number']")
    public WebElement cardNumberField;

    @FindBy(css = "input[data-qa='cvc']")
    public WebElement cvcField;

    @FindBy(css = "input[data-qa='expiry-month']")
    public WebElement expiryMonthField;

    @FindBy(css = "input[data-qa='expiry-year']")
    public WebElement expiryYearField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".alert-success.alert")
    public WebElement successMessage;

    @FindBy(css = "h2[data-qa='order-placed']")
    public WebElement orderPlacedMessage;

    //--------------------------------------------------------

    public void inputNameOnCardField(String name){
        nameOnCardField.clear();
        nameOnCardField.sendKeys(name);
    }

    public void inputCardNumberField(String number){
        cardNumberField.clear();
        cardNumberField.sendKeys(number);
    }

    public void inputCvcField(String cvc){
        cvcField.clear();
        cvcField.sendKeys(cvc);
    }

    public void inputExpiryMonthField(String month){
        expiryMonthField.clear();
        expiryMonthField.sendKeys(month);
    }

    public void inputExpiryYearField(String year){
        expiryYearField.clear();
        expiryYearField.sendKeys(year);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
}