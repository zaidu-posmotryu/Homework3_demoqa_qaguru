package demoqa.dasha;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class automationPracticeform {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x900";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkFormTest(){
       open("/automation-practice-form");
        //executeJavaScript("document.body.style.zoom='75%'");

        $ ("#firstName").setValue("Jane");
        $ ("#lastName").setValue("Doe");
        $ ("#userEmail").setValue("janedoe@yahoo.com");
        $ (byText("Male")).click();
        $ ("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--008:not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $ (byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("this_is_my_life.jpg");
        $ ("#currentAddress").setValue("My new address");
        $("#state").click();
        // $(".").selectOptionByValue("NCR");

       


        /* $ ("[id=submit]").click(); */



    }

    }
