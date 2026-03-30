package test.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.cssClass;

public class TestdempQa {

    @Test
    void successTest()  {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Sidorov Dmitry");
        $("#userEmail").setValue("Dog123444@gail.ru");
        $("#currentAddress").setValue("Dagestan");
        $("#permanentAddress").setValue("Dagestan, street Grom");
        $("#submit").click();

        $("#output #name").shouldHave(text("Sidorov Dmitry"));
        $("#output #email").shouldHave(text("Dog123444@gail.ru"));
        $("#output #currentAddress").shouldHave(text("Dagestan"));
        $("#output #permanentAddress").shouldHave(text("Dagestan, street Grom"));
    }

    @Test
    void minimalTest(){
        open("https://demoqa.com/text-box");
        $("#userName").setValue("test");
        $("#submit").click();
        $("#output #name").shouldHave(text("test"));
    }

    @Test
    void negativeTest(){
        open("https://demoqa.com/text-box");
        $("#userEmail").setValue("testgmail.com");
        $("#submit").click();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}