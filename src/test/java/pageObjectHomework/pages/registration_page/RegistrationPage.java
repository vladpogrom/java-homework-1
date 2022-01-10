package pageObjectHomework.pages.registration_page;

import com.codeborne.selenide.SelenideElement;
import pageObjectHomework.pages.components.CalendarComponent;
import pageObjectHomework.pages.components.UploadComponent;
import pageObjectHomework.tests.TestData;
import java.util.Arrays;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pageObjectHomework.tests.TestBase.URL;

public class RegistrationPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public UploadComponent uploadComponent = new UploadComponent();
    TestData data = new TestData();
    public SelenideElement genderLocator = $("#gender-radio-" + (data.genderType+1)).parent();
    static SelenideElement firstNameLocator = $("#firstName");
    static SelenideElement lastNameLocator = $("#lastName");
    static SelenideElement userEmailLocator = $("#userEmail");
    static SelenideElement userNumberLocator = $("#userNumber");
    static SelenideElement resultTableElementLocator = $("[class=table-responsive]");
    static SelenideElement submitButtonLocator = $("#submit");
    static SelenideElement submitFormLocator = $("#example-modal-sizes-title-lg");
    static SelenideElement practiceFormSelector = $(".practice-form-wrapper");
    static SelenideElement closeFormLocator = $("#closeLargeModal");
    static SelenideElement currentAdressLocator = $("#currentAddress");
    static SelenideElement hobbyCheckboxLocator = $("#hobbiesWrapper");
    static SelenideElement subjectsInputLocator = $("#subjectsInput");
    static SelenideElement selectStateLocator = $("#react-select-3-input");
    static SelenideElement selectCityLocator = $("#react-select-4-input");
    public static SelenideElement uploadPictureLocator = $("#uploadPicture");

    public RegistrationPage openPage() {
        open(URL);
        practiceFormSelector.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameLocator.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameLocator.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberLocator.setValue(value);
        return this;
    }

    public RegistrationPage checkResultValue(String value) {
        resultTableElementLocator.shouldHave(text(value));
        return this;
    }

    public RegistrationPage setGender() {
        genderLocator.click();
        return this;
    }

    public RegistrationPage submitClick() {
        submitButtonLocator.scrollTo().click();
        return this;
    }

    public RegistrationPage checkVisibleOfSubmitForm() {
        submitFormLocator.shouldHave(text(data.submitFormText));
        return this;
    }

    public RegistrationPage closeForm() {
        closeFormLocator.scrollIntoView(false).click();
        return this;
    }

    public RegistrationPage typeCurrentAdress(String value) {
        currentAdressLocator.setValue(value);
        return this;
    }

    public RegistrationPage typeHobbies(String[] hobbies) {
        Arrays.stream(hobbies).forEach(hobby -> {
            hobbyCheckboxLocator.$(byText(hobby)).click();
        });
        return this;
    }

    public RegistrationPage typeSubjects (String[] subjects) {
        Arrays.stream(subjects).forEach(subject -> {
            subjectsInputLocator.setValue(subject).pressEnter();
        });
        return this;
    }

    public RegistrationPage typeState(String value) {
        selectStateLocator.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeCity(String value) {
        selectCityLocator.setValue(value).pressEnter();
        return this;
    }
}
