package test.examples;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import test.data.TestBase;

import java.util.Locale;

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

    @Test //Тест на простую форму успешный полный
    void successTest_with_faker() {
        Faker faker = new Faker();
        Faker fakerRu = new Faker(new Locale("ru"));
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = fakerRu.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();

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
}