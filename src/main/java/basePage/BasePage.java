package basePage;

import init.Init;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public void waitForPageLoad(){
        waitForReady(By.xpath("//body"));
    }

    public BasePage(){
        this.driver = Init.getDriver();
        this.wait = new WebDriverWait(driver, 60);
        new WebDriverWait(driver, 30 , 200);
        PageFactory.initElements(driver, this);
        waitForPageLoad();
    }

    public WebElement waitForReady(WebElement webElement){
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitForReady(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public void newWindow(BasePage page){
        ArrayList<String> tabs = new ArrayList<>(page.driver.getWindowHandles());
        page.driver.switchTo().window(tabs.get(0));
        page.driver.close();
        page.driver.switchTo().window(tabs.get(1));
    }
}
