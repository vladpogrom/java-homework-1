package pageObjectHomework.pages.components;

import pageObjectHomework.pages.registration_page.RegistrationPage;

public class UploadComponent {
    public void UploadFile(String path) {

        RegistrationPage.uploadPictureLocator.uploadFromClasspath(path);
    }
}
