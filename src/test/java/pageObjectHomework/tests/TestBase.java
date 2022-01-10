package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import pageObjectHomework.pages.registration_page.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    public static String URL = "/automation-practice-form";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
