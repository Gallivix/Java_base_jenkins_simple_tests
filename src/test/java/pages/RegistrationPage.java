package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement outputResults = $(".table-responsive"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            modalDialog = $("div.modal-dialog"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            subjectsInput = $("#subjectsInput"),

            subjectsClick =  $("#react-select-2-option-0"),
            hobbiesCheckBox = $("#hobbies-checkbox-1"),
            currentAddressInput =  $("#currentAddress"),
            state =  $("#state"),
            stateInput = $("#react-select-3-option-1"),
            city =  $("#city"),
            cityInput= $("#react-select-4-option-1"),
            submitButton = $("#submit");

            CalendarComponent calendarComponent = new CalendarComponent(); // todo move to BasePage

    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Type email \"{value}\"")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Type gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Type UserNumber \"{value}\"")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Type DateOfBirth \"{value}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeSubjects() {
        subjects.click();
        return this;
    }

    public RegistrationPage typeSubjectsInput(String value) {
        subjectsInput.setValue(value);

        return this;
    }

    public RegistrationPage typeSubjectsClick() {
        subjectsClick.click();
        return this;
    }

    public RegistrationPage typeHobbiesCheckBox() {
        hobbiesCheckBox.click();
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage state() {
        state.click();
        return this;
    }

    public RegistrationPage typeState() {
        stateInput.click();
        return this;
    }

    public RegistrationPage city() {
        city.click();
        return this;
    }
    public RegistrationPage typeCity() {
        cityInput.click();
        return this;
    }

    public RegistrationPage SubmitForm() {
        submitButton.click();
        return this;
    }
    @Step("Check that field \"{key}\" has result \"{value}\"")
    public RegistrationPage checkResult(String key, String value) {
        outputResults.shouldHave(text(key), text(value));
        return this;
    }



    public RegistrationPage checkModalAppears() {
        modalDialog.should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}