package utility;

import com.github.javafaker.Faker;

import java.time.ZoneId;

public class DataFaker {

    private final Faker faker;

    public DataFaker() {
        faker = new Faker();
    }

    public String getLogin() {
        return faker.name().username();
    }

    public String getPassword() {
        return faker.internet().password();
    }

    public String getShortPassword() {
        return faker.internet().password(1, 6);
    }

    public String getName() {
        return faker.name().firstName();
    }

    public String getSurname() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public int getDayOfBirth() {
        return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth();
    }

    public int getMonthOfBirth() {
        return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
    }

    public int getYearOfBirth() {
        return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
    }

    public String getPhoneNumber() {

        return String.valueOf(faker.numerify("### ### ###"));
    }

}
