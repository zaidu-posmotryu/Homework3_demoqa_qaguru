package demoqa.dasha.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {


    public SubjectsComponent setSubject() {
        $ ("#subjectsInput").setValue("Arts").pressEnter();
        return this;
    }
}