package pagesRGS;

import basePage.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RGSMainPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/a[contains(text(), 'Страхование')]")
    public WebElement dropDownButton;

    @FindBy(xpath = "//ul[contains(@class, 'collapse')]//a[contains(text(), 'ДМС')]")
    public WebElement openDMSButton;

    @Step("Press dropDown button")
    public void dropDownBtn(){
        waitForReady(dropDownButton).click();
    }
    @Step("Open DMS web-page rgs")
    public RGSPageDMS openDMS(){
        waitForReady(openDMSButton).click();
        return new RGSPageDMS();
    }
}
