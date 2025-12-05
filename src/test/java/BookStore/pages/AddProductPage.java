package BookStore.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AddProductPage {

    private final SelenideElement titleInput =
            $$("vaadin-text-field").findBy(attribute("label", "Title"));

    private final SelenideElement priceInput =
            $$("vaadin-text-field").findBy(attribute("label", "Price"));

    private final SelenideElement categorySelect =
            $("vaadin-combo-box");

    private final SelenideElement saveButton =
            $$("vaadin-button").findBy(text("Save"));

    public void fillForm(String title, String price, String category) {
        titleInput.shouldBe(visible).setValue(title);
        priceInput.shouldBe(visible).setValue(price);
        categorySelect.selectOptionContainingText(category);
    }

    public void submit() {
        saveButton.shouldBe(enabled).click();
    }
}
