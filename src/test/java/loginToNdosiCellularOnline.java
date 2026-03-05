import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginToNdosiCellularOnline {

    WebDriver driver;

    @Test
    public void loginWithValidCredentials() {

        //Open the Chrome browser
        driver = new ChromeDriver();
        // Navigate to the Ndosi Cellular Online website
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        // Enter valid email
        driver.findElement(By.id("login-email")).sendKeys("kimoslice@gmail.com");
        // Enter valid password
        driver.findElement(By.id("login-password")).sendKeys("Qwerty1!");
        // Click on the login button
        driver.findElement(By.id("login-submit")).click();


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
        Assert.assertEquals(myCoursesText,"\uD83D\uDCDA My Courses");


        //Note: The "Welcome back, Kimo!" needs to be changed so that it may be used by other users as well. It is currently hardcoded to only work for the user "Kimo".

        //Wait for the "Welcome Back Kimo" message to be visible after logging in
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")));

        // Verify that the welcome message is displayed correctly
        String WelcomeBackText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).getText();
        // Assert that the welcome message is correct
        System.out.println(WelcomeBackText);
        // Assert that the welcome message is correct
        Assert.assertEquals(WelcomeBackText,"Welcome back, Kimo! \uD83D\uDC4B");

        //Navigating to the required page

        // Click on the Learn button (Would this be a drop down menu or a button??)
        //driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Learn')]")).click(); //This works

        //Note - The below doesnt work because the "Learning Materials" button is not immediately clickable after
        // clicking on the "Learn" button, as it may take some time for the dropdown menu to appear.
        // Therefore, we need to wait for the "Learning Materials" button to be clickable before clicking on it.

        // Click on the learning Materials button
        //driver.findElement(By.xpath("//*[@id="app-root"]/nav/div[1]/div[2]/div[1]/div/button[2]")).click();
        //driver.findElement(By.xpath("//*[contains(text(),'Learning Materials')]")).click();


        //The below code is used to wait for the "Learning Materials" button to be clickable before clicking on it.
        //This is necessary because the "Learning Materials" button may not be immediately clickable after clicking
        // on the "Learn" button, as it may take some time for the dropdown menu to appear.
        By learningBtn = By.xpath("//nav//button[.//text()[contains(.,'Learning Materials')]]");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(learningBtn));
        driver.findElement(learningBtn).click();

        //Navigating to the Web Automation Advance course page
        driver.findElement(By.xpath("//button[.//text()[contains(.,'Web Automation Advance')]]")).click();

        //Clicking the Device Type dropdown
        driver.findElement(By.id("deviceType")).click();

        //
        //By phoneOption = By.xpath("//button[.//text()[contains(.,'Phone')]]");
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(phoneOption));
        //driver.findElement(phoneOption).click();

        //Thread.sleep(2000);

        //driver.findElement(By.xpath("//button[.//text()[contains(.,'Phone')]]")).click();
        //Note: The above code may not work because the "Phone" option may not be immediately clickable after clicking
        // on the "Device Type" dropdown, as it may take some time for the dropdown menu to appear. Therefore, we need
        // to wait for the "Phone" option to be clickable before clicking on it.


        //To click on "Phone" from a dropdown option list, you need to use a Select class for standard HTML <select>
        // elements, or use WebDriverWait with elementToBeClickable if it's a custom dropdown.
        //Since your code already uses WebDriverWait with elementToBeClickable, your current approach is correct.
        // However, if the "Phone" option is part of a standard HTML <select> element, you can use the Select class
        // to select it by visible text
        Select deviceTypeDropDown = new Select(driver.findElement(By.id("deviceType")));
        deviceTypeDropDown.selectByVisibleText("Phone");

        //Need to add assertions to verify that the "Phone" option is selected successfully


        //Clicking Brand dropdown
        //By brand = By.xpath("//nav//button[.//text()[contains(.,'Brand')]]");
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(brand));
        //driver.findElement(brand).click();

        //Clicking the Brand dropdown using the id locator
        driver.findElement(By.id("brand")).click();

        //Selecting "Apple" from the Brand dropdown
        Select brandDropDown = new Select(driver.findElement(By.id("brand")));
        brandDropDown.selectByVisibleText("Apple");

        //Need to add assertions to verify that the "Apple" option is selected successfully
        driver.findElement(By.xpath("//*[@id=\"device-preview\"]/div/div/div[2]")).isDisplayed();

        //Clicking the 128GB option from the Storage option
        driver.findElement(By.xpath("//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]")).click();













    }

}
