package test.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FullAllPage;
import test.data.TestBaseFull;
import test.data.TestData;

public class TestFullForm extends TestBaseFull {
    FullAllPage fullAllPage = new FullAllPage();
    TestData testData;

    @BeforeEach
    void setUp() {
        testData = new TestData();
    }

    //Тест на успешное заполнение формы все поля заполнены
    @Test
    void successFullAll() {
        fullAllPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .closeBanner()
                .typeUserEmail(testData.userEmailForFull)
                .selectGender(testData.gender)
                .typeUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .typeSubject(testData.subject)
                .selectHobby(testData.hobbiesWrapper)
                .uploadPicture(testData.Picture)
                .typeCurrentAddress(testData.currentAddressForFull)
                .selectState(testData.State)
                .selectCity(testData.city)
                .submitForm();

        // Проверки
        fullAllPage.checkStudentName(testData.firstName, testData.lastName)
                .checkStudentEmail(testData.userEmailForFull)
                .checkGender(testData.gender)
                .checkMobile(testData.userNumber)
                .checkDateOfBirth(testData.dateOfBirth)
                .checkSubjects(testData.subject)
                .checkHobbies(testData.hobbiesWrapper)
                .checkPicture(testData.Picture)
                .checkAddress(testData.currentAddressForFull)
                .checkStateAndCity(testData.State, testData.city);
    }

    // Тест на успешное заполнение только обязательных полей
    @Test
    void successFull() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmailForFull)
                .selectGender(testData.gender)
                .typeUserNumber(testData.userNumber)
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkStudentName(testData.firstName, testData.lastName)
                .checkStudentEmail(testData.userEmailForFull)
                .checkGender(testData.gender)
                .checkMobile(testData.userNumber);
    }

    // Пустые обязательные поля
    @Test
    void requiredFieldsEmpty() {
        fullAllPage.openPage()
                .closeBanner()
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(testData.message);
    }

    // Некорректный номер телефона (9 цифр)
    @Test
    void invalidMobileNumber() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .selectGender(testData.gender)
                .typeUserNumber(testData.invalidUserNumber)
                .scrollToSubmit()
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(testData.message);
    }

    // Не выбран пол (gender)
    @Test
    void genderNotSelected() {
        fullAllPage.openPage()
                .closeBanner()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmailForFull)
                .typeUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .typeSubject(testData.subject)
                .selectHobby(testData.hobbiesWrapper)
                .typeCurrentAddress(testData.currentAddressForFull)
                .selectState(testData.State)
                .selectCity(testData.city)
                .submitForm();

        fullAllPage.checkResultModalNotVisible()
                .checkFormError(testData.message);
    }
}