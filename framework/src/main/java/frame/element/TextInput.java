package frame.element;
import frame.element.XPathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Condition.visible;

public class TextInput extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(TextInput.class);

    public TextInput(String XPath) {
        super(XPath);
        logger.info("Initialized text input with XPath: {}", XPath);
    }

    public TextInput(String attribute, String value) {
        super(new XPathBuilder("input").withAttribute(attribute, value).build());
        logger.info("Initialized text input with attribute {}={} and XPath: {}", attribute, value, element);
    }

    /**  Конструктор для полного XPath */
    public TextInput(String rawXPath, boolean isRaw) {
        super(rawXPath);
        logger.info("Initialized text input with raw XPath: {}", rawXPath);
    }

    public boolean isEmpty() {
        boolean empty = getValue().isEmpty();
        logger.info("Checked if input is empty: {}", empty);
        return empty;
    }

    /** Ввести значение */
    public void setValue(String value) {
        element.shouldBe(visible).setValue(value);
        logger.info("Set value '{}' for input with XPath: {}", value, element);
    }

    /**  Получить значение */
    public String getValue() {
        String value = element.shouldBe(visible).getValue();
        logger.info("Retrieved value '{}' from input with XPath: {}", value, element);
        return value;
    }

    /**  Очистить поле */
    public void clear() {
        element.shouldBe(visible).clear();
        logger.info("Cleared input with XPath: {}", element);
    }

    public static TextInput byAttribute(String attribute, String value) {
        return new TextInput(new XPathBuilder("input").withAttribute(attribute, value).build());
    }

    /** Создать input по name */
    public static TextInput byName(String name) {
        return new TextInput("name", name);
    }

    /** Создать input по id */
    public static TextInput byId(String id) {
        return new TextInput("id", id);
    }

    /** Создать input по placeholder */
    public static TextInput byPlaceholder(String placeholder) {
        return new TextInput("placeholder", placeholder);
    }

    /** Создать input по type (например, 'text', 'email', 'password') */
    public static TextInput byType(String type) {
        return new TextInput("type", type);
    }

    /** Создать input по частичному совпадению атрибута */
    public static TextInput byContainsAttribute(String attribute, String value) {
        return new TextInput(new XPathBuilder("input").containsAttribute(attribute, value).build(), true);
    }

    /** Создать input по полному XPath */
    public static TextInput fromXPath(String rawXPath) {
        return new TextInput(rawXPath, true);
    }
}