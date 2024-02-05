package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "form-control")
    public WebElement addCommentField;

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement placeOrderButton;

    //-------------------------------------------------

    public void inputCommentField(String comment){
        addCommentField.clear();
        addCommentField.sendKeys(comment);
    }

    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
    }
}