package SamplerTest;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SamplerPage {
    private static final String URL = "https://demo.vaadin.com/sampler/";

    public SelenideElement textInputsCategory = $(byText("Text inputs"));
    public SelenideElement textFieldOption = $(byText("Text field"));
    public SelenideElement demoInput = $(".v-textfield");

    public void openPage() {
        open(URL);
    }

    public void navigateToTextField() {
        textInputsCategory.click();
        textFieldOption.click();
    }
}