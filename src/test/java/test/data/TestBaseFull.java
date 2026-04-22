package test.data;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseFull {

    @BeforeAll
    static void setupSelenideQaGury() {
        Configuration.browserSize = "1920х1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://qa-guru.github.io";
        Configuration.clickViaJs = true;
    }

}
