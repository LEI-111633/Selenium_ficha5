package formTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class FormPageTest {

    FormPage formPage = new FormPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";

        // ADICIONE ESTA LINHA:
        Configuration.holdBrowserOpen = true;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://vaadin-form-example.demo.vaadin.com/");
    }

    @Test
    public void joinCommunitySuccessfully() throws IOException {
        formPage.firstNameInput.sendKeys("Samuel");
        formPage.lastNameInput.sendKeys("Silva");
        formPage.userHandleInput.sendKeys("samuel_dev");

        formPage.wantedPasswordInput.sendKeys("MinhaPasswordForte123!");
        formPage.passwordAgainInput.sendKeys("MinhaPasswordForte123!");

        File tempImage = File.createTempFile("avatar_teste", ".png");
        java.nio.file.Files.writeString(tempImage.toPath(), "conteudo falso de imagem");
        tempImage.deleteOnExit();
        formPage.uploadFileInput.uploadFile(tempImage);

        formPage.allowMarketingCheckbox.click();
        formPage.emailInput.sendKeys("samuel@iscte-iul.pt");

        formPage.joinTheCommunityButton.click();


        formPage.successMessage.shouldBe(visible, Duration.ofSeconds(10));
        formPage.successMessage.shouldHave(text("Data saved"));
    }
}