package pageObjectHomework.pages.components;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataComponent {
    // It's okay
    public static String day;
    public static int month;
    public static String year;
    static Random rnd;
    static Date dt;
    static long ms;
    static String pattern;
    static String assertPattern;
    public static String parseDate;
    public static String assertDate;
    public static String[] splitDate;
    public static String userMonthAssert;

    public void dataComponentSet() {
        // Random description
        rnd = new Random();
        ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        dt = new Date(ms);

        // Pattern for type
        pattern = "dd/MM/yyyy";
        Format formatter = new SimpleDateFormat(pattern);
        parseDate = formatter.format(dt);
        day = parseDate.substring(0,2);
        month = Integer.parseInt(parseDate.substring(3,5));
        year = parseDate.substring(6,10);

        // Pattern for assert (month)
        assertPattern = "dd/MMMM/yyyy";
        Format formatterAssert = new SimpleDateFormat(assertPattern);
        assertDate = formatterAssert.format(dt);
        splitDate = assertDate.split("/");
        userMonthAssert = splitDate[1];
    }
}
