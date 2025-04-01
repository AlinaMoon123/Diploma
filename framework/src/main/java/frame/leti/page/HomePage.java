package frame.leti.page;

import com.codeborne.selenide.SelenideElement;
import frame.basePage.BasePage;
import frame.element.BaseElement;
import frame.element.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private final SelenideElement dropdownMenu = $x("//div[contains(@class, 'dropdown-bottom')]");
    private final Button logoutButton = new Button("//button[text()=' Выйти']");

    public HomePage() {
        super("https://id.etu.ru/", "//a[@href=\"/personal\"]");
        logger.info("Home page initialized");
    }

    public void logout() {
        logger.info("Opening dropdown menu");
        dropdownMenu.click();

        logger.info("Clicking logout button");
        //logoutButton.click();
    }
}
