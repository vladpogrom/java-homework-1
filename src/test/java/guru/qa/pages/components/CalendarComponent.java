package guru.qa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    public void setDate(String date, String month, String year) {
        $("#dateOfBirthInput").click();
        $("[class*='year-select']").selectOptionByValue(String.valueOf(year));
        $("[class*='month-select']").selectOptionByValue(String.valueOf(month));
        $$("[role=option]").findBy(text(String.valueOf(date))).click();
    }


}

