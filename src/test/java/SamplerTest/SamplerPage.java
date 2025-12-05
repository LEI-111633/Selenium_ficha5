package SamplerTest;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class SamplerPage {
    private static final String URL = "https://demo.vaadin.com/sampler/";

    // Alterado de byText para withText para ser mais flexível
    public SelenideElement textInputsCategory = $(withText("Text inputs"));

    // Alterado de byText para withText
    public SelenideElement textFieldOption = $(withText("Text field"));

    // O seletor CSS do input parece correto para a versão do Vaadin usada no Sampler
    public SelenideElement demoInput = $(".v-textfield");

    public void openPage() {
        open(URL);
    }

    public void navigateToTextField() {
        // O Selenide aguarda automaticamente, mas o withText ajuda se houver espaços extras
        textInputsCategory.click();
        textFieldOption.click();
    }
}