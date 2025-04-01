package frame.element;

public class XPathBuilder {
    private StringBuilder xpath;

    // Конструктор для автоматической генерации XPath
    public XPathBuilder(String tag) {
        this.xpath = new StringBuilder("//").append(tag);
    }

    // Новый статический метод для передачи полного XPath
    public static XPathBuilder fromRawXPath(String rawXPath) {
        XPathBuilder builder = new XPathBuilder("*"); // Временное значение
        builder.xpath = new StringBuilder(rawXPath);
        return builder;
    }

    public XPathBuilder withAttribute(String attribute, String value) {
        xpath.append(String.format("[@%s='%s']", attribute, value));
        return this;
    }

    public XPathBuilder containsText(String text) {
        xpath.append(String.format("[contains(text(),'%s')]", text));
        return this;
    }

    public XPathBuilder containsAttribute(String attribute, String value) {
        xpath.append(String.format("[contains(@%s,'%s')]", attribute, value));
        return this;
    }

    public String build() {
        return xpath.toString();
    }
}
