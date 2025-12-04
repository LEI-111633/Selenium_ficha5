package DatabaseTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatabasePage {

    private final String url = "https://vaadin-database-example.demo.vaadin.com/";

    public void openPage() {
        open(url);
    }

    public ElementsCollection rows() {
        return $$("vaadin-grid-cell-content[part='body-cell'] "
                + "tbody tr"); // pode ser ajustado consoante o HTML real
    }

    public SelenideElement titleCell(String title) {
        return $$("vaadin-grid-cell-content")
                .findBy(text(title));
    }

    public String imdbHrefForTitle(String title) {
        return titleCell(title)
                .parent()
                .parent()
                .$$("a")
                .first()
                .getAttribute("href");
    }
}
