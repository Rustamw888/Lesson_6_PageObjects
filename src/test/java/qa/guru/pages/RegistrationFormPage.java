package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import qa.guru.pages.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage extends Calendar {

    // locators
    SelenideElement registrationFormName = $(".practice-form-wrapper");
    SelenideElement resultFormTitle = $("#example-modal-sizes-title-lg");
    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement email = $("#userEmail");
    SelenideElement gender = $("#genterWrapper");
    SelenideElement phoneNumber = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobby = $("#hobbiesWrapper");
    SelenideElement uploadPicture = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateSelector = $("#state");
    SelenideElement citySelector = $("#city");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    SelenideElement close = $("#closeLargeModal");
    SelenideElement tableForm = $(".table-responsive");
    SelenideElement submit = $("#submit");

    // actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        registrationFormName.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(Long value) {
        phoneNumber.setValue(value.toString());
        return this;
    }

    public RegistrationFormPage setBirthDate(Integer day, Integer month, Integer year) {
        dateOfBirthInput.click();
        setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobby.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setFile(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateSelector.click();
        stateCityWrapper.$(byText(state)).click();
        citySelector.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationFormPage pressSubmitBtn() {
        submit.click();
        return this;
    }

    public RegistrationFormPage resultCheckingForm(String key, String value) {
        resultFormTitle.shouldHave(text("Thanks for submitting the form"));
        tableForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationFormPage pressCloseBtn() {
        close.click();
        return this;
    }
}
