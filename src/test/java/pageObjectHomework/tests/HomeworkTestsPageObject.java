package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class HomeworkTestsPageObject extends TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        dataComponent.dataComponentSet();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Owner("vladpogrom")
    @DisplayName("Тесты на форму /practice-form")
    void fillForm() {
        step ("Открываем страницу", () -> {
            registrationPage.openForm();
        });
        step ("Заполняем дату и загружаем картинку", () -> {
            registrationPage.calendarComponent.setDate(data.userDateDay, data.userDateMonth, data.userDateYear);
            registrationPage.uploadComponent.UploadFile(data.userPicture);
        });
        step ("Заполняем остальные инпуты", () -> {
            registrationPage
                    .typeMethod(registrationPage.firstNameLocator, data.firstName)
                    .typeMethod(registrationPage.lastNameLocator, data.lastName)
                    .typeMethod(registrationPage.userEmailLocator, data.userEmail)
                    .setGender(data.genderType)
                    .typeMethod(registrationPage.userNumberLocator, data.userNumber)
                    .typeMethod(registrationPage.currentAdressLocator, data.userAdress)
                    .typeStateAndCity(registrationPage.selectStateLocator, data.userState)
                    .typeStateAndCity(registrationPage.selectCityLocator, data.userCity)
                    .typeSubjects(registrationPage.subjectsInputLocator, data.subjects)
                    .typeHobbies(registrationPage.hobbyCheckboxLocator, data.hobbies);
        });
        step ("Нажимаем сабмит и проверяем что форма проверки открыта", () -> {
            registrationPage.submitClick()
                    .checkResultValue(registrationPage.submitFormLocator, data.submitFormText);
        });
        step ("Делаем ассерты", () -> {
            registrationPage
                    .textCheckResultValue(data.firstName + " " + data.lastName)
                    .textCheckResultValue(data.userEmail)
                    .textCheckResultValue(String.join(", ", data.subjects))
                    .textCheckResultValue(String.join(", ", data.hobbies))
                    .textCheckResultValue(data.userNumber)
                    .textCheckResultValue(data.userPicture.substring(6))
                    .textCheckResultValue(data.userAdress)
                    .textCheckResultValue(data.userState + " " + data.userCity)
                    .textCheckResultValue(data.genderType)
                    .textCheckResultValue((data.userDateDay) + " " + (data.userDateMonthAssert) + "," + (data.userDateYear));
        });
        step ("Закрываем страницу", () -> {
            registrationPage.closeForm();
        });
    }

    @AfterEach
    public void saveSources() {
        registrationPage.attachPageSource();
    }
}