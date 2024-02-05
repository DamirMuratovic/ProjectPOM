package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class BaseTest {
    public static WebDriver driver;
    public JavascriptExecutor js;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public Homepage homepage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public AccountCreatedPage accountCreatedPage;
    public AccountDeletedPage accountDeletedPage;
    public ProductsPage productsPage;
    public ProductDetailsPage productDetailsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public PaymentPage paymentPage;
    public VideoTutorialsPage videoTutorialsPage;
    public ContactUsPage contactUsPage;
    public static Random r;
    public String signUpEmail, signUpEmail2, passwordLogin, passwordLogin2, signUpName, signUpName2, genderAcc, dayAcc, monthAcc, yearAcc, newsletterAcc, specialOfferAcc, firstNameAcc, lastNameAcc, companyAcc, address1Acc, address2Acc, countryAcc, stateAcc, cityAcc, zipCodeAcc, mobileNumberAcc, invalidEmail, invalidPassword, emptyEmail, emptyPassword, expectedMessage, expectedURL, formName, formEmail, formSubject, formMessage, formLocation;
    public int addButton;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor)driver;
        driver.navigate().to("https://automationexercise.com/");
        excelReader = new ExcelReader("POMData.xlsx");
        r = new Random();

        signUpEmail = excelReader.getStringData("Form", 1, 0);
        signUpEmail2 = excelReader.getStringData("Form", 2, 0);
        passwordLogin = excelReader.getStringData("Form", 1, 1);
        passwordLogin2 = excelReader.getStringData("Form", 2, 1);
        signUpName = excelReader.getStringData("Form", 1, 2);
        signUpName2 = excelReader.getStringData("Form", 2, 2);
        genderAcc = excelReader.getStringData("Form", 1, 3);
        dayAcc = excelReader.getStringData("Form", 1, 4);
        monthAcc = excelReader.getStringData("Form", 1, 5);
        yearAcc = excelReader.getStringData("Form", 1, 6);
        newsletterAcc = excelReader.getStringData("Form", 2, 7);
        specialOfferAcc = excelReader.getStringData("Form", 2, 8);
        firstNameAcc = excelReader.getStringData("Form", 1, 9);
        lastNameAcc = excelReader.getStringData("Form", 1, 10);
        companyAcc = lastNameAcc = excelReader.getStringData("Form", 1, 11);
        address1Acc = excelReader.getStringData("Form", 1, 12);
        address2Acc = excelReader.getStringData("Form", 1, 13);
        countryAcc = excelReader.getStringData("Form", 1, 14);
        stateAcc = excelReader.getStringData("Form", 1, 15);
        cityAcc = excelReader.getStringData("Form", 1, 16);
        zipCodeAcc = excelReader.getStringData("Form", 1, 17);
        mobileNumberAcc = excelReader.getStringData("Form", 1, 18);

        invalidPassword = excelReader.getStringData("Form", 1, 19);
        invalidEmail = excelReader.getStringData("Form", 1, 20);
    }

    //---------------------------------------------
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void closeVignette(){
        js.executeScript("const elements = document.getElementsByClassName" +
                "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}