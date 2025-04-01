package frame.element;
import frame.element.XPathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;

public class Button extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(Button.class);

    // Конструктор с атрибутами
    public Button(String attribute, String value) {
        super(new XPathBuilder("button").withAttribute(attribute, value).build()); // Передаём строку XPath
        logger.info("Initialized button with attribute {}={} and XPath: {}", attribute, value, element);
    }

    // конструктор для полного XPath
    public Button(String rawXPath) {
        super(rawXPath); // Передаём строку, а не SelenideElement
        logger.info("Initialized button with raw XPath: {}", rawXPath);
    }

    public static Button byAttribute(String attribute, String value) {
        return new Button(new XPathBuilder("button").withAttribute(attribute, value).build());
    }

    // Метод создания кнопки по тексту внутри неё
    public static Button byText(String text) {
        return new Button("text", text);
    }

    // Метод создания кнопки, если текст частично совпадает
    public static Button byContainsText(String text) {
        return new Button("contains(text())", text);
    }

    // Метод создания кнопки по полному XPath
    public static Button fromXPath(String rawXPath) {
        return new Button(rawXPath);
    }

    public static Button byContainsAttribute(String attribute, String value) {
        return new Button(new XPathBuilder("button").containsAttribute(attribute, value).build());
    }


    // Клик по кнопке
    public void click() {
        element.shouldBe(enabled).click();
        logger.info("Clicked button with XPath: {}", element);
    }
}
