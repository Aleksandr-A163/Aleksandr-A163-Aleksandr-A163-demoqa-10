package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.util.stream.Stream;
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

    static Stream<Arguments> bookDetailsTest() {
        return Stream.of(
                Arguments.of("Git Pocket Guide", "Richard E. Silverman", "O'Reilly Media"),
                Arguments.of("Learning JavaScript Design Patterns", "Addy Osmani", "O'Reilly Media"),
                Arguments.of("Designing Evolvable Web APIs with ASP.NET", "Glenn Block et al.", "O'Reilly Media")
        );
    }

}