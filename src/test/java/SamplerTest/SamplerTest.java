package SamplerTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;

public class SamplerTest {
    SamplerPage page = new SamplerPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;

        // Adicione esta linha para manter o browser aberto
        Configuration.holdBrowserOpen = true;

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @DisplayName("Test Suite 6: Interação com Data Input (Text Field)")
    public void textFieldInteractionTest() {
        page.openPage();

        page.navigateToTextField();

        page.demoInput.shouldBe(visible);
        page.demoInput.clear();
        page.demoInput.setValue("Teste Selenide");

        page.demoInput.shouldHave(value("Teste Selenide"));
    }
}
