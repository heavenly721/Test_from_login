package test.examples;

import org.junit.jupiter.api.Test;
import test.data.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.data.TestData.*;

public class TestdempQa extends TestBase {

    @Test //Тест на простую форму успешный полный
    void successTest() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

    @Test //Тест на простую форму успешный с минимумом полей
    void minimalTest(){
        open("/text-box");
        $("#userName").setValue(userName);
        $("#submit").click();
        $("#output #name").shouldHave(text(userName));
    }

    @Test //Тест на простую форму негативный
    void negativeTest(){
        open("/text-box");
        $("#userEmail").setValue(userEmail);
        $("#submit").click();
        $("#output #email").shouldHave(text(userEmail));
    }
}