package pageObjectHomework.tests;

import org.junit.jupiter.api.Test;

public class HomeworkTestsPageObject extends TestBase {

    @Test
    void fillForm() {
        // Open page
        registrationPage.openForm();
        registrationPage.calendarComponent.setDate(data.userDateDay, data.userDateMonth, data.userDateYear);
        registrationPage.uploadComponent.UploadFile(data.userPicture);
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

        // Submit to assert form
        registrationPage.submitClick()
                .checkResultValue(registrationPage.submitFormLocator, data.submitFormText);

        //Asserts
        registrationPage
                .textCheckResultValue(data.firstName + " " + data.lastName)
                .textCheckResultValue(data.userEmail)
                .textCheckResultValue(String.join(", ", data.subjects))
                .textCheckResultValue(String.join(", ", data.hobbies))
                .textCheckResultValue(data.userNumber)
                .textCheckResultValue(data.userPicture.substring(4))
                .textCheckResultValue(data.userAdress)
                .textCheckResultValue(data.userState + " " + data.userCity)
                .textCheckResultValue(data.genderType)
                .textCheckResultValue((data.userDateDay) + " " + (data.userDateMonthAssert) + "," + (data.userDateYear));

        // Close form
        registrationPage.closeForm();
    }
}