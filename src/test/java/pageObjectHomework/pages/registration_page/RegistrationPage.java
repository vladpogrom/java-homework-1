package pageObjectHomework.pages.registration_page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageObjectHomework.pages.components.CalendarComponent;
import pageObjectHomework.pages.components.UploadComponent;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pageObjectHomework.tests.TestBase.URL;

public class RegistrationPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public UploadComponent uploadComponent = new UploadComponent();

    // Locators
    public SelenideElement genderLocator = $("#genterWrapper");
    public SelenideElement firstNameLocator = $("#firstName");
    public SelenideElement lastNameLocator = $("#lastName");
    public SelenideElement userEmailLocator = $("#userEmail");
    public SelenideElement userNumberLocator = $("#userNumber");
    public SelenideElement resultTableElementLocator = $("[class=table-responsive]");
    public SelenideElement submitButtonLocator = $("#submit");
    public SelenideElement submitFormLocator = $("#example-modal-sizes-title-lg");
    public SelenideElement practiceFormSelector = $(".practice-form-wrapper");
    public SelenideElement closeFormLocator = $("#closeLargeModal");
    public SelenideElement currentAdressLocator = $("#currentAddress");
    public SelenideElement hobbyCheckboxLocator = $("#hobbiesWrapper");
    public SelenideElement subjectsInputLocator = $("#subjectsInput");
    public SelenideElement selectStateLocator = $("#react-select-3-input");
    public SelenideElement selectCityLocator = $("#react-select-4-input");
    public SelenideElement uploadPictureLocator = $("#uploadPicture");

    @Step("Открыть страницу {URL}")
    public RegistrationPage openForm() {
        open(URL);
        return this;
    }

    @Step("Проверить, что страница открыта")
    public RegistrationPage checkResultValue(SelenideElement element, String value) {
        element.shouldHave(text(value));
        return this;
    }

    @Step("Проверка наличия текста {value} на форме проверки")
    public RegistrationPage textCheckResultValue(String value) {
        resultTableElementLocator.shouldHave(text(value));
        return this;
    }

    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeMethod(SelenideElement element, String value) {
        element.setValue(value);
        return this;
    }

    @Step("Выбрать радиобаттон гендера {value}")
    public RegistrationPage setGender(String value) {
        genderLocator.$(byText(value)).click();
        return this;
    }

    @Step("Нажать кнопку сабмита")
    public RegistrationPage submitClick() {
        submitButtonLocator.scrollTo().click();
        return this;
    }

    @Step("Закрыть форму проверки")
    public RegistrationPage closeForm() {
        closeFormLocator.scrollIntoView(false).click();
        return this;
    }

    @Step("Проверить, что форма проверки закрыта")
    public boolean isCloseFormClosed(SelenideElement element) {
        return element.isDisplayed(); // or shouldBe(visible)
    }

    @Step("Заполнить поле hobbies")
    public RegistrationPage typeHobbies(SelenideElement element, String[] hobbies) {
        Arrays.stream(hobbies).forEach(hobby ->
                element.$(byText(hobby)).click());
        return this;
    }

    @Step("Заполнить поле subjects")
    public RegistrationPage typeSubjects(SelenideElement element, String[] subjects) {
        Arrays.stream(subjects).forEach(subject ->
                element.setValue(subject).pressEnter());
        return this;
    }

    @Step("Заполнить поле state значением {value}")
    public RegistrationPage typeStateAndCity(SelenideElement element, String value) {
        element.setValue(value).pressEnter();
        return this;
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
