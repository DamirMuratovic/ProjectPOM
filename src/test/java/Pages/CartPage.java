package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {
    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fa.fa-home")
    public WebElement homepageLink;

    @FindBy(className = "product_image")
    public WebElement productImage;

    @FindBy(className = "cart_quantity_delete")
    public List<WebElement> itemList;

    @FindBy(className = "cart_quantity")
    public List<WebElement> quantityFields;

    @FindBy(className = "text-center")
    public WebElement emptyCartMessage;

    @FindBy(linkText = "here")
    public WebElement hereLink;

    @FindBy(className = "product_image")
    public List<WebElement> productsInCart;

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement checkoutButton;

    //-----------------------------------------------

    public void clickOnHomepage(){
        homepageLink.click();
    }
    public void deleteAllItems(){
        if(itemList.isEmpty()){
            System.out.println("There is no items in the Cart!");
        }else if(itemList.size() == 1) {
            itemList.get(0).click();
        }else {
            for (int i = 0; i < itemList.size(); i++) {
                itemList.get(i).click();
                driver.navigate().refresh();
                i--;
            }
        }
    }

    public void deleteRandomItem(){
        int rand = r.nextInt(itemList.size());
        itemList.get(rand).click();
    }

    public void deleteLastAddedItem(){
        itemList.get(itemList.size()-1).click();
    }

    public int numberOfProducts(){
        return productsInCart.size();
    }

    public int quantityFieldsNumber(){
        int quantity = 0;
        for(int i = 0; i < quantityFields.size(); i++){
            quantity += Integer.parseInt(quantityFields.get(i).getText());
        }
        return quantity;
    }

    public void clickOnHereLink(){
        hereLink.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
}