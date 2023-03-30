package homework_2.com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestStudentRegistrationForm extends TestBase {
  @Test
  void successfulFillFormTest() {
    open("/automation-practice-form");

    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('header').remove()");

    $("#firstName").setValue("Elza");
    $("#lastName").setValue("Smite");
    $("#userEmail").setValue("elza@net.com");
    $("#genterWrapper").$(byText("Female")).click();
    $("#userNumber").setValue("9115645654");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-container").$(".react-datepicker__month-select").click();
    $(by("value", "7")).click();
    $(".react-datepicker__year-select").click();
    $(by("value", "2000")).click();
    $(by("aria-label", "Choose Friday, August 18th, 2000")).click();
    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#hobbiesWrapper").$(byText("Reading")).click();
    $("#subjectsInput").setValue("Mathematics");
    $("#uploadPicture").uploadFile(new File("src/test/resources/screenshot_1.png"));
    $("#currentAddress").setValue("London");
    $("#state").click();
    $(byText("Haryana")).click();
    $("#city").click();
    $(byText("Karnal")).click();

    $("#submit").click();

    $(".table-responsive").shouldHave(
            text("Elza Smite"),
            text("elza@net.com"),
            text("Female"),
            text("9115645654"),
            text("18 August,2000"),
            text("Sports, Reading"),
            text("screenshot_1.png"),
            text("London"),
            text("Haryana Karnal"));

    $("#closeLargeModal").click();
  }
}
