package demoqa.dasha.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.dasha.pages.components.CalendarComponent;
import demoqa.dasha.pages.components.ResultsTableComponent;
import demoqa.dasha.pages.components.StateAndCityComponent;
import demoqa.dasha.pages.components.SubjectsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class automationPracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            addressInput =  $("#currentAddress");

    private final static String TITLE_TEXT = "Student Registration Form";

    public automationPracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
      public automationPracticeFormPage setFirstName(String value) {
          firstNameInput.setValue(value);
          return this;
    }
      public automationPracticeFormPage setLastName(String value) {
          lastNameInput.setValue(value);
          return this;
    }
      public automationPracticeFormPage setEmail (String value) {
          emailInput.setValue(value);
          return this;
    }
      public automationPracticeFormPage setGender(String value) {
          $("#genterWrapper").$(byText(value)).click();
          return this;
    }
    public automationPracticeFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public automationPracticeFormPage setBirthDate(String day, String month, String year) {
        $ ("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public automationPracticeFormPage setSubject(String value) {
        subjectsComponent.setSubject();
        return this;
    }
    public automationPracticeFormPage setHobby (String value) {
        $ (byText("Reading")).click();
        return this;
    }
    public automationPracticeFormPage uploadPicture(String value) {
        $ ("input#uploadPicture").uploadFromClasspath("this_is_my_life.jpg");
        return this;
    }
    public automationPracticeFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public automationPracticeFormPage setLocation(String state, String city) {
        stateAndCityComponent.setStateAndCity(state, city);
        return this;
    }
    public automationPracticeFormPage submitTheForm() {
        $ ("[id=submit]").click();
        return this;
    }
    public automationPracticeFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }
    public automationPracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
