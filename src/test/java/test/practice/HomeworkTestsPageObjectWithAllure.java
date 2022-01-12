package test.practice;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjectHomework.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Тесты для формы")
public class HomeworkTestsPageObjectWithAllure extends TestBase {

    @BeforeAll
    public static void setUp() {
        registrationPage.openForm();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем, что форма открыта")
    public void isFormOpened() {
        registrationPage.checkResultValue(
                registrationPage.practiceFormSelector, data.openPageTextAssert
        );
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user firstname")
    public void typeUserFirstnameInput() {
        registrationPage.typeMethod(registrationPage.firstNameLocator, data.firstName);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user lastname")
    public void typeUserLastNameInput() {
        registrationPage.typeMethod(registrationPage.lastNameLocator, data.lastName);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user email")
    public void typeUserEmailInput() {
        registrationPage.typeMethod(registrationPage.userEmailLocator, data.userEmail);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем радиселект user gender")
    public void typeUserGenderRadio() {
        registrationPage.setGender(data.genderType);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user number")
    public void typeUserPhoneInput() {
        registrationPage.typeMethod(registrationPage.userNumberLocator, data.userNumber);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user number")
    public void typeDateOfBirth() {
        registrationPage.calendarComponent.setDate(
                data.userDateDay, data.userDateMonth, data.userDateYear
        );
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем мультиинпут для subjects")
    public void typeMultipleInputSubjects() {
        registrationPage.typeHobbies(registrationPage.subjectsInputLocator, data.subjects);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем мультиинпут для hobbies")
    public void typeMultipleInputHobbies() {
        registrationPage.typeSubjects(registrationPage.hobbyCheckboxLocator, data.hobbies);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Загружаем картинку юзера")
    public void uploadUserPicture() {
        registrationPage.uploadComponent.UploadFile(data.userPicture);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем инпут user adress")
    public void typeUserAdressInput() {
        registrationPage.typeMethod(registrationPage.currentAdressLocator, data.userAdress);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем селект для user state")
    public void typeUserStateInput() {
        registrationPage.typeStateAndCity(registrationPage.selectStateLocator, data.userState);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Заполняем селект для user city")
    public void typeUserCityInput() {
        registrationPage.typeStateAndCity(registrationPage.selectCityLocator, data.userCity);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Нажмаем сабмит для открытия формы проверки")
    public void typeSubmitToOpenCheckForm() {
        registrationPage.submitClick();
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем, что форма проверки открыта")
    public void isCheckFormOpened() {
        registrationPage.checkResultValue(registrationPage.submitFormLocator, data.submitFormText);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие firstname lastname")
    public void isFirstnameLastnameExist() {
        registrationPage.textCheckResultValue(data.firstName + " " + data.lastName);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие email")
    public void isUserEmailExists() {
        registrationPage.textCheckResultValue(data.userEmail);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user number")
    public void isUserNumberExists() {
        registrationPage.textCheckResultValue(data.userNumber);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user adress")
    public void isUserAdressExists() {
        registrationPage.textCheckResultValue(data.userAdress);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие gender type")
    public void isUserGenderExists() {
        registrationPage.textCheckResultValue(data.genderType);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие state and city")
    public void isUserStateAndCityExists() {
        registrationPage.textCheckResultValue(data.userState + " " + data.userCity);
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user picture")
    public void isUserPictureExists() {
        registrationPage.textCheckResultValue(data.userPicture.substring(4));
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user date of birth")
    public void isUserDateOfBirthExists() {
        registrationPage.textCheckResultValue(
                (data.userDateDay) + " " + (data.userDateMonthAssert) + "," + (data.userDateYear)
        );
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user subjects")
    public void isUserSubjectsExists() {
        registrationPage.textCheckResultValue(String.join(", ", data.subjects));
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем наличие user hobbies")
    public void isUserHobbiesExists() {
        registrationPage.textCheckResultValue(String.join(", ", data.hobbies));
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Закрываем форму")
    public void closeForm() {
        registrationPage.closeForm();
    }

    @Test
    @Owner(value = "vladpogrom")
    @DisplayName("Проверяем, что форма закрыта")
    public void isCloseFormClosedWithAssert() {
        assertFalse(registrationPage.isCloseFormClosed(registrationPage.closeFormLocator));
    }

    @AfterEach
    public void saveSources() {
        registrationPage.attachPageSource();
    }
}
