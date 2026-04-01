package test.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFullForm {

    @BeforeAll
    static void beforeALL(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://qa-guru.github.io";
    }

    @Test //Тест на успешное заполнение формы все поля заполнены
    void successFullAll() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val("Mikhail");
        $("[id=lastName]").val("Mar");
        $("[id=userEmail]").val("heaven21@gmail.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val("9154322223");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("November");
        $("[class=react-datepicker__year-select]").selectOption("1999");
        $("[class*='react-datepicker__day'][data-day='11']").click();
        $("[id=subjectsInput]").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFromClasspath("test1.txt");
        $("[id=currentAddress]").setValue("Vladivostok");
        $("[id=state]").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("[id=city]").click();
        $(byText("Lucknow")).click();
        $("[id=submit]").click();

        //Проверка заполнения
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mikhail Mar"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("heaven21@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9154322223"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("1999-11-11"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test1.txt"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Vladivostok"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Lucknow"));

    }

    @Test //Тест на успешное заполнение формы только с обязательными полями
    void successFull() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val("Mikhail");
        $("[id=lastName]").val("Mar");
        $("[id=userEmail]").val("heaven21@gmail.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val("9154322223");
        $("[id=submit]").scrollTo().click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mikhail Mar"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("heaven21@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9154322223"));
    }

    @Test //Пустые обязательные поля
    void requiredFieldsEmpty() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#submit").scrollTo().click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test //Некорректный номер телефона (9 цифр)
    void invalidMobileNumber() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").val("Mikhail");
        $("#lastName").val("Mar");
        $("#gender-radio-1").click();
        $("#userNumber").val("123456789");
        $("#submit").scrollTo().click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test //Не выбран пол (gender)
    void genderNotSelected() {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").val("Mikhail");
        $("#lastName").val("Mar");
        $("#userEmail").val("heaven21@gmail.com");
        $("#userNumber").val("9154322223");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day[data-day='11']").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbies-checkbox-2").click();
        $("#currentAddress").setValue("Vladivostok");
        $("#state").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }
}
