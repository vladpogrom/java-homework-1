package pageObjectHomework.pages.components;

import static pageObjectHomework.tests.TestBase.registrationPage;

public class UploadComponent {

    public void UploadFile(String path) {
        registrationPage.uploadPictureLocator.uploadFromClasspath(path);
    }
}
