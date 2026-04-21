package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsComponent {

    private SelenideElement tableResults = $(".table-responsive");

    public ResultsComponent checkStudentName(String firstName, String lastName) {
        tableResults.$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        return this;
    }

    public ResultsComponent checkStudentEmail(String email) {
        tableResults.$(byText("Student Email")).parent().shouldHave(text(email));
        return this;
    }

    public ResultsComponent checkGender(String gender) {
        tableResults.$(byText("Gender")).parent().shouldHave(text(gender));
        return this;
    }

    public ResultsComponent checkMobile(String mobile) {
        tableResults.$(byText("Mobile")).parent().shouldHave(text(mobile));
        return this;
    }

    public ResultsComponent checkDateOfBirth(String dateOfBirth) {
        tableResults.$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        return this;
    }

    public ResultsComponent checkSubjects(String subject) {
        tableResults.$(byText("Subjects")).parent().shouldHave(text(subject));
        return this;
    }

    public ResultsComponent checkHobbies(String hobby) {
        tableResults.$(byText("Hobbies")).parent().shouldHave(text(hobby));
        return this;
    }

    public ResultsComponent checkPicture(String pictureName) {
        tableResults.$(byText("Picture")).parent().shouldHave(text(pictureName));
        return this;
    }

    public ResultsComponent checkAddress(String address) {
        tableResults.$(byText("Address")).parent().shouldHave(text(address));
        return this;
    }

    public ResultsComponent checkStateAndCity(String state, String city) {
        tableResults.$(byText("State and City")).parent().shouldHave(text(state + " " + city));
        return this;
    }

    // Универсальный метод для проверки любого поля
    public ResultsComponent checkField(String fieldName, String expectedValue) {
        tableResults.$(byText(fieldName)).parent().shouldHave(text(expectedValue));
        return this;
    }
}
