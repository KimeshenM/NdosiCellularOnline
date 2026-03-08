package Pages;

import Tests.LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement loginEmailField;

    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    WebElement LoginSubmitButton;

    //Welcome back message
    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement welcomeBackMessage;

    public void clickLoginButton() {
        loginButton.click();
    }
    public void enterEmailAddress(String email) {
        loginEmailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        loginPasswordField.sendKeys(password);
    }
    public void clickLoginSubmitButton() {
        LoginSubmitButton.click();
    }
    public void verifyWelcomeBackMessage(String expectedMessage) {
        String actualMessage = welcomeBackMessage.getText();
        System.out.println(actualMessage);
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }


}
