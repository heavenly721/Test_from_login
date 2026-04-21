package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ErrorComponent;
import pages.components.ResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FullAllPage {

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
    public FullAllPage openPage() {
        open("/one-page-form/automation-practice-form.html");
        return this;
    }

    public FullAllPage closeBanner() {
        closeButton.click();
        return this;
    }

    public FullAllPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FullAllPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FullAllPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FullAllPage selectGender(String gender) {
        getGenderRadio(gender).click();
        return this;
    }

    public FullAllPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public FullAllPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public FullAllPage typeSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public FullAllPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();  // Используем поле класса
        return this;
    }

    public FullAllPage uploadPicture(String picturePath) {
        uploadPicture.uploadFromClasspath(picturePath);
        return this;
    }

    public FullAllPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public FullAllPage selectState(String state) {
        stateInput.scrollTo().click();
        $(byText(state)).click();
        return this;
    }

    public FullAllPage selectCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public FullAllPage scrollToSubmit() {
        submitButton.scrollTo();
        return this;
    }

    public FullAllPage submitForm() {
        submitButton.click();
        return this;
    }

    // Проверки через ResultsComponent
    public FullAllPage checkStudentName(String firstName, String lastName) {
        resultsTable.checkStudentName(firstName, lastName);
        return this;
    }

    public FullAllPage checkStudentEmail(String email) {
        resultsTable.checkStudentEmail(email);
        return this;
    }

    public FullAllPage checkGender(String gender) {
        resultsTable.checkGender(gender);
        return this;
    }

    public FullAllPage checkMobile(String mobile) {
        resultsTable.checkMobile(mobile);
        return this;
    }

    public FullAllPage checkDateOfBirth(String dateOfBirth) {
        resultsTable.checkDateOfBirth(dateOfBirth);
        return this;
    }

    public FullAllPage checkSubjects(String subject) {
        resultsTable.checkSubjects(subject);
        return this;
    }

    public FullAllPage checkHobbies(String hobby) {
        resultsTable.checkHobbies(hobby);
        return this;
    }

    public FullAllPage checkPicture(String pictureName) {
        resultsTable.checkPicture(pictureName);
        return this;
    }

    public FullAllPage checkAddress(String address) {
        resultsTable.checkAddress(address);
        return this;
    }

    public FullAllPage checkStateAndCity(String state, String city) {
        resultsTable.checkStateAndCity(state, city);
        return this;
    }

    public FullAllPage checkResultModalNotVisible() {
        error.checkResultModalNotVisible();
        return this;
    }

    public FullAllPage checkFormError(String expectedMessage) {
        error.checkFormError(expectedMessage);
        return this;
    }
}