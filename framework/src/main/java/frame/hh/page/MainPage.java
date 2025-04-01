package frame.hh.page;
import com.codeborne.selenide.Selenide;
import frame.basePage.BasePage;
import frame.element.Button;
import frame.element.Link;
import frame.element.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    private final Button searchButton = new Button("data-qa", "search-button" );
    TextInput searchInput= TextInput.byId("a11y-search-input");
    Link LoginLink = Link.byAttribute("class", "supernova-button");
    Button cleartextButton = Button.byAttribute("data-qa", "input-clearable-button");
    Button regionButton = Button.byAttribute("data-qa", "region-clarification-submit-button");

    public MainPage() {
        super("https://spb.hh.ru/?hhtmFrom=vacancy_search_list", new Button("data-qa", "search-button" ));
        logger.info("Main page initialized");
    }

    public void clickRegionButton() {
        regionButton.click();
        logger.info("Region button clicked");
    }

    public boolean searchInputIsEmpty(){
        return searchInput.isEmpty();
    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("Search button clicked");
    }
    public boolean  regionButtonIsDisplayed(){
        return regionButton.isDisplayed();
    }

    public boolean  clearTextButtonIsDisplayed(){
        return cleartextButton.isDisplayed();
    }

    public void clickClearTextButton() {
        cleartextButton.click();
        logger.info("Clear text button clicked");
    }

    public void clickModal(){
        Selenide.$("[data-qa='bloko-modal-close']").click();

    }

    public boolean  modalIsDisplayed(){
        return Selenide.$("[data-qa='bloko-modal-close']").isDisplayed();
    }

    public boolean  clearIsNotDisplayed(){
        return cleartextButton.isNotDisplayed();
    }


    public void enterSearchRequest(String searchRequest) {
        searchInput.setValue(searchRequest);
        logger.info("Entered search request");
    }

}
