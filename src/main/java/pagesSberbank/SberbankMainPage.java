package pagesSberbank;

import basePage.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberbankMainPage extends BasePage {
    public final static String SBER_URL = "http://www.sberbank.ru/ru/person";

    @FindBy(xpath = "//span[contains(text(), 'Страхование')]")
    public WebElement insuranceButton;

    @FindBy(xpath = "//a[contains(text(), 'Путешествия и покупки')][contains(@class, 'lg-menu')]")
    public WebElement travelAndPurchasesBtn;

    @Step("Insurance button click")
    public void insuranceBtn(){
        waitForReady(insuranceButton).click();
    }

    @Step("Purchases and travel button click")
    public void purchasesAndTravelClick(){
        waitForReady(travelAndPurchasesBtn).click();
    }

    @Step("Open sberbank purchases and travel page")
    public SberbankTravelInsurancePage openTravelInsurance(){
        return new SberbankTravelInsurancePage();
    }
}
