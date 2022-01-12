package test.practice;

import org.junit.jupiter.api.Test;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class TestTestTest {
    public static int day;
    public static int month;
    public static int year;
    static Random rnd;
    static Date dt;
    static long ms;
    static String pattern;
    static String parseDate;
    public static String assertDate;
    public String monthAssert;
    static String assertPattern;

    @Test
    void testTests() {
//        // Random description
//        rnd = new Random();
//        ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
//        dt = new Date(ms);
//
//        // Pattern for type
//        pattern = "dd/MM/yyyy";
//        Format formatter = new SimpleDateFormat(pattern);
//        parseDate = formatter.format(dt);
//        day = Integer.parseInt(parseDate.substring(0,2));
//        month = Integer.parseInt(parseDate.substring(3,5));
//        year = Integer.parseInt(parseDate.substring(6,10));
//
//        // Pattern for assert (month)
//        assertPattern = "dd/MMMM/yyyy";
//        Format formatterAssert = new SimpleDateFormat(assertPattern);
//        assertDate = formatterAssert.format(dt);
//        String[] splitDate = assertDate.split("/");
//        String test = splitDate[1];
//
//        System.out.println(day);
//        System.out.println(month);
//        System.out.println(year);
//        System.out.println();
    }
}
