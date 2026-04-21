package test.examples;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import test.data.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.data.TestData.*;

public class TestdempQa extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test //Тест на простую форму успешный полный
    void successTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkOutputField("currentAddress", currentAddress);
        textBoxPage.checkOutputField("permanentAddress", permanentAddress);
    }

    @Test //Тест на простую форму успешный с минимумом полей
    void minimalTest(){
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.submitForm();
        textBoxPage.checkField("name", userName);
    }

    @Test //Тест на простую форму негативный
    void negativeTest(){
        textBoxPage.openPage();
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.submitForm();
        textBoxPage.checkField("email", userEmail);
    }

    @Test
    void minimalTest_chaining(){
        textBoxPage.openPage()
        .typeUserName(userName)
        .submitForm()
        .checkField("name", userName);
    }
}