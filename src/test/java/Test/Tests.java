package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class Tests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws IOException {
        homepage = new Homepage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = new AccountDeletedPage();
        productsPage = new ProductsPage();
        productDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
        videoTutorialsPage = new VideoTutorialsPage();
        contactUsPage = new ContactUsPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
    }

    @Test(priority = 10)
    public void userCanSignUpWithFilledMandatoryFields() {
        homepage.clickOnLogInOutLink();
        Assert.assertTrue(loginPage.signUpButton.isDisplayed());
        loginPage.inputSignUpNameField(signUpName);
        loginPage.inputSignUpEmailField(signUpEmail);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(signUpPage.createAccountButton.isDisplayed());
        closeVignette();
        signUpPage.inputPasswordField(passwordLogin);
        signUpPage.inputFirstNameField(firstNameAcc);
        signUpPage.inputLastNameField(lastNameAcc);
        signUpPage.inputAddress1Field(address1Acc);
        signUpPage.clickOnCountry(countryAcc);
        signUpPage.inputStateField(stateAcc);
        signUpPage.inputCityField(cityAcc);
        signUpPage.inputZipcodeField(zipCodeAcc);
        signUpPage.inputMobileNumberField(mobileNumberAcc);
        scrollToElement(signUpPage.createAccountButton);
        signUpPage.clickOnCreateAccountButton();
        Assert.assertEquals(accountCreatedPage.accountCreatedMessage.getText(), "ACCOUNT CREATED!");
        wait.until(ExpectedConditions.elementToBeClickable(accountCreatedPage.continueButton));
        accountCreatedPage.clickOnContinueButton();
        closeVignette();
        Assert.assertTrue(homepage.deleteAccount.isDisplayed());
        homepage.clickOnDeleteAccount();
        closeVignette();
        Assert.assertEquals(accountDeletedPage.accountDeletedMessage.getText(), "ACCOUNT DELETED!");
        accountDeletedPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    @Test(priority = 12)
    public void userCanSignUpWithFilledAllFields() throws InterruptedException {
        homepage.clickOnLogInOutLink();
        Assert.assertTrue(loginPage.signUpButton.isDisplayed());
        loginPage.inputSignUpNameField(signUpName);
        loginPage.inputSignUpEmailField(signUpEmail);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(signUpPage.createAccountButton.isDisplayed());
        closeVignette();
        signUpPage.clickOnGender(genderAcc);
        signUpPage.inputPasswordField(passwordLogin);
        signUpPage.clickOnDays(dayAcc);
        signUpPage.clickOnMonths(monthAcc);
        signUpPage.clickOnYears(yearAcc);
        signUpPage.clickOnNewsletter(newsletterAcc);
        signUpPage.clickOnReceiveSpecialOffers(specialOfferAcc);
        signUpPage.inputFirstNameField(firstNameAcc);
        signUpPage.inputLastNameField(lastNameAcc);
        signUpPage.inputCompanyField(companyAcc);
        signUpPage.inputAddress1Field(address1Acc);
        signUpPage.inputAddress2Field(address2Acc);
        signUpPage.clickOnCountry(countryAcc);
        signUpPage.inputStateField(stateAcc);
        signUpPage.inputCityField(cityAcc);
        signUpPage.inputZipcodeField(zipCodeAcc);
        signUpPage.inputMobileNumberField(mobileNumberAcc);
        scrollToElement(signUpPage.createAccountButton);
        signUpPage.clickOnCreateAccountButton();
        expectedMessage = "ACCOUNT CREATED!";
        Assert.assertEquals(accountCreatedPage.accountCreatedMessage.getText(), expectedMessage);
        wait.until(ExpectedConditions.elementToBeClickable(accountCreatedPage.continueButton));
        accountCreatedPage.clickOnContinueButton();
        Assert.assertTrue(homepage.deleteAccount.isDisplayed());
        homepage.clickOnLogInOutLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 14)
    public void userCannotSignUpWithUnfilledMandatoryFields() {
        homepage.clickOnLogInOutLink();
        Assert.assertTrue(loginPage.signUpButton.isDisplayed());
        loginPage.inputSignUpNameField(signUpName2);
        loginPage.inputSignUpEmailField(signUpEmail2);
        loginPage.clickOnSignInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
        closeVignette();
        scrollToElement(signUpPage.createAccountButton);
        signUpPage.clickOnCreateAccountButton();
        Assert.assertTrue(signUpPage.createAccountButton.isDisplayed());
    }

    @Test(priority = 16)
    public void userCannotSignUpWithExistingEmail() {
        homepage.clickOnLogInOutLink();
        Assert.assertTrue(loginPage.signUpButton.isDisplayed());
        loginPage.inputSignUpNameField(signUpName);
        loginPage.inputSignUpEmailField(signUpEmail);
        loginPage.clickOnSignInButton();
        expectedMessage = "Email Address already exist!";
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedMessage);
    }

    @Test(priority = 20)
    public void userCanLoginWithValidEmailAndPassword() {
        homepage.clickOnLogInOutLink();
        Assert.assertTrue(loginPage.signUpButton.isDisplayed());
        loginPage.inputEmailField(signUpEmail);
        loginPage.inputPasswordField(passwordLogin);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homepage.loggedInUser.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    @Test(priority = 22)
    public void userCannotLoginWithValidEmailAndInvalidPassword() {
        homepage.clickOnLogInOutLink();
        loginPage.inputEmailField(signUpEmail);
        loginPage.inputPasswordField(invalidPassword);
        loginPage.clickOnLoginButton();
        expectedMessage = "Your email or password is incorrect!";
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedMessage);
    }

    @Test(priority = 24)
    public void userCannotLoginWithInvalidEmailAndValidPassword() {
        homepage.clickOnLogInOutLink();
        loginPage.inputEmailField(invalidEmail);
        loginPage.inputPasswordField(passwordLogin);
        loginPage.clickOnLoginButton();
        expectedMessage = "Your email or password is incorrect!";
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedMessage);
    }

    @Test(priority = 26)
    public void userCannotLoginWithEmptyEmailFieldAndEmptyPasswordField() {
        emptyEmail = "";
        emptyPassword = "";
        homepage.clickOnLogInOutLink();
        loginPage.inputEmailField(emptyEmail);
        loginPage.inputPasswordField(emptyPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 28)
    public void userCanLogoutAfterLoginWithValidEmailAndPassword(){
        userCanLoginWithValidEmailAndPassword();
        homepage.clickOnLogInOutLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 30)
    public void userCanClickOnProductsLink() {
        homepage.clickOnProductsLink();
        closeVignette();
        homepage.clickOnProductsLink();
        closeVignette();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
    }

    @Test(priority = 32)
    public void userCanFillSearchFieldAndClick() {
        String product = "shirt";
        userCanClickOnProductsLink();
        productsPage.inputSearchField(product);
        productsPage.clickOnSearchButton();
        closeVignette();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products?search="+product);
    }

    @Test(priority = 34)
    public void userCanClickOnViewProduct() {
        userCanClickOnProductsLink();
        productsPage.returnProduct();
        Assert.assertTrue(productDetailsPage.quantityField.isDisplayed());
    }

    @Test(priority = 36)
    public void userCanClickOnViewProductAndAddItToCart() {
        userCanClickOnViewProduct();
        productDetailsPage.addToCartButton.click();
        Assert.assertTrue(productDetailsPage.viewCartLink.isDisplayed());
        productDetailsPage.viewCartLink.click();
        Assert.assertEquals(cartPage.quantityFieldsNumber(), 1);
    }

    @Test(priority = 38)
    public void userCanClickOnRandomBrand(){
        userCanClickOnProductsLink();
        productsPage.clickOnBrand();
    }

    @Test(priority = 40)
    public void userCanClickOnRandomGender(){
        userCanClickOnProductsLink();
        productsPage.clickOnGender();
    }

    @Test(priority = 50)
    public void userCanAddAProductToCart() throws InterruptedException {
        userCanLoginWithValidEmailAndPassword();
        homepage.clickOnCartLink();
        cartPage.deleteAllItems();
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.hereLink));
        Assert.assertTrue(cartPage.hereLink.isDisplayed());
        cartPage.clickOnHereLink();
        closeVignette();
        cartPage.clickOnHomepage();
        closeVignette();
        homepage.clickOnRandomAddToCartButton();
        homepage.clickOnViewCart();
        closeVignette();
        Assert.assertEquals(cartPage.quantityFieldsNumber(), 1);
    }

    @Test(priority = 52)
    public void userCanAdd3ProductsToCart() throws InterruptedException {
        userCanLoginWithValidEmailAndPassword();
        homepage.clickOnCartLink();
        cartPage.deleteAllItems();
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.hereLink));
        Assert.assertTrue(cartPage.hereLink.isDisplayed());
        cartPage.clickOnHereLink();
        closeVignette();
        cartPage.clickOnHomepage();
        closeVignette();
        homepage.clickOnRandomToAdd3ProductsToCartButton();
        Assert.assertEquals(cartPage.quantityFieldsNumber(), 3);
    }

    @Test(priority = 54)
    public void userCanBuyChoosenProductWithFilledMandatoryFields() throws InterruptedException {
        userCanAddAProductToCart();
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        closeVignette();
        checkoutPage.clickOnPlaceOrderButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/payment");
        paymentPage.inputNameOnCardField("Damir Muratovic");
        paymentPage.inputCardNumberField("1407 3645 7477 9641");
        paymentPage.inputCvcField("374");
        paymentPage.inputExpiryMonthField("07");
        paymentPage.inputExpiryYearField("2026");
        paymentPage.clickOnSubmitButton();
        Assert.assertEquals(paymentPage.orderPlacedMessage.getText(), "ORDER PLACED!");
    }

    @Test(priority = 56)
    public void userCannotBuyChoosenProductWithoutFilledMandatoryFields() throws InterruptedException {
        userCanAddAProductToCart();
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        closeVignette();
        checkoutPage.clickOnPlaceOrderButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/payment");
        paymentPage.inputNameOnCardField("Damir Muratovic");
        //paymentPage.inputCardNumberField("1407 3645 7477 9641");
        paymentPage.inputCvcField("374");
        paymentPage.inputExpiryMonthField("07");
        paymentPage.inputExpiryYearField("2026");
        paymentPage.clickOnSubmitButton();
        Assert.assertTrue(paymentPage.submitButton.isDisplayed());
    }

    @Test(priority = 60)
    public void userCanRemoveLastAddedProductFromCart() throws InterruptedException {
        userCanAdd3ProductsToCart();
        cartPage.deleteLastAddedItem();
        Assert.assertEquals(cartPage.quantityFieldsNumber(), 2);
    }

    @Test(priority = 62)
    public void userCanRemoveRandomProductFromCart() throws InterruptedException {
        userCanAdd3ProductsToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.deleteRandomItem();
        Assert.assertEquals(cartPage.quantityFieldsNumber(), 2);
    }

    @Test(priority = 64)
    public void userCanRemoveAllProductsFromCart() throws InterruptedException {
        userCanLoginWithValidEmailAndPassword();
        homepage.clickOnCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.deleteAllItems();
        wait.until(ExpectedConditions.visibilityOf(cartPage.emptyCartMessage));
        Assert.assertEquals(cartPage.emptyCartMessage.getText(), "Cart is empty! Click here to buy products.");
    }

    @Test(priority = 70)
    public void userCanClickOnVideoTutorials(){
        driver.get("https://automationexercise.com/");
        homepage.clickOnVideoTutorials();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/c/AutomationExercise");
    }

    @Test(priority = 72)
    public void userCanClickOnYouTubeTab(){
        String tab = "Playlists";          //Options: Home, Videos, Playlists, Community
        userCanClickOnVideoTutorials();
        videoTutorialsPage.clickOnYtTab(tab);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/@AutomationExercise/"+tab.toLowerCase());
    }

    @Test(priority = 74)
    public void userCanClickRandomVideo() throws InterruptedException {
        String tab = "Videos";
        userCanClickOnVideoTutorials();
        videoTutorialsPage.clickOnYtTab(tab);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/@AutomationExercise/"+tab.toLowerCase());
        videoTutorialsPage.clickOnRandomVideo();
        Assert.assertTrue(videoTutorialsPage.subscribeButton.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(videoTutorialsPage.skipButton));
        videoTutorialsPage.clickOnSkipButton();
    }

    @Test(priority = 80)
    public void userCanClickOnContactUsForm(){
        driver.get("https://automationexercise.com/");
        homepage.clickOnContactUs();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/contact_us");
    }

    @Test(priority = 82)
    public void userCanSubmitContactUsForm() throws InterruptedException {
        formSubject = "Test";
        formMessage = "Some text for automation testing!";
        userCanClickOnContactUsForm();
        contactUsPage.inputNameField(signUpName);
        contactUsPage.inputEmailField(signUpEmail);
        contactUsPage.inputSubjectField(formSubject);
        contactUsPage.inputMessageField(formMessage);
        contactUsPage.insertFile();
        contactUsPage.clickOnSubmitButton();
        driver.switchTo().alert().accept();
        Assert.assertEquals(contactUsPage.successMessage.getText(), "Success! Your details have been submitted successfully.");
    }

    @Test(priority = 84)
    public void userCannotSubmitFormWithoutEmail(){
        formSubject = "Test";
        formMessage = "Some text for automation testing!";
        userCanClickOnContactUsForm();
        contactUsPage.inputNameField(signUpName);
        contactUsPage.inputSubjectField(formSubject);
        contactUsPage.inputMessageField(formMessage);
        contactUsPage.insertFile();
        contactUsPage.clickOnSubmitButton();
        Assert.assertTrue(contactUsPage.submitButton.isDisplayed());
    }

    @Test(priority = 90)
    public void userCanSignUpForSubscription(){
        userCanLoginWithValidEmailAndPassword();
        scrollIntoView(homepage.subscribeField);
        homepage.inputSubscribeField(signUpEmail);
        homepage.clickOnSubscribeButton();
    }

    @Test(priority = 100)
    public void deleteUser(){
        userCanLoginWithValidEmailAndPassword();
        homepage.clickOnDeleteAccount();
        closeVignette();
        Assert.assertTrue(accountDeletedPage.accountDeletedMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}