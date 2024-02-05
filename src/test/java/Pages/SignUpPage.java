package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends BaseTest {
    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    public WebElement mrGenderRadioBtn;

    @FindBy(id = "id_gender2")
    public WebElement mrsGenderRadioBtn;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement daysField;

    @FindBy(id = "months")
    public WebElement monthsField;

    @FindBy(id = "years")
    public WebElement yearsField;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    public WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement address1Field;

    @FindBy(id = "address2")
    public WebElement address2Field;

    @FindBy(id = "country")
    public WebElement countryField;

    @FindBy(id = "state")
    public WebElement stateField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zipcode")
    public WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccountButton;

    //------------------------------------------

    public void clickOnGender(String gender){
        if(gender.equalsIgnoreCase("Mr")) {
            mrGenderRadioBtn.click();
        }else if(gender.equalsIgnoreCase("Mrs")){
            mrsGenderRadioBtn.click();
        }
    }

    public void inputPasswordField(String pass){
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public void clickOnDays(String day){
        Select select = new Select(daysField);
        for(int i = 0; i < select.getOptions().size(); i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(day)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public void clickOnMonths(String month){
        Select select = new Select(monthsField);
        for(int i = 0; i < select.getOptions().size(); i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(month)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public void clickOnYears(String year){
        Select select = new Select(yearsField);
        for(int i = 0; i < select.getOptions().size(); i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(year)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public void clickOnNewsletter(String newsletter){
        if(newsletter.equalsIgnoreCase("Yes")){
            newsletterCheckbox.click();
        }
    }

    public void clickOnReceiveSpecialOffers(String specialOffer){
        if(specialOffer.equalsIgnoreCase("Yes")){
            specialOffersCheckbox.click();
        }
    }

    public void inputFirstNameField(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastNameField(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputCompanyField(String company){
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void inputAddress1Field(String address1){
        address1Field.clear();
        address1Field.sendKeys(address1);
    }

    public void inputAddress2Field(String address2){
        address2Field.clear();
        address2Field.sendKeys(address2);
    }

    public void clickOnCountry(String country){
        Select select = new Select(countryField);
        for(int i = 0; i < select.getOptions().size(); i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(country)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public void inputStateField(String state){
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void inputCityField(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZipcodeField(String zipcode){
        zipcodeField.clear();
        zipcodeField.sendKeys(zipcode);
    }

    public void inputMobileNumberField(String mobile){
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobile);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }
}