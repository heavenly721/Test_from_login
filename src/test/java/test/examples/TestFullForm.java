package test.examples;

import org.junit.jupiter.api.Test;
import test.data.TestBaseFull;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.data.TestData.*;

public class TestFullForm extends TestBaseFull {

    //Тест на успешное заполнение формы все поля заполнен
    @Test
    void successFullAll() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val(firstName);
        $("[id=lastName]").val(lastName);
        $("[id=userEmail]").val(userEmailForFull);
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val(userNumber);
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(monthOfBirth);
        $("[class=react-datepicker__year-select]").selectOption(yearOfBirth);
        $("[class*='react-datepicker__day'][data-day='" + dayOfBirth + "']").click();
        $("[id=subjectsInput]").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbiesWrapper)).click();
        $("[id=uploadPicture]").uploadFromClasspath(Picture);
        $("[id=currentAddress]").setValue(currentAddressForFull);
        $("[id=state]").scrollTo().click();
        $(byText(State)).click();
        $("[id=city]").click();
        $(byText(city)).click();
        $("[id=submit]").click();

        //Проверка заполнения
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmailForFull));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbiesWrapper));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(Picture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddressForFull));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(State + " " + city));
    }

    //Тест на успешное заполнение формы только с обязательными полями
    @Test
    void successFull() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val(firstName);
        $("[id=lastName]").val(lastName);
        $("[id=userEmail]").val(userEmailForFull);
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val(userNumber);
        $("[id=submit]").scrollTo().click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmailForFull));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
    }

    //Пустые обязательные поля
    @Test
    void requiredFieldsEmpty() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#submit").scrollTo().click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    //Некорректный номер телефона (9 цифр)
    @Test
    void invalidMobileNumber() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").val(invalidUserNumber); // Нужно добавить переменную для некорректного номера
        $("#submit").scrollTo().click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    //Не выбран пол (gender)
    @Test
    void genderNotSelected() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmailForFull);
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day[data-day='" + dayOfBirth + "']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#currentAddress").val(currentAddressForFull);
        $("#state").scrollTo().click();
        $(byText(State)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text(message));
    }
}
