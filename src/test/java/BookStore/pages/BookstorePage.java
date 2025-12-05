package BookStore.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BookstorePage {

    private SelenideElement addProductButton = $("vaadin-button#add");
    private SelenideElement productGrid = $("vaadin-grid");

    public void open(String url) {
        open(url);
    }

    public void clickAddProduct() {
        addProductButton.shouldBe(visible).click();
    }

    public boolean hasProduct(String productName) {
        return productGrid.$$("vaadin-grid-cell-content")
                .findBy(text(productName))
                .exists();
    }
    
}
