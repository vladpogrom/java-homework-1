package pageObjectHomework.tests;

import org.junit.jupiter.api.Test;

public class HomeworkTestsPageObject extends TestBase {

    @Test
    void fillForm() {
        // Open page
        registrationPage.openPage();
        registrationPage.calendarComponent.setDate(data.userDateDay, data.userDateMonth, data.userDateYear);
        registrationPage.uploadComponent.UploadFile(data.userPicture);
        registrationPage
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender(data.genderType)
                .typeUserNumber(data.userNumber)
                .typeCurrentAdress(data.userAdress)
                .typeSubjects(data.subjects)
                .typeState(data.userState)
                .typeCity(data.userCity)
                .typeHobbies(data.hobbies);

        // Submit to assert form
        registrationPage.submitClick()
                        .checkVisibleOfSubmitForm();

        //Asserts
        registrationPage
                .checkResultValue(data.firstName + " " + data.lastName)
                .checkResultValue(data.userEmail)
                .checkResultValue(String.join(", ", data.subjects))
                .checkResultValue(String.join(", ", data.hobbies))
                .checkResultValue(data.userNumber)
                .checkResultValue(data.userPicture.substring(4))
                .checkResultValue(data.userAdress)
                .checkResultValue(data.userState + " " + data.userCity)
                .checkResultValue(data.genderType)
                .checkResultValue((data.userDateDay) + " " + (data.userDateMonthAssert) + "," + (data.userDateYear));

        // Close form
        registrationPage.closeForm();
    }
}
