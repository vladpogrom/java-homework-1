package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static guru.qa.tests.TestData.*;

public class HomeworkTestsPageObject extends TestBase {

    @Test
    void fillForm() {
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .typeUserNumber(userNumber);
        registrationPage.setGender();
        registrationPage.uploadComponent.UploadFile(userPicture);
        registrationPage.typeCurrentAdress(userAdress);

        $("#react-select-3-input").setValue("Har").pressEnter();
        $("#react-select-4-input").setValue("Kar").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter().setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        //Fill date
        registrationPage.calendarComponent.setDate(userDateDay,userDateMonth,userDateYear);

        // Click to submit
        registrationPage.submitClick();

        //Check visible of form
        registrationPage.checkVisibleOfSubmitForm();

        //Asserts
        registrationPage
                .checkResultValue(firstName + lastName)
                .checkResultValue(userEmail)
                .checkResultValue("Other")
                .checkResultValue(userNumber)
                .checkResultValue("userDateDay April,userDateYear") // todo
                .checkResultValue("Sports, Reading, Music")
                .checkResultValue(userPicture.substring(2))
                .checkResultValue(userAdress)
                .checkResultValue("Haryana Karnal");

        //Close form
        registrationPage.closeFormClick();
    }
}
