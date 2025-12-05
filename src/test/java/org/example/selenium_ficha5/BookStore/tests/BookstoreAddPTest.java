package org.example.selenium_ficha5.BookStore.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import org.example.selenium_ficha5.BookStore.pages.BookstorePage;
import org.example.selenium_ficha5.BookStore.pages.AddProductPage;

public class BookstoreAddPTest {
    private BookstorePage bookstorePage = new BookstorePage();
    private AddProductPage addProductPage = new AddProductPage();

    @BeforeAll
    static void setupAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    void openApplication() {
        bookstorePage.open("https://vaadin.com/demos/bookstore");
    }

    @Test
    @DisplayName("Adicionar um produto à lista")
    void testAddProduct() {
        bookstorePage.clickAddProduct();

        addProductPage.fillForm(
                "Livro",
                "20",
                "Technology"
        );

        addProductPage.submit();

        Assertions.assertTrue(
                bookstorePage.hasProduct("Livro Selenium Automático"),
                "O produto não apareceu"
        );
    }
    
}
