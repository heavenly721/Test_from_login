package test.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import test.TestBaseDemoQa;
import test.data.TestData;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class TestdempQa extends TestBaseDemoQa {
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData;

    @BeforeEach
    void setUp() {
        testData = new TestData();
    }

    @Test // Тест на простую форму успешный полный
    void successTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.typeUserEmail(testData.userEmail);
        textBoxPage.typeCurrentAddress(testData.currentAddress);
        textBoxPage.typePermanentAddress(testData.permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", testData.userName);
        textBoxPage.checkField("email", testData.userEmail);
        textBoxPage.checkOutputField("currentAddress", testData.currentAddress);
        textBoxPage.checkOutputField("permanentAddress", testData.permanentAddress);
    }

    @Test // Тест на простую форму успешный с минимумом полей
    void minimalTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.submitForm();
        textBoxPage.checkField("name", testData.userName);
    }

    @Test // Тест на простую форму негативный
    void negativeTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserEmail(testData.userEmail);
        textBoxPage.submitForm();
        textBoxPage.checkField("email", testData.userEmail);
    }

    @Test
    void minimalTest_chaining() {
        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .submitForm()
                .checkField("name", testData.userName);
    }

    @Test
    void successTest_with_faker() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.typeUserEmail(testData.userEmail);
        textBoxPage.typeCurrentAddress(testData.currentAddress);
        textBoxPage.typePermanentAddress(testData.permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", testData.userName);
        textBoxPage.checkField("email", testData.userEmail);
        textBoxPage.checkOutputField("currentAddress", testData.currentAddress);
        textBoxPage.checkOutputField("permanentAddress", testData.permanentAddress);
    }

    @Test
    void successTest_with_utils() {
        String userName = getRandomString(10);
        String userEmail = getRandomEmail();
        String currentAddress = "Dagestan";
        String permanentAddress = "Dagestan, street Grom";

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