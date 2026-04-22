package test.data;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    //For = TestdemoQa
    public String userName = fakerRu.name().fullName();
    public String userEmail = RandomUtils.getRandomEmail();
    public String currentAddress = fakerRu.address().fullAddress();
    public String permanentAddress = fakerRu.address().fullAddress();

    //For = TestFullForm
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmailForFull = RandomUtils.getRandomEmail();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String monthOfBirth = RandomUtils.getRandomMonth();
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2024));
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    public String subject = faker.options().option("Physics", "Chemistry", "Biology", "Maths", "Computer Science");
    public String hobbiesWrapper = faker.options().option("Sports", "Reading", "Music");
    public String Picture = "test1.txt";
    public String currentAddressForFull = fakerRu.address().fullAddress();
    public String State = faker.options().option("Uttar Pradesh", "Rajasthan", "Haryana", "NCR", "Delhi");
    public String city = switch (State) {
        case "Uttar Pradesh" -> faker.options().option("Lucknow", "Agra", "Merrut");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "NCR" -> faker.options().option("Delhi", "Noida", "Gurgaon");
        default -> "Lucknow";};
    public String gender = RandomUtils.getRandomGender();
    public String dateOfBirth = String.format("%s-%s-%s", yearOfBirth,
            RandomUtils.getMonthNumber(monthOfBirth), dayOfBirth);
    public String invalidUserNumber = faker.phoneNumber().subscriberNumber(9);
    public String message = "Please fill required fields and enter a valid 10-digit mobile number.";
}
