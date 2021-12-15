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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkTests {

//    @BeforeAll
//    static void beforeAll() {
//       Configuration.browserSize = "1920x1080";}

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

//        $("#userName").setValue("Alex");
//        $("#userEmail").setValue("Alex@gmail.com");
//        $("#currentAddress").setValue("Adress Alex");
//        $("#permanentAddress").setValue("Alex Permanentr");
//        $("#submit").scrollTo().click();
//
//        $("#output").shouldBe(visible);
//        $("#name").shouldHave(text("Alex"));
//        $("#email").shouldHave(text("Alex@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Adress Alex"));
//        $("#output").$("#permanentAddress").shouldHave(text("Alex Permanentr"));


        $("#firstName").setValue("Big");
        $("#lastName").setValue("Lebovski");
        $("#userEmail").setValue("Lebovski@gmail.com");
        $("[for=\"gender-radio-3\"]").click();
        $("#userNumber").setValue("9887987687");
//        #datebirth
        $("[for=\"hobbies-checkbox-1\"]").click();
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("[for=\"hobbies-checkbox-3\"]").click();
//        #picture
//        new File("test_file.png")
//        new DownloadFileWithHttpRequest("https://yt3.ggpht.com/a/AATXAJzizDQ--4hzM0TYKt_HBizzKgSeO3VrabeSVQ=s900-c-k-c0xffffffff-no-rj-mo");
        $("#uploadPicture").uploadFile(new File("test_file.png"));
        $("#currentAddress").setValue("Adress Big");
//        #state
//        #city
        $("#submit").scrollTo().click();


    }
}
