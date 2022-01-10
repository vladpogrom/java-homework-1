package test.practice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("Alex@gmail.com");
        $("#currentAddress").setValue("Adress Alex");
        $("#permanentAddress").setValue("Alex Permanentr");
        $("#submit").scrollTo().click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("Alex@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Adress Alex"));
        $("#output").$("#permanentAddress").shouldHave(text("Alex Permanentr"));
    }
}
