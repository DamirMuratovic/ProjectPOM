package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BaseTest {
    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    public WebElement searchField;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(className = "choose")
    public List<WebElement> productList;

    @FindBy(className = "brands-name")
    public WebElement brands;

    @FindBy(css = "a[data-parent='#accordian']")
    public List<WebElement> genderList;

    @FindBy(xpath = "//div/div/ul/li/a[contains(text(), 'category_products')]")
    public List<WebElement> subGenderList;
    //By.xpath('//tr/td/a[contains(text(),'Annual Report')]')

    //-------------------------------------------------

    public void inputSearchField(String product){
        searchField.clear();
        searchField.sendKeys(product);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void returnProduct(){
        int ran = r.nextInt(productList.size());
        productList.get(ran).click();
    }

    public void clickOnGender(){
        int gender = r.nextInt(genderList.size());
        genderList.get(gender).click();
    }

    public void clickOnSubGender(){
        subGenderList.getFirst().getText();
        subGenderList.getFirst().click();
    }

    public void clickOnBrand(){
        List<WebElement> brandList;
        brandList = brands.findElements(By.tagName("a"));
        int brand = r.nextInt(brandList.size());
        brandList.get(brand).click();
    }
}