package frame.leti.page;

import frame.basePage.BasePage;
import frame.element.Button;
import com.codeborne.selenide.SelenideElement;
import frame.element.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final TextInput usernameField = new TextInput("type", "email");
    private final TextInput passwordField = TextInput.byType("password");
    Button loginButton = Button.byContainsAttribute("class", "btn-primary");

    public LoginPage() {
        super("https://id.etu.ru/login", Button.byContainsAttribute("class", "btn-primary"));
        logger.info("Login page initialized");
    }

    public void enterUsername(String username) {
        usernameField.setValue(username);
        logger.info("Entered username: {}", username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
        logger.info("Entered password");
    }

    public void clickLoginButton() {
        loginButton.click();
        logger.info("Login button clicked");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isErrorMessageDisplayed() {
        return $x("//span[contains(@class, 'text-error')]").isDisplayed();
    }

    public String getErrorMessage() {
        return $x("//span[contains(@class, 'text-error')]").shouldBe(visible).getText();
    }

}
