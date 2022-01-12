package githubRepo.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstPopupTest {

    @Test
    void firstContrubuterShouldBeAndreiSolntsev(){
        // открыть страничку репозитория Селенида
        open("https://github.com/selenide/selenide");

        // подвести мышку к первому элементу в области Contributors, ищет ближайший div к элементу / hover наводит мышь
        $(".Layout-sidebar").$(byText("Contributors")).closest("div")
                        .$$("ul li").first().hover();

        // тоже самое только проще
        $$(".Layout-sidebar .BorderGrid-row").find(text("Contributors"))
                .$$("ul li").first().hover();

        // check: в появившемся окошке (оверлей) текст Andrei Solntsev
        $$(".Popover-message").find(visible).shouldHave(text("Andrei Solntsev"));

    }
}