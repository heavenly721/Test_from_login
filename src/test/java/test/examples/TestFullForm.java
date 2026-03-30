package test.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFullForm {

    @Test
    void successFull() {
        open("https://qa-guru.github.io/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").val("Mikhail");
        $("[id=lastName]").val("Mar");
        $("[id=userEmail]").val("heaven21@gmail.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").val("9154322223");
        $("[id=dateOfBirthInput]").click();

        $("[id=submit]").scrollTo().click();

        //Проверки формы всплывающего окна
        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mikhail"));
        $("#resultBody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Mar"));
        $("#resultBody tr:nth-child(2) td:nth-child(2)").shouldHave(text("heaven21@gmail.com"));
        $("#resultBody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("#resultBody tr:nth-child(4) td:nth-child(2)").shouldHave(text("9154322223"));
    }
}
