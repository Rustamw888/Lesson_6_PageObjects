package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.pages.RegistrationFormPage;

import java.util.Locale;

import static java.lang.String.format;
import static qa.guru.pages.components.Calendar.fullBirthDate;

public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = format("%s %s", firstName, lastName);
    String email = fakerEn.internet().emailAddress();
    Long phoneNumber = faker.number().numberBetween(1000000000L, 9999999999L);
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
    String fullAddress = format("%s %s", state, city);

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";
    }

    @Test
    public void fieldFormTestHomeWork() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Other")
                .setPhoneNumber(phoneNumber)
                .setBirthDate(
                        faker.number().numberBetween(1, 28),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1900, 2022))
                .setSubjects("Maths")
                .setHobby("Sports")
                .setFile("pictures/1.png")
                .setAddress(address)
                .setStateAndCity(state, city)
                .pressSubmitBtn()
                .resultCheckingForm("Student Name", fullName)
                .resultCheckingForm("Student Email", email)
                .resultCheckingForm("Gender", "Other")
                .resultCheckingForm("Mobile", phoneNumber.toString())
                .resultCheckingForm("Date of Birth", fullBirthDate)
                .resultCheckingForm("Subjects", "Maths")
                .resultCheckingForm("Hobbies", "Sports")
                .resultCheckingForm("Picture", "1.png")
                .resultCheckingForm("Address", address)
                .resultCheckingForm("State and City", fullAddress)
                .pressCloseBtn();
    }
}
