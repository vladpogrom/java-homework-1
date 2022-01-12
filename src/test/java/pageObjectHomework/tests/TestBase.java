package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import pageObjectHomework.pages.components.DataComponent;
import pageObjectHomework.pages.registration_page.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static DataComponent dataComponent = new DataComponent();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public TestData data = new TestData();

    public static String URL = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void setUp() {
        dataComponent.dataComponentSet();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        
    }

}
