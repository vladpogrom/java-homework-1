package pageObjectHomework.tests;

import org.junit.jupiter.api.Test;

public class HomeworkTestsPageObject extends TestBase {

    @Test
    void fillForm() {
        // Open page
        registrationPage.openPage();

        // Fill form (с календарем надо более универсальный метод, т.к месяц может бьть 02, а день 31
        registrationPage.uploadComponent.UploadFile(data.userPicture);
        registrationPage.calendarComponent.setDate(data.userDateDay,data.userDateMonth,data.userDateYear);
        registrationPage
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeEmail(data.userEmail)
                .setGender()
                .typeUserNumber(data.userNumber)
                .typeCurrentAdress(data.userAdress)
                .typeSubjects(data.subjects)
                .typeState(data.userState)
                .typeCity(data.userCity)
                .typeHobbies(data.hobbies);

        // Submit to asserts form
        registrationPage.submitClick()
                        .checkVisibleOfSubmitForm();

        //Asserts
        registrationPage
                .checkResultValue(data.firstName + " " + data.lastName)
                .checkResultValue(data.userEmail)
                .checkResultValue(String.join(", ", data.subjects))
                .checkResultValue(String.join(", ", data.hobbies))
                .checkResultValue(data.userNumber)
                .checkResultValue((data.userDateDay) + " " + (registrationPage.calendarComponent.getMonth(data.userDateMonth)) + "," + (data.userDateYear))
                .checkResultValue(data.userPicture.substring(4))
                .checkResultValue(data.userAdress)
                .checkResultValue(data.userState + " " + data.userCity)
                .checkResultValue(data.genders[data.genderType]);

        // Close form
        registrationPage.closeForm();
    }
}
