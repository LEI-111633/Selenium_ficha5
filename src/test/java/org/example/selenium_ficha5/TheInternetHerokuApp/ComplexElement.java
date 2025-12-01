package org.example.selenium_ficha5.TheInternetHerokuApp;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ComplexElement {

    public SelenideElement fileInput = $("#file-upload");

    public SelenideElement uploadButton = $("#file-submit");

    public SelenideElement successHeader = $("h3");
    public SelenideElement uploadedFileName = $("#uploaded-files");
}
