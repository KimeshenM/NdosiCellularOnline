package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LoginPage.clickLoginButton();
        LoginPage.enterEmailAddress("kimoslice@gmail.com");



        //Note: Copilot suggested another way to verify that the user is logged in successfully by checking for the presence of the "My Courses" section. This is a more reliable way to verify that the user is logged in successfully, as it does not rely on the welcome message, which may change based on the user's name.
        //Should the welcome message be changed to "Welcome back, [User's Name]!" instead of "Welcome back, Kimo!", the test will fail because it is currently hardcoded to only work for the user "Kimo". Therefore, it is better to verify that the user is logged in successfully by checking for the presence of the "My Courses" section, which is a more reliable way to verify that the user is logged in successfully.

        //Should the Copilot suggestion be used or should we stick with Ndosi Class  methods??

        // Wait for the "My Courses" section to be visible after logging in
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-main-content\"]/section/div[3]/div[1]/div[1]/h3")));

        // Verify that the user is logged in successfully by checking for the presence of the "My Courses" section
        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[3]/div[1]/div[1]/h3")).isDisplayed();

        // Verify that the welcome message is displayed correctly
        String myCoursesText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[3]/div[1]/div[1]/h3")).getText();
        // Print the welcome message to the console
        System.out.println(myCoursesText);
        // Assert that the welcome message is correct
        Assert.assertEquals(myCoursesText, "\uD83D\uDCDA My Courses");

        //Note: The "Welcome back, Kimo!" needs to be changed so that it may be used by other users as well. It is currently hardcoded to only work for the user "Kimo".

        //Wait for the "Welcome Back Kimo" message to be visible after logging in
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")));

        // Verify that the welcome message is displayed correctly
        String WelcomeBackText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).getText();
        // Assert that the welcome message is correct
        System.out.println(WelcomeBackText);
        // Assert that the welcome message is correct
        Assert.assertEquals(WelcomeBackText, "Welcome back, Kimo! \uD83D\uDC4B");
    }
}
