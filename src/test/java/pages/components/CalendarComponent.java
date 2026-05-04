package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement monthSelect = $(".react-datepicker__month-select");
    private SelenideElement yearSelect = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        System.out.println("Available months: " + monthSelect.getOptions().texts());
        System.out.println("Trying to select: " + month);
        monthSelect.selectOption(month);
        System.out.println("Selected month: " + monthSelect.getSelectedOptionText());
        yearSelect.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}