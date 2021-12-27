package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubAssertionsTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void softAssertions() {
        // открыть страницу github.com/selenide/selenide
        open("/selenide/selenide");

        // перейти в раздел wiki
        $("#wiki-tab").click();

        //убедитесь, что в списке страниц есть страница SoftAssertions
        $(".markdown-body").$("[href='/selenide/selenide/wiki/SoftAssertions']").shouldBe(Condition.visible);

        // откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").$("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}
