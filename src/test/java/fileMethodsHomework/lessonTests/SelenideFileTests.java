package fileMethodsHomework.lessonTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFileTests {
    // Ищет файлы в src main/resources и т.д
    private ClassLoader cl = SelenideFileTests.class.getClassLoader();

    @Test
    @DisplayName("Скачиваем файл и получаем массив байт через инпут стрим, читаем все байты и преобразуем в стринг")
    void DownloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        // Класс файл нужен для работы с путями на ПК и т.д
        File downloadedFile = Selenide.$("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8))
                    .contains("Eclipse Public License - v 2.0");
        }
    }

    @Test
    @DisplayName("Загружаем файл")
    void uploadFile() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        Selenide.$("input[type='file']").uploadFromClasspath("files/txtTest.txt");
        Selenide.$("#file-submit").click();
        Selenide.$("#uploaded-files").shouldHave(Condition.text("txtTest.txt"));
    }
}
