import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LitresTest {

    @BeforeEach
    void openLitres() {
        open("https://www.litres.ru");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Books.csv")
    public void testLitres(String keyword, String expectedTitle) {
        $(byName("q")).setValue(keyword).pressEnter();
        $$("[class*='ArtInfo-modules__title']").first().shouldHave(text(expectedTitle));
    }
}
