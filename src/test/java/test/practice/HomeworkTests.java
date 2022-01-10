package test.practice;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTests {

    @BeforeEach
    void openForm() {
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
        $("#gender-radio-3").parent().click(); // кликаем по элементу родителя, интересно
        $("#userNumber").setValue("9887987687");
        $("#uploadPicture").uploadFromClasspath("img/test_file.png"); // самый правильный метод для загрузки файлов
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
        $$("[role=option]").findBy(text("21")).click();

        // Click to submit
        $("#submit").scrollTo().click();

        //Check visible of form
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Asserts
        $("[class=table-responsive]").shouldHave(
                text("Big Lebovski"),
                text("Lebovski@gmail.com"),
                text("Other"),
                text("9887987687"),
                text("21 April,1996"),
                text("Sports, Reading, Music"),
                text("test_file.png"),
                text("Adress Big"),
                text("Haryana Karnal"));

        //Close form
        $("#closeLargeModal").scrollIntoView(false).click();
    }
}
