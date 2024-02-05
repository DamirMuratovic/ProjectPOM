package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BaseTest {
    public ContactUsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='name']")
    public WebElement nameField;
    @FindBy(css = "input[data-qa='email']")
    public WebElement emailField;

    @FindBy(css = "input[data-qa='subject']")
    public WebElement subjectField;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(css = "input[name='upload_file']")
    public WebElement chooseFileButton;

    @FindBy(css = "input[data-qa='submit-button']")
    public WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    public WebElement successMessage;

    //------------------------------------------------------

    public void inputNameField(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void inputEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputSubjectField(String subject){
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    public void inputMessageField(String message){
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void insertFile(){
        formLocation = "C:\\Users\\Dacha\\Desktop\\IT Bootcamp\\Manuelno testiranje\\Bug report 1.png";
        chooseFileButton.sendKeys(formLocation);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
}