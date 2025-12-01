package org.example.selenium_ficha5.TheInternetHerokuApp;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

class ComplexElementTest {

    ComplexElement page = new ComplexElement();

    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void testFileUpload() throws IOException {
        File tempFile = new File("teste_upload_selenium.txt");
        if (!tempFile.exists()) {
            Files.writeString(tempFile.toPath(), "Conteúdo de teste para a ficha 5.");
        }
        tempFile.deleteOnExit();

        open("https://the-internet.herokuapp.com/upload");

        page.fileInput.uploadFile(tempFile);

        page.uploadButton.click();

        page.successHeader.shouldBe(visible).shouldHave(text("File Uploaded!"));

        page.uploadedFileName.shouldHave(text("teste_upload_selenium.txt"));
    }

}