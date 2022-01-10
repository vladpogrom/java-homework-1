package test.practice;

import pageObjectHomework.pages.registration_page.RegistrationPage;
import org.junit.jupiter.api.Test;

public class TestTestTest {
    String[] subjects = {"Chemistry", "Arts", "English", "Commerce"};

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testTests() {
            System.out.println(String.join(", ", subjects));



    }
}
