import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class YouTubeTest {

    @ParameterizedTest
    @MethodSource("videoLinks")
    public void testYouTube(String link) {
        open(link);
        $("#movie_player").shouldBe(visible);
    }

    static Stream<String> videoLinks() {
        return Stream.of(
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                "https://www.youtube.com/watch?v=kXYiU_JCYtU",
                "https://www.youtube.com/watch?v=9bZkp7q19f0"
        );
    }
}
