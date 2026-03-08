package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver startBrowser(String BrowserChoice, String url) {
        if (BrowserChoice.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BrowserChoice.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (BrowserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        }

}
