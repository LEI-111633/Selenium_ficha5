package BookStore.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AddProductPage {
    
    private SelenideElement titleInput = $("#title");
    private SelenideElement priceInput = $("#price");
    private SelenideElement categorySelect = $("#category");
    private SelenideElement saveButton = $("vaadin-button#save");

    public void fillForm(String title, String price, String category) {
        titleInput.shouldBe(visible).setValue(title);
        priceInput.shouldBe(visible).setValue(price);
        categorySelect.selectOptionContainingText(category);
    }

    public void submit() {
        saveButton.shouldBe(enabled).click();
    }
}
