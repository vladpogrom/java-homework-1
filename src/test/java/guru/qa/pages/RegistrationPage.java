package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.UploadComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.tests.TestData.submitFormText;

public class RegistrationPage {
        static SelenideElement
                firstNameLocator = $("#firstName");
    static SelenideElement lastNameLocator = $("#lastName");
    static SelenideElement userEmailLocator = $("#userEmail");
    static SelenideElement userNumberLocator = $("#userNumber");
    static SelenideElement resultTableElementLocator = $("[class=table-responsive]");
    static SelenideElement genderRadioLocator = $("#gender-radio-3").parent();
    static SelenideElement submitButtonLocator = $("#submit");
    static SelenideElement submitFormLocator = $("#example-modal-sizes-title-lg");
    static SelenideElement practiceFormSelector = $(".practice-form-wrapper");
    static SelenideElement closeFormLocator = $("#closeLargeModal");
    static SelenideElement currentAdressLocator = $("#currentAddress");
    public static SelenideElement uploadPictureLocator = $("#uploadPicture");
//                dateInputLocator = $("#dateOfBirthInput"),
//                yearSelectLocator = $("[class*='year-select']").selectOptionByValue(year),
//                monthSelectLocator = $("[class*='month-select']").selectOptionByValue(month),
//                daySelectLocator = $$("[role=option]").findBy(text(date)).click();

    public CalendarComponent calendarComponent = new CalendarComponent();
        public UploadComponent uploadComponent = new UploadComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
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
        genderRadioLocator.click();

        return this;
    }

    public RegistrationPage submitClick() {
        submitButtonLocator.scrollTo().click();

        return this;
    }

    public RegistrationPage checkVisibleOfSubmitForm() {
        submitFormLocator.shouldHave(text(submitFormText));

        return this;
    }

    public RegistrationPage closeFormClick() {
        closeFormLocator.scrollIntoView(false).click();

        return this;
    }

    public RegistrationPage typeCurrentAdress(String value) {
        currentAdressLocator.setValue(value);

        return this;
    }

}
