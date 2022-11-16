import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentForm {
    @Test
    void fillStudentFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Пёс");
        $("[id=lastName]").setValue("Шарик");
        $("[id=userEmail]").setValue("DogsHeart@google.com");
    }
}


