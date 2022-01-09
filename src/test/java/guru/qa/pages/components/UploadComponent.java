package guru.qa.pages.components;

import guru.qa.pages.RegistrationPage;

public class UploadComponent {
    public void UploadFile(String path) {
        RegistrationPage.uploadPictureLocator.uploadFromClasspath(path);
    }


}
