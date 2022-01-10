package pageObjectHomework.tests;

import com.github.javafaker.Faker;
import pageObjectHomework.pages.components.DataComponent;
import static pageObjectHomework.utils.RandomUtils.getRandomEmail;
import static pageObjectHomework.utils.RandomUtils.getRandomPhone;

public class TestData {
    static Faker faker = new Faker();
    String genderType = "Male";
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = getRandomEmail();
    String userNumber = getRandomPhone(String.valueOf(79));
    String userAdress = faker.address().fullAddress();
    String userCity = "Karnal";
    String userState = "Haryana";
    String userPicture = "img/test_file.png";
    String userDateDay = DataComponent.day;
    int userDateMonth = DataComponent.month;
    String userDateYear = DataComponent.year;
    String userDateMonthAssert = DataComponent.userMonthAssert;
    public String submitFormText = "Thanks for submitting the form";
    public String[] genders = {"Male", "Female", "Other"},
            subjects = {"Chemistry", "Arts", "English", "Commerce"},
            hobbies = {"Sports", "Reading", "Music"};
}