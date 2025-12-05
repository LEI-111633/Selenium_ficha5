package formTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

// page_url = https://vaadin-form-example.demo.vaadin.com/
public class FormPage {

    public SelenideElement firstNameInput = $$("vaadin-text-field").findBy(text("First name"));;
    public SelenideElement lastNameInput = $$("vaadin-text-field").findBy(text("Last name"));
    public SelenideElement userHandleInput = $$("vaadin-text-field").findBy(text("User handle"));
    public SelenideElement uploadFileInput = $(shadowCss("#fileInput", "vaadin-upload"));
    public SelenideElement wantedPasswordInput = $$("vaadin-password-field").findBy(text("Wanted Password"));
    public SelenideElement passwordAgainInput = $$("vaadin-password-field").findBy(text("Password again"));
    public SelenideElement allowMarketingCheckbox = $$("vaadin-checkbox").findBy(text("Allow Marketing?"));
    public SelenideElement emailInput = $$("vaadin-email-field").findBy(text("Email"));
    public SelenideElement joinTheCommunityButton = $(byText("Join the community"));
    public SelenideElement successMessage = $(shadowCss("vaadin-notification-card[theme~='success']", "vaadin-notification-container"));

}