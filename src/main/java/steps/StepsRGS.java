package steps;

import basePage.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import init.Init;
import pagesRGS.RGSMainPage;
import pagesRGS.RGSPageDMS;

import java.util.concurrent.TimeUnit;

public class StepsRGS {

    RGSMainPage rgsMainPage = new RGSMainPage();
    RGSPageDMS rgsPageDMS;

    static  {
        Init.startBrowser(RGSMainPage.RGS_URL);
    }

    @Когда("выбран пункт меню Страхование")
    public void выбран_пункт_меню_Страхование() {
        rgsMainPage.dropDownBtn();
    }

    @Когда("выбран пункт подменю ДМС")
    public void выбран_пункт_подменю_ДМС() {
        rgsPageDMS = rgsMainPage.openDMS();
    }

    @Тогда("переходим на страницу добровольного медицинского страхования")
    public void переходим_на_страницу_добровольного_медицинского_страхования() {

    }

    @Когда("присутствует заголовок ДМС — добровольное медицинское страхование")
    public void присутствует_заголовок_ДМС_добровольное_медицинское_страхование() {
        rgsPageDMS.textDisplayedCheck(rgsPageDMS.headlineTextDMS);
    }

    @Тогда("нажимаем кнопку Отправить заявку")
    public void нажимаем_кнопку_Отправить_заявку() {
        rgsPageDMS.buttonClick(rgsPageDMS.requestBtn);
    }

    @Тогда("присутствует заголовок Заявка на добровольное медицинское страхование")
    public void присутствует_заголовок_Заявка_на_добровольное_медицинское_страхование() {
        rgsPageDMS.textDisplayedCheck(rgsPageDMS.headlineTextRequest);
    }

    @Когда("заполняются поля:")
    public void заполняются_поля(io.cucumber.datatable.DataTable dataTable) {
        rgsPageDMS.fillingForm(rgsPageDMS.lastName, "Иванов");
        rgsPageDMS.fillingForm(rgsPageDMS.name, "Иван");
        rgsPageDMS.fillingForm(rgsPageDMS.patronymic, "Иванович");
        rgsPageDMS.fillingFormRegion(rgsPageDMS.region);
        rgsPageDMS.fillingForm(rgsPageDMS.phoneNumber, "9997771234");
        rgsPageDMS.fillingForm(rgsPageDMS.email, "qwertyqwerty");
        rgsPageDMS.fillingForm(rgsPageDMS.comment, "Текст комментария");
    }

    @Когда("поставлен чекбокс Я согласен на обработку моих персональных данных")
    public void поставлен_чекбокс_Я_согласен_на_обработку_моих_персональных_данных() {
        rgsPageDMS.checkBoxFilling(rgsPageDMS.checkBoxAccept);
    }

    @Тогда("значения полей равны:")
    public void значения_полей_равны(io.cucumber.datatable.DataTable dataTable) {
        rgsPageDMS.checkAssert(rgsPageDMS.lastName, "Иванов");
        rgsPageDMS.checkAssert(rgsPageDMS.name, "Иван");
        rgsPageDMS.checkAssert(rgsPageDMS.patronymic, "Иванович");
        rgsPageDMS.checkAssert(rgsPageDMS.region, "77");
        rgsPageDMS.checkAssert(rgsPageDMS.phoneNumber, "+7 (999) 777-12-34");
        rgsPageDMS.checkAssert(rgsPageDMS.email, "qwertyqwerty");
        rgsPageDMS.checkAssert(rgsPageDMS.comment, "Текст комментария");
        rgsPageDMS.assertCheckBox(rgsPageDMS.checkBoxAccept);
    }

    @Когда("нажали на кнопку Отправить")
    public void нажали_на_кнопку_Отправить() {
        rgsPageDMS.buttonClick(rgsPageDMS.sendButton);
    }

    @Тогда("присутствует сообщение об ошибке")
    public void присутствует_сообщение_об_ошибке() {
        rgsPageDMS.textDisplayedCheck(rgsPageDMS.errorMessageIsDisplayed);
    }

    @Тогда("очищаем поле Эл. почта")
    public void очищаем_поле_Эл_почта() {
        rgsPageDMS.email.clear();
    }

    @Тогда("заново заполняем поле Эл. почта корректными данными qwerty@yandex.ru")
    public void заново_заполняем_поле_Эл_почта_корректными_данными_qwerty_yandex_ru() {
        rgsPageDMS.fillingForm(rgsPageDMS.email, "qwerty@yandex.ru");
    }
}
