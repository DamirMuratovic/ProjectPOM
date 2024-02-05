package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseTest {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement emailField;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement signUpName;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement signUpEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(css = "p[style='color: red;']")
    public WebElement errorMessage;

    //------------------------------------------------

    public void inputEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void inputSignUpNameField(String name){
        signUpName.clear();
        signUpName.sendKeys(name);
    }

    public void inputSignUpEmailField(String emailSignUP){
        signUpEmail.clear();
        signUpEmail.sendKeys(emailSignUP);
    }

    public void clickOnSignInButton(){
        signUpButton.click();
    }
}