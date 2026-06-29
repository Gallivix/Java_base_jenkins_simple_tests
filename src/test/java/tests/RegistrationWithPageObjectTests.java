package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Story("Форма регистрации")
public class RegistrationWithPageObjectTests extends TestBase {


    @Test
    @DisplayName("Полная форма регистрации")
    void successfulRegistrationTest() {


        step("Открываем главную страницу", () ->
            registrationPage.openPage());
        step("Заполнение формы регистрации", () -> {
            registrationPage
                    .setFirstName("Alex")
                    .setLastName("Egorov")
                    .setEmail("alex@egorov.com")
                    .setGender("Other")
                    .setUserNumber("1234567890")
                    .setDateOfBirth("30", "July", "2008")
                    .typeSubjects()
                    .typeSubjectsInput("Math")
                    .typeSubjectsClick()
                    .typeHobbiesCheckBox()
                    .typeCurrentAddress("Some address 1")
                    .state()
                    .typeState()
                    .city()
                    .typeCity()
                    .SubmitForm();
        });
        step("Проверка итоговой формы регистрации", () -> {
            step("Check registration form results component appears", () -> { // or move to pageobject step
                registrationPage
                .checkModalAppears();
            });
            registrationPage.checkResult("Student Name", "Alex Egorov")
                    .checkResult("Student Email", "alex@egorov.com");
        });
    }

    @Test
    @DisplayName("Broken Registration")
    void brokenRegistrationTest() {
        step("Open registration page", () ->
            registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage
                    .setFirstName("Alex")
                    .setLastName("Egorov")
                    .setEmail("alex111@egorov.com")
                    .setGender("Other")
                    .setUserNumber("1234567890");
            $("#submit").click();
        });

        step("Check registration form results data", () -> {
            registrationPage
                    .checkModalAppears()
                    .checkResult("Student Name", "Alex Egorov")
                    .checkResult("Student Email", "alex111@egorov.com");
        });
    }
}