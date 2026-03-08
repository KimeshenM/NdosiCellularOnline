package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String BrowserChoice = "chrome";

    public final WebDriver driver = browserFactory.startBrowser(BrowserChoice, url);




}
