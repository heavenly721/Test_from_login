package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ErrorComponent;
import pages.components.ResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OneFormPage {

    // Components
    private CalendarComponent calendar = new CalendarComponent();
    private ResultsComponent resultsTable = new ResultsComponent();
    private ErrorComponent error = new ErrorComponent();

    // Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#state");
    private SelenideElement cityInput = $("#city");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement closeButton = $("[aria-label='Close']");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement getGenderRadio(String gender) {
        int genderNumber = gender.equalsIgnoreCase("male") ? 1 :
                gender.equalsIgnoreCase("female") ? 2 : 3;
        return $(String.format("#gender-radio-%d", genderNumber));
    }

    // Actions
    public OneFormPage openPage() {
        open("/one-page-form/automation-practice-form.html");
        return this;
    }

    public OneFormPage closeBanner() {
        closeButton.click();
        return this;
    }

    public OneFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public OneFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public OneFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public OneFormPage selectGender(String gender) {
        getGenderRadio(gender).click();
        return this;
    }

    public OneFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public OneFormPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public OneFormPage typeSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public OneFormPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();  // Используем поле класса
        return this;
    }

    public OneFormPage uploadPicture(String picturePath) {
        uploadPicture.uploadFromClasspath(picturePath);
        return this;
    }

    public OneFormPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public OneFormPage selectState(String state) {
        stateInput.scrollTo().click();
        $(byText(state)).click();
        return this;
    }

    public OneFormPage selectCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public OneFormPage scrollToSubmit() {
        submitButton.scrollTo();
        return this;
    }

    public OneFormPage submitForm() {
        submitButton.click();
        return this;
    }

    // Проверки через ResultsComponent
    public OneFormPage checkStudentName(String firstName, String lastName) {
        resultsTable.checkStudentName(firstName, lastName);
        return this;
    }

    public OneFormPage checkStudentEmail(String email) {
        resultsTable.checkStudentEmail(email);
        return this;
    }

    public OneFormPage checkGender(String gender) {
        resultsTable.checkGender(gender);
        return this;
    }

    public OneFormPage checkMobile(String mobile) {
        resultsTable.checkMobile(mobile);
        return this;
    }

    public OneFormPage checkDateOfBirth(String dateOfBirth) {
        resultsTable.checkDateOfBirth(dateOfBirth);
        return this;
    }

    public OneFormPage checkSubjects(String subject) {
        resultsTable.checkSubjects(subject);
        return this;
    }

    public OneFormPage checkHobbies(String hobby) {
        resultsTable.checkHobbies(hobby);
        return this;
    }

    public OneFormPage checkPicture(String pictureName) {
        resultsTable.checkPicture(pictureName);
        return this;
    }

    public OneFormPage checkAddress(String address) {
        resultsTable.checkAddress(address);
        return this;
    }

    public OneFormPage checkStateAndCity(String state, String city) {
        resultsTable.checkStateAndCity(state, city);
        return this;
    }

    public OneFormPage checkResultModalNotVisible() {
        error.checkResultModalNotVisible();
        return this;
    }

    public OneFormPage checkFormError(String expectedMessage) {
        error.checkFormError(expectedMessage);
        return this;
    }
}