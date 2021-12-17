package vladpogrom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm() {
        //Open form
        open("https://demoqa.com/automation-practice-form");

        //Fill easy forms
        $("#firstName").setValue("Big");
        $("#lastName").setValue("Lebovski");
        $("#userEmail").setValue("Lebovski@gmail.com");
        $("[for=\"gender-radio-3\"]").click();
        $("#userNumber").setValue("9887987687");
        $("#subjectsInput").setValue("Arts").pressEnter().setValue("English").pressEnter().pressEnter();
        $("#uploadPicture").uploadFromClasspath("test_file.png");
        $("#currentAddress").setValue("Adress Big");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        //Run cycle for filling checkboxes todo
        $("[for=\"hobbies-checkbox-1\"]").click();
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("[for=\"hobbies-checkbox-3\"]").click();

        //Fill date
//        $("#dateOfBirthInput"); todo

        $("#submit").scrollTo().click();

        // Run check form
        checkForm();
    }

    void checkForm() {
        //Check visible of form
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Asserts
        $(byText("Big Lebovski")).should(appear);
        $(byText("Lebovski@gmail.com")).should(appear);
        $(byText("Other")).should(appear);
        $(byText("9887987687")).should(appear);
//        $(byText("21 April,1996")).should(appear);
        $(byText("Sports, Reading, Music")).should(appear);
        $(byText("test_file.png")).should(appear);
        $(byText("Adress Big")).should(appear);
        $(byText("Haryana Karnal")).should(appear);

        //Close form
        $("#closeLargeModal").scrollIntoView(false).click();
    }
}
