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

        //Navigating to the required page//

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

        //Thread.sleep(2000); //<<<<<<< Note: thread.sleep wont work here as I haven't put throw.InterruptedException in the
        // "method signature" of the test method. Therefore, I need to use WebDriverWait to wait for
        // the "Phone" option to be clickable before clicking on it.

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
        //driver.findElement(By.xpath("//*[@id=\"device-preview\"]/div/div/div[2]")).isDisplayed();
        //Note, the above works and should work as an assertion as xpath is correct with position,
        // but it is not a good practice to use xpath with position as it may change based on the UI changes.
        // Therefore, it is better to use a more reliable locator strategy, such as using the text of the element
        // or using a unique attribute of the element. HOWEVER
        driver.findElement(By.xpath("//*[contains(text(), 'Apple')]")).getText().equals("Apple");
        //wont the above assert the Apple from the dropdown rather than the Apple from the device preview??

        //Clicking the 128GB option from the Storage option
        By storage128 = By.id("storage-128GB");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(storage128));
        driver.findElement(storage128).click();

        //Need to add assertions to verify that the "128GB" option is selected successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"device-preview\"]/div/div/div[3]/strong[2]")).isDisplayed()); //NOTE * IS FOR ENTIRE PROJECT
        //Note: the above assertion may not be the best as positions may change, I should
        // use contains text instead of position(I only worry that it may reference to the dropdown)
        // this may be a blonde moment for me

        new WebDriverWait(driver, Duration.ofSeconds(5));

        //Verifying that the unit price is displayed correctly
        //Assert.assertEquals(driver.findElement(By.id("unit-price-value")));

        //selecting the color dropdown
        driver.findElement(By.id("color")).click();

        //Selecting the blue option
        Select colorDropDown = new Select(driver.findElement(By.id("color")));
        colorDropDown.selectByVisibleText("Blue");

        //Need to add assertions to verify that the "Blue" option is selected successfully
        //driver.findElement(By.xpath("//strong[contains(text(),'Blue')]")).isDisplayed();
        //Assert.assertEquals(driver.findElement(By.xpath("//strong[contains(text(),'Blue')]")).getText(), "Blue");

        String colorPreviewText = driver.findElement(By.xpath("//option[contains(text(),\"Blue\")]")).getText();
        System.out.println(colorPreviewText);
        Assert.assertEquals(colorPreviewText, "Blue");
        //The above may be referencing the dropdown option rather than the color preview

        //Entering the quantity
        driver.findElement(By.id("quantity")).sendKeys("2");

        //Need to add assertions to verify that the quantity is entered successfully
        //getText() does not work for input fields, we need to use getAttribute("value") instead
        String quantityValue = driver.findElement(By.id("quantity-value")).getText();
        System.out.println(quantityValue);
        Assert.assertEquals(quantityValue, "2");

        //Entering the address
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("123 Test Street");
        //Need to add assertions to verify that the address is entered successfully
        String address = driver.findElement(By.xpath("//*[@id=\"address\"]")).getAttribute("value");
        System.out.println(address);
        Assert.assertEquals(address, "123 Test Street");

        //Clicking the Next button to proceed to the inventory page
        driver.findElement(By.id("inventory-next-btn")).click();

        //Need to add assertions to verify that the user is navigated to the inventory page successfully
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("review-section-title")));
        String inventoryPageText = driver.findElement(By.id("review-section-title")).getText();
        System.out.println(inventoryPageText);
        Assert.assertEquals(inventoryPageText, "REVIEW");

        //Clicking the Express Shipping option
        driver.findElement(By.id("shipping-express")).click();

        //Need to add assertions to verify that the "Express Shipping" option is selected successfully
        String shippingAmt = driver.findElement(By.id("breakdown-shipping-value")).getText();
        System.out.println(shippingAmt);
        Assert.assertEquals(shippingAmt, "R25.00");

        //Clicking the 1 Year Warranty option
        driver.findElement(By.id("warranty-option-1yr")).click();
        //Need to add assertions to verify that the "1 Year Warranty" option is selected successfully (R25.00)
        driver.findElement(By.id("breakdown-warranty-value")).isDisplayed();
        //Note the below assertion does not display in terminal nor the above
        Assert.assertEquals(driver.findElement(By.id("breakdown-warranty-value")).getText(), "R49.00");

        //The below code works and displays the warranty amount in the terminal.
        String warrantyAmt = driver.findElement(By.id("breakdown-warranty-value")).getText();
        System.out.println(warrantyAmt);
        Assert.assertEquals(warrantyAmt, "R49.00");

        //Entering the discount code
        driver.findElement(By.id("discount-code")).sendKeys("SAVE10");
        //Clicking the Apply button
        driver.findElement(By.id("apply-discount-btn")).click();

        //Assertion that the discount code is applied
        String DiscountAmt = driver.findElement(By.id("discount-feedback")).getText();
        System.out.println(DiscountAmt);
        Assert.assertEquals(DiscountAmt, "Code SAVE10 applied: -10%");

        //Clicking the Purchase button to complete the purchase
        driver.findElement(By.id("purchase-device-btn")).click();

        //Waiting for the order successful toast message to be visible after clicking the Purchase button
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"purchase-success-toast\"]/div[1]/h4")));

        //Assertion to verify that the order successful toast message is displayed correctly
        String orderSuccessfulText = driver.findElement(By.xpath("//*[@id=\"purchase-success-toast\"]/div[1]/h4")).getText();
        System.out.println(orderSuccessfulText);
        Assert.assertEquals(orderSuccessfulText, "ORDER SUCCESSFUL! \uD83C\uDF89");

        //clicking the View Invoice button to navigate to the invoice page
        driver.findElement(By.id("view-history-btn")).click();

        //waiting for the invoice history page to be visible after clicking the View Invoice button
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("invoice-history-title")));

        //Assertion to verify that the user is navigated to the invoice history page successfully
        String invoiceHistoryText = driver.findElement(By.id("invoice-history-title")).getText();
        System.out.println(invoiceHistoryText);
        Assert.assertEquals(invoiceHistoryText, "\uD83D\uDCC4 Invoice History");

        new WebDriverWait(driver, Duration.ofSeconds(5));

        //Clicking the View Invoice button to view the invoice details of the order
        //driver.findElement(By.xpath("//id[contains(text(), '\\uD83D\\uDC41\\uFE0F View')]")).click();

        By viewBtn = By.xpath("//button[.//text()[contains(.,'\uD83D\uDC41\uFE0F View')]]");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(viewBtn));
        driver.findElement(viewBtn).click();

        //Waiting for the invoice details page to be visible after clicking the View Invoice button
        new  WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//class[text()[contains(.,'Total: R930.60')]]")));

        //Assertion to verify that the user is navigated to the invoice details page successfully
        String invoiceDetailsText = driver.findElement(By.xpath("//class[text()[contains(.,'Total: R930.60')]]")).getText();
        System.out.println(invoiceDetailsText);
        Assert.assertEquals(invoiceDetailsText, "Total: R930.60");









    }



    @Test(alwaysRun = true)
    public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

}
