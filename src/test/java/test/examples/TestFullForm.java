package test.examples;

import org.junit.jupiter.api.Test;
import pages.FullAllPage;
import test.data.TestBaseFull;

import static test.data.TestData.*;

public class TestFullForm extends TestBaseFull {
    FullAllPage fullAllPage = new FullAllPage();

    //Тест на успешное заполнение формы все поля заполнен
    @Test
    void successFullAll() {
        fullAllPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .closeBanner()
                .typeUserEmail(userEmailForFull)
                .selectGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .typeSubject(subject)
                .selectHobby(hobbiesWrapper)
                .uploadPicture(Picture)
                .typeCurrentAddress(currentAddressForFull)
                .selectState(State)
                .selectCity(city)
                .submitForm();

        // Проверки
        fullAllPage.checkStudentName(firstName, lastName)
                .checkStudentEmail(userEmailForFull)
                .checkGender(gender)
                .checkMobile(userNumber)
                .checkDateOfBirth(dateOfBirth)
                .checkSubjects(subject)
                .checkHobbies(hobbiesWrapper)
                .checkPicture(Picture)
                .checkAddress(currentAddressForFull)
                .checkStateAndCity(State, city);
    }

    // Тест на успешное заполнение только обязательных полей
    @Test
    void successFull() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmailForFull)
                .selectGender(gender)
                .typeUserNumber(userNumber)
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkStudentName(firstName, lastName)
                .checkStudentEmail(userEmailForFull)
                .checkGender(gender)
                .checkMobile(userNumber);
    }

    // Пустые обязательные поля
    @Test
    void requiredFieldsEmpty() {
        fullAllPage.openPage()
                .closeBanner()
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(message);
    }

    // Некорректный номер телефона (9 цифр)
    @Test
    void invalidMobileNumber() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .selectGender(gender)
                .typeUserNumber(invalidUserNumber)
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(message);
    }

    // Не выбран пол (gender)
    @Test
    void genderNotSelected() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmailForFull)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .typeSubject(subject)
                .selectHobby(hobbiesWrapper)
                .typeCurrentAddress(currentAddressForFull)
                .selectState(State)
                .selectCity(city)
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(message);
    }
}