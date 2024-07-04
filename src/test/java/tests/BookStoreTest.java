package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BookStoreTest extends TestBase {

    @DisplayName("Тестирование поиска книги по названию")
    @CsvFileSource(resources = "/book_details.csv")
    @ParameterizedTest
    void searchBookTest(String bookTitle) {
        open("https://demoqa.com/books");
        $("#searchBox").setValue(bookTitle);
        $(".rt-tbody").shouldHave(text(bookTitle));
    }

}