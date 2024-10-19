import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class baseTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        open("https://etu.ru/");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void testExample() {
        String pageTitle = title();
        System.out.println("Page title is: " + pageTitle);
    }
}
