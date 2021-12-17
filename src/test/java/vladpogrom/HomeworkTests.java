package vladpogrom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTests {

    @BeforeEach
    void openForm(){
        clearBrowserCookies();
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillForm() {
        //Fill easy lines
        $("#firstName").setValue("Big");
        $("#lastName").setValue("Lebovski");
        $("#userEmail").setValue("Lebovski@gmail.com");
        $("[for=gender-radio-3]").click(); // or $("gender-radio-3").parent().click;
        $("#userNumber").setValue("9887987687");
        $("#uploadPicture").uploadFromClasspath("test_file.png");
        $("#currentAddress").setValue("Adress Big");
        $("#react-select-3-input").setValue("Har").pressEnter();
        $("#react-select-4-input").setValue("Kar").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter().setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        //Fill date
        $("#dateOfBirthInput").click();
        $("[class*='year-select']").selectOptionByValue("1996");
        $("[class*='month-select']").selectOptionByValue("3");
        $("[class*='21']").click(); // ставим кавычки если локатор имеет пробелы

        // Click to submit
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
        $(byText("21 April,1996")).should(appear);
        $(byText("Sports, Reading, Music")).should(appear);
        $(byText("test_file.png")).should(appear);
        $(byText("Adress Big")).should(appear);
        $(byText("Haryana Karnal")).should(appear);

        //Close form
        $("#closeLargeModal").scrollIntoView(false).click();
    }
}
