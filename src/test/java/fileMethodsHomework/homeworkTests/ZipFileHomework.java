package fileMethodsHomework.homeworkTests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileHomework {
    @Test
    @DisplayName("Тест на проверку pdf, csv, xlsx")
    void zipTestForAll() throws Exception {

        try (ZipFile testZipFile = new ZipFile("src\\test\\resources\\files\\testFilesZip.zip")) {
            Enumeration<? extends ZipEntry> entries = testZipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry testEntry = entries.nextElement();
                String fileExtension = testEntry.getName();
                fileExtension = fileExtension.substring(fileExtension.lastIndexOf(".") + 1);
                InputStream inputStream;
                switch (fileExtension) {
                    case ("pdf"):
                        inputStream = testZipFile.getInputStream(testEntry);
                        PDF pdfParsed = new PDF(inputStream);
                        assertThat(pdfParsed.text).contains("div");
                        break;
                    case ("xlsx"):
                        inputStream = testZipFile.getInputStream(testEntry);
                        XLS parsedFile = new XLS(inputStream);
                        assertThat(parsedFile.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue()).isEqualTo("Abril");
                        break;
                    case ("csv"):
                        inputStream = testZipFile.getInputStream(testEntry);
                        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
                        List<String[]> list = reader.readAll();
                        assertThat(list).hasSize(3).contains(new String[]{"Author", " Book"}, new String[]{"Block", " Apteka"}, new String[]{"Esenin", " Cherniy Chelovek"});
                        break;

                }
            }
        }
    }
}
