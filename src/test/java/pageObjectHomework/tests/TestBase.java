package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import pageObjectHomework.pages.components.DataComponent;
import pageObjectHomework.pages.registration_page.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static DataComponent dataComponent = new DataComponent();
    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    public static String URL = "/automation-practice-form";

    @BeforeAll
    static void setUp() {
        dataComponent.dataComponentSet();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        
    }

}
