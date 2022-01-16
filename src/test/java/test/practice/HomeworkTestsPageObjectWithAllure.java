//package test.practice;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.Owner;
//import org.junit.jupiter.api.*;
//import pageObjectHomework.tests.TestBase;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DisplayName("Тесты для формы")
//public class HomeworkTestsPageObjectWithAllure extends TestBase {
//
//    @BeforeAll
//    public static void setUp() {
//        dataComponent.dataComponentSet();
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//        registrationPage.openForm();
//    }
//
//    @Order(1)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем, что форма открыта")
//    public void isFormOpened() {
//        registrationPage.checkResultValue(
//                registrationPage.practiceFormSelector, data.openPageTextAssert
//        );
//    }
//
//    @Order(2)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user firstname")
//    public void typeUserFirstnameInput() {
//        registrationPage.typeMethod(registrationPage.firstNameLocator, data.firstName);
//    }
//
//    @Order(3)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user lastname")
//    public void typeUserLastNameInput() {
//        registrationPage.typeMethod(registrationPage.lastNameLocator, data.lastName);
//    }
//
//    @Order(4)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user email")
//    public void typeUserEmailInput() {
//        registrationPage.typeMethod(registrationPage.userEmailLocator, data.userEmail);
//    }
//
//    @Order(5)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем радиселект user gender")
//    public void typeUserGenderRadio() {
//        registrationPage.setGender(data.genderType);
//    }
//
//    @Order(6)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user number")
//    public void typeUserPhoneInput() {
//        registrationPage.typeMethod(registrationPage.userNumberLocator, data.userNumber);
//    }
//
//    @Order(1)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user number")
//    public void typeDateOfBirth() {
//        registrationPage.calendarComponent.setDate(
//                data.userDateDay, data.userDateMonth, data.userDateYear
//        );
//    }
//
//    @Order(7)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем мультиинпут для subjects")
//    public void typeMultipleInputSubjects() {
//        registrationPage.typeSubjects(registrationPage.subjectsInputLocator, data.subjects);
//    }
//
//    @Order(8)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем мультиинпут для hobbies")
//    public void typeMultipleInputHobbies() {
//        registrationPage.typeHobbies(registrationPage.hobbyCheckboxLocator, data.hobbies);
//    }
//
//    @Order(9)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Загружаем картинку юзера")
//    public void uploadUserPicture() {
//        registrationPage.uploadComponent.UploadFile(data.userPicture);
//    }
//
//    @Order(10)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем инпут user adress")
//    public void typeUserAdressInput() {
//        registrationPage.typeMethod(registrationPage.currentAdressLocator, data.userAdress);
//    }
//
//    @Order(11)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем селект для user state")
//    public void typeUserStateInput() {
//        registrationPage.typeStateAndCity(registrationPage.selectStateLocator, data.userState);
//    }
//
//    @Order(12)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Заполняем селект для user city")
//    public void typeUserCityInput() {
//        registrationPage.typeStateAndCity(registrationPage.selectCityLocator, data.userCity);
//    }
//
//    @Order(13)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Нажмаем сабмит для открытия формы проверки")
//    public void typeSubmitToOpenCheckForm() {
//        registrationPage.submitClick();
//    }
//
//    @Order(14)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем, что форма проверки открыта")
//    public void isCheckFormOpened() {
//        registrationPage.checkResultValue(registrationPage.submitFormLocator, data.submitFormText);
//    }
//
//    @Order(15)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие firstname lastname")
//    public void isFirstnameLastnameExist() {
//        registrationPage.textCheckResultValue(data.firstName + " " + data.lastName);
//    }
//
//    @Order(16)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие email")
//    public void isUserEmailExists() {
//        registrationPage.textCheckResultValue(data.userEmail);
//    }
//
//    @Order(17)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user number")
//    public void isUserNumberExists() {
//        registrationPage.textCheckResultValue(data.userNumber);
//    }
//
//    @Order(18)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user adress")
//    public void isUserAdressExists() {
//        registrationPage.textCheckResultValue(data.userAdress);
//    }
//
//    @Order(19)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие gender type")
//    public void isUserGenderExists() {
//        registrationPage.textCheckResultValue(data.genderType);
//    }
//
//    @Order(20)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие state and city")
//    public void isUserStateAndCityExists() {
//        registrationPage.textCheckResultValue(data.userState + " " + data.userCity);
//    }
//
//    @Order(21)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user picture")
//    public void isUserPictureExists() {
//        registrationPage.textCheckResultValue(data.userPicture.substring(4));
//    }
//
//    @Order(22)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user date of birth")
//    public void isUserDateOfBirthExists() {
//        registrationPage.textCheckResultValue(
//                (data.userDateDay) + " " + (data.userDateMonthAssert) + "," + (data.userDateYear)
//        );
//    }
//
//    @Order(23)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user subjects")
//    public void isUserSubjectsExists() {
//        registrationPage.textCheckResultValue(String.join(", ", data.subjects));
//    }
//
//    @Order(24)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем наличие user hobbies")
//    public void isUserHobbiesExists() {
//        registrationPage.textCheckResultValue(String.join(", ", data.hobbies));
//    }
//
//    @Order(25)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Закрываем форму")
//    public void closeForm() {
//        registrationPage.closeForm();
//    }
//
//    @Order(26)
//    @Test
//    @Owner(value = "vladpogrom")
//    @DisplayName("Проверяем, что форма закрыта")
//    public void isCloseFormClosedWithAssert() {
//        assertTrue(registrationPage.isCloseFormClosed(registrationPage.closeFormLocator));
//    }
//
//    @AfterEach
//    public void saveSources() {
//        registrationPage.attachPageSource();
//    }
//}
