package frame.leti.page;
import frame.basePage.BasePage;
import frame.element.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LKPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LKPage.class);
    private final Button menuButton = new Button("//button[@aria-haspopup='menu'']");
    private final Button moreButton = new Button("//button[text()=\" Ещё \"]");

    public LKPage() {
        super("https://lk.etu.ru/student#/news", "//div[@class = 'logo']]");
        logger.info("LK page initialized");
    }
}
