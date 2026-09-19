package utils;

import net.datafaker.Faker;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomZipCode() {
        return faker.address().zipCode();
    }
}
