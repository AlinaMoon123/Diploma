package frame.hh.page;

import frame.basePage.BasePage;
import frame.element.Button;
import frame.element.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    Button signupButton = Button.byContainsAttribute("data-qa", "signup");
    TextInput loginInput = TextInput.byName("login");
    public LoginPage() {
        super("https://spb.hh.ru/account/login?backurl=%2F&hhtmFrom=account_login", Button.byContainsAttribute("data-qa", "signup"));
        logger.info("Main page initialized");
    }
}
