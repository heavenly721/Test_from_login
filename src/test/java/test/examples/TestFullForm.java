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
    }

    @Test //Тест на успешное заполнение формы все поля заполнены
    void successFullAll() {
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
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
        $("[id=hobbies-checkbox-2]").click();
        $("[id=uploadPicture]").uploadFromClasspath("test1.txt");
        $("[id=currentAddress]").setValue("Vladivostok");
        $("[id=state]").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("[id=city]").click();
        $(byText("Lucknow")).click();
        $("[id=submit]").click();

        //Проверка заполнения
        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mikhail"));
        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mar"));
        $("#resultBody tr:nth-child(2) td:nth-child(2)").shouldHave(text("heaven21@gmail.com"));
        $("#resultBody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("#resultBody tr:nth-child(4) td:nth-child(2)").shouldHave(text("9154322223"));
        $("#resultBody tr:nth-child(5) td:nth-child(2)").shouldHave(text("1999-11-11"));
        $("#resultBody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Physics"));
        $("#resultBody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Reading"));
        $("#resultBody tr:nth-child(8) td:nth-child(2)").shouldHave(text("test1.txt"));
        $("#resultBody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Vladivostok"));
        $("#resultBody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Uttar Pradesh Lucknow"));
    }

    @Test //Тест на успешное заполнение формы только с обязательными полями
    void successFull() {
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val("Mikhail");
        $("[id=lastName]").val("Mar");
        $("[id=userEmail]").val("heaven21@gmail.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val("9154322223");
        $("[id=submit]").scrollTo().click();

        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mikhail"));
        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mar"));
        $("#resultBody tr:nth-child(2) td:nth-child(2)").shouldHave(text("heaven21@gmail.com"));
        $("#resultBody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("#resultBody tr:nth-child(4) td:nth-child(2)").shouldHave(text("9154322223"));
    }

    @Test //Пустые обязательные поля
    void requiredFieldsEmpty() {
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#submit").scrollTo().click();

        $("#resultModal").shouldNotBe(visible);
        $("#formError").shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
    }

    @Test //Некорректный номер телефона (9 цифр)
    void invalidMobileNumber() {
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
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
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
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
