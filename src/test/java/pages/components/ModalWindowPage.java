package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.ResultTableData;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage {
    private SelenideElement modalWindow = $(".modal-dialog");
    private SelenideElement modalWindowHeader = $("#example-modal-sizes-title-lg");
    private SelenideElement modalWindowTable = $(".table-responsive");

    @Step("Проверяем, что после заполнения формы появился модал")
    public ModalWindowPage checkModalWindow () {
        modalWindow.should(appear);

        return this;
    }

    @Step("Проверяем, что сообщение об успешном заполнении формы в модале появилось")
    public ModalWindowPage checkModalWindowHeader (String value) {
        modalWindowHeader.shouldHave(text(value));;

        return this;
    }

    @Step("Проверяем, что {key} соответствует введенному {value}")
    public ModalWindowPage checkModalWindowTable (String key, String value) {
        modalWindowTable.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверяем, что после заполнения формы не появился модал")
    public void checkModalWindowNotVisible() {
        modalWindow.shouldNotBe(visible);
    }

}
