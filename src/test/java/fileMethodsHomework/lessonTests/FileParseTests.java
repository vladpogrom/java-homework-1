package fileMethodsHomework.lessonTests;


import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParseTests {

    private final ClassLoader cl = FileParseTests.class.getClassLoader();

    @Test
    void parsePdfTestDownload() throws Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = Selenide.$(byText("PDF download")).download();
        PDF parsedFile = new PDF(pdfDownload);
        assertThat(parsedFile.author).contains("Marc Philipp");
    }

    @Test
    void parseXlsTest() throws Exception {
        try (InputStream xlsStream = cl.getResourceAsStream("files/xlsxTest.xlsx")) {
            XLS parsedFile = new XLS(xlsStream);
            assertThat(parsedFile.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue())
                    .isEqualTo("Abril");
        }
    }

    @Test
    void parseCsvFile() throws Exception {
        try (InputStream csvStream = cl.getResourceAsStream("files/csvTest.csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(csvStream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(3)
                    .contains(
                            new String[]{"Author", "Book"},
                            new String[]{"Block", "Apteka"},
                            new String[]{"Esenin", "Cherniy Chelovek"}
                    );
        }
    }

    @Test
    void zipTest() throws Exception {
        //sample-zip-file.zip

        try (InputStream stream = cl.getResourceAsStream("files/zipTest.zip");
             ZipInputStream zipStream = new ZipInputStream(stream)) {
            // читает из архива файлы и папки
            ZipEntry zipFile;
            while ((zipFile = zipStream.getNextEntry()) != null) {
                assertThat(zipFile.getName()).isEqualTo("sample.txt");
            }

        }

        ZipFile zf = new ZipFile(new File(cl.getResource("files/sample-zip-file.zip").toURI()));

    }


}