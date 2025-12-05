package BookStore.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import BookStore.pages.BookstorePage;
import BookStore.pages.AddProductPage;

public class BookstoreAddPTest {
    private BookstorePage bookstorePage = new BookstorePage();
    private AddProductPage addProductPage = new AddProductPage();

    @BeforeAll
    static void setupAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 80000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    void openApplication() {
        bookstorePage.openPage("https://vaadin-bookstore-example.demo.vaadin.com/");
    }


    @Test
    @DisplayName("Adicionar um produto à lista")
    void testAddProduct() {
        bookstorePage.clickAddProduct();

        addProductPage.fillForm(
                "Livro Selenium Automático",
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
