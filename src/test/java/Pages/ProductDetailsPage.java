package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BaseTest {
    public ProductDetailsPage (){
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "quantity")
    public WebElement quantityField;

    @FindBy(css = ".btn.btn-default.cart")
    public WebElement addToCartButton;

    @FindBy(linkText = "View Cart")
    public WebElement viewCartLink;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    public WebElement continueButton;

    //-----------------------------------------

}