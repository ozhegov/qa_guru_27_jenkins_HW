package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {

    SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            hobbiesWrapper =  $("#hobbiesWrapper"),
                            userAddressInput = $("#currentAddress"),
                            subjectWrapper = $("#subjectsWrapper"),
                            subjectInput = $("#subjectsInput"),
                            fileUpload =  $("#uploadPicture"),
                            stateSelector = $("#state"),
                            stateCityWrapper = $("#stateCity-wrapper"),
                            citySelector = $("#city"),
                            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу с формой")
    public FormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Удаляем со страницы футер и рекламные баннеры")
    public FormPage removeFooter() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    @Step("Вводим имя {firstName}")
    public FormPage setFirstName (String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Ввводим фамилию {lastName}")
    public FormPage setLastName (String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Ввводим email {email}")
    public FormPage setEmail (String email) {
        emailInput.setValue(email);

        return this;
    }

    @Step("Ввводим пол {gender}")
    public FormPage setGender (String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    @Step("Ввводим номер мобильного телефона {userNumber}")
    public FormPage setUserNumber (String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    @Step("Ввводим дату рождения {day} {month} {year}")
    public FormPage setDayOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDay(day, month, year);

        return this;
    }

    @Step("Ввводим предмет {subject}")
    public FormPage setSubject (String subject) {
        subjectWrapper.click();
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Ввводим хобби {hobby}")
    public FormPage setHobby (String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    @Step("Загружаем картинку {fileName}")
    public FormPage uploadPicture (String fileName) {
        fileUpload.uploadFromClasspath(fileName);

        return this;
    }

    @Step("Ввводим адрес проживания {userAddress}")
    public FormPage setUserAddress (String userAddress) {
        userAddressInput.setValue(userAddress);

        return this;
    }

    @Step("Ввводим штат {state}")
    public FormPage setState (String state) {
        stateSelector.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    @Step("Ввводим город {city}")
    public FormPage setCity (String city) {
        citySelector.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    @Step("Нажимаем кнопку submit")
    public void submitForm () {
        submitButton.click();
    }

}
