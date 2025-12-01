package org.example.selenium_ficha5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
    public SelenideElement acceptCookiesButton = $x("//button[contains(text(), 'Accept All') or contains(text(), 'Aceitar tudo')]");

    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement searchInput = $("[data-test-id='search-input']");

    public SelenideElement toolsMenu = $x("//button[@data-test='main-menu-item-action' and contains(., 'Developer Tools')]");

    public SelenideElement seeDeveloperToolsButton = $x("//a[@data-test='suggestion-link']");
    public SelenideElement findYourToolsButton = $x("//a[@data-test='suggestion-link']");
}
