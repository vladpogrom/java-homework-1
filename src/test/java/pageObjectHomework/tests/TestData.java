package pageObjectHomework.tests;

import com.github.javafaker.Faker;

import static pageObjectHomework.utils.RandomUtils.getRandomEmail;
import static pageObjectHomework.utils.RandomUtils.getRandomPhone;

public class TestData {
    static Faker faker = new Faker();
    public int genderType = faker.number().numberBetween(0,2);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = getRandomEmail();
    String userNumber = getRandomPhone(String.valueOf(79));
    String userAdress = faker.address().fullAddress();
    String userCity = "Karnal";
    String userState = "Haryana";
    String userPicture = "img/test_file.png";
    int userDateDay = faker.number().numberBetween(1, 31);
    int userDateMonth = faker.number().numberBetween(0, 11);
    int userDateYear = faker.number().numberBetween(1920, 2022);
    public String submitFormText = "Thanks for submitting the form";
    public String[] genders = {"Male", "Female", "Other"},
            subjects = {"Chemistry", "Arts", "English", "Commerce"},
            hobbies = {"Sports", "Reading", "Music"};
}