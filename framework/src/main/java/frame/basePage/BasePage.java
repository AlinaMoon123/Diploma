package frame.basePage;

import com.codeborne.selenide.Selenide;
import frame.component.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage extends Component {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected final String url;


    /** Конструктор, принимающий XPath как строку */
    protected BasePage(String url, String mainElementXPath) {
        super($x(mainElementXPath));
        this.url = url;
        logger.info("Initialized page with URL: {}", url);
    }

    /** Новый конструктор, принимающий объект `Component` */
    protected BasePage(String url, Component mainElement) {
        super(mainElement.getElement()); // Используем SelenideElement внутри компонента
        this.url = url;
        logger.info("Initialized page with URL: {} and main element: {}", url, mainElement);
    }

    public void openPage() {
        logger.info("Opening page: {}", url);
        Selenide.open(url);
        waitForPageToLoad();
    }

    public void refreshPage() {
        logger.info("Refreshing the page");
        Selenide.refresh();
        waitForPageToLoad();
    }

    /** Ожидание загрузки главного элемента страницы */
    public void waitForPageToLoad() {
        logger.info("Waiting for the main element to become visible...");
        element.shouldBe(visible);
        logger.info("Page is loaded successfully.");
    }
}


