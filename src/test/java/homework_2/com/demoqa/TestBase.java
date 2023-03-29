package homework_2.com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

  public class TestBase {
    @BeforeAll
    static void beforeAll() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.browserSize = "1520x1080";
      Configuration.browser = "firefox";
//    Configuration.timeout = 8000;
      Configuration.holdBrowserOpen = true;
    }
  }

