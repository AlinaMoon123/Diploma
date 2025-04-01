package frame.element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;

public class Link extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(Link.class);

    //  Конструктор по XPath
    public Link(String XPath) {
        super(XPath);
        logger.info("Initialized link with XPath: {}", XPath);
    }

    //  Конструктор по атрибуту
    public Link(String attribute, String value) {
        super(new XPathBuilder("a").withAttribute(attribute, value).build());
        logger.info("Initialized link with attribute {}={} and XPath: {}", attribute, value, element);
    }

    //  Клик по ссылке
    public void click() {
        element.shouldBe(visible).click();
        logger.info("Clicked link with XPath: {}", element);
    }

    //  Получение URL из атрибута href
    public String getHref() {
        String href = element.shouldBe(visible).getAttribute("href");
        logger.info("Retrieved href '{}' from link with XPath: {}", href, element);
        return href;
    }

    //  Получение полного текста ссылки
    public String getText() {
        String text = element.shouldBe(visible).getText();
        logger.info("Retrieved text '{}' from link with XPath: {}", text, element);
        return text;
    }

    //  Создание ссылки по полному XPath
    public static Link fromXPath(String rawXPath) {
        return new Link(rawXPath);
    }

    //  Создание ссылки по точному тексту
    public static Link byText(String text) {
        return new Link(new XPathBuilder("a").withAttribute("text", text).build());
    }

    //  Создание ссылки, если текст частично совпадает
    public static Link byContainsText(String text) {
        return new Link(new XPathBuilder("a").containsText(text).build());
    }

    //  Создание ссылки по атрибуту (например, `href`)
    public static Link byAttribute(String attribute, String value) {
        return new Link(new XPathBuilder("a").withAttribute(attribute, value).build());
    }

    //  Создание ссылки, если атрибут частично совпадает (например, `href` содержит часть URL)
    public static Link byContainsAttribute(String attribute, String value) {
        return new Link(new XPathBuilder("a").containsAttribute(attribute, value).build());
    }
}
