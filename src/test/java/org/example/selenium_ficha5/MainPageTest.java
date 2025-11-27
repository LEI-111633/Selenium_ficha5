package org.example.selenium_ficha5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
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

        if (mainPage.acceptCookiesButton.exists()) {
            mainPage.acceptCookiesButton.click();
        }
    }

    @Test
    public void search() {
        mainPage.searchButton.click();


        mainPage.searchInput.setValue("Selenium");

        $("button[data-test='full-search-button']").click();

        mainPage.searchInput.shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();
        $("div[data-test='main-submenu']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.toolsMenu.click();
        mainPage.seeDeveloperToolsButton.click();
        $("h1").shouldBe(visible);
    }
}