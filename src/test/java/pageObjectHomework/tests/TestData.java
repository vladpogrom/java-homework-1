package pageObjectHomework.tests;

import com.github.javafaker.Faker;

import static pageObjectHomework.tests.TestBase.dataComponent;
import static pageObjectHomework.utils.RandomUtils.getRandomEmail;
import static pageObjectHomework.utils.RandomUtils.getRandomPhone;

public class TestData {
    static Faker faker = new Faker();
    public String genderType = "Male";
    // сделал их static т.к почему то меняются значения во время выполнения тестов
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = getRandomEmail();
    public static String userNumber = getRandomPhone(String.valueOf(79));
    public static String userAdress = faker.address().fullAddress();
    public String userCity = "Karnal";
    public String userState = "Haryana";
    public String userPicture = "img/test_file.png";
    public String openPageTextAssert = "Student Registration Form";
    public int userDateDay = dataComponent.day;
    public int userDateMonth = dataComponent.month;
    public String userDateYear = dataComponent.year;
    public String userDateMonthAssert = dataComponent.userMonthAssert;
    public String submitFormText = "Thanks for submitting the form";
    public String[] genders = {"Male", "Female", "Other"},
            subjects = {"Chemistry", "Arts", "English", "Commerce"},
            hobbies = {"Sports", "Reading", "Music"};
}