package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Init {
    public static WebDriver driver;

    public static void startBrowser(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
