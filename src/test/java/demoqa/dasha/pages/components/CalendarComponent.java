package demoqa.dasha.pages.components;

import com.codeborne.selenide.Configuration;
import demoqa.dasha.pages.automationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    public CalendarComponent setDate(String day, String month, String year) {
        $ (".react-datepicker__month-select").selectOption(month);
        $ (".react-datepicker__year-select").selectOption(year);
        $ (".react-datepicker__day--0" + day + ":not(.react-datepicker__day--selected").click();

        return this;
    }
    }
