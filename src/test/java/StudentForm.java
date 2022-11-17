import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.UploadFile;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentForm {
    @BeforeAll
    static void beforeall() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillStudentFormTest() {
        //Open Browser Chrome
        open("https://demoqa.com/automation-practice-form");

        //Name
        $("[id=firstName]").setValue("Пёс");
        $("[id=lastName]").setValue("Шарик");

        //Email
        $("[id=userEmail]").setValue("DogsHeart@google.com");

        //Gender
        $(byText("Other")).shouldBe(visible).click();

        //Mobile
        $("[id=userNumber]").setValue("1234567890");

        //Date of Birth
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("February");
        $("[class=react-datepicker__year-select]").selectOption("1988");
        $x("//div[@aria-label='Choose Monday, February 29th, 1988']").click();

        //Subject
        $("[id=subjectsInput]").setValue("Computer").pressTab();

        //Hobbies
        $(byText("Sports")).shouldBe(visible).click();
        $(byText("Reading")).shouldBe(visible).click();
        $(byText("Music")).shouldBe(visible).click();

        //Picture
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/sharik.jpeg"));

        //Current Address
        $("[id=currentAddress]").setValue("Moscow, Prechistenka str, 24/1");

        //State and city
        $("[id=react-select-3-input]").setValue("Haryana").pressTab();
        $("[id=react-select-4-input]").setValue("Panipat").pressTab();

        //Submit button
        $(byText("Submit")).shouldBe(visible).click();







    }
}


