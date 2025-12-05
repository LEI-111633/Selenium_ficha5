package BookStore.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BookstorePage {

    private final SelenideElement addProductButton =
            $$("vaadin-button").findBy(text("New product"));

    private final SelenideElement productGrid = $("vaadin-grid");

    public void openPage(String url) {
        com.codeborne.selenide.Selenide.open(url);
    }

    public void clickAddProduct() {
        addProductButton.shouldBe(visible).click();
    }

    public boolean hasProduct(String productName) {
        productGrid.shouldHave(text(productName));
        return true;
    }
}
