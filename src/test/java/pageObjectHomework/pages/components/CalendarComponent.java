package pageObjectHomework.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.text.DateFormatSymbols;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    static SelenideElement dateInputLocator = $("#dateOfBirthInput");
    static SelenideElement yearSelectLocator = $("[class*='year-select']");
    static SelenideElement monthSelectLocator = $("[class*='month-select']");
    static ElementsCollection daySelectLocator = $$("[role=option]");

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }

    public void setDate(int day, int month, int year) {
        dateInputLocator.click();
        yearSelectLocator.selectOptionByValue(String.valueOf(year));
        monthSelectLocator.selectOptionByValue(String.valueOf(month));
        daySelectLocator.findBy(text(String.valueOf(day))).click();
    }
}

