package demoqa.dasha.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class automationPracticeform {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkFormTest(){
       open("/automation-practice-form");
        //executeJavaScript("document.body.style.zoom='75%'");
        executeJavaScript("$('#fixedban').remove()");

        $ ("#firstName").setValue("Jane");
        $ ("#lastName").setValue("Doe");
        $ ("#userEmail").setValue("janedoe@yahoo.com");
        $ (byText("Female")).click();
        $ ("#userNumber").setValue("1234567890");
        $ ("#dateOfBirthInput").click();
        $ (".react-datepicker__month-select").selectOption("May");
        $ (".react-datepicker__year-select").selectOption("1990");
        $ (".react-datepicker__day--015:not(.react-datepicker__day--selected").click();
        $ ("#subjectsInput").setValue("Arts").pressEnter();
        $ (byText("Reading")).click();
        $ ("input#uploadPicture").uploadFromClasspath("this_is_my_life.jpg");
        $ ("#currentAddress").setValue("My new address");
        $ ("#state").click();
        $ (byText("Uttar Pradesh")).click();
        $ ("#city").click();
        $ (byText("Agra")).click();
        $ ("[id=submit]").click();

        $ ("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $$ (".table-responsive").findBy(text("Student Name")).shouldHave(text("Jane Doe"));
        $$ (".table-responsive").findBy(text("Student Email")).shouldHave(text("janedoe@yahoo.com"));
        $$ (".table-responsive").findBy(text("Gender")).shouldHave(text("Female"));
        $$ (".table-responsive").findBy(text("Mobile")).shouldHave(text("1234567890"));
        $$ (".table-responsive").findBy(text("Date of Birth")).shouldHave(text("15 May,1990"));
        $$ (".table-responsive").findBy(text("Subjects")).shouldHave(text("Arts"));
        $$ (".table-responsive").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$ (".table-responsive").findBy(text("Picture")).shouldHave(text("this_is_my_life.jpg"));
        $$ (".table-responsive").findBy(text("Address")).shouldHave(text("My new address"));
        $$ (".table-responsive").findBy(text("State and City")).shouldHave(text("Uttar Pradesh Agra"));

        $ ("#closeLargeModal").click();
    }

    }
