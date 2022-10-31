package demoqa.dasha.tests;

import com.codeborne.selenide.Configuration;
import demoqa.dasha.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static demoqa.dasha.pages.TestUserData.*;

public class AutomationPracticeFormWithPageObjectsPlusFaker {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x1200";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkFormTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPicture()
                .setAddress(currentAddress)
                .setLocation(location, town)
                .submitTheForm();

        automationPracticeFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "this_is_my_life.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", location + " " + town);
    }
}
