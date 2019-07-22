package pagesSberbank;

import basePage.BasePage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberbankTravelInsurancePage extends BasePage {

    @FindBy(xpath = "//h3[text() = 'Страхование путешественников']")
    public WebElement headlineInsuranceAndTravel;

    @FindBy(xpath = "//a[contains(@href, 'vzr')]")
    public WebElement makeRequestBtn;

    @Step("Check displayed headline text")
    public void textDisplayedCheck(WebElement element){
        waitForReady(element);
        boolean b = element.isDisplayed();
        Assert.assertTrue("The text is not displayed", b);
    }

    @Step("Open sberbank insurance page")
    public void makeRequest(){
        waitForReady(makeRequestBtn).click();
    }

    @Step("Open sberbank insurance page")
    public SberbankInsurancePage goToNextPage(){
        return new SberbankInsurancePage();
    }
}
