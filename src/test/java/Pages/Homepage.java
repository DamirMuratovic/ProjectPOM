package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;

public class Homepage extends BaseTest {
    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fa.fa-lock")
    public WebElement logInOutLink;

    @FindBy(css = ".material-icons.card_travel")
    public WebElement productsLink;

    @FindBy(css = ".fa.fa-shopping-cart")
    public WebElement cartLink;

    @FindBy(css = ".fa.fa-envelope")
    public WebElement contactUsLink;

    @FindBy(css = ".fa.fa-youtube-play")
    public WebElement videoTutorialsLink;

    @FindBy (css = ".fa.fa-user")
    public WebElement loggedInUser;

    @FindBy(css = ".fa.fa-trash-o")
    public WebElement deleteAccount;

    @FindBy(css = ".btn.btn-default.add-to-cart")
    public List<WebElement> addToCartButton;

    @FindBy(css = ".modal-title.w-100")
    public WebElement addedMessage;

    @FindBy(linkText = "View Cart")
    public WebElement viewCart;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    public WebElement continueButton;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeField;

    @FindBy(id = "subscribe")
    public WebElement subscribeButton;


    //----------------------------------------

    public void clickOnLogInOutLink(){
        logInOutLink.click();
    }

    public void clickOnProductsLink(){
        productsLink.click();
    }

    public void clickOnCartLink(){
        cartLink.click();
    }

    public void clickOnVideoTutorials(){
        videoTutorialsLink.click();
    }

    public void clickOnContactUs(){
        contactUsLink.click();
    }


    public void clickOnDeleteAccount(){
        deleteAccount.click();
    }

    public void clickOnRandomAddToCartButton(){
        addButton = r.nextInt((addToCartButton.size()-6));
        if(addButton%2 == 0) {
            addToCartButton.get(addButton).click();
        }else {
            addToCartButton.get(addButton-1).click();
        }
    }

    public void clickOnRandomToAdd3ProductsToCartButton(){
        for(int i = 0; i <= 3; i++) {
            addButton = r.nextInt((addToCartButton.size() - 6));
            if(i == 3){
                clickOnCartLink();
                break;
            }
            else if (addButton%2 == 0) {
                addToCartButton.get(addButton).click();
            } else {
                addToCartButton.get(addButton-1).click();
            }
            clickOnContinueButton();
        }
    }

    public void clickOnViewCart(){
        viewCart.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void inputSubscribeField(String email){
        subscribeField.clear();
        subscribeField.sendKeys(email);
    }

    public void clickOnSubscribeButton(){
        subscribeButton.click();
    }
}