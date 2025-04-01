package frame.hh.page;

import frame.basePage.BasePage;
import frame.element.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);
    Button saveSearchButton = Button.byContainsAttribute("data-qa", "saved");

    public SearchPage() {
        super("https://spb.hh.ru/search/vacancy?text=&area=2&hhtmFrom=main&hhtmFromLabel=vacancy_search_line", Button.byContainsAttribute("data-qa", "saved"));
        logger.info("Search page initialized");
    }

}
