package DatabaseTest;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.Condition.*;

public class DatabaseTest {

    private static final String[] TITLES = {
            "Law Abiding Citizen",
            "Knives Out",
            "The Last Jedi"
    };

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    void showsAllMovies() {
        DatabasePage page = new DatabasePage();
        page.openPage();

        for (String title : TITLES) {
            page.titleCell(title).shouldBe(visible);
            String href = page.imdbHrefForTitle(title);
            Assertions.assertTrue(href.contains("imdb"));
        }
    }
}

