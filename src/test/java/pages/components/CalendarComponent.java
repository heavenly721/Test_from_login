package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static test.data.TestData.*;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day[data-day='" + dayOfBirth + "']").click();
    }
}
