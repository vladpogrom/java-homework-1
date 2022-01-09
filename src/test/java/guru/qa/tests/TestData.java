package guru.qa.tests;

import com.github.javafaker.Faker;

import static guru.qa.utils.RandomUtils.*;

public class TestData {
    static Faker faker = new Faker();
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = getRandomEmail();
    static String userNumber = faker.phoneNumber().phoneNumber();
    public static String userAdress = faker.address().fullAddress();
    public static String userDateMonth = String.valueOf(faker.date().birthday().getMonth()); // todo fix month in check form
    public static String userDateDay = String.valueOf(faker.date().birthday().getDay());
    public static String userDateYear = "19" + (faker.date().birthday().getYear());
    static String userPicture = "img/test_file.png";
    public static String submitFormText = "Thanks for submitting the form";
}