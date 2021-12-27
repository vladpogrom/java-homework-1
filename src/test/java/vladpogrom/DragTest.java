package vladpogrom;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragTest {

    @Test
    void dragDrop() {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Пример реализации если бы dragAndDrop не работал
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-a"));

        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }



}
