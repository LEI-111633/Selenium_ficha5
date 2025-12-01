package org.example.selenium_ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");

        try {
            // Espera até 6s para aparecer e clica
            mainPage.acceptCookiesButton.shouldBe(visible, Duration.ofSeconds(6)).click();

            // Espera que a animação termine e o banner suma da frente
            mainPage.acceptCookiesButton.should(disappear);
        } catch (Throwable e) {
            // Se não aparecer, seguimos em frente
        }
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        mainPage.searchInput.shouldBe(visible, Duration.ofSeconds(5)).click();

        mainPage.searchInput.setValue("Selenium");

        $("button[data-test='full-search-button']").click();

        mainPage.searchInput.shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();
        mainPage.findYourToolsButton.shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.toolsMenu.click();
        mainPage.seeDeveloperToolsButton.click();
        $("h1").shouldBe(visible);
    }
}