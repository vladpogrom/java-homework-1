package githubRepo.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SerchSelenideRepository {
    @Test
    void shouldFindSelenideRepositoryInGithub(){
        // открыть страницу test.practice.github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // пример поиска через xpath
        $x("");
        // нажимаем на линк от первого результата поиска, после локатора списка надо указать первый элемент (li)
        $$("ul.repo-list li").first().$("a").click();
        // check: в заголовке встречается selenide/selenide, переносы строки в html надо писать просто как пробел
        $("h1").shouldHave(text("selenide / selenide"));
        webdriver().shouldHave(url("saf"));
        // задать время пока браузер остается открыт (5 сек)
        sleep(5000);
    }
}
