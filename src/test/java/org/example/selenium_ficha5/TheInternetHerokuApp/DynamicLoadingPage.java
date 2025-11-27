package org.example.selenium_ficha5.TheInternetHerokuApp;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPage {
    private final String URL = "https://the-internet.herokuapp.com/dynamic_loading/1";

    // Seletores
    public SelenideElement startButton = $("#start button");
    public SelenideElement loadingBar = $("#loading");
    public SelenideElement finishText = $("#finish h4");

    public void openPage() {
        open(URL);
    }
}