package org.example.selenium_ficha5.TheInternetHerokuApp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.selenium_ficha5.TheInternetHerokuApp.DynamicLoadingPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.hidden;

public class DynamicLoadingTest {
    DynamicLoadingPage page = new DynamicLoadingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void testHiddenElementAppears() {
        page.openPage();

        page.startButton.click();

        page.loadingBar.shouldBe(visible);

        page.finishText.shouldHave(text("Hello World!"));

        // Opcional: Garantir que o loading já não está visível
        page.loadingBar.shouldBe(hidden);
    }
}