package demo;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.components.ModalWindowPage;
import utils.TestData;

import java.util.Map;

import static utils.ResultTableData.*;

@Tag("regression")
@Owner("Maksim Ozhegov")
public class DemoQaFormTestsWithPom extends TestBase {

    FormPage formPage = new FormPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();

    TestData testData = new TestData();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("При заполнении всех полей формы валдиными данными появляется модал с заполненными данными")
    void seeModalTableWhenAllDataInputsFilled(){

        formPage.openPage()
                .removeFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobileNumber)
                .setDayOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.userSubject)
                .setHobby(testData.userHobby)
                .uploadPicture(testData.picture)
                .setUserAddress(testData.userStreetAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submitForm();

        modalWindowPage.checkModalWindow()
                .checkModalWindowHeader(MODAL_HEADER.description)
                .checkModalWindowTable(NAME.description, testData.firstName + " " + testData.lastName)
                .checkModalWindowTable(EMAIL.description, testData.userEmail)
                .checkModalWindowTable(GENDER.description, testData.userGender)
                .checkModalWindowTable(MOBILE.description, testData.userMobileNumber)
                .checkModalWindowTable(DATE_OF_BIRTH.description, testData.day + " " + testData.month + "," + testData.year)
                .checkModalWindowTable(SUBJECTS.description, testData.userSubject)
                .checkModalWindowTable(HOBBIES.description, testData.userHobby)
                .checkModalWindowTable(PICTURE.description, testData.picture)
                .checkModalWindowTable(ADDRESS.description, testData.userStreetAddress)
                .checkModalWindowTable(STATE_AND_CITY.description, testData.userState + " " + testData.userCity);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("При заполнении минимального количества полей формы валдиными данными появляется модал с заполненными данными")
    void seeModalTableWhenMinDataInputsFilled() {
        formPage.openPage()
                .removeFooter()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userMobileNumber)
                .submitForm();

        modalWindowPage.checkModalWindow()
                .checkModalWindowHeader(MODAL_HEADER.description)
                .checkModalWindowTable(NAME.description, testData.firstName + " " + testData.lastName)
                .checkModalWindowTable(GENDER.description, testData.userGender)
                .checkModalWindowTable(MOBILE.description, testData.userMobileNumber);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("При незаполнении полей формы и нажатии кнопки submit модал с заполненными данными не появляется")
    void checkEmptyForm() {
        formPage.openPage()
                .removeFooter()
                .submitForm();

        modalWindowPage.checkModalWindowNotVisible();
    }
}
