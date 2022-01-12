package pageObjectHomework.tests;

import com.github.javafaker.Faker;
import pageObjectHomework.pages.components.DataComponent;
import static pageObjectHomework.utils.RandomUtils.getRandomEmail;
import static pageObjectHomework.utils.RandomUtils.getRandomPhone;

public class TestData {
    static Faker faker = new Faker();
    public String genderType = "Male";
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = getRandomEmail();
    public String userNumber = getRandomPhone(String.valueOf(79));
    public String userAdress = faker.address().fullAddress();
    public String userCity = "Karnal";
    public String userState = "Haryana";
    public String userPicture = "img/test_file.png";
    public String openPageTextAssert = "Student Registration Form";
    public int userDateDay = DataComponent.day;
    public int userDateMonth = DataComponent.month;
    public String userDateYear = DataComponent.year;
    public String userDateMonthAssert = DataComponent.userMonthAssert;
    public String submitFormText = "Thanks for submitting the form";
    public String[] genders = {"Male", "Female", "Other"},
            subjects = {"Chemistry", "Arts", "English", "Commerce"},
            hobbies = {"Sports", "Reading", "Music"};
}