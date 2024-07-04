package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Selenide.*;


public class MVideoTests extends TestBase{
    String url = "https://www.mvideo.ru/";

    @Test
    @Tag("BLOCKER")
    @DisplayName("Поиск товара Iphone на сайте МВидео")
    void searchProductTest() {
        open(url);

        $(".input__field").setValue("iphone").pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text("iphone"));
    }

    @ValueSource(strings = {
            "rtx",
            "iphone"
    })
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Поиск товара {0} на сайте МВидео")
    void searchProductMVideoTest(String searchQuery) {
        open(url);

        $(".input__field").setValue(searchQuery).pressEnter();
        $(".ng-star-inserted").shouldHave(Condition.text(searchQuery));
    }

}