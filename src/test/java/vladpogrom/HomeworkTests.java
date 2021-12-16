package vladpogrom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.impl.DownloadFileWithHttpRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Big");
        $("#lastName").setValue("Lebovski");
        $("#userEmail").setValue("Lebovski@gmail.com");
        $("[for=\"gender-radio-3\"]").click();
        $("#userNumber").setValue("9887987687");
//        $("#dateOfBirthInput");
        $("[for=\"hobbies-checkbox-1\"]").click();
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("[for=\"hobbies-checkbox-3\"]").click();
        $("#uploadPicture").uploadFromClasspath("test_file.png");
        $("#currentAddress").setValue("Adress Big");
        $("#state").scrollTo().click();
        $(By.xpath("//div[contains(text(),'Haryana')]")).click();
        $("#city").scrollTo().click();
        $(By.xpath("//div[contains(text(),'Karnal')]")).click();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));
        $(By.xpath("//td[contains(text(),'Big Lebovski')]")).shouldHave(text("Big Lebovski"));
        $(By.xpath("//td[contains(text(),'Lebovski@gmail.com')]")).shouldHave(text("Lebovski@gmail.com"));
        $(By.xpath("//td[contains(text(),'Other')]")).shouldHave(text("Other"));
        $(By.xpath("//td[contains(text(),'9887987687')]")).shouldHave(text("9887987687"));
        //        $("#dateOfBirthInput");
        $(By.xpath("//td[contains(text(),'Sports, Reading, Music')]")).shouldHave(text("Sports, Reading, Music"));
        $(By.xpath("//td[contains(text(),'test_file.png')]")).shouldHave(text("test_file.png"));
        $(By.xpath("//td[contains(text(),'Adress Big')]")).shouldHave(text("Adress Big"));
        $(By.xpath("//td[contains(text(),'Haryana Karnal')]")).shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").scrollIntoView(false).click();

    }
}
