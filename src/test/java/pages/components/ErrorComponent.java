package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorComponent {

    private SelenideElement resultModal = $("#resultModal");
    private SelenideElement formError = $("#formError");

    public ErrorComponent checkResultModalNotVisible() {
        resultModal.shouldNotBe(visible);
        return this;
    }

    public ErrorComponent checkFormError(String expectedMessage) {
        formError.shouldHave(text(expectedMessage));
        return this;
    }

}