import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class WikipediaTest {

    @BeforeEach
    void openWikipedia() {
        open("https://en.wikipedia.org/wiki/Main_Page");
    }

    @ParameterizedTest
    @EnumSource (value = City.class, mode = EnumSource.Mode.INCLUDE)
    public void testWikipedia(City city) {
        $(byName("search")).setValue(city.name()).pressEnter();
        $("h1#firstHeading").shouldHave(text(city.name()));
    }
}
