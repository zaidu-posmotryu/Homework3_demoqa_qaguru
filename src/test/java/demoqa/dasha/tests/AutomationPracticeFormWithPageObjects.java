package demoqa.dasha.tests;

import com.codeborne.selenide.Configuration;
import demoqa.dasha.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void checkFormTest(){
        automationPracticeFormPage.openPage()
                .setFirstName("Jane")
                .setLastName("Doe")
                .setEmail("janedoe@yahoo.com")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setBirthDate("15", "May", "1990")
                .setSubjects("Arts")
                .setHobby()
                .uploadPicture()
                .setAddress("My new address")
                .setLocation("Uttar Pradesh", "Agra")
                .submitTheForm();

        automationPracticeFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Jane Doe")
                .checkResult("Student Email", "janedoe@yahoo.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "15 May,1990")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "this_is_my_life.jpg")
                .checkResult("Address", "My new address")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }
}
