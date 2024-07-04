package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Selenide;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @AfterEach
    void closeBrowser(){
            Selenide.closeWebDriver();
        }
}