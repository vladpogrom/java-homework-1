package parametriseTestHomework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;

@Owner("vladpogrom")
@DisplayName("Тесты на авито")
public class ParametriseTest {

    public static String URL = "https://www.avito.ru/";

    static Stream<Arguments> avitoStreamTestProvider() {
        return Stream.of(
                Arguments.of("Екатеринбург", "Екатеринбург"),
                Arguments.of("Москва", "Москва"),
                Arguments.of("Челябинск", "Челябинская область")
        );
    }

    @ValueSource(strings = {"Екатеринбург", "Москва", "Челябинск"})
    @ParameterizedTest(name = "ValueSource тесты на смену города: {0}")
    void avitoTestChangeCity(String testData) {
        Selenide.open(URL);
        Selenide.$("[data-marker='search-form/region']").click();
        Selenide.$("[data-marker='popup-location/region/input']").setValue(testData);
        Selenide.$("[data-marker='suggest-list']").$(byText(testData)).click();
        Selenide.$("[data-marker='popup-location/save-button']").click();
        Selenide.$("[data-marker='search-form/region']")
                .shouldHave(Condition.text(testData));
    }

    @CsvSource(value = {
            "Екатеринбург, Екатеринбург",
            "Москва, Москва",
            "Челябинск, Челябинская область"})
    @ParameterizedTest(name = "CsvSource есты на смену города: {0}")
    void avitoTestChangeCityWithCsv(String testData, String testResult) {
        Selenide.open(URL);
        Selenide.$("[data-marker='search-form/region']").click();
        Selenide.$("[data-marker='popup-location/region/input']").setValue(testData);
        Selenide.$("[data-marker='suggest-list']").$(byText(testData)).click();
        Selenide.$("[data-marker='popup-location/save-button']").click();
        Selenide.$("[data-marker='search-form/region']")
                .shouldHave(Condition.text(testResult));
    }

    @ParameterizedTest(name = "MethodSource тесты на смену города: {0}")
    @MethodSource("avitoStreamTestProvider")
    void avitoTestChangeCityWithMethodSource(String testData, String testResult) {
        Selenide.open(URL);
        Selenide.$("[data-marker='search-form/region']").click();
        Selenide.$("[data-marker='popup-location/region/input']").setValue(testData);
        Selenide.$("[data-marker='suggest-list']").$(byText(testData)).click();
        Selenide.$("[data-marker='popup-location/save-button']").click();
        Selenide.$("[data-marker='search-form/region']")
                .shouldHave(Condition.text(testResult));
    }

    @Disabled
    @ValueSource(strings = {"Екатеринбург", "Москва", "Челябинск"})
    @ParameterizedTest
    @DisplayName("Тесты на смену города на странице")
    void avitoTest() {
        Selenide.open(URL);
        Selenide.$("[data-marker='search-form/region']").click();
        Selenide.$("[data-marker='popup-location/region/input']").setValue("Москва");
        Selenide.$("[data-marker='suggest-list']").$(byText("Москва")).click();
        Selenide.$("[data-marker='popup-location/save-button']").click();
        Selenide.$("[data-marker='search-form/region']")
                .shouldHave(Condition.text("Москва"));
    }
}
