package steps;


import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import init.Init;
import org.junit.After;
import org.junit.Before;
import pagesSberbank.SberbankInsurancePage;
import pagesSberbank.SberbankMainPage;
import pagesSberbank.SberbankTravelInsurancePage;

public class StepsSber {
    SberbankMainPage sberbankMainPage = new SberbankMainPage();
    SberbankInsurancePage sberbankInsurancePage;
    SberbankTravelInsurancePage sberbankTravelInsurancePage;

    static  {
        Init.startBrowser(SberbankMainPage.SBER_URL);
    }

    @Когда("выбран пункт меню {string}")
    public void выбран_пункт_меню(String string) {
        sberbankMainPage.insuranceBtn();
    }

    @Когда("выбран пункт подменю {string}")
    public void выбран_пункт_подменю(String string) {
        sberbankMainPage.purchasesAndTravelClick();
    }

    @Тогда("переходим на страницу страхования путешественников")
    public void переходим_на_страницу_страхования_путешественников() {
        sberbankTravelInsurancePage = sberbankMainPage.openTravelInsurance();
    }

    @Когда("присутствует заголовок Страхование путешественников")
    public void присутствует_заголовок_Страхование_путешественников() {
        sberbankTravelInsurancePage.textDisplayedCheck(sberbankTravelInsurancePage.headlineInsuranceAndTravel);
    }

    @Тогда("нажимаем кнопку Оформить онлайн")
    public void нажимаем_кнопку_Оформить_онлайн() {
        sberbankTravelInsurancePage.makeRequest();
    }

    @Тогда("переходим на страницу страхования")
    public void переходим_на_страницу_страхования() {
        sberbankInsurancePage = sberbankTravelInsurancePage.goToNextPage();
        sberbankInsurancePage.newWindow(sberbankInsurancePage);
    }

    @Когда("выбрана минимальная сумма страхования")
    public void выбрана_минимальная_сумма_страхования() {
        sberbankInsurancePage.findAndClickMinimumBtn();
    }

    @Тогда("нажимаем кнопку Оформить")
    public void нажимаем_кнопку_Оформить() {
        sberbankInsurancePage.findAndClickRegistrationBtn();
    }

    @Когда("заполняются все поля:")
    public void заполняются_все_поля(io.cucumber.datatable.DataTable dataTable) {
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.insuredSurname, "PETROV");
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.insuredName, "PETR");
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.insuredBirthDate, "01.01.2000");
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.insuredBirthDateTable);
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.surname, "Иванов");
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.name, "Иван");
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.middlename, "Иванович");
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.birthDateTable);
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.birthDate, "21.03.1999");
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.birthDateTable);
        sberbankInsurancePage.checkBox(sberbankInsurancePage.female);
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.passportSeries, "8264");
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.passportNumber, "826401");
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.issueDateTable);
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.issueDate, "02.02.2015");
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.issueDateTable);
        sberbankInsurancePage.fillingForm(sberbankInsurancePage.issuePlace, "УФМС по Московской области");
    }

    @Тогда("значения всех полей равны:")
    public void значения_всех_полей_равны(io.cucumber.datatable.DataTable dataTable) {
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.insuredSurname, "PETROV");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.insuredName, "PETR");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.insuredBirthDate, "01.01.2000");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.surname, "Иванов");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.name, "Иван");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.middlename, "Иванович");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.birthDate, "21.03.1999");
        sberbankInsurancePage.assertCheckBox(sberbankInsurancePage.female);
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.passportSeries, "8264");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.passportNumber, "826401");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.issueDate, "02.02.2015");
        sberbankInsurancePage.checkAssert(sberbankInsurancePage.issuePlace, "УФМС по Московской области");
    }

    @Тогда("присутствует сообщение об ошибке заполнения формы")
    public void присутствует_сообщение_об_ошибке_заполнения_формы() {
        sberbankInsurancePage.buttonClick(sberbankInsurancePage.continueButton);
        sberbankInsurancePage.textDisplayedCheck(sberbankInsurancePage.errorMessage);
    }
}
